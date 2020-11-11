package com.mx.dao;
import com.mx.entidad.Celular;
import com.mx.entidad.MarcaCelular;
import com.mx.general.DataBase;
import com.mx.general.Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MarcaCelularDao implements Operaciones{
	
	DataBase db = new DataBase();
	MarcaCelular mc = null;

	public String guardar(Object obj) {
		mc = (MarcaCelular) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "INSERT INTO MARCACELULAR VALUES(?, ?, ?, ?)";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, mc.getId());
			pst.setString(2, mc.getNombre());
			pst.setString(3, mc.getPais());
			pst.setString(4, mc.getSlogan());
			int fila = pst.executeUpdate();
			
			if (fila==1) {
				resp = "1";
				System.out.println("Guardado Correctamente");
			}else {
				resp = "0";
				System.out.println("No se pudo completar la acción");
			}
			System.out.println("Se insertó marca"+fila);
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al guardar");
		}
		return resp;
	}
	
	public String editar(Object obj) {
		mc = (MarcaCelular) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "UPDATE MARCACELULAR SET NOMBRE=?, PAIS=?, SLOGAN=? WHERE ID=?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setString(1, mc.getNombre());
			pst.setString(2, mc.getPais());
			pst.setString(3, mc.getSlogan());
			pst.setInt(4, mc.getId());
			int fila = pst.executeUpdate();
			
			if (fila==1) {
				resp = "1";
				System.out.println("Editado Correctamente");
			}else {
				resp = "0";
				System.out.println("No se pudo completar la acción");
			}
			System.out.println("Se editó marca"+fila);
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al editar");
		}
		return resp;
	}
	
	public String eliminar(Object obj) {
		mc = (MarcaCelular) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "DELETE FROM MARCACELULAR WHERE ID = ?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, mc.getId());
			int fila = pst.executeUpdate();
			
			if (fila==1) {
				resp = "1";
				System.out.println("Eliminado Correctamente");
			}else {
				resp = "0";
				System.out.println("No se pudo completar la acción");
			}
			System.out.println("Se eliminó marca"+fila);
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al editar");
		}
		return resp;
	}

	public Object buscar(Object obj) {
		mc = (MarcaCelular) obj;
		Connection conn ;
		PreparedStatement pst;
		String query = "SELECT ID, NOMBRE, PAIS, SLOGAN FROM MARCACELULAR WHERE ID = "+mc.getId();
		ResultSet rs;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				mc = new MarcaCelular (rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("PAIS"), rs.getString("SLOGAN")); 
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al buscar");
		}
		return mc;
	}

	public List mostrar() {
		List<MarcaCelular> lista = new ArrayList<MarcaCelular>();
		Connection cone;
		PreparedStatement pst;
		String query = "SELECT ID, NOMBRE, PAIS, SLOGAN FROM MARCACELULAR";
		ResultSet rs;
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				lista.add(new MarcaCelular(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("PAIS"), rs.getString("SLOGAN")));
			}
			cone.close();
		} catch (Exception e) {
			System.out.println("Error al buscar");
		}
		return lista;
	}
}
