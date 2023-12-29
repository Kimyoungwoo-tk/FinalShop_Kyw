package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import util.Util;

public class MemberChangePw implements MenuCommand {

	private MallController cont = MallController.getInstance();
	
	
	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		
		cont.setNext("MemberMain");
		String pw = Util.getValue("pw >>");
		int idIdx = mDAO.idValue(cont.getLoginId());
		int pwIdx = mDAO.pwValue(pw);
		if(pwIdx != idIdx) {
			System.out.println("비밀번호가 틀렸습니다");
			return false;
		}
		String newPw = Util.getValue("newPW >>");
		if(pw.equals(newPw)) {
			System.out.println("다른 비밀번호 입력");
			return false;
		}
		mDAO.getmList().get(idIdx).setPw(newPw);
		System.out.println("비밀번호 변경 완료");
		
		return false;
	}

}
