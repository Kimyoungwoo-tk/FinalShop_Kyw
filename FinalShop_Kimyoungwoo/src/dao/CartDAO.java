package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dto.Cart;
import dto.Item;

public class CartDAO {
	private static CartDAO instance = new CartDAO();
	private static ArrayList<Cart> cList;

	public CartDAO() {
		cList = new ArrayList<Cart>();
	}

	public static CartDAO getInstance() {
		return instance;
	}

	public ArrayList<Cart> getcList() {
		return cList;
	}
	// 회원 삭제 시 카트 삭제
	public void MemberDelete(String id) {
		if (cList.size() == 0)
			return;

		for (int i = 0; i < cList.size(); i += 1) {
			if (cList.get(i).getId().equals(id)) {
				cList.remove(i);
				i--;
			}
		}
	}
	
	public void DeleteItem(int itemNum) {
		if (cList.size() == 0)
			return;
		for (int i = 0; i < cList.size(); i += 1) {
			if (cList.get(i).getItemNum() == itemNum) {
				cList.remove(i);
				i--;
			}
		}
	}
	
	public static String DataToFile() {
		String data = "";
		if (cList.size() == 0)
			return data;
		for (Cart c : cList) {
			data += c.DataToFile() + "\n";
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}
	
	public static void FileToData(List<String> cData) {
		if (cData.isEmpty())
			return;

		int maxCartNum = 0;
		for (int i = 0; i < cData.size(); i += 1) {
			Cart c = new Cart();
			String[] info = cData.get(i).split("/");
			c = c.CreateCart(info);
			cList.add(c);
			if (maxCartNum < Integer.parseInt(info[0])) {
				maxCartNum = Integer.parseInt(info[0]);
			}
		}
		Cart.setNum(maxCartNum);
	}
	
}