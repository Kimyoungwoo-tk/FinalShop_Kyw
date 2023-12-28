package dto;

import java.util.Objects;

public class Cart {
	private static int num;
	private int cartNum;
	private String id;
	private int itemNum;
	private int itemCnt;
	
	public Cart() {
		
	}
	
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		Cart.num = num;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getItemCnt() {
		return itemCnt;
	}
	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}
	
	
	Cart(String id, int itemNum, int itemCnt) {
		this.cartNum = ++num;
		this.id = id;
		this.itemNum = itemNum;
		this.itemCnt = itemCnt;
	}
	
	private Cart(String cartNum, String id, String itemNum, String itemCnt) {
		this.cartNum = Integer.parseInt(cartNum);
		this.id = id;
		this.itemNum = Integer.parseInt(itemNum);
		this.itemCnt = Integer.parseInt(itemCnt);
	}
	
	public Cart  CreateCart(String[] info) {
		if(info == null || info.length == 0) return null;
		
		return new Cart(info[0], info[1], info[2], info[3]);
	}
	
	
	@Override
	public String toString() {
		return  itemCnt + "개";
	}

	public String DataToFile() {
		return "%d/%s/%d/%d".formatted(cartNum, id, itemNum, itemCnt);
	}



}