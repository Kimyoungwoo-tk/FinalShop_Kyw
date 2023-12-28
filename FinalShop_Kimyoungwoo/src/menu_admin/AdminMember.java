package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.MemberDAO;
import util.Util;

public class AdminMember implements MenuCommand {

	private MallController cont = MallController.getInstance();
	

	@Override
	public boolean update() {
		MemberDAO dao = MemberDAO.getInstance();
		cont.setNext("AdminMember");
		System.out.println("===[ 관리자 : 회원 관리]===");
		System.out.println("[1] 회원 목록");
		System.out.println("[2] 회원 삭제");
		System.out.println("[3] 뒤로 가기");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴 입력", 0, 3);
		
		if(sel ==1) {
			cont.setNext("AdminMemberList");
		}else if(sel ==2) {
			cont.setNext("AdminMemberDelete");
		}else if(sel == 3) {
			cont.setNext("AdminMain");
		}else if(sel ==0) {
			cont.setNext("");
		}
		return false;
	}
}
