package esercizio1;

public class Light {

	private boolean lightOn = false;
	private boolean bottomIn = false;
	private boolean bottomOut = false;

	Light() {
	}

	public boolean onOff(boolean light, boolean in, boolean out) {

		this.bottomIn = in;
		this.bottomOut = out;

		if ((bottomIn || bottomOut) && !light) {
			lightOn = true;
			return true; // Luce accesa
		} else {
			lightOn = false;
			return false; // Luce spenta
		}
	}
}