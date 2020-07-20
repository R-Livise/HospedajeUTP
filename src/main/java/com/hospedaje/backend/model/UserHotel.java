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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rafael
 *
 */
@Entity
@Table(name = "user")
public class UserHotel {

	public UserHotel() {
	}

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "name", length = 50)
	public String name;
	@Column(name = "lasname", length = 50)
	public String lasname;
	@Column(name = "nickname", length = 50)
	public String nickname;
	@Column(name = "password", length = 50)
	public String password;
	@Column(name = "typo_user", length = 20)
	public String typeUser;
	@Column(name = "phone", length = 12)
	public String phone;
	@Column(name = "email", length = 30)
	public String email;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "rol_user", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
			@JoinColumn(name = "id_rol") })
	private Set<Rol> rol = new HashSet<Rol>();
	
	@OneToMany(mappedBy = "userCliente", cascade = CascadeType.ALL)
	public Set<Reservation> reservationCli;
	
	@OneToMany(mappedBy = "userAgencia", cascade = CascadeType.ALL)
	public Set<Reservation> reservationAge;

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

	public String getLasname() {
		return lasname;
	}

	public void setLasname(String lasname) {
		this.lasname = lasname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

	public Set<Reservation> getReservationCli() {
		return reservationCli;
	}

	public void setReservationCli(Set<Reservation> reservationCli) {
		this.reservationCli = reservationCli;
	}

	public Set<Reservation> getReservationAge() {
		return reservationAge;
	}

	public void setReservationAge(Set<Reservation> reservationAge) {
		this.reservationAge = reservationAge;
	}

	
	
}