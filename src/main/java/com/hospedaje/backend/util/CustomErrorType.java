/**Decorador de errores
 * 
 */
package com.hospedaje.backend.util;

/**
 * @author rafael
 *
 */
public class CustomErrorType {
	
	public static int NO_EXIST = 1;
	public static int EXIST = 1;
	public static int NECESARY = 1;
	
	private String errorMessage;
	
	

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CustomErrorType(int message, Class<?> entidad) {

		String nombre = entidad.getName();
		
		switch (message) {
		case 1:
			this.errorMessage = "no extiste" + nombre;
			break;
		case 2:
			this.errorMessage = nombre + "is nesario para la copmletar";
			break;
		case 3:
			this.errorMessage = nombre + "is nesario para la copmletar";
			break;
		default:
			break;
		}
	}

	public String getErrorMessage() {

		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
