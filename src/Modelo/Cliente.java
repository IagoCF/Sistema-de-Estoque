package Modelo;

import java.math.BigInteger;
import java.util.Date;

public class Cliente {
	private BigInteger cpf;
	private String nome, email;
	private Date dataNascimento;
	
	public BigInteger getCpf() {
		return cpf;
	}
	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Cliente(BigInteger cpf, String nome, String email, Date dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
}
