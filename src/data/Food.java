package data;

import org.json.simple.JSONObject;

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

    @SuppressWarnings("unchecked")
	public JSONObject getJsonObj() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("portion", minPortion);
        return obj;
    }

    public String nameToString() {
        return name;
    }

    public String minPortionToString() {
        return minPortion.toString();
    }

}
