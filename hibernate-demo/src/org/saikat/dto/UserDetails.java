package org.saikat.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_JOINING")
	private Date joinedDate;
	
	@Column(name="USER_DESC")
	private String description;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
	@SequenceGenerator(name="sequence-gen", sequenceName="adress_seq", initialValue=1, allocationSize=12)
	@CollectionId(columns = {@Column(name="ADDRESS_ID")}, generator = "sequence-gen", type = @Type(type = "long"))
	private List<Address> listOfAddresses = new ArrayList<>();
	
	protected UserDetails() {
	}
	
	public UserDetails(String userName, Date joinedDate, List<Address> listOfAddressses, String description) {
		super();
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.listOfAddresses = listOfAddressses;
		this.description = description;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate
				+ ", description=" + description + ", listOfAddresses=" + listOfAddresses + "]";
	}
}
