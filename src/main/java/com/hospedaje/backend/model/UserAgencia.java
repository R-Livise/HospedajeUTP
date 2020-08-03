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
@Table(name = "user_agencia")
@PrimaryKeyJoinColumn(referencedColumnName = "id_user")
public class UserAgencia extends UserHotel{
	
	@Column(name = "business_name", length = 50)
	public String businessName;
	@Column(name = "ruc", length = 50)
	public String ruc;
	@Column(name = "address", length = 50)
	public String address;

}
