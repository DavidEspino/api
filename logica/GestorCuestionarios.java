package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class GestorCuestionarios {
	
	private static GestorCuestionarios mgc;
	
	private GestorCuestionarios(){}
	
	public static GestorCuestionarios getGestorCuestionarios(){
		if(mgc == null){
			mgc = new GestorCuestionarios();
		}
		return mgc;
	}

	public LinkedList<Cuestionario> obtenerCuestionarios() {
		String nombre;
		int id;
		Cuestionario c;
		LinkedList<Cuestionario> rdo = new LinkedList<Cuestionario>();
		String consulta = "select nombre, id from cuestionario;";
		try {
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				nombre = sql.getString("nombre");
				id = sql.getInt("id");
				c = new Cuestionario(id, nombre);
				rdo.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rdo;
	}

	
	public LinkedList<Cuestionario> obtenerCuestionariosUsuario(String pUsuario) {
		String nombre;
		int id;
		Cuestionario c;
		LinkedList<Cuestionario> rdo = new LinkedList<Cuestionario>();
		String consulta = "select titulo, idCuestionario from cuestionario where usuCreador='"+pUsuario+"';";
		try {
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				nombre = sql.getString("titulo");
				id = sql.getInt("idCuestionario");
				c = new Cuestionario(id, nombre);
				rdo.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rdo;
	}

	public String obtenerNombreCuestionario(int pIdCuestionario) {
		String nombre = null;
		
		String consulta = "select titulo from cuestionario where idCuestionario='"+pIdCuestionario+"';";
		try {
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				nombre = sql.getString("titulo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}


	public LinkedList<Pregunta> obtenerPreguntasCuestionario(int idCuestionario) {

		
		LinkedList<Pregunta> listaPreguntas = new LinkedList<Pregunta>();
		LinkedList<Integer> idPreguntas = new LinkedList<Integer>();
		
		//Cogemos la lista de ids de las preguntas
		String consulta = "select idPreg from cuesticontienepreg where idCuesti='"+idCuestionario+"';";
		try {
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				int id = sql.getInt("idPreg");
				idPreguntas.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//Generamos las preguntas a partir de sus ids	
		for (int i = 0; i < idPreguntas.size(); i++) {
			consulta = "select pregunta from preguntas where idPregunta='"+idPreguntas.get(i)+"';";
			try {
				ResultSet sql = BD.getInstance().consulta(consulta);
				while(sql.next()){
					String pregunta = sql.getString("pregunta");
					Pregunta miPregunta = new Pregunta(idPreguntas.get(i), pregunta);
					listaPreguntas.add(miPregunta);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		return listaPreguntas;
	}
	/**
	 * @author HelenJ
	 */
	public void anadirRespuestaBD(int pIdCuesti,int pIdPre, String pResp, String pUsuario){
		try {
			String sql = "INSERT INTO `respuesta`(`idPreg`, `respuesta`, `idusuariocontesta`) "
					   + "VALUES ("+pIdPre+",'"+pResp+",'"+pUsuario+"');";
			BD.getInstance().insertar(sql);
			
			//obtengo la fecha actual
			Calendar fecha = new GregorianCalendar();
			String f=""+fecha.get(Calendar.DAY_OF_MONTH)+""+fecha.get(Calendar.MONTH)+""+fecha.get(Calendar.YEAR)+"";
			
			sql="INSERT INTO `usucontestacuesti`(`nomUsu`, `idCuesti`, `fecha`) "
			  + "VALUES ('"+pUsuario+"',"+pIdCuesti+",'"+f+"');";
			BD.getInstance().insertar(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
