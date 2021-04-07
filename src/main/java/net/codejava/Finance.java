package net.codejava;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="financetable")
public class Finance {
	
	@Id
	@Column(name="serielNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serielNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="totalAmount")
	private double totalAmount;
	
	@Column(name="givenAmount")
	private double givenAmount;
	
	@Column(name="takemAmount")
	private double takemAmount;
	
	@NotNull
	@Column(name="city")
	private String city;
	
	@Column(name="date")
	private Date date;
	
	public Finance() {
		super();
	}
	
	public int getSerielNumber() {
		return serielNumber;
	}
	public void setSerielNumber(int serielNumber) {
		this.serielNumber = serielNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getGivenAmount() {
		return givenAmount;
	}
	public void setGivenAmount(double givenAmount) {
		this.givenAmount = givenAmount;
	}
	public double getTakemAmount() {
		return takemAmount;
	}
	public void setTakemAmount(double takemAmount) {
		this.takemAmount = takemAmount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Finance(int serielNumber, String name, double totalAmount, double givenAmount, double takemAmount,
			String city, Date date) {
		super();
		this.serielNumber = serielNumber;
		this.name = name;
		this.totalAmount = totalAmount;
		this.givenAmount = givenAmount;
		this.takemAmount = takemAmount;
		this.city = city;
		this.date = date;
	}
	
	
	

}
