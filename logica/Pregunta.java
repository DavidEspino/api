package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Pregunta {

	private int id;
	private String titulo;
	//private String tipo;
	private LinkedList<String> listaRespuestas;

	public Pregunta(int pId, String pTitulo){
		this.id = pId;
		titulo = pTitulo;	
		cargarRespuestas();
	}

	public void cargarRespuestas(){
		listaRespuestas = new LinkedList<String>();
		try {
			String consulta = "select respuesta from respuesta where idPreg = '"+id+"';";
			ResultSet sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				listaRespuestas.add(sql.getString("respuesta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public String getTitulo(){
		return this.titulo;
	}
	public int getId() {
		return id;
	}
	
	/**
	 * @author HelenJ
	 */
	public String getTipoPreg(int pIdPregunta){
		String tipo="";
		
		try {
			int cont=2;	
			String sql = "SELECT tipo "
							+ "FROM preguntas "
							+ "WHERE idPregunta = "+pIdPregunta+";";
			ResultSet resul = BD.getInstance().consulta(sql);
			tipo=resul.getString("tipo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;


	}
	/**
	 * @author HelenJ
	 */
	private void anadirRespuesta(String pResp, String pUsuario){
		try {
			String sql = "INSERT INTO `respuesta`(`idPreg`, `respuesta`, `idusuariocontesta`) VALUES ("+this.id+",'"+pResp+",'"+pUsuario+"')";
			BD.getInstance().insertar(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LinkedList<String> getRespuestas() {
		return this.listaRespuestas;
	}

}
