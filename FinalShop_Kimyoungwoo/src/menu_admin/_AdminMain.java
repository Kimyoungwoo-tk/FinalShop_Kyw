package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import dao.FileDAO;
import util.Util;

public class _AdminMain implements MenuCommand {
	private MallController cont= MallController.getInstance();

	@Override
	public boolean update() {
		cont.setNext("AdminMain");
		System.out.println("===관리자===");
		System.out.println("[1] 회원관리");
		System.out.println("[2] 상품관리");
		System.out.println("[3] 게시판관리");
		System.out.println("[4] 로그아웃");
		System.out.println("[5] 파일저장");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴입력", 0, 5);
		
		if(sel == 1) {
			cont.setNext("AdminMember");
		}else if(sel == 2) {
			cont.setNext("AdminItem");
		}else if(sel == 3) {
			cont.setNext("AdminBoard");
		}else if(sel == 4) {
			cont.setNext("MallMain");
			System.out.println("관리자 로그아웃");
			cont.setLoginId("");
		}else if(sel == 5) {
			cont.setNext("AdminFileSave");
		}else if(sel == 0) {
			cont.setNext("");
		}
		
		return false;
	}

}