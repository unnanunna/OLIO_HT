package HT;

public class VitaminRecomment {
	
	private int vitamins = 0;
	
	/*public String recommenterVitamin(String gender, int age) {
		return lause;
	}*/
	
	public void vitaminAdd() {
		if (vitamins == 0) {
			vitamins += 1;
			System.out.println("Congratulations, you have taken your vitamins today.");
		}
		else if (vitamins == 1) {
			System.out.println("You already had your vitamins today.");
		}
	}
}
