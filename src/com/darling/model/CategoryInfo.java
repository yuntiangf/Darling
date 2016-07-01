package com.darling.model;

public class CategoryInfo {
	
	//商品类别识别码id
	private String category_id;
			
	//商品类别图片
	private int category_image;
			
	//商品类别名称
	private String category_name;

	//“发现”的类别界面用到的构造函数
	public CategoryInfo(int category_image) {
		super();
		this.category_image = category_image;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public int getCategory_image() {
		return category_image;
	}

	public void setCategory_image(int category_image) {
		this.category_image = category_image;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
