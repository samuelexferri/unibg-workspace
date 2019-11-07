import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JButton btnNewButton;

	private ButtonModel model;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public View(ButtonModel model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);

		textField2 = new JTextField();
		contentPane.add(textField2);
		textField2.setColumns(10);

		btnNewButton = new JButton("New button");

		contentPane.add(btnNewButton);
		this.model = model;
		model.addObserver(this);
	}

	public void addMouseAdapter(MouseAdapter adapter) {
		btnNewButton.addMouseListener(adapter);
	}

	public void addActionListener(ActionListener adapter) {
		btnNewButton.addActionListener(adapter);
	}

	@Override
	public void update(Observable o, Object arg) {
		btnNewButton.setBackground(model.getColor());
		textField2.setText(model.getText());
	}

	public int getNumber() {
		return Integer.parseInt(textField.getText());
	}
}