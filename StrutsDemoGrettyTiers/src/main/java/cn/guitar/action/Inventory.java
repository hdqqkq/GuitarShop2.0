package cn.guitar.action;

import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.guitar.domain.Guitar;
import cn.guitar.domain.GuitarSpec;
import cn.guitar.service.GuitarService;
import cn.guitar.service.GuitarServiceDB;

public class Inventory extends ActionSupport  {
	
	private static final long serialVersionUID = 1L;
	private String serialNumber, builder, model, type, backWood, topWood;
	private double price;	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String search() {
		Guitar searchGuitar = new Guitar(serialNumber, price,
				new GuitarSpec(builder, model, type, backWood, topWood));
		GuitarService guitarService = new GuitarServiceDB();
		guitarService.Search(searchGuitar);
		ActionContext.getContext().put("guitar", guitarService.Search(searchGuitar).get(0));
		return SUCCESS;
		}

}
