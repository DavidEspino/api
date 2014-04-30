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
		boolean login =false;
		
		try {
			ResultSet rs = BD.getInstance().consulta("select nomUsu,contraseña,tipo from administrador where nomUsu='"+nombreRellenador+"';");				
			rs.next();
			if(rs.getString(2)==contrasena){
				login=true;
			}
			if (login == true){
				tipo = rs.getString(3);
			}	
		} 
		catch (SQLException e) {
				//e.printStackTrace();
				//No es rellenador
		}

			return tipo;
	}
	

}