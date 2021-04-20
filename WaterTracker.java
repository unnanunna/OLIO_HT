package HT;

public class WaterTracker {
	
	private int water;
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
	
	public int waterAdd(int water) {
		totalWater = totalWater + water; 
		return totalWater;
	}

}
