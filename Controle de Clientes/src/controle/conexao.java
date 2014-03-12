package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	private static conexao instace;
	private String usuarioBanco = "postgres";
	private String senhaBanco = "postgre";
	
	private conexao(){
		try {
			File arq = new File("BDconfig.txt");
			FileReader arqReader;
			BufferedReader bfr;
			FileOutputStream fos;
			if(arq.exists() == false){
				arq.createNewFile();
				fos = new FileOutputStream(arq);
				int tamanho = usuarioBanco.getBytes().length+senhaBanco.getBytes().length+2;
				byte[] vet = new byte[tamanho];
				int i = 0;
				while(i != usuarioBanco.getBytes().length){
					vet[i] = usuarioBanco.getBytes()[i];
					i++;
				}
				vet[i] = '\r';
				vet[i+1] = '\n';
				i += 2;
				while(i != tamanho){
					vet[i] = senhaBanco.getBytes()[i-usuarioBanco.getBytes().length-2];
					i++;
				}
				
				fos.write(vet);
				fos.close();
			}else{
				arqReader = new FileReader("BDconfig.txt");
				bfr = new BufferedReader(arqReader);
				usuarioBanco = bfr.readLine();
				senhaBanco = bfr.readLine();
				bfr.close();
				System.out.println("\n"+usuarioBanco+"\n"+senhaBanco+"\n");
				arqReader.close();
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:postgresql:" +
					"//localhost:5432/ContClientBD/cont_de_clientes",
					usuarioBanco,senhaBanco);
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
