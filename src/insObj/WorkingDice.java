package insObj;
import java.util.Random;

public class WorkingDice {
	
	public static boolean Dice(int difficult) {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(difficult*2);
		if(difficult<rand_int1) {
			return true;
		}
		return false;
		
	}
	
}
