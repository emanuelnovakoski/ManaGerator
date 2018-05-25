package classes;

import org.json.simple.JSONObject;

/**
 * Created by rodrigofranzoi on 24/05/18.
 */
public class Food {

    String name;
    Double minPortion;

    public Food(String name, Double minPortion) {
        this.name = name;
        this.minPortion = minPortion;
    }

    public String toString() {
        return "Nome: " + name + "\t\tPorção: " + minPortion.toString();
    }

    public JSONObject getJsonObj() {

        JSONObject obj = new JSONObject();

        obj.put("name", name);
        obj.put("portion", minPortion);

        return obj;
    }
}
