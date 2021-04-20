package HT;

import java.util.Scanner;

public class Mainclass {
	public static void main(String[] args) {
		
		//kokeulutiedot
		double inputWeight;
		double inputExercise1;
		int exercise;
		
		String name = "";
		int age = 0;
		float weight = 0;
		String gender = "";
		float exercise1 = 0;
		//private float exercise;
		
		WaterTracker Tracker = new WaterTracker();
		Entry entry = new Entry();
		
		entry.getName(name);
		entry.getAge(age);
		weight = entry.getWeight(weight);
		entry.getGender(gender);
		exercise1 = entry.getExercise(exercise1);
		
		/*System.out.print("Your weight: ");
		Scanner scanner1 = new Scanner(System.in);
		inputWeight = scanner1.nextDouble();
		
		System.out.print("Your exercise per day (hours): ");
		Scanner scanner2 = new Scanner(System.in);
		inputExercise1 = scanner2.nextDouble();*/
		
		//muutetaan minuuteiksi ja pyöristetään int
		exercise = (int) Math.round(exercise1*60);

		//System.out.println("Result: " + Tracker.waterAmount(inputWeight, exercise));
		System.out.println("Result: " + Tracker.waterAmount(weight, exercise));
		System.out.println("End.");
	}
}
