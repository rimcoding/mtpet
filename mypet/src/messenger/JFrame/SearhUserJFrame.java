package messenger.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import messenger.dao.UserDao;

public class SearhUserJFrame extends JFrame{

	String[] name = {"id","username","birthday","phone","email","animalname"};
	
	DefaultTableModel dt = new DefaultTableModel(name,0);
	JTable jt = new JTable(dt);
	JScrollPane jsp = new JScrollPane(jt);
	
	JPanel p = new JPanel();
	String[] comboName = {"ALL","username","animal_name"};
	
	JComboBox combo = new JComboBox(comboName);
	
	JTextField jtf = new JTextField(20);
	JButton search = new JButton("검색");
	JButton back = new JButton("돌아가기");
	
	UserDao userDao = new UserDao();
	
	public SearhUserJFrame() {

		super("유저정보");
		
		p.setBackground(Color.LIGHT_GRAY);
		p.add(combo);
		p.add(jtf);
		p.add(search);
		p.add(back);
		add(jsp,"Center");
		add(p,"South");
		
		setSize(600,500);
		setVisible(true);
		setLocationRelativeTo(null);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (dt.getRowCount() > 0) {
			jt.setRowSelectionInterval(0, 0);
		}
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String fieldName = combo.getSelectedItem().toString();
				
				if (fieldName.trim().equals("ALL")) {
					userDao.selectAll(dt);
					if (dt.getRowCount() > 0) {
						jt.setRowSelectionInterval(0, 0);
					}
				}else {
					if (jtf.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸을 채워주세요");
					}else {
						userDao.userselect(dt, fieldName, jtf.getText());
						if (dt.getRowCount() > 0) {
							jt.setRowSelectionInterval(0, 0);
						}
					}
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
		SearhUserJFrame frame = new SearhUserJFrame();
	}
}
