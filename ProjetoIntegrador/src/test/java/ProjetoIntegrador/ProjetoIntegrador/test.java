package ProjetoIntegrador.ProjetoIntegrador;


import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Test;

import bancoDados.Conexao;
import dao.PacienteDAO;
import model.Paciente;

public class test {

	public void initConectar() {

		Conexao conexao = new Conexao();

	}

	
	public void testTest() {

		PacienteDAO dao = new PacienteDAO();
		LinkedList<Paciente> pacienteList = new LinkedList<Paciente>();

		pacienteList = dao.listarPacientes();

		System.out.println("\nLista de todos os pacientes:\n");
		for (Paciente paciente : pacienteList) {

			System.out.println(" " + paciente);
			System.out.println("-----------------------------------" + "------------------------------------");
		}

	}

	public void testVacinados() {

		PacienteDAO dao = new PacienteDAO();
		LinkedList<Paciente> pacienteList = new LinkedList<Paciente>();

		pacienteList = (LinkedList<Paciente>) dao.listarVacinados();

		System.out.println("\nLista dos que foram vacinados: \n ");
		for (Paciente paciente : pacienteList) {

			System.out.println(paciente);
			System.out.println("-------------------------------------" + "----------------------------------");
		}

	}

	public void testConsultar() {

		PacienteDAO dao = new PacienteDAO();
		dao.consultar("cpf");

	}


	public void testUpdate() {
		PacienteDAO dao = new PacienteDAO();

		dao.updateUf("SC", "74125898547");
		
	}

	
	
	
	public void testSalvar() {
		PacienteDAO dao = new PacienteDAO();
	
		//dao.salvar("Rodrigo", "25252515478", false, "MS"); já foi salvo
		
		


	}
}
