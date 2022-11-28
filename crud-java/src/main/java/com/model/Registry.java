package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "registrations_new")
public class Registry implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(nullable = false, length = 120)
	private String name;
	@Column(nullable = false, length = 18)
	private String cpf;
	@Column(name = "registry_date")
	@Temporal(TemporalType.DATE)
	private Date registryDate;
	@Column(nullable = false, length = 120)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private ProfileType profile;
	@Column
	private List<Adress> adress;
	
	public List<Adress> getAdress() {
		return adress;
	}
	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registry other = (Registry) obj;
		return Objects.equals(id, other.id);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getRegistryDate() {
		return registryDate;
	}
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProfileType getProfile() {
		return profile;
	}
	public void setProfile(ProfileType profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "Registry [id=" + id + "]";
	}
	
	
	
	
	

}
