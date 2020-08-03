/**
 * 
 */
package com.hospedaje.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rafael
 *
 */
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {

	public Room() {
	}

	@Id
	@Column(name = "id_room")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "typo_room", length = 50)
	public String typoRoom;
	@Column(name = "number")
	public int number;
	@Column(name = "floor")
	public int floor;
	@Column(name = "code", length = 50)
	public String code;
	@Column(name = "nBed", length = 50)
	public String nBed;
	@Column(name = "status")
	public boolean status;
	
	@ManyToOne
	@JoinColumn(name="id_reservation")
	public Reservation reservation;

	
}