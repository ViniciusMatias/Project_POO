package model;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial {

	private Map<String, Cliente> clientes;
	private Map<String, Produto> produtos;
	private Map<String, Pedido> pedidos;

	public SistemaComercialMap() {
		this.clientes = new HashMap<String, Cliente>();
		this.produtos = new HashMap<String, Produto>();
		this.pedidos = new HashMap<String, Pedido>();
	}

	@Override
	public boolean existeProduto(Produto produto) {
		if (this.produtos.containsKey(produto.getCodigo())) {
			return true;
		} else {
			return false;
		}
	}
	public ArrayList<Cliente> ClientesLista(){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		for(Cliente a : this.clientes.values()) {
			lista.add(a);
		}
		return lista;
	}
	public ArrayList<Pedido> pedidosLista(){
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		for(Pedido a : this.pedidos.values()) {
			lista.add(a);
		}
		return lista;
	}
	

	@Override
	public Produto pesquisaProduto(String codProduto) throws ProdutoNaoExisteException {

		if (this.produtos.containsKey(codProduto)) {
			return this.produtos.get(codProduto);
		}
		throw new ProdutoNaoExisteException("Não foi encontrado produto" + " com o código " + codProduto);
	}

	@Override
	public boolean cadastraProduto(Produto produto) {
		if (this.produtos.containsKey(produto.getCodigo())) {
			return false;
		} else {
			this.produtos.put(produto.getCodigo(), produto);
			return true;
		}

	}

	@Override
	public boolean cadastraCliente(Cliente cliente) {
		if(! existeCliente(cliente)){
			this.clientes.put(cliente.getId(), cliente);
			return true;
		}
		return false;
		
		
//		if (this.clientes.containsKey(cliente.getId())) {
//			return false;
//		} else {
//			this.clientes.put(cliente.getId(), cliente);
//			return true;
//		}
	}

	@Override
	public boolean existeCliente(Cliente cliente) {
		if (this.clientes.containsKey(cliente.getId())) {
			return true;
		}
		return false;
	}

	@Override
	public Cliente pesquisaCliente(String id) {
		if (clientes.containsKey(id)) {
			return this.clientes.get(id);
		}
		return null;
	}

	@Override
	public Collection<Cliente> pesquisaClienteComOnomeComecandoCom(String prefixo) {
		Collection<Cliente> lista = new ArrayList<Cliente>();
		for (Cliente a : this.clientes.values()) {
			if (a.getNome().startsWith(prefixo)) {
				lista.add(a);
			}
		}
		return lista;

	}

	@Override
	public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
		Collection<Produto> listaProdutosCategoria = new ArrayList<Produto>();
		for (Produto p : this.produtos.values()) {
			if (p.getCategoria() == categoria) {
				listaProdutosCategoria.add(p);
			}
		}
		return listaProdutosCategoria;

	}
	
	public ArrayList<Produto> produtos(){
		ArrayList<Produto> listaProduto = new ArrayList<>();
		for(Produto p: this.produtos.values()) {
			listaProduto.add(p);
		}
		return listaProduto;
	}

	@Override
	public boolean cadastraPedido(Pedido pedido) {
		if(this.clientes.containsKey(pedido.getCliente().getId()) && this.produtos.containsKey(pedido.getProduto().getCodigo())) {
			this.pedidos.put(pedido.getCodPedido(), pedido);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean exitePedido(Pedido pedido) {
		if (this.pedidos.containsKey(pedido.getCodPedido())) {
			return true;
		} else {
			return false;
		}
		
	}

}
