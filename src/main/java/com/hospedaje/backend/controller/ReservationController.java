/**
 * 
 */
package com.hospedaje.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hospedaje.backend.model.Product;
import com.hospedaje.backend.model.Reservation;
import com.hospedaje.backend.service.interfaces.IProductService;
import com.hospedaje.backend.service.interfaces.IReservationService;
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
@Api(tags = "reservation")
public class ReservationController {

	@Autowired
	IReservationService _reservationService;

	// GET
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/reservation", method = RequestMethod.GET, headers = "Accept=application/json")
		@ApiOperation(value = "Listar Address", notes = "Servicio para listar todas las direcciones")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontradas"),
				@ApiResponse(code = 404, message = "Direccion no encontrados") })
		public ResponseEntity<List<Reservation>> getAddress() {

			List<Reservation> address = new ArrayList<>();
			address = _reservationService.findAll();
			if (address.isEmpty()) {
				return new ResponseEntity(HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity<List<Reservation>>(address, HttpStatus.OK);
		}

		
		// GET
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		@ApiOperation(value = "Listar direcciones por ID", notes = "Servicio para listar todas las direciones")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones encontrados"),
				@ApiResponse(code = 404, message = "Direcciones no encontrados") })
		public ResponseEntity<Reservation> getAddressId(@PathVariable("id") Long idAddress) {
			
			if (idAddress == null || idAddress <= 0) {
				return new ResponseEntity(new CustomErrorType("direcciones is required"), HttpStatus.CONFLICT);
			}

			Reservation address= _reservationService.findById(idAddress);
			if (address == null) {
				return new ResponseEntity(HttpStatus.CONFLICT);
			}
			return new ResponseEntity<Reservation>(address, HttpStatus.OK);
		}
		
		// POST
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/reservation", method = RequestMethod.POST, headers = "Accept=application/json")
		@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear un nueva direccion")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion creada correctamente"),
				@ApiResponse(code = 400, message = "Solicitud Inválida") })
		public ResponseEntity<?> createAddress(@RequestBody Reservation address, UriComponentsBuilder uriComponentsBuilder) {
		
			_reservationService.create(address);
			
			return new ResponseEntity(HttpStatus.OK);
		}

		// UPDATE
		@RequestMapping(value = "/reservation/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
		@ApiOperation(value = "Actualizar Direcciones", notes = "Servicio para actualizar una direccion")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Direcciones actualizada correctamente"),
				@ApiResponse(code = 404, message = "Direcciones no encontrada") })
		public ResponseEntity<Reservation> updateAddress(@PathVariable("id") Long idAddress,
				@RequestBody Reservation address) {
			if (idAddress == null || idAddress <= 0) {
				return new ResponseEntity(new CustomErrorType("direccion is required"), HttpStatus.CONFLICT);
			}

			address.setId(idAddress);
			
			_reservationService.update(address);
			
			Reservation newCurrentAddress = _reservationService.findById(idAddress);
			
			return new ResponseEntity<Reservation>(newCurrentAddress, HttpStatus.OK);
		}

		// DELETE
		@RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
		@ApiOperation(value = "Eliminar direccion", notes = "Servicio para eliminar una direccion")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Direccion eliminada correctamente"),
				@ApiResponse(code = 404, message = "Direccion no encontrada") })
		public ResponseEntity<?> deleteAddress(@PathVariable("id") Long idAddress) {
			if (idAddress == null || idAddress<= 0) {
				return new ResponseEntity(new CustomErrorType("user is required"), HttpStatus.CONFLICT);
			}

			Reservation address = _reservationService.findById(idAddress);
			if (address == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			_reservationService.deleteById(idAddress);
			return new ResponseEntity<Reservation>(HttpStatus.OK);

		}
}
