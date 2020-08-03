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
import com.hospedaje.backend.model.UserClient;
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
@Api(tags = "client")
public class ClientController {

	@Autowired
	@Qualifier("Client")
	IUserService _clientAgenciaService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// GET
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/client", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar Address", notes = "Servicio para listar todas las direcciones")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontradas"),
			@ApiResponse(code = 404, message = "Direccion no encontrados") })
	public ResponseEntity<List<UserAgencia>> getAddress() {

		List<UserAgencia> address = new ArrayList<>();
		address = (List<UserAgencia>) (List<?>) _clientAgenciaService.findAll();
		if (address.isEmpty()) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<List<UserAgencia>>(address, HttpStatus.OK);
	}

	// GET
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar direcciones por ID", notes = "Servicio para listar todas las direciones")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontrados"),
			@ApiResponse(code = 404, message = "Direcciones no encontrados") })
	public ResponseEntity<UserClient> getAddressId(@PathVariable("id") Long idAddress) {

		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("direcciones is required"), HttpStatus.CONFLICT);
		}

		UserClient address = (UserClient) _clientAgenciaService.findById(idAddress);
		if (address == null) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<UserClient>(address, HttpStatus.OK);
	}

	// POST
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/client", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear un nueva direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<?> createAddress(@RequestBody UserClient address, UriComponentsBuilder uriComponentsBuilder) {
		address.setPassword(encoder.encode(address.getPassword()));
		_clientAgenciaService.create(address);

		return new ResponseEntity(HttpStatus.OK);
	}

	// UPDATE
	@RequestMapping(value = "/client/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	@ApiOperation(value = "Actualizar Direcciones", notes = "Servicio para actualizar una direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones actualizada correctamente"),
			@ApiResponse(code = 404, message = "Direcciones no encontrada") })
	public ResponseEntity<UserClient> updateAddress(@PathVariable("id") Long idAddress,
			@RequestBody UserClient address) {
		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("direccion is required"), HttpStatus.CONFLICT);
		}

		address.setId(idAddress);
		address.setPassword(encoder.encode(address.getPassword()));
		_clientAgenciaService.update(address);

		UserClient newCurrentAddress = (UserClient) _clientAgenciaService.findById(idAddress);

		return new ResponseEntity<UserClient>(newCurrentAddress, HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar direccion", notes = "Servicio para eliminar una direccion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion eliminada correctamente"),
			@ApiResponse(code = 404, message = "Direccion no encontrada") })
	public ResponseEntity<?> deleteAddress(@PathVariable("id") Long idAddress) {
		if (idAddress == null || idAddress <= 0) {
			return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
		}

		UserClient address = (UserClient) _clientAgenciaService.findById(idAddress);
		if (address == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_clientAgenciaService.deleteById(idAddress);
		return new ResponseEntity<UserClient>(HttpStatus.OK);

	}

}
