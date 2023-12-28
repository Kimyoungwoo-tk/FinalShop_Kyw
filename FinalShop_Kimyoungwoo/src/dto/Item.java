package dto;

public class Item {
	private static int num;
	private int itemNum;
	private String categoryName;
	private String itemName;
	private int price;

	public Item() {
		
	}

	public Item(String categoryName, String itemName, int price) {
		this.itemNum = num++;
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.price = price;
	}

	private Item(String itemNum, String categoryName, String itemName, String price) {
		this.itemNum = Integer.parseInt(itemNum);
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
	}
	
	
	public String DataToFile() {
		return "%d/%s/%s/%d".formatted(itemNum, categoryName, itemName, price);
	}
	
	
	public Item CreateItem(String[] info) {
		if (info == null || info.length == 0)
			return null;

		return new Item(info[0], info[1], info[2], info[3]);
	}

	public String printItem() {
		return "%s".formatted(itemName);
	}
	
	@Override
	public String toString() {
		return "[%d]\t[%s]\t[%s]\t[%d원]".formatted(itemNum, categoryName, itemName, price);
	}
	
	

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Item.num = num;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}