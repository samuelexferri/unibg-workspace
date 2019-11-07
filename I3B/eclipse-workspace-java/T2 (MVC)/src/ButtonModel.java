import java.awt.Color;
import java.util.Observable;

public class ButtonModel extends Observable {
	private Color color;
	private String text;
	private static int MULTIPLIER = 21;
	private int number;

	public ButtonModel() {
		reset();
	}

	public void reset() {
		text = "";
		mouseOut();
	}

	public void mouseIn() {
		color = Color.BLUE;
		setChanged();
		notifyObservers();
	}

	public void mouseOut() {
		color = Color.GRAY;
		setChanged();
		notifyObservers();
	}

	public void checkNumber() {
		if ((number * MULTIPLIER) % 5 == 0)
			text = "Multiplo di 5";
		else
			text = "Non multiplo di 5";
		setChanged();
		notifyObservers();
	}

	public Color getColor() {
		return this.color;
	}

	public String getText() {
		return this.text;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}