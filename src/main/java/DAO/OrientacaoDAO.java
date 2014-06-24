package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class OrientacaoDAO {
	
	public boolean Add(Orientacao o){
		String SQL;
		
		SQL = "INSERT INTO orientacao (aluno_id, professor_id, ano)"
				+ "VALUES"
				+" ("+o.getAluno_id()
				+", "+o.getProfessor_id()
				+", "+o.getAno() + ")";
		
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
	
	public boolean delete(int aluno, int professor, int ano){
		String SQL;
		
		SQL = "DELETE FROM orientacao WHERE aluno_id = "+Integer.toString(aluno)+" AND "
				+ "professor_id = "+Integer.toString(professor)+" AND ano = "+Integer.toString(ano);
		
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
	
	public ArrayList<Orientacao> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM orientacao";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Orientacao> lo = new ArrayList<Orientacao>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Orientacao o = new Orientacao();
			while(rs.next()){
				o.setAluno_id(rs.getInt("aluno_id"));
				o.setProfessor_id(rs.getInt("professor_id"));
				o.setAno(rs.getInt("ano"));
				lo.add(o);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lo;
	}
	
	public ArrayList<Orientacao> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Orientacao> lo = new ArrayList<Orientacao>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Orientacao o = new Orientacao();
			while(rs.next()){
				o.setAluno_id(rs.getInt("aluno_id"));
				o.setProfessor_id(rs.getInt("professor_id"));
				o.setAno(rs.getInt("ano"));
				lo.add(o);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lo;
	}	
	
}