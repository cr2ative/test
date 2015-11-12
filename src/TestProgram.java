import java.sql.SQLException;
import java.util.List;

import kr.talenton.webprj.dao.MemberDao;
import kr.talenton.webprj.vo.Member;

public class TestProgram {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		List<Member> list = dao.getMembers();
		
		for(Member m : list)
		{
			System.out.printf("mid : %s, name : %s, regdate : %s\n",m.getMid(), m.getName(),m.getRegdate());
		}
		
	}

}
