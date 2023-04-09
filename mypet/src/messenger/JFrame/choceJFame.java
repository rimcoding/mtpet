package messenger.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class choceJFame extends JFrame {

	private JLabel background;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	
	public choceJFame() {
		initDate();
		setIninLayout();
		ActionListener();
	}

	private void initDate() {
		setSize(550,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Icon icon3 = new ImageIcon("images/write.png");
		button1 = new JButton(icon3);
		button1.setBounds(150, 350, 100, 40);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		
		Icon allsearch = new ImageIcon("images/allsearch2.png");
		button2 = new JButton(allsearch);
		button2.setBounds(310, 345, 100, 50);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		
		Icon search = new ImageIcon("images/search2.png");
		button3 = new JButton(search);
		button3.setBounds(150, 430, 100, 40);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		button3.setFocusPainted(false);
		
		
		Icon delete = new ImageIcon("images/delete.png");
		button4 = new JButton(delete);
		button4.setBounds(310, 430, 100, 40);
		button4.setBorderPainted(false);
		button4.setContentAreaFilled(false);
		button4.setFocusPainted(false);
		
	
		Icon icon2 = new ImageIcon("images/choce_background.png");
		background = new JLabel(icon2);
		background.setSize(550,550);
		
	}

	private void setIninLayout() {
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	
		add(background);
		
		background.setLocation(0,0);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
	private void ActionListener() {
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AnimalsaveJFame animalsaveJFame = new AnimalsaveJFame();
				dispose();
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearhPetJFrame  allsearhTableJFrame = new SearhPetJFrame();
				dispose();
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SearhUserJFrame frame = new SearhUserJFrame();
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "정말로 삭제하실건가요? ㅠㅠ");
				dispose();
				AnimaldeleteJFame animaldeleteJFame = new AnimaldeleteJFame();
			}
		});
	
	}
	public static void main(String[] args) {
		choceJFame choceJFame = new choceJFame();
	}
}


