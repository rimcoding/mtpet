package messenger.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel background;
	private JLabel Dog;
	private JButton button;
	
	public MainFrame() {
		initDate();
		setIninLayout();
		ActionListener();
	}

	

	private void initDate() {
		setTitle("강아지탐정");
		setSize(550,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/Dog.png");
		Dog = new JLabel(icon);
		Dog.setSize(450,450);
		background = new JPanel();
		background.setBackground(Color.LIGHT_GRAY);
		background.setSize(600,600);
		button = new JButton("접속");
		button.setBounds(190, 450, 150, 35);
	}

	private void setIninLayout() {
		setLocationRelativeTo(null);
		Dog.setLocation(30,0);
		add(Dog);
		add(button);
		add(background);
		setLayout(null);
		setVisible(true);
	}
	
	private void ActionListener() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame frame = new LoginFrame();
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
}
