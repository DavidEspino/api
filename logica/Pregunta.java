package logica;

import java.util.LinkedList;

public class Pregunta {

	private int id;
	private String titulo;
	private String respuesta;
	private LinkedList<String> listaRespuestas;

	public Pregunta(int pId){
		this.id = pId;
	}

	private String getTitulo(){
		return this.titulo;
	}

	public LinkedList<String> cargarRespuestas(){
		return this.listaRespuestas;
	}

	public LinkedList<String> getRespuestas() {
		// TODO EGOITZ
		return null;
	}

}
