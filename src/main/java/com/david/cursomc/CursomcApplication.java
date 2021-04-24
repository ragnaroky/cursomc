package com.david.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.david.cursomc.domain.Categoria;
import com.david.cursomc.domain.Cidade;
import com.david.cursomc.domain.Cliente;
import com.david.cursomc.domain.Endereco;
import com.david.cursomc.domain.Estado;
import com.david.cursomc.domain.ItemPedido;
import com.david.cursomc.domain.Pagamento;
import com.david.cursomc.domain.PagamentoComBoleto;
import com.david.cursomc.domain.PagamentoComCartao;
import com.david.cursomc.domain.Pedido;
import com.david.cursomc.domain.Produto;
import com.david.cursomc.domain.enums.EstadoPagamento;
import com.david.cursomc.domain.enums.TipoCliente;
import com.david.cursomc.repositories.CategoriaRepository;
import com.david.cursomc.repositories.CidadeRepository;
import com.david.cursomc.repositories.ClienteRepository;
import com.david.cursomc.repositories.EnderecoRepository;
import com.david.cursomc.repositories.EstadoRepository;
import com.david.cursomc.repositories.ItemPedidoRepository;
import com.david.cursomc.repositories.PagamentoRepository;
import com.david.cursomc.repositories.PedidoRepository;
import com.david.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args)throws Exception{
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		Categoria cat3 = new Categoria(null, "cama mesa e banho");
		Categoria cat4 = new Categoria(null, "eletrônicos");
		Categoria cat5 = new Categoria(null, "jardinagem");
		Categoria cat6 = new Categoria(null, "decoração");
		Categoria cat7 = new Categoria(null, "perfumaria");
		
		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.00);
		Produto p3 = new Produto(null,"mouse",80.00);
		Produto p4 = new Produto(null,"mesa",2000.00);
		Produto p5 = new Produto(null,"toalha",800.00);
		Produto p6 = new Produto(null,"colcha",80.00);
		Produto p7 = new Produto(null,"tv true collor",2000.00);
		Produto p8 = new Produto(null,"roçadeira",800.00);
		Produto p9 = new Produto(null,"abajour",80.00);
		Produto p10 = new Produto(null,"pendente",2000.00);
		Produto p11 = new Produto(null,"shampoo",800.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
		Estado est1 = new Estado(null,"minas gerais");
		Estado est2 = new Estado(null,"sao paulo");
		
		Cidade c1 = new Cidade(null,"uberlandia",est1);
		Cidade c2 = new Cidade(null,"sao paulo",est2);
		Cidade c3 = new Cidade(null,"campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente (null, "maria silva", "maria@gmail.com", "12345678912", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("988745687", "986541247"));
		
		Endereco e1 = new Endereco(null, "rua flores", "300","casa", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "av matos", "12","casa", "centro", "38220021", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1,e1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}
}
