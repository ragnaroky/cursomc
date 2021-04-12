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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args)throws Exception{
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.00);
		Produto p3 = new Produto(null,"mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
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
	}
}
