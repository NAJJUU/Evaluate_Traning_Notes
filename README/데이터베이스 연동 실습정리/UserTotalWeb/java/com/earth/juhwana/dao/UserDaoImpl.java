package com.earth.juhwana.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.earth.juhwana.domain.User;

import jakarta.validation.Valid;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	User user = null;

	@Override
	public User select(String id) {
		
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			

			String sql = "select * from total_User where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setReg_date(new Date(rs.getDate(5).getTime()));
				return user;
			}		
		} catch (SQLException e) {e.printStackTrace();
		} finally {close(rs, pstmt, conn);}
		return user;
	}
	
	private void close(AutoCloseable...closeables) {
		for(AutoCloseable autoCloseable : closeables) {
			if(autoCloseable != null) {try {autoCloseable.close();} catch (Exception e) {e.printStackTrace();}}
		}
	}

	@Override
	public int deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "delete from total_User";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	@Override
	public int insert(@Valid User user) {
		try {
			conn = ds.getConnection();			
			/*
			 * 인파라미터에는 물음표를 사용함
			 * 정확한 값을 나중에 채워주겠다는 의미임
			 */
			String sql = "INSERT INTO total_User "
					+ "VALUES(?,?,?,?, now())";
			pstmt = conn.prepareStatement(sql);
			/*
			 * 인파라미터(=입력값에 사용된 물음표(?)) 설정시 데이터 타입에 맞는 set 메서드를 사용함
			 * set메서드는 데이터 타입별로 다양하게 준비되어 있음
			 */
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPwd());
			pstmt.setString(4, user.getEmail());
			
			return pstmt.executeUpdate();		//insert, update, delete
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public int update(User user) throws SQLException {
		String sql = "update total_User set id = ?, name = ?, pwd = ?, name = ?, reg_date = ?  where id = ?";
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPwd());
			pstmt.setString(4, user.getName());
			pstmt.setDate(5, new java.sql.Date(user.getReg_date().getTime()));
			pstmt.setString(6, user.getId());
			
		} catch (SQLException e) {
			return 0;
		}
		return pstmt.executeUpdate();
	}

}
























