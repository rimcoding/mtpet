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

public class LoginFrame extends JFrame {

	private JTextField Username, Password;
	private JButton loginBtn, joinBtn;
	private JPanel contentpane;
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel idLogin = new JLabel("ID");
		idLogin.setBounds(41,52,69,35);
		contentpane.add(idLogin);
		
		JLabel passwordLogin = new JLabel("Password");
		passwordLogin.setBounds(41, 103, 69, 35);
		contentpane.add(passwordLogin);
		
		Username = new JTextField();
		Username.setBounds(157, 52, 176, 35);
		contentpane.add(Username);
		Username.setColumns(10);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(229, 154, 104, 29);
		contentpane.add(joinBtn);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(108, 154, 106, 29);
		contentpane.add(loginBtn);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(157, 103, 176, 35);
		contentpane.add(Password);
		
		setVisible(true);
		
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinFrame frame = new JoinFrame();
				dispose();
			}
		});
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDao userDao = new UserDao();
				int result = userDao.select(Username.getText(),Password.getText());
				if (result ==1) {
					JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
					dispose();
					choceJFame choceJFame = new choceJFame();
				}else if(result == 0){
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
				}
			}
				
				
		});
		
	}

	public static void main(String[] args) {
		LoginFrame frame = new LoginFrame();
	}
}
