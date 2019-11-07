import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
	private ButtonModel model;
	private View frame;

	public Controller(ButtonModel model, View frame) {
		this.model = model;
		this.frame = frame;
	}

	public void activate() {
		frame.addMouseAdapter(new MouseListener());
		frame.addActionListener(new ActionL());
	}

	class MouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {

			super.mouseEntered(e);
			model.mouseIn();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			model.mouseOut();
		}
	}

	class ActionL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setNumber(frame.getNumber());
			model.checkNumber();
		}
	}
}
