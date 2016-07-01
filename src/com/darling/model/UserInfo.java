package com.darling.model;


/**
 * 定义用户信息表
 *
 */
public class UserInfo {

	private String id;
	private String nickname;
	private String name;
	private String birth;
	private String sex;
	private String location;
	private String unit;
	private String department;
	private String job;
	private String password;
	private String deviceId;
	private String unitType;
	
	private GENDER gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickname;
	}
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public GENDER getGender() {
		return gender;
	}
	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	private enum GENDER{
		MAN,WOMAN
	}
			
}

