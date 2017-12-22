package com.ytzh.pojo;

public class Goods {
	private String g_id;
	private String g_name;
	private String g_vendibility;
	private String g_stock;
	private String cost_integration;
	private String g_type;
	private String g_brand;
	private String g_synopsis;
	private String g_img;
	private String g_img_size;
	private String state;
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String gId) {
		g_id = gId;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String gName) {
		g_name = gName;
	}
	public String getG_vendibility() {
		return g_vendibility;
	}
	public void setG_vendibility(String gVendibility) {
		g_vendibility = gVendibility;
	}
	public String getG_stock() {
		return g_stock;
	}
	public void setG_stock(String gStock) {
		g_stock = gStock;
	}
	public String getCost_integration() {
		return cost_integration;
	}
	public void setCost_integration(String costIntegration) {
		cost_integration = costIntegration;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String gType) {
		g_type = gType;
	}
	public String getG_brand() {
		return g_brand;
	}
	public void setG_brand(String gBrand) {
		g_brand = gBrand;
	}
	public String getG_synopsis() {
		return g_synopsis;
	}
	public void setG_synopsis(String gSynopsis) {
		g_synopsis = gSynopsis;
	}
	public String getG_img() {
		return g_img;
	}
	public void setG_img(String gImg) {
		g_img = gImg;
	}
	public String getG_img_size() {
		return g_img_size;
	}
	public void setG_img_size(String gImgSize) {
		g_img_size = gImgSize;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Goods [cost_integration=" + cost_integration + ", g_brand="
				+ g_brand + ", g_id=" + g_id + ", g_img=" + g_img
				+ ", g_img_size=" + g_img_size + ", g_name=" + g_name
				+ ", g_stock=" + g_stock + ", g_synopsis=" + g_synopsis
				+ ", g_type=" + g_type + ", g_vendibility=" + g_vendibility
				+ ", state=" + state + "]";
	}
	
	
}
