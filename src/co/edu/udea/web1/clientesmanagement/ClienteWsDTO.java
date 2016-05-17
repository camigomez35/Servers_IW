package co.edu.udea.web1.clientesmanagement;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Clase usada como intermediario para traer la informacion de los clientes.
 * 
 * @author Maria Camila Gomez Restrepo
 *
 */
@XmlRootElement
public class ClienteWsDTO {
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
