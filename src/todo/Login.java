package todo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import todo.todoapp;
import javax.swing.Timer;

public class Login extends Frame implements ActionListener, MouseMotionListener, MouseListener {

	Label title;
	Label username;
	TextField usenamTextField;
	JPasswordField passwordField;
	Label passwordlbl;
	Button btnSubmit;
	Label prompt;

	public Login() {

		title = new Label("To Do List");
		title.setForeground(Color.white);
		// title.setBackground(Color.black);
		title.setFont(new Font("Monospace", Font.BOLD, 25));
		title.setBounds(170, 40, 170, 50);

		username = new Label("Username : ");
		username.setForeground(Color.white);
		username.setFont(new Font("Monospace", Font.BOLD, 20));
		username.setBounds(160, 100, 170, 50);

		usenamTextField = new TextField();
		usenamTextField.setFont(new Font("Monospace", Font.BOLD, 17));
		usenamTextField.setBounds(160, 160, 170, 30);

		passwordlbl = new Label("Password : ");
		passwordlbl.setForeground(Color.white);
		passwordlbl.setFont(new Font("Monospace", Font.BOLD, 20));
		passwordlbl.setBounds(160, 200, 170, 60);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monospace", Font.BOLD, 17));
		passwordField.setBounds(160, 270, 170, 30);

		btnSubmit = new Button("Submit");
		btnSubmit.setFont(new Font("Monospace", Font.BOLD, 17));
		btnSubmit.setForeground(Color.white);
		btnSubmit.setBackground(Color.black);
		// btnSubmit.setBorder(BorderFactory.createEmptyBorder());
		btnSubmit.setBounds(160, 350, 170, 50);

		btnSubmit.addActionListener(this);

		prompt = new Label("Processing Your Request !!");
		prompt.setForeground(Color.black);
		prompt.setFont(new Font("Monospace", Font.BOLD, 15));
		prompt.setBounds(135, 430, 260, 50);
		prompt.setVisible(false);

		add(title);
		add(username);
		add(usenamTextField);
		add(passwordlbl);
		add(passwordField);
		add(btnSubmit);
		add(prompt);
		setBackground(Color.decode("#ff0066"));
		setSize(500, 600);
		setLayout(null);
		setVisible(true);

		btnSubmit.addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = usenamTextField.getText().toString();
		String pass123 = passwordField.getText().toString();
		if (user.equals("bond007") && pass123.equals("james")) {
			System.out.println("inside admin and password");
			prompt.setVisible(true);
			prompt.setText("Processing Your Request");
			try {
				Thread.sleep(2000);
				prompt.setText("Login Successful");
				
				new todoapp();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}
		else {

			prompt.setText("Invalid Username or Password");
			prompt.setVisible(true);
			System.out.println("Wrong username");
		}
	}
	
	

	public static void main(String[] args) {
		Login object = new Login();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		btnSubmit.setBackground(Color.white);
		btnSubmit.setForeground(Color.black);
		btnSubmit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		btnSubmit.setBackground(Color.black);
		btnSubmit.setForeground(Color.white);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
