package model;

public class Paciente {
	
	/*
	 * Define a estrutura da tabela "Paciente" do banco de dados.
	 * Ou seja, permite que atribuimos e recebemos os dados do banco de 
	 * dados com total integridade. Os atributos dessa classe são os mesmos
	 * atributos definidos na hora da criação da tabela no banco de dados
	 */
	
	private long id;
	private String nome; 
	private String cpf;
	private boolean vacinado; 
	private String uf;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public boolean isVacinado() {
		return vacinado;
	}
	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", vacinado=" + vacinado + ", uf=" + uf + "]";
	} 
	
	
}
