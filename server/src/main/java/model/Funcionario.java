package model;

public class Funcionario {
	
	int id;
	String nome;
	String cargo;
	String dataNascimento;
	String dataEmpresa;
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", dataNascimento=" + dataNascimento
				+ ", dataEmpresa=" + dataEmpresa + "]";
	}

	public Funcionario(int id, String nome, String cargo, String dataNascimento, String dataEmpresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.dataEmpresa = dataEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataEmpresa() {
		return dataEmpresa;
	}

	public void setDataEmpresa(String dataEmpresa) {
		this.dataEmpresa = dataEmpresa;
	}
	
	
	

}
