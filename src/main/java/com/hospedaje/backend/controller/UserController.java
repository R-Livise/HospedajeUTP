/**
 * 
 */
package com.hospedaje.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
@Api(tags = "user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

	@Autowired
	IUserService _userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// GET
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<List<UserHotel>> getUsers() {

		List<UserHotel> users = new ArrayList<>();
		users = _userService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<UserHotel>>(users, HttpStatus.OK);
	}

	// GET
//		@PreAuthorize("hasRole('ROLE_RECEP')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas por ID", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<UserHotel> getSocialMediaById(@PathVariable("id") Long idUser,
			@RequestParam(value = "embedder", required = false) String embedder) {
		if (idUser == null || idUser <= 0) {
			return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
		}

		UserHotel user = _userService.findById(idUser);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

//			if (embedder != null) {
//				//System.out.println(user.toString());
//				System.out.println(user.getRol());
//			}

		return new ResponseEntity<UserHotel>(user, HttpStatus.OK);
	}

	// POST
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear un nueva reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<?> createUser(@RequestBody UserHotel user, UriComponentsBuilder uriComponentsBuilder) {
		if (user.getEmail().equals(null) || user.getEmail().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		if (_userService.findByNickname(user.getNickname()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		user.setPassword(encoder.encode(user.getPassword()));

		_userService.create(user);

		UserHotel user2 = _userService.findByNickname(user.getNickname());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/user/{id}").buildAndExpand(user2.getId()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// UPDATE
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrada") })
	public ResponseEntity<UserHotel> updateUser(@PathVariable("id") Long idUser,
			@RequestBody UserHotel user) {
		if (idUser == null || idUser <= 0) {
			return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
		}

		UserHotel currentUser = _userService.findById(idUser);
		if (currentUser == null) {
			return new ResponseEntity(new CustomErrorType("no existe el ususraio"), HttpStatus.NO_CONTENT);
		}

		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPassword(encoder.encode(user.getPassword()));

		System.out.println(currentUser.getPassword());

		_userService.update(currentUser);
		return new ResponseEntity<UserHotel>(currentUser, HttpStatus.OK);
	}

	// DELETE
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva eliminada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrada") })
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long idUser) {
		if (idUser == null || idUser <= 0) {
			return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
		}

		UserHotel user = _userService.findById(idUser);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_userService.deleteById(idUser);
		return new ResponseEntity<UserHotel>(HttpStatus.OK);

	}

}
