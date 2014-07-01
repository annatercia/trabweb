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
				+", "+p.getProjeto_id()+")";

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

	public boolean hasProfessor(int pid){
		String SQL;

		SQL = "select count(*) from participacao, colaboradores"
				+ " where participacao.colaborador_id=colaboradores.id"
				+ " and colaboradores.tipo='professor'"
				+ " and participacao.projeto_id="+pid;

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

	public boolean hasOther(int cid){
		String SQL;

		SQL = "SELECT count( * ) FROM participacao, projetos, colaboradores "
				+ "WHERE participacao.projeto_id = projetos.id "
				+ "AND colaboradores.tipo = 'aluno' "
				+ "AND colaboradores.grau = 'graduação' "
				+ "AND projetos.status= 'em andamento' "
				+ "AND participacao.colaborador_id ="+cid;

		Connection conn = new Conn().getConnection();

		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
			if(rs.getInt("count(*)")>1)
				return true;

		}catch(SQLException e){
			System.out.println("Erro no SQL:"+e.getMessage());
			return true;
		}

		return false;
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



