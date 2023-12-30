package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminBoard implements MenuCommand {
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		cont.setNext("AdminBoard");
		System.out.println("===[ 관리자 : 게시판 관리 ]===");
		System.out.println("[1] 게시판 목록");
		System.out.println("[2] 게시글 삭제");
		System.out.println("[3] 뒤로 가기");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴 입력", 0, 3);

		if (sel == 1) {
			cont.setNext("BoardList");
		} else if (sel == 2) {
			cont.setNext("BoardDelPage");
		} else if(sel == 3){
			cont.setNext("AdminMain");
		} else if(sel == 0) {
			cont.setNext("");
		}
		return false;
	}
}