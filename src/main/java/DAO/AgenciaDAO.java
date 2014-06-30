package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class AgenciaDAO {
	
	public boolean Add(Agencia a){
		String SQL;
		
		SQL = "INSERT INTO agencias (nome) VALUES ( '"+a.getNome()+"')";
				
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
		
		SQL = "DELETE FROM agencias WHERE id = "+Integer.toString(id);
		
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
		
		SQL = "SELECT * FROM agencias";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Agencia> la = new ArrayList<Agencia>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Agencia a = new Agencia();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public ArrayList<String> getAllNome(){
		String SQL;
		
		SQL = "SELECT nome FROM agencias";
		
		Connection conn = new Conn().getConnection();
		ArrayList<String> la = new ArrayList<String>();
		la.add("");
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				la.add(rs.getString("nome"));
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
				a.setNome(rs.getString("nome"));
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
		
		SQL = "SELECT * FROM agencias WHERE id = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Agencia a = new Agencia();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return a;
	}
	
	public void update(Agencia a){
		String SQL = "UPDATE agencia SET ";
		ArrayList<String> fu = new ArrayList<String>();
		
		try{
			if (a.getId() == 0){
				throw new Exception("Nenhum id definido");
			}
		}catch(Exception e){
			System.out.print("Erro:"+e.getMessage());
		}
		
		if(!a.getNome().equals("")){
			fu.add("nome='"+a.getNome()+"'");
		}
		
		int i;
		
		for(i=0;i<fu.size();i++){
			SQL += fu.get(i);
			
			if(i < fu.size()-1){
				SQL += ", ";
			}else{
				SQL += " ";
			}
		}
		
		SQL += "WHERE id = "+Integer.toString(a.getId());
		
		Connection conn = new Conn().getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		}catch(SQLException e){
			System.out.println("Erro no SQL");
		}
	}
	
}