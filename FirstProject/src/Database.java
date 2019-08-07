import java.sql.*;
import java.util.*;

public class Database {

	Connection con = null;
	PreparedStatement unopstmt = null;
	PreparedStatement jpstmt = null;
	PreparedStatement lpstmt = null;
	PreparedStatement lpstmt2= null;
	PreparedStatement mpstmt = null;
	PreparedStatement mspstmt = null;
	String sql = null;
	ResultSet rs = null;
	
	
	public String login(String id, String password) {
		String response =null;
		try {
			sql = "select id, password, block,login from signup where id = ? and password = ?";
			lpstmt = con.prepareStatement(sql);
			lpstmt.setString(1, id);
			lpstmt.setString(2, password);
			rs = lpstmt.executeQuery();
			if (rs.next()) {
				if(rs.getInt("block") == 1) {
					response = String.format("null/차단된사용자입니다", rs.getString(1));
				}
				else {
					response = String.format("%s/로그인 성공", rs.getString(1));
					
				}
				
			} else {
				response = "ID, PASSWORD가 틀립니다";
			}

		} catch (SQLException sqle) {
			response = "알 수 없는 에러가 발생했습니다.";
		}
		
		return response;
	}
	
	
	public String join(String id, String password) {
		String response = "회원가입완료";
		try {
			sql = "insert into signup (id, password) values (?, ?)";
			jpstmt = con.prepareStatement(sql);
			jpstmt.setString(1, id);
			jpstmt.setString(2, password);
			jpstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			response = "중복된 ID가 있습니다.";
		} catch (SQLException sqle) {
			response = "데이터베이스 입력오류입니다.";
		} 
		return response;
	}
	
	
	public void connectDatabase() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (SQLException sqle) {
			System.out.println("Connection Error");
		}
	}
}

