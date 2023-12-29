package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;

public class AdminMemberList implements MenuCommand {
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		
		cont.setNext("AdminMember");
		if(mDAO.getmList().size()==0) {
			System.out.println("회원이 존재하지 않습니다");
			return false;
		}
		
		mDAO.MemberList();
		return false;
	}
}