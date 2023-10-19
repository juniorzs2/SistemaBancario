package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;

	@Before
	public void setUp() {
		Cliente cliente01 = new Cliente(idCliente01, "Joao", 42, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 34, "mariafe@gmail.com", 1, true);

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	@Test
	public void testPesquisaCliente() {
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);

		assertThat(cliente.getId(), is(idCliente01));
	}

	@Test
	public void testRemoveCliente() {
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), equalTo(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}

	@Test
	public void validarIdateEquivalenciaInferior1() throws IdadeNaoPermitidaException {
		try {
			boolean validacao = gerClientes.validaIdade(17);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}
	}

	@Test
	public void validarIdateEquivalenciaDentro() throws IdadeNaoPermitidaException {
		
		try {
			boolean validacao = gerClientes.validaIdade(18);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}
	}

	@Test
	public void validarIdateEquivalenciaSuperio2() throws IdadeNaoPermitidaException {
		
		try {
			boolean validacao = gerClientes.validaIdade(66);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}

	}

	@Test
	public void validarIdateLimiteInferior() throws IdadeNaoPermitidaException {

		try {
			boolean validacao = gerClientes.validaIdade(17);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}
	}

	@Test
	public void validarIdateLimiteDentro() throws IdadeNaoPermitidaException {

		try {
			boolean validacao = gerClientes.validaIdade(18);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}
	}

	@Test
	public void validarIdateLimiteDentroSuperior() throws IdadeNaoPermitidaException {
		try {
			boolean validacao = gerClientes.validaIdade(65);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}
	}

	@Test
	public void validarIdateEquivalenciaInferior() throws IdadeNaoPermitidaException {
		try {
			boolean validacao = gerClientes.validaIdade(66);
			assertTrue(validacao);

		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("A idade do cliente precisa estar entre 18 e 65 anos."));
		}

	}

}