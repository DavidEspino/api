package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
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
}
