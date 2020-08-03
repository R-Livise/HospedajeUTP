/**
 * 
 */
package com.hospedaje.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "user_client")
@PrimaryKeyJoinColumn(referencedColumnName = "id_user")
public class UserClient extends UserHotel{

	@Column(name = "name", length = 50)
	public String name;
	@Column(name = "lasname", length = 50)
	public String lasname;
	@Column(name = "dni", length = 50)
	public String dni;
	@Column(name = "sexo", length = 1)
	public String sexo;
	@Column(name = "edad")
	public int edad;
	
}
