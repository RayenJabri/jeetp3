package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ImetierCatalogue;
import metier.MetierImpl;
import web.BoissonModele;
import metier.Boisson;
@WebServlet (name="cs",urlPatterns= {"/controleur"})
public class ControleurServlet extends HttpServlet {
private ImetierCatalogue metier;
@Override
public void init() throws ServletException {
metier=new MetierImpl();
}
@Override
protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	String mc=request.getParameter("motCle");
	BoissonModele mod = new BoissonModele();
	mod.setMotCle(mc);
	List<Boisson> bois= metier.getBoissonsParMotCle(mc);
	mod.setBoissons(bois);
	request.setAttribute("modele", mod);
	request.getRequestDispatcher("BoissonsView.jsp").forward(request,response);
	}

}