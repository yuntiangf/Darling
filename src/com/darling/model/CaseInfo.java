package com.darling.model;

/**
 * 搭配案例类
 * @author:MushRoom
 * @date:2015-10-24 下午10:47:58
 */
public class CaseInfo {

	//案例识别码id
	private String case_id;
	
	//案例提交者识别码
	private String user_id;
	
	//案例提交者名称
	private String user_name;
	
	//喜欢人数
	private int lover_num;
	
	//案例风格
	private String case_style;
	
	//案例描述
	private String case_description;
	
	//初始化社区界面的时候需要用的构造函数
	public CaseInfo(String caseId,String userId,String userName,int loverNum){
		this.case_id=caseId;
		this.user_id=userId;
		this.user_name=userName;
		this.lover_num=loverNum;
	}
	
	//初始化“美丽搭”界面需要用的构造函数
	public CaseInfo(String caseId,String caseStyle,String caseDescription){
		this.case_id=caseId;
		this.case_style=caseStyle;
		this.case_description=caseDescription;
	}

	public String getCase_id() {
		return case_id;
	}

	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getLover_num() {
		return lover_num;
	}

	public void setLover_num(int lover_num) {
		this.lover_num = lover_num;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getCase_style() {
		return case_style;
	}

	public void setCase_style(String case_style) {
		this.case_style = case_style;
	}

	public String getCase_description() {
		return case_description;
	}

	public void setCase_description(String case_description) {
		this.case_description = case_description;
	}
}
