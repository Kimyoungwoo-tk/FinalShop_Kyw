package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import dto.Member;
import util.Util;

public class MallJoin implements MenuCommand {
	private MallController cont= MallController.getInstance();


	@Override
	public boolean update() {
		System.out.println("=====[ 회원가입 ]=====");
		MemberDAO dao = MemberDAO.getInstance();
		String id = Util.getValue("아이디 ");
		
		if(dao.idValue(id)!= -1) {
			System.out.println("이미 사용하는 아이디");
			return false;
		}
		
		String pw = Util.getValue("비밀번호 ");
		String name = Util.getValue("이름 ");
		
		dao.getmList().add(new Member(id , pw, name));
		System.out.println("가입완료");
				
		cont.setNext("MallMain");
		return false;
	}

}