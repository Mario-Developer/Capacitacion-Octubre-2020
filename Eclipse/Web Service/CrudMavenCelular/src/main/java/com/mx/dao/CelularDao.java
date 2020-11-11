package com.mx.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Celular;
import com.mx.general.DataBase;
import com.mx.general.Operaciones;

public class CelularDao implements Operaciones{
	
	DataBase db = new DataBase();
	Celular cel = null;

	public String guardar(Object obj) {
		cel = (Celular)obj;
		Connection cone;
		PreparedStatement pst;
		String query = "INSERT INTO CELULAR VALUES(?, ?, ?, ?)";
		String resp = null;
		
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			pst.setInt(1,  cel.getId());
			pst.setString(2, cel.getModelo());
			pst.setString(3, cel.getMarca());
			pst.setDouble(4, cel.getPrecio());
			int fila = pst.executeUpdate();
			
			if(fila==1) {
				resp="1";
				System.out.println("guardado");
			}else {
				resp="0";
				System.out.println("No guardado");
			}
			
			System.out.println("Se insertó celular-> "+fila);
			cone.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("error");
		}
		return resp;
	}

	public String editar(Object obj) {
		cel = (Celular)obj;
		Connection cone;
		PreparedStatement pst;
		String query = "UPDATE CELULAR SET MODELO=?, MARCA=?, PRECIO=? WHERE ID=?";
		String resp = null;
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			pst.setString(1, cel.getModelo());
			pst.setString(2, cel.getMarca());
			pst.setDouble(3, cel.getPrecio());
			pst.setInt(4,  cel.getId());
			int fila = pst.executeUpdate();
			
			if(fila==1) {
				System.out.println("Se editó"+fila);
				resp = "1";
			}else {
				System.out.println("No se editó"+fila);
				resp = "0";
			}
			cone.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error editar: "+e.getMessage());
		}
		return resp;
	}

	public String eliminar(Object obj) {
		cel = (Celular)obj;
		Connection cone;
		PreparedStatement pst;
		String query = "DELETE FROM CELULAR WHERE ID = ?";
		String resp = null;
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			
			pst = cone.prepareStatement(query);
			pst.setInt(1, cel.getId());
			
			int fila = pst.executeUpdate();
			if (fila==1) {
				System.out.println("Se eliminó");
				resp = "1";
			}else {
				System.out.println("No se eliminó");
				resp = "0";
			}
			System.out.println("Se eliminó celular-> "+fila);
			cone.close();
			
		} catch (Exception e) {
			System.out.println("Error insertar: "+e.getMessage());
		}
		return resp;
	}

	public Object buscar(Object obj) {
		cel = (Celular)obj;
		Connection cone;
		PreparedStatement pst;
		String query = "SELECT ID, MODELO, MARCA, PRECIO FROM CELULAR WHERE ID=" +cel.getId();
		ResultSet rs;
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				cel = new Celular(rs.getInt("ID"), rs.getString("MODELO"), rs.getString("MARCA"), rs.getDouble("PRECIO"));
			}
			cone.close();
		} catch (Exception e) {
			System.out.println("Error insertar: "+e.getMessage());
		}
		return cel;
	}

	public List mostrar() {
		List<Celular> lista = new ArrayList<Celular>();
		Connection cone;
		PreparedStatement pst;
		String query = "SELECT ID, MODELO, MARCA, PRECIO FROM CELULAR";
		ResultSet rs;
		String resp = null;
		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				lista.add(new Celular(rs.getInt("ID"), rs.getString("MODELO"), rs.getString("MARCA"), rs.getDouble("PRECIO")));
			}
			cone.close();
		} catch (Exception e) {
			// System.out.println("Error insertar: "+e.getMessage());
		}
		return lista;
	}

}
