package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class ColaboradoresDAO {
	
	public boolean Add(Colaboradores c){
		String SQL;
		
		SQL = "INSERT INTO colaboradores (nome, grau, tipo, email)"
				+ "VALUES"
				+" ( '"+c.getNome()
				+"', '"+c.getGrau()
				+"', '"+c.getTipo()
				+"', '"+c.getEmail()+"') ";
		
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
		
		SQL = "DELETE FROM colaboradores WHERE id = "+Integer.toString(id);
		
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
	
	public ArrayList<Colaboradores> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM colaboradores";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Colaboradores> lc = new ArrayList<Colaboradores>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Colaboradores c = new Colaboradores();
			while(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setGrau(rs.getString("grau"));
				c.setTipo(rs.getString("tipo"));
				c.setEmail(rs.getString("email"));
				lc.add(c);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lc;
	}
	
	public ArrayList<String> getAllNome(){
		String SQL;
		
		SQL = "SELECT * FROM colaboradores";
		
		Connection conn = new Conn().getConnection();
		ArrayList<String> lc = new ArrayList<String>();
		lc.add("");
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				lc.add(rs.getString("nome"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lc;
	}
	
	
	
	public ArrayList<Colaboradores> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Colaboradores> lc = new ArrayList<Colaboradores>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Colaboradores c;
			while(rs.next()){
				c= new Colaboradores();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setGrau(rs.getString("grau"));
				
				c.setTipo(rs.getString("tipo"));
				c.setEmail(rs.getString("email"));
				lc.add(c);
				c=null;
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lc;
	}
	
	public Colaboradores getById(int id){
		String SQL;
		
		SQL = "SELECT * FROM colaboradores WHERE id = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Colaboradores c = new Colaboradores();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setGrau(rs.getString("grau"));
				c.setTipo(rs.getString("tipo"));
				c.setEmail(rs.getString("email"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return c;
	}
	
	public void update(Colaboradores c){
		String SQL = "UPDATE colaboradores SET ";
		ArrayList<String> fu = new ArrayList<String>();
		
		try{
			if (c.getId() == 0){
				throw new Exception("Nenhum id definido");
			}
		}catch(Exception e){
			System.out.print("Erro:"+e.getMessage());
		}
		
		if(!c.getNome().equals("")){
			fu.add("nome='"+c.getNome()+"'");
		}
		
		if(!c.getEmail().equals("")){
			fu.add("email='"+c.getEmail()+"'");
		}
		
		if(!c.getGrau().equals("")){
			fu.add("grau='"+c.getGrau()+"'");
		}
		
		if(!c.getTipo().equals("")){
			fu.add("tipo='"+c.getTipo()+"'");
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
		
		SQL += "WHERE id = "+Integer.toString(c.getId());
		
		Connection conn = new Conn().getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		}catch(SQLException e){
			System.out.println("Erro no SQL");
		}
	}
	
}



