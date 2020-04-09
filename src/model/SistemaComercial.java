package model;
import java.util.Collection;

public interface SistemaComercial {
	public boolean existeProduto(Produto produto);

	public Produto pesquisaProduto(String codProduto) throws ProdutoNaoExisteException;

	public boolean cadastraProduto(Produto produto);

	public boolean cadastraPedido(Pedido pedido);
	public boolean exitePedido(Pedido pedido);
	public boolean cadastraCliente(Cliente cliente);

	public boolean existeCliente(Cliente cliente);

	public Cliente pesquisaCliente(String id);

	public Collection<Cliente> pesquisaClienteComOnomeComecandoCom(String prefixo);

	public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria);
}
