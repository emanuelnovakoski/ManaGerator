package data;

import org.json.simple.JSONObject;

public class User {

    public  String username;
    public  String email;
    public  String phone;
    private String password;

    public User (String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public boolean passwordDidMatch(String password) {
        return this.password.equals(password);
    }

    @SuppressWarnings("unchecked")
	public JSONObject getJsonObj() {
        JSONObject obj = new JSONObject();
        obj.put("username", username);
        obj.put("password", password);
        obj.put("email", email);
        obj.put("phone", phone);
        return obj;
    }

    public String toString() {
        return "Username:\t" + username + "\n" + "Password:\t" + password + "\n" + "Email:\t\t" + email + "Phone:\t\t" + phone;
    }

}
