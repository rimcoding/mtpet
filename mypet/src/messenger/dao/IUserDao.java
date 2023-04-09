package messenger.dao;

import javax.swing.table.DefaultTableModel;

import messenger.dto.UserDTO;

public interface IUserDao {
	int select(String id,String password);
	int save(UserDTO user);
	
	public void selectAll(DefaultTableModel t_model);
	public void userselect(DefaultTableModel dt, String fieldName, String word);
	int idselect(String id);
}
