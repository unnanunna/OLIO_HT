package HT;

import java.util.Scanner;

public class Mainclass {
	public static void main(String[] args) {
		
		//kokeulutiedot
		double inputWeight;
		double inputExercise1;
		int exercise;
		
		WaterTracker Tracker = new WaterTracker();
		
		System.out.print("Your weight: ");
		Scanner scanner1 = new Scanner(System.in);
		inputWeight = scanner1.nextDouble();
		
		System.out.print("Your exercise per day (hours): ");
		Scanner scanner2 = new Scanner(System.in);
		inputExercise1 = scanner2.nextDouble();
		//muutetaan minuuteiksi ja pyöristetään int
		exercise = (int) Math.round(inputExercise1*60);

		System.out.println("Result: " + Tracker.waterAmount(inputWeight, exercise));
		System.out.println("End.");
	}
}
