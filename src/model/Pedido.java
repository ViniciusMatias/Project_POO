package model;

public class Pedido {
	private Produto produto;
	private Cliente cliente;
	private String codPedido;
	
	public Pedido(Cliente cliente, Produto produto, String codPedido) {
		this.produto = produto;
		this.cliente = cliente;
		this.codPedido = codPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	public String toString() {
		return "\nNome: "+this.cliente.getNome()+"\nId: "+this.cliente.getId()+"\nEndereço: "+this.cliente.getEndereco()+"\nProduto: "+this.produto.getDescricao()+"\nCodigo_pedido: "+this.getCodPedido()+"\n";
	}
	
	}
