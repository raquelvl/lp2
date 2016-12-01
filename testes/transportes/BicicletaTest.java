package transportes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BicicletaTest {
	
	Bicicleta b1;
	
	@Before
	public void setup() throws Exception {
		b1 = new Bicicleta(10);
	}

	@Test
	public void testBicicleta() {
		Assert.assertEquals("t1", 0.0, b1.getVelocidadeAtual(), 0.005);
		Assert.assertEquals("t1", 10.0, b1.getVelocidadeMaxima(), 0.005);
	}
	
	@Test(expected=Exception.class)
	public void testBicicletaVelocidadeNegativa() throws Exception {
		Bicicleta b2 = new Bicicleta(-0.01);
	}

	@Test
	public void testPara() {
		Assert.assertEquals("t1", 0.0, b1.getVelocidadeAtual(), 0.005);
		b1.acelera();
		Assert.assertEquals("t1", 1.0, b1.getVelocidadeAtual(), 0.005);
		b1.para();
		Assert.assertEquals("t1", 0.0, b1.getVelocidadeAtual(), 0.005);
		b1.para();
		Assert.assertEquals("t1", 0.0, b1.getVelocidadeAtual(), 0.005);
	}

	@Test
	public void testAcelera() {
		Assert.assertEquals("t1", 0.0, b1.getVelocidadeAtual(), 0.005);
		for (double i = 1; i <= 10; i++) {
			b1.acelera();
			Assert.assertEquals("t1", i, b1.getVelocidadeAtual(), 0.005);
		}
		b1.acelera();
		Assert.assertEquals("t1", 10.0, b1.getVelocidadeAtual(), 0.005);
	}

	@Test
	public void testDesacelera() {
		Assert.assertEquals("t2", 0.0, b1.getVelocidadeAtual(), 0.005);
		for (double i = 1; i <= 10; i++) {
			b1.acelera();
		}
		Assert.assertEquals("t2", 10.0, b1.getVelocidadeAtual(), 0.005);
		
		for (double i = 9.0; i >= 0.0; i--) {
			b1.desacelera();
			Assert.assertEquals("t2", i, b1.getVelocidadeAtual(), 0.005);
		}
		b1.desacelera();
		Assert.assertEquals("t2", 0.0, b1.getVelocidadeAtual(), 0.005);	}

	@Test
	public void testEqualsObject() throws Exception {
		Assert.assertEquals("t3", b1, b1);
		Bicicleta b2 = new Bicicleta(10);
		Assert.assertEquals("t3", b2, b1);
		b1.acelera();
		Assert.assertEquals("t3", b2, b1);
		Bicicleta b3 = new Bicicleta(10.01);
		Assert.assertNotEquals("t3", b3, b1);
	}

	@Test
	public void testToString() {
		Assert.assertEquals("t2", "Velocidade atual: 0.0/ Velocidade maxima: 10.0", b1.toString());
		b1.acelera();
		Assert.assertEquals("t2", "Velocidade atual: 1.0/ Velocidade maxima: 10.0", b1.toString());
	}

}
