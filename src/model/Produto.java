package model;

public class Produto {
	private String codigo;
	private String descricao;
	private double precoVenda;
	private CategoriaProduto categoria;

	public Produto(String codigo, String descricao, double precoVenda, CategoriaProduto categoria) {

		this.codigo = codigo;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.categoria = categoria;
	}

	public Produto() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

}
