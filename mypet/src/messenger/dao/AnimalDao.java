package messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import messenger.DBHelper;
import messenger.dto.AnimalDTO;



public class AnimalDao implements IAnimalDao {

	DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AnimalDao() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int update(AnimalDTO animal) {
		int resultRow = 0;
		if (animal.getAnimal_name().equals("")) {
			return resultRow;
		}else if(animal.getAnimal_type().equals("")) {
			return resultRow;
		}else if(animal.getAnimal_age().equals("")) {
			return resultRow;
		}else if (animal.getAnimal_information().equals("")) {
			return resultRow;
		}
		String sql = " INSERT INTO animal(animal_name,animal_type,age,animal_information) "
				+ " VALUES "
				+ "	( ? , ? , ? , ? ) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,animal.getAnimal_name());
			pstmt.setString(2, animal.getAnimal_type());
			pstmt.setString(3, animal.getAnimal_age());
			pstmt.setString(4, animal.getAnimal_information());
			resultRow = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			System.out.println("AnimalDao에서 에러발생");
			e.printStackTrace();
		
	}
		return resultRow;
	}

	@Override
	public int delete(AnimalDTO animal) {
		
		int resultRow = 0;
		
		String sql = " DELETE FROM animal WHERE animal_name = ?"
				+ " AND  animal_type = ? AND age = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, animal.getAnimal_name());
			pstmt.setString(2, animal.getAnimal_type());
			pstmt.setString(3, animal.getAnimal_age());
		
			resultRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	
	@Override
	public void selectAll(DefaultTableModel t_model) {
		String sql = " SELECT * from animal order by animal_id ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i< t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(1),rs.getString(2),
					rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				t_model.addRow(data);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void select(DefaultTableModel dt, String fieldName, String word) {
		String sql = " SELECT * FROM animal WHERE  " + fieldName.trim()
		+ " LIKE '%"  + word.trim() +"%' " ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				dt.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
