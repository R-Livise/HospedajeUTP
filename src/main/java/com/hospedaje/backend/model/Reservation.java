/**
 * 
 */
package com.hospedaje.backend.model;

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

/**
 * @author rafael
 *
 */
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "id_reservation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	public Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finish_at")
	public Date finishAt;
	@Column(name = "day_use")
	public int dayUse;
	
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