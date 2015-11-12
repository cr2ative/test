package kr.talenton.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.talenton.webprj.vo.Member;

public class MemberDao {
	public List<Member> getMembers() throws SQLException{
		return getMembers(1);
	}
	
	public List<Member> getMembers(int page) throws SQLException{
		
		int start = 1+(page-1)*10;
		int end = page*10;
	
		String sql = "SELECT * FROM"
				+ "(SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC)"
				+ "NUM, MEMBERS.* FROM MEMBERS)A"
				+ "	WHERE NUM BETWEEN "+start+" AND "+end;
		//String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String url = "jdbc:sqlserver://211.238.142.251:1433;databaseName=talenton;";
		
		Connection con = DriverManager.getConnection(url,"talent","talenton3");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		while(rs.next()){
			member = new Member();
			/*member.setAge(rs.getInt("age"));
			member.setRegdate(rs.getDate("regdate"));
			member.setAddress(rs.getString("address"));
			member.setBirthday(rs.getString("birthday"));
			member.setGender(rs.getString("gender"));
			member.setIp(rs.getString("ip"));
			member.setMajor(rs.getString("major"));*/
			member.setMid(rs.getString("mid"));
			member.setName(rs.getString("name"));
			member.setRegdate(rs.getDate("regdate"));
			/*member.setPhone(rs.getString("phone"));
			member.setPwd(rs.getString("pwd"));
			member.setSsn(rs.getString("ssn"));*/
			
			list.add(member);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
	}
}
