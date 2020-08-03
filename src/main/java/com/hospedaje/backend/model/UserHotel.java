/**
 * 
 */
package com.hospedaje.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserHotel {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "email", length = 50, unique = true)
	public String email;
	@Column(name = "password", length = 100)
	public String password;
	@Column(name = "phone", length = 12)
	public String phone;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "rol_user", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
			@JoinColumn(name = "id_rol") })
	private Set<Rol> rol = new HashSet<Rol>();

	@OneToMany(mappedBy = "userCliente", cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Reservation> reservationCli;

	@OneToMany(mappedBy = "userAgencia", cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Reservation> reservationAge;

}