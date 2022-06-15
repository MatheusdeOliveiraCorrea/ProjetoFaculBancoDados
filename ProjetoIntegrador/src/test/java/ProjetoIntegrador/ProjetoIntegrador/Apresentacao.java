package ProjetoIntegrador.ProjetoIntegrador;

import java.util.LinkedList;

import dao.PacienteDAO;
import model.Paciente;

public class Apresentacao {

	/*
	 * Criando uma LinkedList para guardar todos os pacientes guardados no banco de
	 * dados. Esses dados são disponibilizados pelo método listarPacientes() da
	 * classe PacienteDAO. Em seguida é usado um for each para percorrer todos os
	 * elementos da lista e imprimir no console
	 */	
	public void listarTodosPacientes() {

		PacienteDAO dao = new PacienteDAO();

		// lista
		LinkedList<Paciente> pacienteList = new LinkedList<Paciente>();

		pacienteList = dao.listarPacientes(); // chamar método

		// for each
		System.out.println("\nLista de todos os pacientes:\n");
		for (Paciente paciente : pacienteList) {

			System.out.println(" " + paciente);
			System.out.println("-----------------------------------" + "------------------------------------");
		}

	}
	
	
	/*
	 * Lista todos os pacientes que estão cadastrados como true em vacinados
	 */
	
	public void listarTodosPacientesVacinados() {

		PacienteDAO dao = new PacienteDAO();
		LinkedList<Paciente> pacienteList = new LinkedList<Paciente>();

		pacienteList = (LinkedList<Paciente>) dao.listarVacinados();

		System.out.println("\nLista dos que foram vacinados: \n ");
		for (Paciente paciente : pacienteList) {

			System.out.println(paciente);
			System.out.println("-------------------------------------" + "----------------------------------");
		}
		
	}
	
	/*
	 * Buscar pelo cpf
	 */
	
	public void buscar() {
		
		PacienteDAO dao = new PacienteDAO();
		dao.consultar("cpf"); //inserir cpf válido
		
	}
	
	public void update() {
		
		PacienteDAO dao = new PacienteDAO();
		dao.updateUf("SC", "74125898547");  
		dao.updateNome("nome", "cpf");
		dao.updateVacinado(false, "cpf");
		
	}
	
	
	
}
