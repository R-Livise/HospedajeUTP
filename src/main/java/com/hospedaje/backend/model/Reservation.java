/**
 * 
 */
package com.hospedaje.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rafael
 *
 */
@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "id_reservation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "start_at")
	public LocalDate startAt;
	@Column(name = "finish_at")
	public LocalDate finishAt;
	@Column(name = "n_people")
	public int nPeople;
	@Column(name = "registration_time")
	public LocalDateTime resgitrationTime;
	@Column(name = "card_number",length = 50)
	public String cardNumber;
	
	@OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
	public Payment payment;
	
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	public Set<Room> room;
	@ManyToOne
	@JoinColumn(name="id_user_client")
	public UserHotel userCliente;
	@ManyToOne
	@JoinColumn(name="id_user_agent")
	public UserHotel userAgencia;


}