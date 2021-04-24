package HT;

public class WaterTracker {
	
	//20 ml
	private int water = 20;
	public double waterAmount;
	public int waterNeeded;
	public int totalWater = 0;
	
	public int getWater(int water) {
		return water;
	}
	
	public int waterAmount(float weight, int exercise) {
		//paino kg, liikunta min, tulos dl
		waterAmount = (((weight/2) * 0.295735296) + (exercise * (0.4 * 0.295735296))) * 100;
		waterNeeded = (int) Math.round(waterAmount);
		return waterNeeded;
	}
	
	public int waterAdd() {
		if (totalWater < waterNeeded) {
			totalWater = totalWater + water;
			System.out.println("You have had " + totalWater + " ml water already today.");
		}
		else if (totalWater >= waterNeeded) {
			totalWater = totalWater + water;
			System.out.println("Congratulations, you already achieved your goal! You have had " + totalWater + " ml water today.");
		}
		return totalWater;
	}
}
