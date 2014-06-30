package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class AdministradorDAO {
	
	public boolean Add(Administrador p){
		String SQL;
		
		SQL = "INSERT INTO administrador (login, senha)"
				+ "VALUES"
				+" ( '"+p.getLogin()
				+"', '"+p.getSenha()
				+"') ";
		
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
		
		SQL = "DELETE FROM administrador WHERE idadministrador = "+Integer.toString(id);
		
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
	
	public ArrayList<Administrador> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM login";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Administrador> la = new ArrayList<Administrador>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Administrador a = new Administrador();
			while(rs.next()){
				a.setIdadministrador(rs.getInt("idadministrador"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getString("senha"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public ArrayList<Administrador> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Administrador> la = new ArrayList<Administrador>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Administrador a = new Administrador();
			while(rs.next()){
				a.setIdadministrador(rs.getInt("idadministrador"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getString("senha"));
				la.add(a);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return la;
	}
	
	public Administrador getById(int id){
		String SQL;
		
		SQL = "SELECT * FROM administrador WHERE idadministrador = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Administrador a = new Administrador();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				a.setIdadministrador(rs.getInt("idadministrador"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getString("senha"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return a;
	}
	
	public void update(Administrador a){
		String SQL = "UPDATE administrador SET ";
		ArrayList<String> fu = new ArrayList<String>();
		
		try{
			if (a.getIdadministrador() == 0){
				throw new Exception("Nenhum id definido");
			}
		}catch(Exception e){
			System.out.print("Erro:"+e.getMessage());
		}
		
		if(!a.getLogin().equals("")){
			fu.add("login='"+a.getLogin()+"'");
		}
		
		if(!a.getSenha().equals("")){
			fu.add("senha='"+a.getSenha()+"'");
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
		
		SQL += "WHERE idadministrador = "+Integer.toString(a.getIdadministrador());
		
		Connection conn = new Conn().getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		}catch(SQLException e){
			System.out.println("Erro no SQL");
		}
	}
	
	
}