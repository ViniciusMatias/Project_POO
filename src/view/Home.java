package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import model.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.TextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class Home extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		SistemaComercialMap sistema = new SistemaComercialMap();
		setTitle("Sistema Comercial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JButton cadastraProduto = new JButton("Cadastra Produtos");
		cadastraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = JOptionPane.showInputDialog("Codigo do Codigo: ");
				String descricao = JOptionPane.showInputDialog("Digite descrição: ");
				double precoVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço: "));
				int selCategoria =  Integer.parseInt(JOptionPane.showInputDialog("1 - Alimento\n2 - Poupa\n3 - Produto de Limpeza"));
				if(selCategoria == 1 ) {
					Produto prod = new Produto(codigo, descricao, precoVenda, CategoriaProduto.ALIMENTO );
					sistema.cadastraProduto(prod);
				}else if(selCategoria == 2 ) {
					Produto prod = new Produto(codigo, descricao, precoVenda, CategoriaProduto.POUPA );
					sistema.cadastraProduto(prod);
				}else if(selCategoria == 3 ) {
					Produto prod = new Produto(codigo, descricao, precoVenda, CategoriaProduto.PRODUTO_DE_LIMPEZA );
					sistema.cadastraProduto(prod);
				}
				
			}
		});
		cadastraProduto.setForeground(Color.BLACK);
		cadastraProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastraProduto.setBorder(new LineBorder(Color.white));
		cadastraProduto.setBackground(Color.WHITE);
		cadastraProduto.setBounds(231, 107, 146, 23);
		contentPane.add(cadastraProduto);
		
		
		//Cadastrar Cliente
		JButton cadastraCliente = new JButton("Cadastrar Cliente");
		cadastraCliente.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = JOptionPane.showInputDialog("Digite seu nome");
				String Endereco = JOptionPane.showInputDialog("Digite seu endereço");
				String email = JOptionPane.showInputDialog("Digite seu email");
				int qualCPFouPJ = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n 1- para CNPJ\n 2 - para CPF")) ;
				
					if(qualCPFouPJ == 1) {
						String CNPJ = JOptionPane.showInputDialog("Digite seu CNPJ");
						
						Cliente clienteCNPJ = new ClienteCNPJ(nome,Endereco,email,CNPJ);						
						sistema.cadastraCliente(clienteCNPJ);
						
					}else if(qualCPFouPJ == 2) {
						String CPF = JOptionPane.showInputDialog("Digite seu CPF");
						
						Cliente clienteCNPJ = new ClienteCPF(nome,Endereco,email,CPF);						
						sistema.cadastraCliente(clienteCNPJ);
					}
				
				
			}
		});
		cadastraCliente.setForeground(Color.BLACK);
		cadastraCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastraCliente.setBorder(new LineBorder(Color.white));
		cadastraCliente.setBackground(Color.WHITE);
		cadastraCliente.setBounds(231, 78, 146, 23);
		contentPane.add(cadastraCliente);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 151, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		JButton produtos = new JButton("Produtos");
		produtos.setBounds(22, 78, 89, 23);
		panel.add(produtos);
		
		JButton clientes = new JButton("Clientes");
		clientes.setBounds(22, 112, 89, 23);
		panel.add(clientes);
		
		JButton pedidos = new JButton("Pedidos");
		pedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Pedido> listaPedidos = sistema.pedidosLista();
				String pedidosview= "";
				for(Pedido a: listaPedidos) {
					pedidosview += "\n________________________"+a.toString()+"\n________________________";
				}JOptionPane.showMessageDialog(null, listaPedidos);
			}
		});
		pedidos.setBounds(22, 146, 89, 23);
		panel.add(pedidos);
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cliente>listaCliente = sistema.ClientesLista();
				String clientesview= "";
				for(Cliente a: listaCliente) {
					clientesview += "\nNome: "+a.getNome()+"\nEndereço: "+a.getEndereco()+"\nID:"+a.getId()+"\n________________________";
				}JOptionPane.showMessageDialog(null, clientesview);
			}
		});
		produtos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Produto>listaProdutos = sistema.produtos();
				String produtosView = "";
				for(Produto a: listaProdutos) {

					produtosView += "\nCodigo: "+a.getCodigo()+"\nProdutos: "+a.getDescricao()+"\nPreço: "+a.getPrecoVenda()+"\n________________________";
				}JOptionPane.showMessageDialog(null, produtosView);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Sistema Comercial");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(161, 33, 216, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrarPedidos = new JButton("Cadastrar Pedidos");
		btnCadastrarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Produto
				CategoriaProduto Categoria = null;
				int selCategoria =  Integer.parseInt(JOptionPane.showInputDialog("Qual a categoria do produto\n1 - Alimento\n2 - Poupa\n3 - Produto de Limpeza"));
				if(selCategoria == 1 ) {
						Categoria = Categoria.ALIMENTO;
				}else if(selCategoria == 2 ) {
					   Categoria = Categoria.POUPA;
				}else if(selCategoria == 3 ) {
					   Categoria = Categoria.PRODUTO_DE_LIMPEZA;
				}
				String codProduto = JOptionPane.showInputDialog("Digite o codigo do produto: ");
				String descricao = JOptionPane.showInputDialog("Digite descrição: ");
				double precoVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço: "));
				Produto produto = new Produto(codProduto, descricao, precoVenda, Categoria);
				
				String codiPedido = JOptionPane.showInputDialog("Digite o codigo do pedido: ");
				//Cliente
				String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");				
				String Endereco = JOptionPane.showInputDialog("Digite o endereço: ");
				String email = JOptionPane.showInputDialog("Digite o email: ");
				 
				
				int qualCPFouPJ =Integer.parseInt(JOptionPane.showInputDialog("Digite:\n 1 - CPF\n 2 - CNPJ:"));
				if(qualCPFouPJ == 1) {
					String CNPJ = JOptionPane.showInputDialog("Digite seu CNPJ");
					
					Cliente clienteCNPJ = new ClienteCNPJ(nome,Endereco,email,CNPJ);						
					Pedido pedidoClienteCPF = new Pedido(clienteCNPJ, produto, codiPedido);
					sistema.cadastraPedido(pedidoClienteCPF);
					
				}else if(qualCPFouPJ == 2) {
					String CPF = JOptionPane.showInputDialog("Digite seu CPF");
					
					Cliente clienteCPF = new ClienteCPF(nome,Endereco,email,CPF);						
					Pedido pedidoClienteCPF = new Pedido(clienteCPF, produto, codiPedido);
					sistema.cadastraPedido(pedidoClienteCPF);
				}
				
				
					
					
			}
		});
		btnCadastrarPedidos.setForeground(Color.BLACK);
		btnCadastrarPedidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrarPedidos.setBorder(new LineBorder(Color.white));
		btnCadastrarPedidos.setBackground(Color.WHITE);
		btnCadastrarPedidos.setBounds(231, 141, 146, 23);
		contentPane.add(btnCadastrarPedidos);
		
		JButton pesquisaProdutos = new JButton("Pesquisa Produtos");
		pesquisaProdutos.setBounds(231, 212, 146, 23);
		contentPane.add(pesquisaProdutos);
		pesquisaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pesquisaProdutos.setForeground(new Color(0, 0, 0));
		pesquisaProdutos.setBackground(new Color(255, 255, 255));
		pesquisaProdutos.setBorder(new LineBorder(Color.white));
		
		JButton pesquisaCliente = new JButton("Pesquisa Clientes");
		pesquisaCliente.setBounds(231, 186, 146, 23);
		contentPane.add(pesquisaCliente);
		pesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int qualCPFouPJ = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n 1- para CNPJ\n 2 - para CPF")) ;
				if(qualCPFouPJ == 1) {
					String CNPJ = JOptionPane.showInputDialog("Digite seu CNPJ");
					JOptionPane.showMessageDialog(null, sistema.pesquisaCliente(CNPJ).getNome());
					
				}else if(qualCPFouPJ == 2) {
					String CPF = JOptionPane.showInputDialog("Digite seu CPF");
					JOptionPane.showMessageDialog(null, sistema.pesquisaCliente(CPF).getNome());
				}
				
			}
		});
		pesquisaCliente.setForeground(Color.BLACK);
		pesquisaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pesquisaCliente.setBorder(new LineBorder(Color.white));
		pesquisaCliente.setBackground(Color.WHITE);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(217, 186, 4, 49);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 0));
		panel_2.setBounds(217, 78, 4, 86);
		contentPane.add(panel_2);
		
		
		pesquisaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codProd = JOptionPane.showInputDialog("Digite o codigo do Produto: ");
				try {
					JOptionPane.showMessageDialog(null, "Poduto da categoria :"+sistema.pesquisaProduto(codProd).getCategoria()+"\nDescrição do produto: "+sistema.pesquisaProduto(codProd).getDescricao()+"\nPreço: "+sistema.pesquisaProduto(codProd).getPrecoVenda());
				} catch (ProdutoNaoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
	}
}
