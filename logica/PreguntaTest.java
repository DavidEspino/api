package logica;

public class PreguntaTest extends Pregunta {
	
	private String[] respuestasPosibles;

	public PreguntaTest(int pId, String pTitulo, String[] pRespuestasPosibles) {
		super(pId, pTitulo);
		respuestasPosibles = pRespuestasPosibles;
	}

}
