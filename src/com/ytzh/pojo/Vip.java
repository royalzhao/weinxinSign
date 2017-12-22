package com.ytzh.pojo;

public class Vip {
	private String 	openid;
	private String v_name;
	private String v_pass;
	private String v_grades;
	private String v_integration;
	private String register_date;
	private String sex;
	private String birthday;
	private String mobile_phone;
	private String fixed_line;
	private String c_integration;
	private String zip_code;
	private String state;
	private String continuities;
	private String s_date;
	private String sign_in_integration;
	//积分排名
    private String rownum;
	
	
	public String getRownum() {
		return rownum;
	}



	public void setRownum(String rownum) {
		this.rownum = rownum;
	}



	public String getOpenid() {
		return openid;
	}



	public void setOpenid(String openid) {
		this.openid = openid;
	}



	public String getV_name() {
		return v_name;
	}



	public void setV_name(String vName) {
		v_name = vName;
	}



	public String getV_pass() {
		return v_pass;
	}



	public void setV_pass(String vPass) {
		v_pass = vPass;
	}



	public String getV_grades() {
		return v_grades;
	}



	public void setV_grades(String vGrades) {
		v_grades = vGrades;
	}



	public String getV_integration() {
		return v_integration;
	}



	public void setV_integration(String vIntegration) {
		v_integration = vIntegration;
	}



	public String getRegister_date() {
		return register_date;
	}



	public void setRegister_date(String registerDate) {
		register_date = registerDate;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getMobile_phone() {
		return mobile_phone;
	}



	public void setMobile_phone(String mobilePhone) {
		mobile_phone = mobilePhone;
	}



	public String getFixed_line() {
		return fixed_line;
	}



	public void setFixed_line(String fixedLine) {
		fixed_line = fixedLine;
	}



	public String getC_integration() {
		return c_integration;
	}



	public void setC_integration(String cIntegration) {
		c_integration = cIntegration;
	}



	public String getZip_code() {
		return zip_code;
	}



	public void setZip_code(String zipCode) {
		zip_code = zipCode;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getContinuities() {
		return continuities;
	}



	public void setContinuities(String continuities) {
		this.continuities = continuities;
	}



	public String getS_date() {
		return s_date;
	}



	public void setS_date(String sDate) {
		s_date = sDate;
	}



	public String getSign_in_integration() {
		return sign_in_integration;
	}



	public void setSign_in_integration(String signInIntegration) {
		sign_in_integration = signInIntegration;
	}



	@Override
	public String toString() {
		return "Vip [birthday=" + birthday + ", c_integration=" + c_integration
				+ ", continuities=" + continuities + ", fixed_line="
				+ fixed_line + ", mobile_phone=" + mobile_phone + ", openid="
				+ openid + ", register_date=" + register_date + ", rownum="
				+ rownum + ", s_date=" + s_date + ", sex=" + sex
				+ ", sign_in_integration=" + sign_in_integration + ", state="
				+ state + ", v_grades=" + v_grades + ", v_integration="
				+ v_integration + ", v_name=" + v_name + ", v_pass=" + v_pass
				+ ", zip_code=" + zip_code + "]";
	}



	
	
	
}
