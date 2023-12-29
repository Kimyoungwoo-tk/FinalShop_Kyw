package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.ItemDAO;
import dto.Cart;
import dto.Item;
import util.Util;

public class MemberShopping implements MenuCommand {
	private MallController cont = MallController.getInstance();

	

	@Override
	public boolean update() {
		CartDAO cDAO = CartDAO.getInstance();
		ItemDAO iDAO = ItemDAO.getInstance();
		
		cont.setNext("MemberMain");
		System.out.println("====쇼핑몰에 오신것을 환영합니다====");
		iDAO.CategoryList();
		int cgSize = ItemDAO.getCategoryList().size();
		
		int idx = Util.getValue("선택", 1, cgSize)-1;
		if(idx == -2) return false;
		
		String cgName = iDAO.getCategoryName(idx);
		ArrayList<Item> cgItemList = iDAO.CategoryToItemList(cgName);
		
		int itemIdx = Util.getValue("선택",1,cgItemList.size()) -1;
		if(itemIdx == -2) return false;
		
		int cnt = Util.getValue("구매수량", 1, 100);
		if(cnt ==-1) return false;
		
		
		//카트 중복검사
		int cartNum = cDAO.cartNumvalue(cont.getLoginId(), cgItemList.get(itemIdx).getItemNum());
		if(cartNum != -1) {
			Cart info = cDAO.getcList().get(cartNum);
			info.setItemCnt(info.getItemCnt()+cnt);
			System.out.println("%s %d개 구매완료".formatted(cgItemList.get(itemIdx).getItemName(),cnt));
			return false;
		}
		
		Cart cart = new Cart(cont.getLoginId(),cgItemList.get(itemIdx).getItemNum(),cnt);
		cDAO.getcList().add(cart);
		
		System.out.println("%s %d개 구매완료".formatted(cgItemList.get(itemIdx).getItemName(),cnt));

		
		
		
		return false;
	}

}
