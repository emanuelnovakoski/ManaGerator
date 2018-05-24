package dados;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public Bool createUser(String username, String password) {

    }

    public Bool logIn(String username, String password) {

    }

    private void readFile(String file) {

    }


    public static ArrayList<String> readFromJsonFile(String fileName){
        ArrayList<String > result = new ArrayList<String>();


        try{
            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);

            JSONObject obj = new JSONObject(text);
            JSONArray arr = obj.getJSONArray("employees");

            for(int i = 0; i < arr.length(); i++){
                String name = arr.getJSONObject(i).getString("name");
                short salary = Short.parseShort(arr.getJSONObject(i).getString("salary"));
                String position = arr.getJSONObject(i).getString("position");
                byte years_in_company = Byte.parseByte(arr.getJSONObject(i).getString("years_in_company"));
                if (position.compareToIgnoreCase("manager") == 0){
                    result.add(new Manager(name, salary, position, years_in_company));
                }
                else{
                    result.add(new OrdinaryEmployee(name, salary, position, years_in_company));
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return result;
    }


}
