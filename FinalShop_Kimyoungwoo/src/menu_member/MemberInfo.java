package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import util.Util;

public class MemberInfo implements MenuCommand {
	private MallController cont = MallController.getInstance();
	
	
	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		cont.setNext("MemberInfo");
		System.out.println("===[내정보]===");
		System.out.println("[1] 비밀번호 수정");
		System.out.println("[2] 뒤로가기");
		System.out.println("[0] 종료");
		
		mDAO.getmList().stream()
					.filter(a -> a.getId().equals(cont.getLoginId()))
					.forEach(System.out::println);
		
		int sel = Util.getValue("선택", 0, 2);
		if(sel ==1) {
			cont.setNext("MemberChangePw");
		}else if(sel ==2) {
			cont.setNext("MemberMain");
		}else if (sel ==0) {
			cont.setNext("");
		}

		return false;
	}
}