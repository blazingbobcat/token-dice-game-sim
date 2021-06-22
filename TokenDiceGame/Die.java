// Die class
public class Die {
	private int num;

	// Constructor
	public Die() {
		num = 1;
	}

	// Roll for random number
	public int Roll() {
		// Random number generator goes here
		num = (int)(Math.random() * 6 + 1);
		return num;
	}

} // end Die class