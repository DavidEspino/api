package logica;

import java.util.LinkedList;

public class Cuestionario {
	
	private String nombre;
	private int id;
	//private int numPreguntas;
	private LinkedList<Pregunta> listaPreguntas; 

	public Cuestionario(int pId, String pNombre) {
		id = pId;
		nombre = pNombre;
		//numPreguntas = pNumPreg;
		this.cargarPreguntas();
		
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Pregunta> getPreguntas() {
		// TODO EGOITZ
		return null;
	}
	
	private int getNumPreguntas(){
		return listaPreguntas.size();
	}
	
	public LinkedList<Pregunta> cargarPreguntas(){
		// cargar la base de datos.
		return this.listaPreguntas;
	}
	
	public void anadePregunta(Pregunta pPregunta){
		this.listaPreguntas.add(pPregunta);
		
	}

	@Override
	public String toString() {
		return nombre+" Preguntas: "+this.listaPreguntas.size();
	}
	
}
