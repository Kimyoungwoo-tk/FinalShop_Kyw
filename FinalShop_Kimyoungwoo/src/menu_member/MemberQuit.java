package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.MemberDAO;
import util.Util;

public class MemberQuit implements MenuCommand{
	private MallController cont = MallController.getInstance();

	

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		CartDAO cDAO = CartDAO.getInstance();
		
		cont.setNext("MallMain");
		int idIdx = mDAO.idValue(cont.getLoginId());
		mDAO.MemberDelete(idIdx);
		cDAO.MemberDelete(cont.getLoginId());
		System.out.println("회원 탈퇴 완료");
		cont.setLoginId("");
			
		return false;
	}
	
}