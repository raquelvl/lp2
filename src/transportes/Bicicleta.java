package transportes;

public class Bicicleta {

	private double velocidadeAtual = 0;
	private double velocidadeMaxima;

	public Bicicleta(double velocidadeMaxima) throws Exception {
		if (velocidadeMaxima <= 0)
			throw new Exception("Velocidade maxima tem que ser maior que zero");
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public double getVelocidadeAtual() {
		return this.velocidadeAtual;
	}

	public void para() {
		this.velocidadeAtual = 0;
	}

	public void acelera() {
		velocidadeAtual = (velocidadeAtual + 1 > getVelocidadeMaxima()) ? getVelocidadeMaxima()
				: velocidadeAtual + 1;
	}

	public void desacelera() {
		velocidadeAtual = (velocidadeAtual - 1 < 0) ? 0 : velocidadeAtual - 1;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Bicicleta))
			return false;
		Bicicleta bicicletaComparada = (Bicicleta) obj;
		return this.velocidadeMaxima == bicicletaComparada
				.getVelocidadeMaxima();
	}

	@Override
	public String toString() {
		return "Velocidade atual: " + this.velocidadeAtual
				+ "/ Velocidade maxima: " + this.velocidadeMaxima;
	}

}