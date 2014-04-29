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
		String nombre, subconsulta;
		int id, numPreg;
		Cuestionario c;
		LinkedList<Cuestionario> rdo = new LinkedList<Cuestionario>();
		String consulta = "select nombre, id from cuestionario;";
		try {
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				nombre = sql.getString("nombre");
				id = sql.getInt("id");
				subconsulta = "select count(*) from preguntas where idCuestionario='"+id+"';";
				ResultSet subsql = BD.getInstance().consulta(subconsulta);
				if(subsql.next()){
					numPreg = subsql.getInt("count(*)");
				}else{
					numPreg = 0;
				}
				c = new Cuestionario(id, nombre);
				rdo.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rdo;
	}

	
	
}
