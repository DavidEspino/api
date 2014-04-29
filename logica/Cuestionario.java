package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void cargarPreguntas(){
		listaPreguntas = new LinkedList<Pregunta>();
		try {
			String titulo, subconsulta1, subconsulta2;
			int idP;
			//consultamos las preguntas pertenecientes al cuestionario y sacamos el titulo y la pregunta
			String consulta = "select * from preguntas inner join cuesticontienepreg on idPreg=idPregunta where idCuesti='"+id+"';";
			ResultSet subsql1, subsql2, sql = BD.getInstance().consulta(consulta);
			while(sql.next()){
				//sacamos el titulo y el id de las preguntas
				titulo = sql.getString("titulo");
				idP = sql.getInt("idPregunta");
				//miramos si la pregunta es de satisfacción
				subconsulta1 =  "select rango from preguntatiposatis where idPreg='"+idP+"';";
				subsql1 = BD.getInstance().consulta(subconsulta1);
				if(subsql1.next()){
					//si lo es, obtenemos el numero del rango y creamos la pregunta y a la lista
					int rango = subsql1.getInt("rango");
					listaPreguntas.add(new PreguntaSatisfaccion(idP, titulo, rango));
				}else{
					//si no es de satisfaccion, miramos si es de test
					subconsulta2 = "select preguno, pregdos, pregtres, pregcuatro from preguntatipotest where idPreg='"+idP+"';";
					subsql2 = BD.getInstance().consulta(subconsulta2);
					if(subsql2.next()){
						//si es así, creamos la pregunta con las posibles respuesta y la añadimos a la lista
						String[] respPosibles = new String[4];
						respPosibles[0] = subsql2.getString("preguno");
						respPosibles[1] = subsql2.getString("pregdos");
						respPosibles[2] = subsql2.getString("pregtres");
						respPosibles[3] = subsql2.getString("pregcuatro");
						listaPreguntas.add(new PreguntaTest(idP, titulo, respPosibles));
					}else{
						//si no es ni satisfacción ni test, creamos una pregunta de tipo corta o larga.
						listaPreguntas.add(new Pregunta(idP, titulo));
					}
					//cerramos consultas
					BD.getInstance().cerrarConsulta(subsql2);
				}
				BD.getInstance().cerrarConsulta(subsql1);
			}
			BD.getInstance().cerrarConsulta(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public LinkedList<Pregunta> getPreguntas() {
		return this.listaPreguntas;
	}
	
	private int getNumPreguntas(){
		return listaPreguntas.size();
	}
	
	
	
	public void anadePregunta(Pregunta pPregunta){
		this.listaPreguntas.add(pPregunta);
		
	}

	@Override
	public String toString() {
		return nombre+" Preguntas: "+this.listaPreguntas.size();
	}
	
}
