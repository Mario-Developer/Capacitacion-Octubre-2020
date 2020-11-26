package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.AlumnoDao;
import com.mx.dao.ProfesorDao;
import com.mx.entidad.Alumno;
import com.mx.entidad.Profesor;

public class ProfesorCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public ProfesorCtrl() {
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
		ProfesorDao dao = null;
		Profesor p = null;
		
		try (PrintWriter out = response.getWriter()) {
			if(request.getParameter("btnGuardar") != null) {
				p = new Profesor();
				p.setId(Integer.parseInt(request.getParameter("id")));
				p.setNombre(request.getParameter("nombre"));
				p.setApp(request.getParameter("app"));
				p.setMatricula(request.getParameter("matricula"));
				dao = new ProfesorDao();
				dao.guardar(p);
			}
			rd = request.getRequestDispatcher("ProfesorV.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error Controller: "+e.getMessage());
		}
	}

}
