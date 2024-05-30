package model;

import java.util.Date;

public class Pedido {

    private int id;
    private Date data;
    private Double total;
    private Cliente cliente;
    private Funcionario funcionario;
    
	public Pedido() {
		super();
	}

	public Pedido(int id, Date data, Double total, Cliente cliente, Funcionario funcionario) {
		super();
		this.id = id;
		this.data = data;
		this.total = total;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", total=" + total + ", cliente=" + cliente + ", funcionario="
				+ funcionario + "]";
	}
	
}