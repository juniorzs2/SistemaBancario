

	package negocio;

	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;

	import java.util.ArrayList;
	import java.util.List;

	import org.junit.Test;

	public class GerenciadoraContasTest {
		private GerenciadoraContas gerContas;

		@Test
		public void testTransfereValor1() {
			int idConta01 = 1;
			int idConta02 = 2;

			ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
			ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

			
			
			List<ContaCorrente> contasDoBanco = new ArrayList<>();
			
			contasDoBanco.add(conta01);
			contasDoBanco.add(conta02);
			
			gerContas = new GerenciadoraContas(contasDoBanco);
		
			boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
			
			assertTrue(sucesso);
			assertThat(conta01.getSaldo(), equalTo(100.0));
			assertThat(conta02.getSaldo(), equalTo(100.0));
		}
		
		
		
		

		@Test
		public void testTransfereValor2() {
			int idConta01 = 1;
			int idConta02 = 2;

			ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
			ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
			
			List<ContaCorrente> contasDoBanco = new ArrayList<>();
			
			contasDoBanco.add(conta01);
			contasDoBanco.add(conta02);
			
			gerContas = new GerenciadoraContas(contasDoBanco);
		
			boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
			
			assertTrue(sucesso);
			assertThat(conta01.getSaldo(), equalTo(-100.0));
			assertThat(conta02.getSaldo(), equalTo(200.0));
		}	
		
		
		@Test
		public void testTransfereValor3() {
			int idConta01 = 1;
			int idConta02 = 2;

			ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
			ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
			
			List<ContaCorrente> contasDoBanco = new ArrayList<>();
			
			contasDoBanco.add(conta01);
			contasDoBanco.add(conta02);
			
			gerContas = new GerenciadoraContas(contasDoBanco);
		
			boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
			
			assertTrue(sucesso);
			assertThat(conta01.getSaldo(), equalTo(-200.0));
			assertThat(conta02.getSaldo(), equalTo(100.0));
		}	
		
		
		
		@Test
		public void testTransfereValor4() {
			int idConta01 = 1;
			int idConta02 = 2;

			ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
			ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
			
			List<ContaCorrente> contasDoBanco = new ArrayList<>();
			
			contasDoBanco.add(conta01);
			contasDoBanco.add(conta02);
			
			gerContas = new GerenciadoraContas(contasDoBanco);
		
			boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
			
			assertTrue(sucesso);
			assertThat(conta01.getSaldo(), equalTo(-300.0));
			assertThat(conta02.getSaldo(), equalTo(100.0));
		}	
		
	}


