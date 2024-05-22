package model;


import java.util.*;

/**
 * 
 */
public class Motorista extends Funcionario {

    public Motorista() {
    }

    private String cnh_moto;
    private Date data_experação;
    
	@Override
	public String toString() {
		return "Motorista [cnh_moto=" + cnh_moto + ", data_experação=" + data_experação + "]";
	}
	
	public Motorista(String cnh_moto, Date data_experação) {
		super();
		this.cnh_moto = cnh_moto;
		this.data_experação = data_experação;
	}
	
	public String getCnh_moto() {
		return cnh_moto;
	}
	public void setCnh_moto(String cnh_moto) {
		this.cnh_moto = cnh_moto;
	}
	public Date getData_experação() {
		return data_experação;
	}
	public void setData_experação(Date data_experação) {
		this.data_experação = data_experação;
	}
    
    

}