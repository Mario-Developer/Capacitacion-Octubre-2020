package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Dueno;
import com.mx.entidad.Pokemon;
import com.mx.general.DataBase;
import com.mx.general.Operaciones;
import com.sun.xml.bind.v2.runtime.reflect.Accessor.GetterSetterReflection;

public class PokemonDao implements Operaciones{
	
	DataBase db = new DataBase();
	Dueno d = null;
	Pokemon pkm = null;

	public String guardar(Object obj) {
		pkm = (Pokemon) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "INSERT INTO POKEMON VALUES(?, ?, ?, ?, ?)";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, pkm.getId());
			pst.setString(2, pkm.getNombre());
			pst.setString(3, pkm.getTipo());
			pst.setString(4, pkm.getAtaque());
			pst.setInt(5, pkm.getDueno().getId());
			int fila = pst.executeUpdate();
			
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
		pkm = (Pokemon) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "UPDATE POKEMON SET NOMBRE_P = ?, TIPO = ?, ATAQUE = ?, ID_DUENO = ? WHERE ID_P = ?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setString(1, pkm.getNombre());
			pst.setString(2, pkm.getTipo());
			pst.setString(3, pkm.getAtaque());
			pst.setInt(4, pkm.getDueno().getId());
			pst.setInt(5, pkm.getId());
			
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
		pkm = (Pokemon) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "DELETE FROM POKEMON WHERE ID_P = ?";
		String resp;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			pst.setInt(1, pkm.getId());
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
		pkm = (Pokemon) obj;
		Connection conn;
		PreparedStatement pst;
		String query = "SELECT * FROM POKEMON INNER JOIN DUENOPOKEMON ON DUENOPOKEMON.ID = POKEMON.ID_DUENO WHERE ID_P = "+pkm.getId();
		ResultSet rs;
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Dueno d = new Dueno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APP"), rs.getString("PUEBLO"));
				pkm = new Pokemon(rs.getInt("ID_P"), rs.getString("NOMBRE_P"), rs.getString("TIPO"), rs.getString("ATAQUE"), d);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al buscar");
		}
		return pkm;
	}

	public List mostrar() {
		List<Pokemon> lista = new ArrayList<Pokemon>();
		Connection conn;
		PreparedStatement pst;
		String query = ("SELECT * FROM POKEMON INNER JOIN DUENOPOKEMON ON DUENOPOKEMON.ID = POKEMON.ID_DUENO");
		ResultSet rs;
		
		try {
			Class.forName(db.getDriver());
			conn = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Dueno d = new Dueno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APP"), rs.getString("PUEBLO"));
				lista.add(new Pokemon(rs.getInt("ID_P"), rs.getString("NOMBRE_P"), rs.getString("TIPO"), rs.getString("ATAQUE"), d));
			}conn.close();
		} catch (Exception e) {
			System.out.println("error al bucar");
		}
		return lista;
	}

}
