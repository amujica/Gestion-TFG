package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;

@WebServlet("/TFGServlet")
public class TFGServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Desde loginServlet se me pasa el email del usuario que ya se ha autenticado
		// y aquí tengo que buscar en la BBDD su TFG y cargar la vista TFGView, que con
		//los parámetros que le pase desde aquí podrá presentarlo bien por pantalla
		
		//Línea para conseguir el email email = ....
		String email = req.getParameter( "email" );
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		req.getSession().setAttribute( "tfg", tdao.read(email) );
		getServletContext().getRequestDispatcher( "/TFGView.jsp" ).forward( req, resp );
	}
}
