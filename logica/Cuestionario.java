package logica;

import java.util.LinkedList;

public class Cuestionario {
	
	private String nombre;
	private int id;
	private int numPreguntas;

	public Cuestionario(int pId, String pNombre, int pNumPreg) {
		id = pId;
		nombre = pNombre;
		numPreguntas = pNumPreg;
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Pregunta> getPreguntas() {
		// TODO EGOITZ
		return null;
	}

	@Override
	public String toString() {
		return nombre+" Preguntas: "+numPreguntas;
	}
	
}
