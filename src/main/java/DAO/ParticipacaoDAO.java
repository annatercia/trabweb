package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class ParticipacaoDAO {
	
	public boolean Add(Participacao p){
		String SQL;
		
		SQL = "INSERT INTO participacao (colaborador_id, projeto_id)"
				+ "VALUES"
				+" ("+p.getColaborador_id()
				+"', "+p.getProjeto_id()+")";
		
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
	
	public boolean delete(int colaborador, int projeto){
		String SQL;
		
		SQL = "DELETE FROM participacao WHERE colaborador_id = "+Integer.toString(colaborador)+"AND "
				+ "projeto_id = "+Integer.toString(projeto);
		
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
	
	public ArrayList<Participacao> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM participacao";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Participacao> lp = new ArrayList<Participacao>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Participacao p = new Participacao();
			while(rs.next()){
				p.setColaborador_id(rs.getInt("colaborador_id"));
				p.setProjeto_id(rs.getInt("projeto_id"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	public ArrayList<Participacao> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Participacao> lp = new ArrayList<Participacao>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Participacao p = new Participacao();
			while(rs.next()){
				p.setColaborador_id(rs.getInt("colaborador_id"));
				p.setProjeto_id(rs.getInt("projeto_id"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}	
	
}



