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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args)throws Exception{
		
	}
}
