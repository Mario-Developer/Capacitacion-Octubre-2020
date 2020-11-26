package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.NoviaDao;
import com.mx.entidad.Novia;

public class NoviaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoviaCtrl() {
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
		NoviaDao dao = null;
		Novia novia = null;
		
		try(PrintWriter out = response.getWriter()){
			if(request.getParameter("btnGuardar") != null) {
				novia = new Novia();
				novia.setId(Integer.parseInt(request.getParameter("id")));
				novia.setNombre(request.getParameter("nombre"));
				novia.setApp(request.getParameter("app"));
				novia.setApm(request.getParameter("apm"));
				novia.setHobbie(request.getParameter("hobbie"));
				dao = new NoviaDao();
				dao.guardar(novia);
			}else if(request.getParameter("btnEliminar") != null) {
				novia = new Novia(Integer.parseInt(request.getParameter("id")));
				dao = new NoviaDao();
				dao.eliminar(novia);	
				
			}else if(request.getParameter("btnEditar") != null) {
				novia = new Novia();
				novia.setId(Integer.parseInt(request.getParameter("id")));
				novia.setNombre(request.getParameter("nombre"));
				novia.setApp(request.getParameter("app"));
				novia.setApm(request.getParameter("apm"));
				novia.setHobbie(request.getParameter("hobbie"));	
				dao = new NoviaDao();
				dao.editar(novia);
			}
			rd = request.getRequestDispatcher("noviaV.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			System.out.println("ERROR CONTROLLER: "+e.getMessage());
		}
	}
}


