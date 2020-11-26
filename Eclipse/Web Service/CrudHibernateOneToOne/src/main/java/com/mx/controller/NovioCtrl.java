package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.NoviaDao;
import com.mx.dao.NovioDao;
import com.mx.entidad.Novia;
import com.mx.entidad.Novio;

public class NovioCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovioCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		metodo(request, response);
	}
	
	protected void metodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = null;
		NovioDao dao = null;
		Novio novio = null;
		Novia novia = null;
		
		try (PrintWriter out = response.getWriter()){
			if(request.getParameter("btnGuardar") != null) {
				novio = new Novio();
				novio.setId(Integer.parseInt(request.getParameter("id")));
				novio.setNombre(request.getParameter("nombre"));
				novio.setApp(request.getParameter("app"));
				novio.setApm(request.getParameter("apm"));
				novio.setProfesion(request.getParameter("profesion"));
				novio.setNovia(new Novia(Integer.parseInt(request.getParameter("id_novia"))));
				System.out.println("Novio: "+novio);
				dao = new NovioDao();
				dao.guardar(novio);
				
			}else if (request.getParameter("btnEliminar") != null) {				
				novio = new Novio(Integer.parseInt(request.getParameter("id")));
				dao = new NovioDao();
				dao.eliminar(novio);
				
			}else if(request.getParameter("btnEditar") != null) {
				novio = new Novio();
				novio.setId(Integer.parseInt(request.getParameter("id")));
				novio.setNombre(request.getParameter("nombre"));
				novio.setApp(request.getParameter("app"));
				novio.setApm(request.getParameter("apm"));
				novio.setProfesion(request.getParameter("profesion"));
				novio.setNovia(new Novia(Integer.parseInt(request.getParameter("id_novia"))));
				dao = new NovioDao();
				System.out.println("Novio: "+novio);
				dao.editar(novio);
			}
			
			rd = request.getRequestDispatcher("novioV.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error controller: "+e.getMessage());
		}
	}
}
