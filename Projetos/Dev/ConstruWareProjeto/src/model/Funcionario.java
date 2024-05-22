package model;

/**
 * 
 * 
 */

public class Funcionario {

    public Funcionario() {
    }

    private int cod_func;
    private String nome_func;
    private String cpf_func;
    private String end_func;
    private String tel_func;
    private String email_func;
    private String login_func;
    private String senha;
    
	@Override
	public String toString() {
		return "Funcionario [cod_func=" + cod_func + ", nome_func=" + nome_func + ", cpf_func=" + cpf_func
				+ ", end_func=" + end_func + ", tel_func=" + tel_func + ", email_func=" + email_func + ", login_func="
				+ login_func + ", senha=" + senha + "]";
	}

	public Funcionario(int cod_func, String nome_func, String cpf_func, String end_func, String tel_func,
			String email_func, String login_func, String senha) {
		super();
		this.cod_func = cod_func;
		this.nome_func = nome_func;
		this.cpf_func = cpf_func;
		this.end_func = end_func;
		this.tel_func = tel_func;
		this.email_func = email_func;
		this.login_func = login_func;
		this.senha = senha;
	}

	public int getCod_func() {
		return cod_func;
	}

	public void setCod_func(int cod_func) {
		this.cod_func = cod_func;
	}

	public String getNome_func() {
		return nome_func;
	}

	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}

	public String getCpf_func() {
		return cpf_func;
	}

	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}

	public String getEnd_func() {
		return end_func;
	}

	public void setEnd_func(String end_func) {
		this.end_func = end_func;
	}

	public String getTel_func() {
		return tel_func;
	}

	public void setTel_func(String tel_func) {
		this.tel_func = tel_func;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}

	public String getLogin_func() {
		return login_func;
	}

	public void setLogin_func(String login_func) {
		this.login_func = login_func;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
    
	
    

}