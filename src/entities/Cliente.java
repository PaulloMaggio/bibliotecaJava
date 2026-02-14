package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	int idCliente;
	String nome;
	String cpf;
	String fone;
	
	public List<Livros> livrosAlugadosCliente = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(int idCliente, String nome, String cpf, String fone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public int setIdCliente() {
		return idCliente;
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
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", fone=" + fone + "]";
	};
	
}
