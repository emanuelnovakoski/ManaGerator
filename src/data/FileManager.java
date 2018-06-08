package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static FileManager sharedInstance;
    private FileManager() {}

    public static FileManager getInstance() {
        if (sharedInstance == null)
            sharedInstance = new FileManager();
        return sharedInstance;
    }

    public boolean isFavoriteFood(String foodName) {
        String[] foods = getFavoriteFoodsName();
        for(int i=0;i<foods.length;i++) {
            if (foodName.equals(foods[i])) {
                return true;
            }
        }
        return false;
    }

    private String[] getFavoriteFoodsName() {
        JSONArray foods = getFoods();
        ArrayList<String> favFoods = new ArrayList<String>();
        for(int i=0;i<foods.size();i++) {
            if ((boolean) ((JSONObject) foods.get(i)).get("fav")){
                favFoods.add((String) ((JSONObject) foods.get(i)).get("name"));
            }
        }
        String[] f = new String[favFoods.size()];
        for(int i=0;i<favFoods.size();i++) {
            f[i] = favFoods.get(i);
        }
        return f;
    }

    @SuppressWarnings("unchecked")
	public boolean setFavorite(String foodName, Boolean value) {
        Food food = getFood(foodName);
        removeFood(foodName);
        JSONArray foods = getFoods();
        JSONObject f = food.getJsonObj();
        f.put("fav", value);
        foods.add(f);
        return writeFile("Foods.json", foods);
    }

    @SuppressWarnings("unchecked")
	public boolean addFood(Food food) {
        JSONArray foods = getFoods();
        JSONObject f = food.getJsonObj();
        f.put("fav", false);
        foods.add(f);
        return writeFile("Foods.json", foods);
    }

    @SuppressWarnings("unchecked")
	public boolean addFood(ArrayList<Food> foodArray) {
        JSONArray foods = getFoods();
        for(int i=0; i<foodArray.size();i++) {
            foods.add(foodArray.get(i).getJsonObj());
        }
        return writeFile("Foods.json", foods);
    }

    public JSONArray removeFood(String foodName) {
        JSONArray foods = getFoods();

        for(int i=0; i<foods.size(); i++) {
            if (foodName.equals((String) ((JSONObject) foods.get(i)).get("name"))) {
                foods.remove(i);
                writeFile("Foods.json", foods);
                return foods;
            }
        }
        return foods;
    }

    @SuppressWarnings("unchecked")
	public boolean createUser(String username, String password, String email, String phone) {
        if (getUser(username) == null) {
            User newUser = new User(username, password, email, phone);
            JSONArray users = getUsers();
            users.add(newUser.getJsonObj());
            return writeFile("Users.json", users);
        }
        return false;
    }

    public boolean logIn(String username, String password) {
        User user = getUser(username);
        if(user != null && user.passwordDidMatch(password)) {
            return true;
        }
        return false;
    }

    public boolean userDidExist(String username) {
        return getUser(username) != null;
    }

    private User getUser(String username) {
        JSONArray users = getUsers();
        for(int i=0; i<users.size(); i++) {
            String user = (String) ((JSONObject) users.get(i)).get("username");
            if (username.equals(user)) {
                String psw = (String) ((JSONObject) users.get(i)).get("password");
                String email = (String) ((JSONObject) users.get(i)).get("email");
                String phone = (String) ((JSONObject) users.get(i)).get("phone");
                return new User(username, psw, email, phone);
            }
        }
        return null;
    }

    public boolean foodDidExist(String foodName) {
        return getFood(foodName) != null;
    }

    public Food getFood(String foodName) {
        JSONArray foods = getFoods();
        for(int i=0;i<foods.size();i++) {
            String food = (String) ((JSONObject) foods.get(i)).get("name");
            if(foodName.equals(food)) {
                double portion = (double) ((JSONObject) foods.get(i)).get("portion");
                String category =  (String) ((JSONObject) foods.get(i)).get("category");
                String date =  (String) ((JSONObject) foods.get(i)).get("date");
                return new Food(food, portion, category, date);
            }
        }
        return null;
    }

    public String[] getFoodsName() {
        JSONArray foods = getFoods();
        String[] foodsName = new String[foods.size()];
        for(int i = 0; i<foods.size(); i++) {
            foodsName[i] = (String) ((JSONObject) foods.get(i)).get("name");
        }
        return foodsName;
    }

    private JSONArray getFoods() {
        JSONArray array = (JSONArray) readFile("Foods.json");
        if (array == null) {
            return new JSONArray();
        }
        return array;
    }

    private JSONArray getUsers() {
        JSONArray array = (JSONArray) readFile("Users.json");
        if (array == null) {
            return new JSONArray();
        }
        return array;
    }

    private Object readFile(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            return parser.parse(new FileReader(filePath));
        }catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    @SuppressWarnings("unused")
	private boolean writeFile(String filePath, JSONArray array) {
        try {

            File file = new File(filePath);

            if (file == null) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(array.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}