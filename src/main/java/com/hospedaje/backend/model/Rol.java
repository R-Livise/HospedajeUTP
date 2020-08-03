/**
 * 
 */
package com.hospedaje.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rafael
 *
 */
@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {

	public Rol() {
	}

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "name", length = 50)
	public String name;
	@Column(name = "description", length = 200)
	public String description;

	@ManyToMany(mappedBy = "rol", fetch = FetchType.LAZY)
	@JsonIgnore
	public Set<UserHotel> user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserHotel> getUser() {
		return user;
	}

	public void setUser(Set<UserHotel> user) {
		this.user = user;
	}

}