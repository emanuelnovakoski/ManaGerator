package control;

import java.util.ArrayList;

import data.FileManager;
import data.Food;

public class FileControl {

	Sensor sensor = new Sensor();
	FileManager fileManager = FileManager.getInstance();

	public boolean checkLogin(String user, String password) {
		return fileManager.logIn(user, password);
	}

	public boolean checkFoodFile(String food) {
		return fileManager.foodDidExist(food);
	}

	public boolean checkUserFile(String name) {
		return fileManager.userDidExist(name);
	}

	public void saveUserFile(String name, String email, String tell, String password) {
		fileManager.createUser(name, password, email, tell);
	}

	public Food getFood(String foodName) {
		return fileManager.getFood(foodName);
	}

	public String[] getFoodsName() {
		return fileManager.getFoodsName();
	}

	public boolean isFavoriteFood(String foodName) {
		return fileManager.isFavoriteFood(foodName);
	}

	public boolean setFavorite(String foodName, boolean value) {
		return fileManager.setFavorite(foodName, value);
	}

	public ArrayList<Food> getFoods() {
		return fileManager.getAllFoods();
	}
	
	public void removeFood(String foodName) {
		fileManager.removeFood(foodName);
	}
	
	public void saveFoodFile(String food, String minValue, String category, String date) {
		FileManager.getInstance().addFood(new Food(food, Double.parseDouble(minValue), category, date));
	}

}