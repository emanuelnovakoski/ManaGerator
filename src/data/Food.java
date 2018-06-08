package data;

import org.json.simple.JSONObject;

public class Food {
	
    String name;
    String category;
    Double minPortion;
    String date;

    public Food(String name, Double minPortion, String category, String date) {
        this.name = name;
        this.minPortion = minPortion;
        this.category = category;
        this.date = date;
    }

    public String toString() {
        return "Nome: " + name + "\t\tPorção: " + minPortion.toString();
    }

    @SuppressWarnings("unchecked")
	public JSONObject getJsonObj() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("portion", minPortion);
        obj.put("category", category);
        obj.put("date", date);

        return obj;
    }

    public String nameToString() {
        return name;
    }

    public String minPortionToString() {
        return minPortion.toString();
    }

}
