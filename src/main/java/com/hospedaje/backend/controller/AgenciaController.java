/**
 * 
 */
package com.hospedaje.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hospedaje.backend.model.UserAgencia;
import com.hospedaje.backend.model.UserHotel;
import com.hospedaje.backend.service.interfaces.IUserService;
import com.hospedaje.backend.util.CustomErrorType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author rafael
 *
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "agencia")
public class AgenciaController {

	@Autowired
	@Qualifier("Agencia")
	IUserService _userAgenciaService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// GET
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/agencia", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar Address", notes = "Servicio para listar todas las direcciones")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontradas"),
			@ApiResponse(code = 404, message = "Direccion no encontrados") })
	public ResponseEntity<List<UserAgencia>> getAddress() {

		List<UserAgencia> address = new ArrayList<>();
		address = (List<UserAgencia>) (List<?>) _userAgenciaService.findAll();
		if (address.isEmpty()) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<List<UserAgencia>>(address, HttpStatus.OK);
	}

	// GET
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar direcciones por ID", notes = "Servicio para listar todas las direciones")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontrados"),
			@ApiResponse(code = 404, message = "Direcciones no encontrados") })
	public ResponseEntity<UserAgencia> getAddressId(@PathVariable("id") Long idAddress) {

		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("direcciones is required"), HttpStatus.CONFLICT);
		}

		UserAgencia address = (UserAgencia) _userAgenciaService.findById(idAddress);
		if (address == null) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<UserAgencia>(address, HttpStatus.OK);
	}

	// POST
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/agencia", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear un nueva direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<?> createAddress(@RequestBody UserAgencia address,
			UriComponentsBuilder uriComponentsBuilder) {

		address.setPassword(encoder.encode(address.getPassword()));

		_userAgenciaService.create(address);

		return new ResponseEntity(HttpStatus.OK);
	}

	// UPDATE
	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	@ApiOperation(value = "Actualizar Direcciones", notes = "Servicio para actualizar una direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones actualizada correctamente"),
			@ApiResponse(code = 404, message = "Direcciones no encontrada") })
	public ResponseEntity<UserAgencia> updateAddress(@PathVariable("id") Long idAddress,
			@RequestBody UserAgencia address) {
		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("direccion is required"), HttpStatus.CONFLICT);
		}

		address.setId(idAddress);
		address.setPassword(encoder.encode(address.getPassword()));
		_userAgenciaService.update(address);

		UserAgencia newCurrentAddress = (UserAgencia) _userAgenciaService.findById(idAddress);

		return new ResponseEntity<UserAgencia>(newCurrentAddress, HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar direccion", notes = "Servicio para eliminar una direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion eliminada correctamente"),
			@ApiResponse(code = 404, message = "Direccion no encontrada") })
	public ResponseEntity<?> deleteAddress(@PathVariable("id") Long idAddress) {
		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
		}

		UserAgencia address = (UserAgencia) _userAgenciaService.findById(idAddress);
		if (address == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_userAgenciaService.deleteById(idAddress);
		return new ResponseEntity<UserAgencia>(HttpStatus.OK);

	}
}
