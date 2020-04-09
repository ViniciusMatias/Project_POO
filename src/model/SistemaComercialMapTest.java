package model;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class SistemaComercialMapTest {

	@Test
	void testacadastroProtudos() {
		SistemaComercialMap a = new SistemaComercialMap();
		Collection<Produto> alimentos = a.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
		assertTrue(alimentos.size() == 0);
		Produto produto01 = new Produto("00055", "carne", 10.0, CategoriaProduto.ALIMENTO);
		a.cadastraProduto(produto01);
		assertEquals(true,a.existeProduto(produto01));
		Collection<Produto> alimentos02 = a.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
		assertTrue(alimentos02.size() == 1);
		Cliente cliente01 = new ClienteCPF("Vinicius","ABC","Vinicius@dce","123");
		Cliente cliente02 = new ClienteCPF("Vinicius","ABC","Vinicius@dce","123");
		//a.cadastraCliente(cliente01);
		assertEquals(true, a.cadastraCliente(cliente02));
	}
	
	@Test
	void testePedido() {
		SistemaComercialMap s = new SistemaComercialMap();
		Cliente user = new ClienteCPF("Vinicius", "João Claudino Cruz", "Vinicius.matias@dce.ufpb","123");
		Produto prod  = new Produto ("123456789","Carne",15.0,CategoriaProduto.ALIMENTO);
		s.cadastraCliente(user);
		s.cadastraProduto(prod);
		assertTrue(s.existeCliente(user) == true);
		assertTrue(s.existeProduto(prod) == true);
		Pedido pedido = new Pedido(user, prod, "165646498");
		s.cadastraPedido(pedido);
		assertTrue(s.exitePedido(pedido) == true);
		
	}
	@Test
	void testException() {
		SistemaComercialMap s = new SistemaComercialMap();
		Produto prod  = new Produto ("123456789","Carne",15.0,CategoriaProduto.ALIMENTO);
		assertThrows(ProdutoNaoExisteException.class, () ->{
			s.pesquisaProduto("123456789");
		});
	}

}
