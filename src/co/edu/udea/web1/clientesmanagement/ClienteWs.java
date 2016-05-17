package co.edu.udea.web1.clientesmanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;
import javassist.tools.rmi.RemoteException;

/**
 * Se establece como un servicio web para mostrar una lista de clientes
 * Usando la conexión con el proyecto SpringExample
 * @author Maria Camila G�mez Restrepo
 *
 */
@Component
@Path("Clientes")
public class ClienteWs{
	/**
	 * @Autowired para inyección de dependencias en el objeto clienteService
	 */
	@Autowired
	ClienteService clienteService;
	
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<ClienteWsDTO> obtener(){
		/**
		 * Para evitar brechas de seguridad y tráfico innecesario de la red
		 * se manejan los objetos Cliente como ClienteWsDTO
		 * 
		 * Se itera sobre los objetos Cliente y se obtienen los datos asignándolos a 
		 * objetos ClienteWsDTO
		 */
		List<ClienteWsDTO> lista = new ArrayList<ClienteWsDTO>();
		try{
			for (Cliente cliente : clienteService.obtener()) {
				ClienteWsDTO clienteWsDto = new ClienteWsDTO();
				clienteWsDto.setCedula(cliente.getCedula());
				clienteWsDto.setNombre(cliente.getNombres());
				clienteWsDto.setApellido(cliente.getApellidos());
				clienteWsDto.setEmail(cliente.getCorreoElectronico());
				lista.add(clienteWsDto);	
			}
		} catch(IWDaoException e){
			throw new RemoteException(e);
		}
		return lista;
	}
}
