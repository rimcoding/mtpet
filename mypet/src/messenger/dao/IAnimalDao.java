package messenger.dao;

import javax.swing.table.DefaultTableModel;

import messenger.dto.AnimalDTO;

public interface IAnimalDao {
	
	public int update(AnimalDTO animal);
	
	public int delete(AnimalDTO animal);
	
	public void selectAll(DefaultTableModel t_model);
	
	public void select(DefaultTableModel dt, String fieldName, String word);
	
}
