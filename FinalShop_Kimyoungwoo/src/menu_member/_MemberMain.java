package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class _MemberMain implements MenuCommand {

	private MallController cont = MallController.getInstance();


	@Override
	public boolean update() {
		cont.setNext("MamberMain");
		System.out.println("=====[회원 %s님]======".formatted(cont.getLoginId()));
		System.out.println("[1] 상품구매");
		System.out.println("[2] 구매내역");
		System.out.println("[3] 게시판");
		System.out.println("[4] 나의정보");
		System.out.println("[5] 회원탈퇴");
		System.out.println("[6] 로그아웃");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴입력", 0, 6);
		
		if(sel ==1) {
			cont.setNext("MemberShopping");
		}else if(sel ==2) {
			cont.setNext("MemberCart");
		}else if(sel ==3) {
			cont.setNext("MemberBoard");
		}else if(sel ==4) {
			cont.setNext("MemberInfo");
		}else if(sel ==5) {
			cont.setNext("MemberQuit");
		}
		else if(sel ==6) {
			cont.setNext("MallMain");
			System.out.println("로그아웃");
			cont.setLoginId("");
		}else if(sel == 0) {
			
		}


		
		
		
		return false;
	}
}