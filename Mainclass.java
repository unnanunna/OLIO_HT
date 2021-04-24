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
		int choise;
		//private float exercise;
		
		Entry entry = new Entry();
		WaterTracker tracker = new WaterTracker();
		VitaminRecomment vitamins = new VitaminRecomment();
		
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
		System.out.println("You need " + tracker.waterAmount(weight, exercise) + " ml water every day.");
		
		while (true) {
			System.out.println("What do you want to do?");
			System.out.println("1) Add glass of water");
			System.out.println("2) Add vitamins of the day");
			System.out.println("0) The next day");
			System.out.println("Your choise: ");
			Scanner scanner = new Scanner(System.in);
			choise = scanner.nextInt();
			if (choise == 0) {
				break;
			}
			else if (choise == 1) {
				tracker.waterAdd();
			}
			else if (choise == 2) {
				vitamins.vitaminAdd();
			}
		}
		
		System.out.println("End.");
	}
}
