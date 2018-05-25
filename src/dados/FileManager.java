package dados;

import classes.Food;
import classes.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rodrigofranzoi on 24/05/18.
 */

public class FileManager {

    private static FileManager sharedInstance;

    private FileManager() {}

    public static FileManager getInstance() {

        if (sharedInstance == null)
            sharedInstance = new FileManager();

        return sharedInstance;
    }


    public boolean addFood(Food food) {
        JSONArray foods = getFoods();
        foods.add(food.getJsonObj());
        return writeFile("Foods.json", foods);
    }

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

    /* CRIA UM NOVO USUÁRIO.
     * RETORNA FALSE CASO O USERNAME JÁ EXISTA
     */
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