package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.ClaseDao;
import com.mx.entidad.Alumno;
import com.mx.entidad.Clase;
import com.mx.entidad.Profesor;


public class ClaseCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClaseCtrl() {
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
		ClaseDao dao = null;
		Clase c = null;
		Alumno a = null;
		Profesor p = null;
		
		try (PrintWriter out = response.getWriter()){
			if(request.getParameter("btnGuardar") != null) {
				c = new Clase();
				//c.setId(Integer.parseInt(request.getParameter("id")));
				c.setNombre(request.getParameter("nombre"));
				c.setAlumno(new Alumno(Integer.parseInt(request.getParameter("id_alumno"))));
				c.setProfesor(new Profesor(Integer.parseInt(request.getParameter("id_profesor"))));
				dao = new ClaseDao();
				dao.guardar(c);
			}
			rd = request.getRequestDispatcher("ClaseV.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
