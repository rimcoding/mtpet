package messenger.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import messenger.dao.AnimalDao;
import messenger.dto.AnimalDTO;

public class AnimalsaveJFame extends JFrame {

	private JPanel contentPane;
	private JLabel lbljoin;
	private JButton save;
	private JButton back;
	private JTextField animalname;
	private JTextField animaltype;
	private JTextField animalage;
	private JTextArea animal_information;
	
	public AnimalsaveJFame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBounds(5, 5, 5, 5);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbljoin = new JLabel("동물정보");
		lbljoin.setBounds(220, 41, 100, 20);
		contentPane.add(lbljoin);
		
		JLabel name = new JLabel("동물 이름");
		name.setBounds(69, 113, 69, 20);
		contentPane.add(name);
		
		JLabel type = new JLabel("동물 종류");
		type.setBounds(69, 163, 69, 20);
		contentPane.add(type);
		
		JLabel information = new JLabel("동물 나이");
		information.setBounds(69, 213, 69, 20);
		contentPane.add(information);
		
		JLabel age = new JLabel("정보");
		age.setBounds(69, 263, 69, 20);
		contentPane.add(age);
		
		animalname = new JTextField();
		animalname.setColumns(10);
		animalname.setBounds(159, 106, 186, 35);
		contentPane.add(animalname);
		
		animaltype = new JTextField();
		animaltype.setColumns(10);
		animaltype.setBounds(159, 156, 186, 35);
		contentPane.add(animaltype);
		
		animalage = new JTextField();
		animalage.setColumns(10);
		animalage.setBounds(159, 206, 186, 35);
		contentPane.add(animalage);
		
		
		animal_information = new JTextArea();
		animal_information.setColumns(10);
		animal_information.setBounds(159, 256, 210, 200);
		contentPane.add(animal_information);
		
		save = new JButton("저장하기");
		save.setBounds(86, 500, 139, 29);
		contentPane.add(save);
		
		back = new JButton("돌아가기");
		back.setBounds(250, 500, 139, 29);
		contentPane.add(back);
		
		setVisible(true);
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AnimalDTO animalDTO = new AnimalDTO(animalname.getText(),animaltype.getText(), animalage.getText(), animal_information.getText());
				AnimalDao animalDao = new AnimalDao();
				int result = animalDao.update(animalDTO);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "저장이 완료되었습니다");
					choceJFame choceJFame = new choceJFame();
					dispose();					
				}else {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 채워주세요");
				}
				
			}
		});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choceJFame choceJFame = new choceJFame();
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		AnimalsaveJFame animalsaveJFame = new AnimalsaveJFame();
	}
}
