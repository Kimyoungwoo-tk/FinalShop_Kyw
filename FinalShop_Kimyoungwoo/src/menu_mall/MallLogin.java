package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import util.Util;

public class MallLogin implements MenuCommand {
	private MallController cont= MallController.getInstance();


	@Override
	public boolean update() {
		MemberDAO dao = MemberDAO.getInstance();
		
		cont.setNext("MallMain");
		System.out.println("=====[ 로그인 ]=====");

		String id = Util.getValue("아이디 ");
		if(dao.idValue(id) == -1) {
			System.out.println("없는 아이디 입니다");
			return false;
		}
		String pw = Util.getValue("비번");
		if(dao.pwValue(pw)!= dao.idValue(id)) {
			System.out.println("비밀번호가 틀렸습니다");
			return false;
		}
		System.out.println("로그인 성공");
		cont.setLoginId(id);
		
		if(id.equals("admin")) {
			cont.setNext("AdminMain");
		}else {
			cont.setNext("MemberMain");
		}
		return false;
		
	}

}