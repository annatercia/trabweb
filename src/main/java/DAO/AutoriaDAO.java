package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class AutoriaDAO {
	
	public boolean Add(Autoria a){
		String SQL;
		
		SQL = "INSERT INTO autoria (colaborador_id, publicacoes_id)"
				+ "VALUES"
				+" ("+a.getColaborador_id()
				+", "+a.getPublicacoes_id()+")";
		
		Connection conn = new Conn().getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		}catch(SQLException e){
			System.out.println("Erro no SQL:"+e.getMessage());
			return false;
		}
		
		return true;
	} 
	
	public boolean delete(int colaborador, int publicaoces){
		String SQL;
		
		SQL = "DELETE FROM autoria WHERE colaborador_id = "+Integer.toString(colaborador)+"AND "
				+ "publicacoes_id = "+Integer.toString(publicaoces);
		
		Connection conn = new Conn().getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		} catch (SQLException e){
			System.out.println("Erro no SQL:"+e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public ArrayList<Autoria> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM autoria";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Autoria> la = new ArrayList<Autoria>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Autoria a = new Autoria();
			while(rs.next()){
				a.setColaborador_id(rs.getInt("colaborador_id"));
				a.setPublicacoes_id(rs.getInt("publicacoes_id"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public ArrayList<Autoria> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Autoria> la = new ArrayList<Autoria>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Autoria a = new Autoria();
			while(rs.next()){
				a.setColaborador_id(rs.getInt("colaborador_id"));
				a.setPublicacoes_id(rs.getInt("publicacoes_id"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}	
	
}



