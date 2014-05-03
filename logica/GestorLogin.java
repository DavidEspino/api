package logica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorLogin {

	private static GestorLogin miGestorLogin;
	
	private GestorLogin(){}
	
	public static GestorLogin getMiGestorLogin(){
		
		if(miGestorLogin == null) {
			miGestorLogin = new GestorLogin();
		}
		
		return miGestorLogin;
	}
	
	
	//Metodo para logear el rellenador
	public String login(String nombreRellenador, String contrasena){
		
		String tipo = "fallo";
		
		try {
			ResultSet rs = BD.getInstance().consulta("select tipo from usuarios where nomUsu='"+nombreRellenador+"' and contraseña='"+contrasena+"';");				
			rs.next();
			tipo = rs.getString(1);
		} 
		catch (SQLException e) {
				//e.printStackTrace();
				//No es rellenador
		}

			return tipo;
	}
	

}