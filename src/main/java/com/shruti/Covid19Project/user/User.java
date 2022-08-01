package com.shruti.Covid19Project.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer Id;
	private String Country;
	private Integer Total_Cases;
	private Integer Active_Cases;
	private Integer Recovered;
	private Integer Decreased;

	protected User() {

	}

	public User(Integer id, String country, Integer total_Cases, Integer active_Cases, Integer recovered,
			Integer decreased) {
		super();
		Id = id;
		Country = country;
		Total_Cases = total_Cases;
		Active_Cases = active_Cases;
		Recovered = recovered;
		Decreased = decreased;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Integer getTotal_Cases() {
		return Total_Cases;
	}

	public void setTotal_Cases(Integer total_Cases) {
		Total_Cases = total_Cases;
	}

	public Integer getActive_Cases() {
		return Active_Cases;
	}

	public void setActive_Cases(Integer active_Cases) {
		Active_Cases = active_Cases;
	}

	public Integer getRecovered() {
		return Recovered;
	}

	public void setRecovered(Integer recovered) {
		Recovered = recovered;
	}

	public Integer getDecreased() {
		return Decreased;
	}

	public void setDecreased(Integer decreased) {
		Decreased = decreased;
	}

	@Override
	public String toString() {
		return String.format("User [Id=%s, Country=%s, Total_Cases=%s, Active_Cases=%s, Recovered=%s, Decreased=%s]",
				Id, Country, Total_Cases, Active_Cases, Recovered, Decreased);
	}

}