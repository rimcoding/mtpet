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

import messenger.dao.AnimalDao;

public class SearhPetJFrame extends JFrame {

	String[] name = {"id","Petname","Pettype","age","information","time"};
	
	DefaultTableModel dt = new DefaultTableModel(name,0);
	JTable jt = new  JTable(dt);
	JScrollPane jsp = new JScrollPane(jt);
	
	JPanel p = new JPanel();
	String[] comboName = {"ALL","animal_name","animal_type"};
	
	JComboBox combo = new JComboBox(comboName);
	
	JTextField jtf = new JTextField(20);
	JButton serach = new JButton("검색");
	JButton back = new JButton("돌아가기");
	
	AnimalDao animalDao = new AnimalDao();
	
	
	public SearhPetJFrame() {
		
		super("강아지 미아방지 프로그램");
		
		p.setBackground(Color.LIGHT_GRAY);
		p.add(combo);
		p.add(jtf);
		p.add(serach);
		p.add(back);
		add(jsp,"Center");
		add(p, "South");
		
		setSize(600,500);
		setVisible(true);
		setLocationRelativeTo(null);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (dt.getRowCount() > 0) {
			jt.setRowSelectionInterval(0, 0);
		}
		serach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fieldName = combo.getSelectedItem().toString();
				
				if (fieldName.trim().equals("ALL")) {
					animalDao.selectAll(dt);
					if (dt.getRowCount() > 0) 
						jt.setRowSelectionInterval(0, 0);
						
					}else {
						if (jtf.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "빈칸을 채워주세요");
						}else {
							animalDao.select(dt, fieldName, jtf.getText());
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
				dispose();
				choceJFame choceJFame = new choceJFame();
			}
		});
	}
	public static void main(String[] args) {
		SearhPetJFrame allsearhTableJFrame = new SearhPetJFrame();
	}
}
