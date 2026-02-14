package entities;

import java.util.Objects;

public class Funcionario {

	int idFuncionario;
	String nome;
	String cpf;
	String fone;
	
	public Funcionario() {
	}

	public Funcionario(int idFuncionario, String nome, String cpf, String fone) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public int setIdFuncionario() {
		return idFuncionario;
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

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFuncionario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return idFuncionario == other.idFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", fone=" + fone
				+ "]";
	}
	
	
	
	
}
