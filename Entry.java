package HT;

import java.time.LocalDate;
import java.util.Scanner;
public class Entry {
	
	//private Date date;
	
	//User luokassa olevat muutujat
	private String name;
	private LocalDate date;
	private int age;
	private float weight;
	private String gender;
	private float exercise;
	

	public LocalDate getDate() {
		/*var today = new Date();
		var day = today.getDate();
		var month = today.getMonth() + 1;
		var year = today.getYear();
		date = day + '.' + month + '.' + year;
		System.out.print(date);*/
		date = java.time.LocalDate.now();
		
		return date;
	}
	
	public String getName(String name) {
		System.out.print("Your name: ");
		Scanner scanner1 = new Scanner(System.in);
		name = scanner1.nextLine();
		return name;
	}
	
	public int getAge(int age) {
		System.out.print("Your age: ");
		Scanner scanner2 = new Scanner(System.in);
		age = scanner2.nextInt();
		return age;
	}
	
	public float getWeight(float weight) {
		System.out.print("Your weight: ");
		Scanner scanner3 = new Scanner(System.in);
		weight = scanner3.nextFloat();
		return weight;
	}
	
	public String getGender(String gender) {
		System.out.print("Your gender: ");
		Scanner scanner4 = new Scanner(System.in);
		gender = scanner4.nextLine();
		return gender;
	}
	
	public float getExercise(float exercise) {
		System.out.print("Your exercise per day (hours): ");
		Scanner scanner3 = new Scanner(System.in);
		exercise = scanner3.nextFloat();
		return exercise;
	}
}
