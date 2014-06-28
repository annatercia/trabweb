package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class ProjetosDAO {
	
	public boolean Add(Projetos p){
		String SQL;
		
		SQL = "INSERT INTO projetos (titulo, data_inicio, data_termino, valor_financiado, objetivo, descricao, agencia_id, status)"
				+ "VALUES"
				+ "('"+p.getTitulo()
				+"', '"+p.getData_inicio()
				+"', '"+p.getData_termino()
				+"', "+Float.toString(p.getValor_financiado())
				+", '"+p.getObjetivo()
				+"', '"+p.getDescricao()
				+"', "+Integer.toString(p.getAgencia_id())
				+", '"+p.getStatus()+"') ";
		
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
		
		SQL = "DELETE FROM PROJETOS WHERE id = "+Integer.toString(id);
		
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
	
	public ArrayList<Projetos> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM projetos";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Projetos> lp = new ArrayList<Projetos>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Projetos p = new Projetos();
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setData_inicio(rs.getString("data_inicio"));
				p.setData_termino(rs.getString("data_termino"));
				p.setAgencia_id(rs.getInt("agencia"));
				p.setValor_financiado(rs.getFloat("valor_financiado"));
				p.setObjetivo(rs.getString("objetivo"));
				p.setDescricao(rs.getString("descricao"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	public ArrayList<String> getAllNome(){
		String SQL;
		
		SQL = "SELECT titulo FROM projetos";
		
		Connection conn = new Conn().getConnection();
		ArrayList<String> lp = new ArrayList<String>();
		lp.add("");
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				lp.add(rs.getString("titulo"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	
	
	public ArrayList<Projetos> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Projetos> lp = new ArrayList<Projetos>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Projetos p = new Projetos();
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setData_inicio(rs.getString("data_inicio"));
				p.setData_termino(rs.getString("data_termino"));
				p.setAgencia_id(rs.getInt("agencia"));
				p.setValor_financiado(rs.getFloat("valor_financiado"));
				p.setObjetivo(rs.getString("objetivo"));
				p.setDescricao(rs.getString("descricao"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	public Projetos getByIdl(int id){
		String SQL;
		
		SQL = "SELECT * FROM projetos WHERE id = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Projetos p = new Projetos();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setData_inicio(rs.getString("data_inicio"));
				p.setData_termino(rs.getString("data_termino"));
				p.setAgencia_id(rs.getInt("agencia_id"));
				p.setValor_financiado(rs.getFloat("valor_financiado"));
				p.setObjetivo(rs.getString("objetivo"));
				p.setDescricao(rs.getString("descricao"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return p;
	}
	
	
}



