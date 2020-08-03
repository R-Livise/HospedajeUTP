/**
 * 
 */
package com.hospedaje.backend.model;

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
@Table(name = "user_administrator")
@PrimaryKeyJoinColumn(referencedColumnName = "id_user")
public class UserAdministrator extends UserHotel{

	@Column(name = "name", length = 50)
	public String name;
	@Column(name = "type", length = 50)
	public String type;
	
}
