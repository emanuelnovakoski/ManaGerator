package control;

import javax.swing.JSpinner;
import interfaces.Notifications;
import data.Food;

public class Sensor {

	FileControl fileControl;
	Notifications notifications = new Notifications();
	Food food;

	public void updateSensors(String  foodName, JSpinner gasValue, JSpinner amountValue, JSpinner weightValue) {
		FileControl fileControl = new FileControl();
		int notification = 0;
		int gas = (Integer) gasValue.getValue();
		int  amount = (Integer) amountValue.getValue();
		float weight = (float) weightValue.getValue();
		if (foodName.equals("Alimentos:")) {
			notification=0;
		}
		else{
			food = fileControl.getFood(foodName);
		notification = checkSensor(food.nameToString(), gas, amount, weight, food.minPortionToString());
		}
		chooseNotification(foodName, notification);
	}

	public int checkSensor(String foodName, int gas, int amount, float weight, String lim) {
		if (amount <= 0) {
			return 1;
		} else if (Float.parseFloat(lim) > weight) {
			return 2;
		} else if (gas > 500) {
			return 3;
		}
		return 4;
	}

	private void chooseNotification(String foodName, int notification) {
		if (notification == 0) {
			notifications.selectFood();
		} else if (notification == 1) {
			notifications.missingIten(foodName);
		} else if (notification == 2) {
			notifications.lowLevels(foodName);
		} else if (notification == 3) {
			notifications.improperConsumption(foodName);
		}
	}
}
