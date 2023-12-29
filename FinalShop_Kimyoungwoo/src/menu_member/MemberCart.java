package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.ItemDAO;
import dao.MemberDAO;
import util.Util;

public class MemberCart implements MenuCommand {
	
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		CartDAO cDAO = CartDAO.getInstance();
		cont.setNext("MemberCart");

		System.out.println("=====[구매내역]=====");
		if(cDAO.getMyCartList(cont.getLoginId())) {
			System.out.println("장바구니에 상품이 없습니다");
			cont.setNext("MemberMain");
			return false;
		}
		
		System.out.println("[1] 쇼핑하기");
		System.out.println("[2] 뒤로가기");
		System.out.println("[0] 종료");
		int sel = Util.getValue("메뉴선택", 0, 2);
		
		if(sel ==1) {
			cont.setNext("MemberShopping");
		}else if(sel ==2) {
			cont.setNext("MemberMain");
		}else if(sel ==3) {
			cont.setNext("");
		}
			
		return false;
	}

}
