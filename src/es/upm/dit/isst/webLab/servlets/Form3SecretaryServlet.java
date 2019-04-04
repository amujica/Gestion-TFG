package es.upm.dit.isst.webLab.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.TFG;

@WebServlet("/Form3SecretaryServlet")
public class Form3SecretaryServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		String email = req.getParameter("email");
		TFG tfg = tdao.read(email);
		tfg.setStatus(3);
		tdao.update(tfg);
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	}
}