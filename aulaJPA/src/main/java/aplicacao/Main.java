package aplicacao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import controller.CompraJPAController;
import controller.PessoaJPAController;
import model.Compra;
import model.Pessoa;

public class Main {
	public static void main(String[] args) {
		CompraJPAController compraController = new CompraJPAController();
		PessoaJPAController pessoaController = new PessoaJPAController();

		// Cria uma instância de Pessoa para teste
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pedro");
		pessoa.setEmail("pedro@example.com");
		pessoa.setLogin("Pedro");
		pessoa.setSenha("pedro123");

		// Teste do método create para Pessoa
		pessoaController.create(pessoa);
		System.out.println("Pessoa criada com sucesso.");

		// Teste do método findById para Pessoa
		Pessoa pessoaEncontrada = pessoaController.findById(pessoa.getId());
		System.out.println("Pessoa encontrada: " + pessoaEncontrada);

		// Teste do método findAll para Pessoa
		List<Pessoa> todasPessoas = pessoaController.findAll();
		System.out.println("Todas as pessoas:");
		for (Pessoa p : todasPessoas) {
			System.out.println(p);
		}

		// Cria uma instância de Compra para teste
		Compra compra = new Compra();
		compra.setData(new Date());
		compra.setFormaDePagamento("Cartão de Crédito");

		// Teste do método create para Compra
		compraController.create(compra);
		System.out.println("Compra criada com sucesso.");

		// Teste do método findById para Compra
		Compra compraEncontrada = compraController.findById(compra.getIdCompra());
		System.out.println("Compra encontrada: " + compraEncontrada);

		// Teste do método findAll para Compra
		List<Compra> todasCompras = compraController.findAll();
		System.out.println("Todas as compras:");
		for (Compra c : todasCompras) {
			System.out.println(c);
		}

		// Teste do método edit para Compra
		compraEncontrada.setFormaDePagamento("Boleto Bancário");
		compraController.edit(compraEncontrada);
		System.out.println("Compra editada com sucesso.");

		// Teste do método destroy para Compra
		compraController.destroy(compra.getIdCompra());
		System.out.println("Compra removida com sucesso.");

		// Teste do método destroy para Pessoa
		pessoaController.destroy(pessoa.getId());
		System.out.println("Pessoa removida com sucesso.");

	}
}