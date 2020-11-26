package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.AlumnoDao;
import com.mx.entidad.Alumno;

public class AlumnoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public AlumnoCtrl() {
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
		AlumnoDao dao = null;
		Alumno a = null;
		
		try (PrintWriter out = response.getWriter()){
			if(request.getParameter("btnGuardar") != null) {
				a = new Alumno();
				a.setId(Integer.parseInt(request.getParameter("id")));
				a.setNombre(request.getParameter("nombre"));
				a.setApp(request.getParameter("app"));
				a.setMatricula(request.getParameter("matricula"));
				dao = new AlumnoDao();
				dao.guardar(a);
			}
			rd = request.getRequestDispatcher("AlumnoV.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error Controller: "+e.getMessage());
		}
	}

}
