package messenger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import messenger.DBHelper;
import messenger.dto.UserDTO;

public class UserDao implements IUserDao {

	DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	
	
	@Override
	public int save(UserDTO user) {
		int resultRow = 0;
		if (user.getId().equals("")) {
			return resultRow;
		}else if(user.getUsername().equals("")) {
			return resultRow; 
		}else if(user.getAnimalname().equals("")) {
			return resultRow;
		}else if(user.getBrithday().equals("")) {
			return resultRow;
		}else if(user.getEmail().equals("")) {
			return resultRow;
		}else if(user.getPhone().equals("")) {
			return resultRow;
		}
		String sql = " INSERT INTO user(id,password,username,animal_name,brithday,email,Phone) "
				+ " VALUES "
				+ " ( ? , ? , ? , ? , ? , ? , ? ) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getAnimalname());
			pstmt.setString(5, user.getBrithday());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getPhone());
			resultRow = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("UserDao에서 에러발생");
			e.printStackTrace();
		}
		return resultRow;
	}


	@Override
	public int select(String id, String password) {
		
		int result = 1;
		
		String sql = " SELECT * "
				+ "    FROM user "
				+ "    WHERE id = ? AND password = ? ";
		
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if (rs.next() == false || (id.isEmpty()) == true) {
				result =0;
				while(rs.next()) {
					UserDTO userdto = new UserDTO(id, password);
					userdto.setId(rs.getString("id"));
					userdto.setPassword(rs.getString("password"));
				}
			}
			
			
		} catch (SQLException e) {
			System.out.println("UserDao select 에러발생");
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public void selectAll(DefaultTableModel t_model) {
		String sql = " SELECT * FROM user order by user_id ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			for(int i= 0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(2),rs.getString(4),rs.getString(6),
						rs.getString(8),rs.getString(7),rs.getString(5)};
				t_model.addRow(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void userselect(DefaultTableModel dt, String fieldName, String word) {
		String sql = " SELECT * FROM user WHERE " + fieldName.trim()
		+ " LiKE '%" +word.trim() +"%' ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(2),rs.getString(4),rs.getString(6),
						rs.getString(8),rs.getString(7),rs.getString(5),};
				dt.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public int idselect(String id) {
		int result = 1;
		String sql = " SELECT * FROM user WHERE id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next() == false || (id.isEmpty()) == true) {
				result =0;
				while(rs.next()) {
					UserDTO userdto = new UserDTO(id);
					userdto.setId(rs.getString("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	


	
	
	

}
