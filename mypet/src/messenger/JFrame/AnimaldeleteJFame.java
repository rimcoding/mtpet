package messenger.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import messenger.dao.AnimalDao;
import messenger.dto.AnimalDTO;

public class AnimaldeleteJFame extends JFrame {

	private JPanel background;
	private JLabel animal;
	private JTextField animalText1;
	private JTextField animalText2;
	private JTextField animalText3;
	private JButton button1;
	private JButton button2;
	private JLabel animalname;
	private JLabel animaltype;
	private JLabel animalage;
	
	public AnimaldeleteJFame() {
		initDate();
		setIninLayout();
		ActionListener();
	}

	private void initDate() {
		setSize(550,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/animal2.png");
		animal = new JLabel(icon);
		animal.setSize(350,350);
		background = new JPanel();
		background.setBackground(Color.LIGHT_GRAY);
		background.setSize(550,650);
		
		animalname = new JLabel("동물이름");
		animalname.setBounds(150, 350, 69, 20);
		
		animalText1 = new JTextField();
		animalText1.setBounds(250, 350, 150, 20);
		
		animaltype = new JLabel("동물종류");
		animaltype.setBounds(150, 400, 69, 20);
		
		animalText2 = new JTextField();
		animalText2.setBounds(250, 400, 150, 20);
		
		animalage = new JLabel("동물나이");
		animalage.setBounds(150, 450, 69, 20);
		
		animalText3 = new JTextField();
		animalText3.setBounds(250, 450, 150, 20);
		
		button1 = new JButton("삭제하기");
		button1.setBounds(100, 550, 150, 35);
		
		button2 = new JButton("돌아가기");
		button2.setBounds(300, 550, 150, 35);
	}

	private void setIninLayout() {
		setLocationRelativeTo(null);
		animal.setLocation(90,0);
		add(animalText1);
		add(animalText2);
		add(animalText3);
		add(button1);
		add(button2);
		add(animalname);
		add(animaltype);
		add(animalage);
		add(animal);
		add(background);
		setLayout(null);
		setVisible(true);
	}

	private void ActionListener() {
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AnimalDTO animalDTO = new AnimalDTO(animalText1.getText(),animalText2.getText(),animalText3.getText());
				AnimalDao animalDao = new AnimalDao();
				int result = animalDao.delete(animalDTO);
				System.out.println(result);
				if (result ==1) {
					JOptionPane.showMessageDialog(null, "애완동물  정보가 삭제되었습니다");
				}else {
					JOptionPane.showMessageDialog(null, "다시 입력해주세요");
				}
			}
		});
		
		
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choceJFame choceJFame = new choceJFame();
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		AnimaldeleteJFame animaldeleteJFame = new AnimaldeleteJFame();
	}
}
