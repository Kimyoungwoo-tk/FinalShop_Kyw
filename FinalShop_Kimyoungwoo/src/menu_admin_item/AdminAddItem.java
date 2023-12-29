package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import dao.ItemDAO;
import dto.Item;
import util.Util;

public class AdminAddItem implements MenuCommand {
	private MallController cont = MallController.getInstance();
	
	@Override
	public boolean update() {
		ItemDAO iDAO = ItemDAO.getInstance();
		cont.setNext("AdminItem");
		iDAO.itemListPrint();
		String  itemName = Util.getValue("아이템 입력:");
		
		long iCnt =iDAO.getItemList()
					   .stream()
					   .filter(i->i.getItemName().equals(itemName))
					   .count();
		
		long cgCnt = iDAO.getItemList()
						.stream()
						.filter(i-> i.getCategoryName().equals(itemName))
						.count();
		
		if(iCnt+cgCnt>0) {
			System.out.println("이미 있는 카테고리/아이템 이름입니다");
			return false;
		}
		
		String cgName = Util.getValue("카테고리 입력:");
		int price = Util.getValue("가격", 100, 1000000);
		
		if(price == -1) {
			return false;
		}
		iDAO.getItemList().add(new Item(cgName,itemName,price));
		
		
		
		
		
		
		
		return false;
	}

}
