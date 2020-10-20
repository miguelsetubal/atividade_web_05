package br.ufc.web.atividade05.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="funcionarios")
public class Func {
	@Id
	@GeneratedValue
	int id;
	String nome;
	String cargo;
	String dnascimento;
	String dempresa;
	
	
	
	public Func(int id, String nome, String cargo, String dnascimento, String dempresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.dnascimento = dnascimento;
		this.dempresa = dempresa;
	}
	public Func(String nome, String cargo, String dnascimento, String dempresa) {
		super();		
		this.nome = nome;
		this.cargo = cargo;
		this.dnascimento = dnascimento;
		this.dempresa = dempresa;
	}
	
	public Func() {
		
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
	public String getDnascimento() {
		return dnascimento;
	}
	public void setDnascimento(String dnascimento) {
		this.dnascimento = dnascimento;
	}
	public String getDempresa() {
		return dempresa;
	}
	public void setDempresa(String dempresa) {
		this.dempresa = dempresa;
	}
	
	@Override
	public String toString() {
		return "funcs [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", dnascimento=" + dnascimento
				+ ", dempresa=" + dempresa + "]";
	}
	
	

}
