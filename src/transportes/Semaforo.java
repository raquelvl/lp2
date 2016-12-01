package transportes;

public class Semaforo {

	public static final String VERDE = "verde";
	public static final String AMARELO = "amarelo";
	public static final String VERMELHO = "vermelho";

	private String cor;

	public Semaforo(String corAtual) throws Exception {

		if (corAtual == null || (!corAtual.equals(Semaforo.VERDE)
				&& !corAtual.equals(Semaforo.VERMELHO)
				&& !corAtual.equals(Semaforo.AMARELO)))

			throw new Exception("Cor de semaforo invalida.");

		cor = corAtual;
	}

	public String mudaCor() {
		switch (cor) {
		case Semaforo.VERDE:
			cor = Semaforo.AMARELO;
			break;
		case Semaforo.VERMELHO:
			cor = Semaforo.VERDE;
			break;
		case Semaforo.AMARELO:
			cor = Semaforo.VERMELHO;
			break;
		}

		return cor;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Semaforo))
			return false;

		Semaforo smf = (Semaforo) obj;
		return getCor().equals(smf.getCor());
	}

	@Override
	public String toString() {
		return "Semaforo estah " + cor;
	}

}
