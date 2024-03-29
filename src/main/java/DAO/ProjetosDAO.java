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

	public boolean Update(Projetos p){
		String SQL;

		SQL = "UPDATE projetos "
				+ "set "
				+ "titulo= '"+p.getTitulo()
				+"', data_inicio= '"+p.getData_inicio()
				+"', data_termino= '"+p.getData_termino()
				+"', valor_financiado= "+Float.toString(p.getValor_financiado())
				+", objetivo= '"+p.getObjetivo()
				+"', descricao= '"+p.getDescricao()
				+"', agencia_id="+Integer.toString(p.getAgencia_id())
				+", status='"+p.getStatus()+"'"
						+ " where id="+p.getId();

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

	public boolean hasPublicacao(int pid){
		String SQL;

		SQL = "select count(*) from publicacoes where publicacoes.projeto_id="+pid;

		Connection conn = new Conn().getConnection();

		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			if(rs.getInt("count(*)")<1)
				return false;

		}catch(SQLException e){
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
				//POG \/
				//p.setAgencia_id(rs.getInt("agencia"));
				p.setValor_financiado(rs.getFloat("valor_financiado"));
				p.setObjetivo(rs.getString("objetivo"));
				p.setDescricao(rs.getString("descricao"));
				
				lp.add(p);
			}
			
			rs.last();

		} catch(SQLException e){
			System.out.println("Erro no SQL 1: "+SQL);
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


	public ArrayList<String> tituloGetBy(String SQL){

		Connection conn = new Conn().getConnection();
		ArrayList<String> lp = new ArrayList<String>();
		lp.add("");
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			Projetos p = new Projetos();
			while(rs.next()){
				p.setTitulo(rs.getString("titulo"));
				lp.add(p.getTitulo());
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
				System.out.println("Projeto: "+rs.getInt("id"));
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setData_inicio(rs.getString("data_inicio"));
				p.setData_termino(rs.getString("data_termino"));
				//POG \/
				//p.setAgencia_id(rs.getInt("agencia"));
				p.setValor_financiado(rs.getFloat("valor_financiado"));
				p.setObjetivo(rs.getString("objetivo"));
				p.setDescricao(rs.getString("descricao"));
				lp.add(p);
			}

			rs.last();

		} catch(SQLException e){
			System.out.println("Erro no SQL 2: "+SQL);
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
				p.setStatus(rs.getString("status"));
			}

			rs.last();

		} catch(SQLException e){
			System.out.println("Erro no SQL");
		}

		return p;
	}

	public void update(Projetos p){
		String SQL = "UPDATE projetos SET ";
		ArrayList<String> fu = new ArrayList<String>();

		try{
			if (p.getId() == 0){
				throw new Exception("Nenhum id definido");
			}
		}catch(Exception e){
			System.out.print("Erro:"+e.getMessage());
		}

		if(!p.getTitulo().equals("")){
			fu.add("titulo='"+p.getTitulo()+"'");
		}

		if(!p.getData_inicio().equals("")){
			fu.add("data_inicio='"+p.getData_inicio()+"'");
		}

		if(!p.getData_termino().equals("")){
			fu.add("data_termino='"+p.getData_termino()+"'");
		}

		if(!p.getDescricao().equals("")){
			fu.add("descricao='"+p.getDescricao()+"'");
		}

		if(!p.getObjetivo().equals("")){
			fu.add("objetivo='"+p.getObjetivo()+"'");
		}

		if(!p.getStatus().equals("")){
			fu.add("status='"+p.getStatus()+"'");
		}

		if(p.getAgencia_id() != 0){
			fu.add("agencia_id="+Integer.toString(p.getAgencia_id()));
		}

		if(p.getValor_financiado() != 0){
			fu.add("valor_financiado="+Float.toString(p.getValor_financiado()));
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

		SQL += "WHERE id = "+Integer.toString(p.getId());

		Connection conn = new Conn().getConnection();

		try{
			Statement stmt = conn.createStatement();
			stmt.execute(SQL);
		}catch(SQLException e){
			System.out.println("Erro no SQL");
		}
	}
}



