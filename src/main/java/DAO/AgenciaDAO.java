package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class AgenciaDAO {
	
	public boolean Add(Agencia a){
		String SQL;
		
		SQL = "INSERT INTO agencia (nome) VALUES ( '"+a.getNome()+"')";
				
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
	
	public boolean delete(int id){
		String SQL;
		
		SQL = "DELETE FROM agencia WHERE id = "+Integer.toString(id);
		
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
	
	public ArrayList<Agencia> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM agencia";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Agencia> la = new ArrayList<Agencia>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Agencia a = new Agencia();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("titulo"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public ArrayList<Agencia> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Agencia> la = new ArrayList<Agencia>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Agencia a = new Agencia();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("titulo"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public Agencia getById(int id){
		String SQL;
		
		SQL = "SELECT * FROM agencia WHERE id = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Agencia a = new Agencia();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("titulo"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return a;
	}
	
	
}