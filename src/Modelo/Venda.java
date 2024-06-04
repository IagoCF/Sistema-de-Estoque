package Modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private BigInteger cliente;
	private ArrayList<Produto> produto;
	private FormaPagamento pagamento;
	private Date dataVenda;
	
	public BigInteger getCliente() {
		return cliente;
	}
	public void setCliente(BigInteger cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getProduto() {
		return produto;
	}
	public void setProduto(ArrayList<Produto> produto) {
		this.produto = produto;
	}
	public FormaPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Venda(BigInteger cliente, ArrayList<Produto> produto, FormaPagamento pagamento, Date dataVenda) {
		super();
		this.cliente = cliente;
		this.produto = produto;
		this.pagamento = pagamento;
		this.dataVenda = dataVenda;
	}
	
}
