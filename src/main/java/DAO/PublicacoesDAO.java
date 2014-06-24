package DAO;

import database.Conn;

import java.sql.*;
import java.util.ArrayList;


public class PublicacoesDAO {
	
	public boolean Add(Publicacoes p){
		String SQL;
		
		SQL = "INSERT INTO publicacoes (titulo, nome_conferencia, ano_publicacao, projeto_id)"
				+ "VALUES"
				+" ( '"+p.getTitulo()
				+"', '"+p.getNome_conferencia()
				+"', "+Integer.toString(p.getAno_publicacao())
				+", "+Integer.toString(p.getProjeto_id())+") ";
		
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
		
		SQL = "DELETE FROM publicacoes WHERE id = "+Integer.toString(id);
		
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
	
	public ArrayList<Publicacoes> getAll(){
		String SQL;
		
		SQL = "SELECT * FROM publicacoes";
		
		Connection conn = new Conn().getConnection();
		ArrayList<Publicacoes> lp = new ArrayList<Publicacoes>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Publicacoes p = new Publicacoes();
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setNome_conferencia(rs.getString("nome_conferencia"));
				p.setAno_publicacao(rs.getInt("ano_publicacao"));
				p.setProjeto_id(rs.getInt("projeto_id"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	public ArrayList<Publicacoes> getBy(String SQL){
		
		Connection conn = new Conn().getConnection();
		ArrayList<Publicacoes> lp = new ArrayList<Publicacoes>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			Publicacoes p = new Publicacoes();
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setNome_conferencia(rs.getString("nome_conferencia"));
				p.setAno_publicacao(rs.getInt("ano_publicacao"));
				p.setProjeto_id(rs.getInt("projeto_id"));
				lp.add(p);
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return lp;
	}
	
	public Publicacoes getById(int id){
		String SQL;
		
		SQL = "SELECT * FROM publicacoes WHERE id = "+Integer.toString(id);
		
		Connection conn = new Conn().getConnection();
		Publicacoes p = new Publicacoes();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setNome_conferencia(rs.getString("nome_conferencia"));
				p.setAno_publicacao(rs.getInt("ano_publicacao"));
				p.setProjeto_id(rs.getInt("projeto_id"));
			}
			
			rs.last();
			
		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}
		
		return p;
	}
	
	
}



