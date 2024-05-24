package model;

/**
 * 
 * 
 */

public class Funcionario extends Cliente {
					
	private String senha;
	private String cargo;
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	
	
}
