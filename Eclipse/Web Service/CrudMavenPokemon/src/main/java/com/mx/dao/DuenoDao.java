package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Dueno;
import com.mx.general.DataBase;
import com.mx.general.Operaciones;

public class DuenoDao implements Operaciones{
	
	DataBase db = new DataBase();
	Dueno d = null;
	
	public String guardar(Object obj) {
		d = (Dueno) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "INSERT INTO DUENOPOKEMON VALUES(?, ?, ?,?)";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, d.getId());
			pst.setString(2, d.getNombre());
			pst.setString(3, d.getApp());
			pst.setString(4, d.getPueblo());			
			int fila =pst.executeUpdate();
			
			if(fila==1) {
				resp = "1";
				System.out.println("guardado");
			}else {
				resp = "0";
				System.out.println("No guardado");
			}
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error");
		}
		
		return resp;
	}

	public String editar(Object obj) {
		d = (Dueno) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "UPDATE DUENOPOKEMON SET NOMBRE = ?, APP = ?, PUEBLO = ? WHERE ID = ?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setString(1, d.getNombre());
			pst.setString(2, d.getApp());
			pst.setString(3, d.getPueblo());
			pst.setInt(4, d.getId());
			int fila = pst.executeUpdate();
			if(fila==1) {
				resp = "1";
				System.out.println("Se editó");
			}else {
				resp = "2";
				System.out.println("No se editó");
			}
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al editar");
		}
		return resp;
	}

	public String eliminar(Object obj) {
		d = (Dueno) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "DELETE FROM DUENOPOKEMON WHERE ID = ?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, d.getId());
			int fila = pst.executeUpdate();
			
			if(fila==1) {
				resp = "1";
				System.out.println("Se eliminó");
			}else {
				resp = "0";
				System.out.println("No se eliminó");
			}
			conn.close();
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al eliminar");
		}
		return resp;
	}

	public Object buscar(Object obj) {
		d = (Dueno) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "SELECT ID, NOMBRE, APP, PUEBLO FROM DUENOPOKEMON WHERE ID = "+d.getId();
		ResultSet rs;
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				d = new Dueno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APP"), rs.getString("PUEBLO"));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al buscar");
		}
		return d;
	}

	public List mostrar() {
		List<Dueno> lista = new ArrayList<Dueno>();
		Connection conn;
		PreparedStatement pst;
		String query = "SELECT ID, NOMBRE, APP, PUEBLO FROM DUENOPOKEMON";
		ResultSet rs;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				lista.add(new Dueno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APP"), rs.getString("PUEBLO")));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al buscar");
		}
		return lista;
	}
	
}
