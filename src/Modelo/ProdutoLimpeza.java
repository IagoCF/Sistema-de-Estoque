package Modelo;

public class ProdutoLimpeza extends Produto{
	
	public ProdutoLimpeza(Integer quantidade, String nome,
							String descricao, String categoria, Double precoCusto,
							Double precoVenda){
		this.quantidade = quantidade;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}
}
