package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bancoDados.Conexao;
import model.Paciente;

public class PacienteDAO {

	private Connection conexaoDAO;

	public PacienteDAO() {

		conexaoDAO = Conexao.getConnection();

	}

	
	public LinkedList<Paciente> listarPacientes() {

		LinkedList<Paciente> list = new LinkedList<Paciente>();

		String sql = "select * from pacientes";

		try {

			PreparedStatement comando = conexaoDAO.prepareStatement(sql);
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Paciente paciente = new Paciente();

				paciente.setId(resultado.getLong("id"));
				paciente.setNome(resultado.getString("nome"));
				paciente.setCpf(resultado.getString("cpf"));
				paciente.setVacinado(resultado.getBoolean("vacinado"));
				paciente.setUf(resultado.getString("uf"));

				list.add(paciente);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Paciente> listarVacinados() {

		List<Paciente> pacientes_vacinados = new LinkedList<Paciente>();

		try {

			String sql = "select * from pacientes";

			PreparedStatement comando = conexaoDAO.prepareStatement(sql);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {

				Paciente paciente = new Paciente();

				paciente.setId(resultado.getLong("id"));
				paciente.setNome(resultado.getString("nome"));
				paciente.setCpf(resultado.getString("cpf"));
				paciente.setVacinado(resultado.getBoolean("vacinado"));
				paciente.setUf(resultado.getString("uf"));

				if (paciente.isVacinado()) {

					pacientes_vacinados.add(paciente);

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pacientes_vacinados;

	}


	public void consultar(String cpf) {

		int sinalizador = 0;
		PacienteDAO dao = new PacienteDAO();

		LinkedList<Paciente> lista = dao.listarPacientes();

		for (Paciente p : lista) {

			if (p.getCpf().equals(cpf)) {

				System.out.println(p);
				sinalizador++;
				break;

			}

		}

		if (sinalizador == 0) {
			System.out.println("---CPF INVALIDO---");
		}

	}

	public void updateNome(String novo_valor, String cpf) {

		try {

			String sql = "update pacientes set nome = ? where cpf = ?";
			PreparedStatement comando = conexaoDAO.prepareStatement(sql);

			comando.setString(1, novo_valor);
			comando.setString(2, cpf);
			

			comando.execute();
			conexaoDAO.commit();
			System.out.println("update com sucesso :)");

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}

	public void updateUf(String novo_valor, String cpf) {

		try {

			String sql = "update pacientes set uf = ? where cpf = ?";
			PreparedStatement comando = conexaoDAO.prepareStatement(sql);

			comando.setString(1, novo_valor);
			comando.setString(2, cpf);
			

			comando.execute();
			conexaoDAO.commit();
			System.out.println("update com sucesso :)");

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	
	public void updateVacinado(boolean vacinado, String cpf) {

		try {

			String sql = "update pacientes set vacinado = ? where cpf = ?";
			PreparedStatement comando = conexaoDAO.prepareStatement(sql);

			comando.setBoolean(1, vacinado);
			comando.setString(2, cpf);
			

			comando.execute();
			conexaoDAO.commit();
			System.out.println("update com sucesso :)");

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	
	public void salvar(String nome, String cpf, boolean vacinado, String uf) {

		try {
			String sql = "insert into pacientes (id, nome, cpf, vacinado, uf) values ( default, ?, ?, ?, ?)";
			PreparedStatement comando = conexaoDAO.prepareStatement(sql);
			;
			comando.setString(1, nome);
			comando.setString(2, cpf);
			comando.setBoolean(3, vacinado);
			comando.setString(4, uf);

			comando.execute();
			conexaoDAO.commit();

		} catch (SQLException e) {
			
			e.printStackTrace();
			
			try {
				conexaoDAO.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}

}
