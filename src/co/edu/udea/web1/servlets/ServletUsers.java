package co.edu.udea.web1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;

/**
 * Servicio utilizado para mostrar la lista de los clientes.
 * 
 * @author Maria Camila Gomez
 */
@WebServlet("/ServletUsers")
public class ServletUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClienteService clienteService = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsers() {
        super();
    }

	/**
	 * Al realizar una petición al servidor se muestra una tabla con la informacion de los clientes.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista = null;
		PrintWriter output = response.getWriter();
		try {
			lista = clienteService.obtener();
		
		output.println("<html>");
		output.println("<body>");
		output.println("<b1>TABLA DE CLIENTES</b1>");
		output.println("</br>");
		output.println("<table border=1>");
		output.println("<tr>");
		output.println("<th>Cedula</th>");
		output.println("<th>Nombre Completo</th>");
		output.println("<th>Correo</th>");
		output.println("</tr>");
		for (Cliente cliente : lista) {
			output.println("<tr>");
			output.println("<td>"+cliente.getCedula()+"</td>");
			output.println("<td>"+cliente.getNombres()+" "+cliente.getApellidos()+"</td>");
			output.println("<td>"+cliente.getCorreoElectronico()+"</td>");
			output.println("</tr>");
		}
		output.println("</table>");
		output.println("</body>");
		output.println("</html>");

		} catch (IWDaoException e) {
			output.println(e.getMessage());
		}finally {
			output.close();	
		}
	}

	/**	 
	 * doPost
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Metodo para inicio de sesion
	*/
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		clienteService = (ClienteService) ac.getBean("clienteService");
	}
	
}
