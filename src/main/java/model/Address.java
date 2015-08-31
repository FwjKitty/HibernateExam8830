package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="address")
@Table(name="address")
public class Address {

	private int address_id;
	private String address;
	private String address2;
	private String district;
	private int city_id;
	//private City city;
	private String postal_code;
	private String phone;
	private Timestamp last_update;
	@Id
	@Column(name="address_id",unique=true,nullable=false)
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	@Column(name="city_id",nullable=false)
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	@Column(name="address",nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Column(name="district")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	/*public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}*/
	@Column(name="postal_code")
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="last_update",nullable=false)
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Address(){};
}