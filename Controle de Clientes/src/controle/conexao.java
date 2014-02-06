package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	private static conexao instace;
	
	private conexao(){
		
	}
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:postgresql:" +
					"//localhost:5432/ContClientBD/cont_de_clientes",
					"postgres","123456");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
		
	}

	public static conexao getInstace() {
		if(instace == null)
			instace = new conexao();
		return instace;
	}
	
	//public static void main(String[] args) {
	//	new conexao().getConnection();
	//	System.out.println("Conectado!");
	//}
}
