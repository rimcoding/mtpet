package messenger.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import messenger.dao.UserDao;
import messenger.dto.UserDTO;

public class JoinFrame extends JFrame {

	
	private JPanel contentPane;
	private JLabel IbIjoin;
	private JButton join;
	private JButton back;
	private JTextField Id;
	private JTextField Username;
	private JTextField Password;
	private JTextField Nickname;
	private JTextField Email;
	private JTextField Brithday;
	private JTextField Phone;
	private JButton idsearch;
	private boolean idsearch2 = false;
	
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IbIjoin = new JLabel("회원가입");
		IbIjoin.setBounds(230, 41, 150, 20);
		contentPane.add(IbIjoin);
		
		JLabel id = new JLabel("id");
		id.setBounds(69, 113, 69, 20);
		contentPane.add(id);
		
		JLabel password = new JLabel("password");
		password.setBounds(69, 163, 69, 20);
		contentPane.add(password);
		
		JLabel username = new JLabel("username");
		username.setBounds(69, 213, 69, 20);
		contentPane.add(username);
		
		JLabel nickname = new JLabel("animalname");
		nickname.setBounds(69, 260, 79, 20);
		contentPane.add(nickname);
		
		JLabel brithday = new JLabel("brithday");
		brithday.setBounds(69, 310, 69, 20);
		contentPane.add(brithday);
		
		JLabel email = new JLabel("email");
		email.setBounds(69, 360, 69, 20);
		contentPane.add(email);
		
		JLabel phone = new JLabel("phone");
		phone.setBounds(69, 410, 69, 20);
		contentPane.add(phone);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(159, 106, 186, 35);
		contentPane.add(Id);
		
		idsearch = new JButton("중복확인");
		idsearch.setBounds(360, 106, 89, 29);
		contentPane.add(idsearch);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(159, 156, 186, 35);
		contentPane.add(Username);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(159, 206, 186, 35);
		contentPane.add(Password);
		
		Nickname = new JTextField();
		Nickname.setColumns(10);
		Nickname.setBounds(159, 256, 186, 35);
		contentPane.add(Nickname);
		
		Brithday = new JTextField();
		Brithday.setColumns(10);
		Brithday.setBounds(159, 306, 186, 35);
		contentPane.add(Brithday);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(159, 356, 186, 35);
		contentPane.add(Email);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(159, 406, 186, 35);
		contentPane.add(Phone);
		
		join = new JButton("회원가입 완료");
		join.setBounds(66, 463, 139, 29);
		contentPane.add(join);
		
		back = new JButton("돌아가기");
		back.setBounds(246, 463, 139, 29);
		contentPane.add(back);
		
		setVisible(true);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					UserDTO userDTO = new UserDTO(Id.getText(),Username.getText(), Password.getText(), Nickname.getText(), Brithday.getText(),Email.getText(), Phone.getText());
					UserDao dao = new UserDao();
					if (idsearch2 == true) {
						int result = dao.save(userDTO);
						if (result == 1) {
							JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
							dispose();
							LoginFrame frame = new LoginFrame();
						}else {
							JOptionPane.showMessageDialog(null, "다시 입력해주세요");
						}
					}else {
						JOptionPane.showMessageDialog(null, "중복체크해주세요");
					}
					
				
			
			}
		});
		idsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				UserDao dao = new UserDao();
				int result = dao.idselect(Id.getText());
				if (result ==1) {
					JOptionPane.showMessageDialog(null, "이미 생성된 아이디입니다.");
				}else if(Id.getText().equals("")){
					JOptionPane.showMessageDialog(null, "빈칸에 입력해주세요");
				}else {
					JOptionPane.showMessageDialog(null, "생성가능한 아이디입니다.");
					idsearch2 = true;
				}
				System.out.println(idsearch2);
			}
		});
	}
	public static void main(String[] args) {
		JoinFrame frame = new JoinFrame();
	}
}
