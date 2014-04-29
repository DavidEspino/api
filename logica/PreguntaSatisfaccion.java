package logica;

public class PreguntaSatisfaccion extends Pregunta {
	
	private int rango;

	public PreguntaSatisfaccion(int pId, String pTitulo, int pRango) {
		super(pId, pTitulo);
		rango = pRango;
	}

}
