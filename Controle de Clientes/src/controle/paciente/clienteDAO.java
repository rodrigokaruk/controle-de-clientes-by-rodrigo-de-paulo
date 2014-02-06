package controle.paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controle.conexao;

import modelagem.Cliente;

public class clienteDAO {
	private int bemscd = 0;
	
	public int getBemscd() {
		return bemscd;
	}

	public long inserir(Cliente cliente) {
		long id = -1;
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

		java.util.Date date = null;
		java.sql.Date sqlDate;
		
		if(cliente.getNascimento().equals("  /  /    ")==false){
		try {
			date = format.parse(cliente.getNascimento());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		sqlDate = new java.sql.Date(date.getTime());
		}else
			sqlDate = new java.sql.Date(1);
		
			
		String sql = "insert into cont_de_clientes."
				+ "cliente(nficha, nome, nascimento, rg, cpf, telefone,"
				+" celular, rua, numrua, complemento, cidade, sexo, profissao, ecivil, clidesde)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql,
							PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, cliente.getnFicha());
			statement.setString(2, cliente.getNome());
			if(sqlDate.getTime() != 1){
				statement.setDate(3, sqlDate);}
			else{
				statement.setDate(3, null);
			}
			if(cliente.getRg().equals("")==false){
				statement.setString(4, cliente.getRg());}
			else{
				statement.setString(4, null);
			}
			if(cliente.getCpf().equals("   .   .   -  ")==false){
				statement.setString(5, cliente.getCpf());}
			else{
				statement.setString(5, null);
			}
			statement.setString(6, cliente.getTelefone());
			statement.setString(7, cliente.getCelular());
			statement.setString(8, cliente.getRua());
			statement.setString(9, cliente.getNumRua());
			statement.setString(10, cliente.getComplemento());
			statement.setString(11, cliente.getCidade());
			statement.setString(12, cliente.getSexo());
			statement.setString(13, cliente.getProfissao());
			statement.setString(14, cliente.geteCivil());
			statement.setString(15, cliente.getCliDesde());
			statement.executeUpdate();
			ResultSet set = statement.getGeneratedKeys();
			
			while (set.next()) {
				id = set.getLong("id");
			}
			bemscd = 10;
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null , e.getMessage()+"\nErro de Banco de dados!");
		}
		cliente.setId((int)id);
		return id;
	}
	
	
	public List<Cliente> buscarNome(String nFicha, String nome){
		String sql;
		Cliente cliente;
		List<Cliente> lista = new ArrayList<Cliente>();
		
		if(nFicha.equals("") == false){
			sql = "select * from cont_de_clientes."
					+ "cliente where nome iLIKE ? " +
					"and nficha = ?" +
					"order by nome;";
		}else
			sql = "select * from cont_de_clientes."
					+ "cliente where nome iLIKE ? order by nome;";
		
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%"+nome+"%");
			if(nFicha.equals("") == false)
				statement.setInt(2, Integer.parseInt(nFicha));
			statement.execute();
			
			ResultSet set = statement.getResultSet();
			while (set.next()) {
				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			    String dataFormatada; 
			    if(set.getDate("nascimento") != null)
			    	dataFormatada = formatador.format(set.getDate("nascimento"));
			    else
			    	dataFormatada = "";
			    
				cliente = new Cliente(set.getInt("id"),set.getInt("nficha"), set.getString("nome"), dataFormatada, 
						set.getString("telefone"), set.getString("celular"), set.getString("rg"), set.getString("cpf"), 
						set.getString("rua"), set.getString("numrua"), set.getString("complemento"), set.getString("cidade"),
						set.getString("sexo"), set.getString("profissao"), set.getString("ecivil"),
						set.getString("clidesde"));
				
				lista.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\nErro de Banco de dados!");
		}
		return lista;
	}
	
	
	@SuppressWarnings("deprecation")
	public void atualizar(Cliente cliente){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

		java.util.Date date = null;
		java.sql.Date sqlDate;
		
		if(cliente.getNascimento().equals("  /  /    ")==false){
		try {
			date = format.parse(cliente.getNascimento());
			date.setDate(date.getDate()+1);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		sqlDate = new java.sql.Date(date.getTime());
		
		}else
			sqlDate = new java.sql.Date(2);
		
				
		String sql = "update cont_de_clientes."
				+ "cliente set (nficha, nome, nascimento, rg, cpf, telefone," 
				+" celular, rua, numrua, complemento, cidade, sexo, profissao, ecivil, clidesde)"
				+ " = (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where id = ?;";
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, cliente.getnFicha());
			statement.setString(2, cliente.getNome());
			//
			if(sqlDate.getTime() != 2){
				statement.setDate(3, sqlDate);}
			else{
				statement.setDate(3, null);
			}
			//
			if(cliente.getRg().equals("")==false){
				statement.setString(4, cliente.getRg());}
			else{
				statement.setString(4, null);
			}
			//
			if(cliente.getCpf().equals("   .   .   -  ")==false){
				statement.setString(5, cliente.getCpf());}
			else{
				statement.setString(5, null);
			}
			//
			statement.setString(6, cliente.getTelefone());
			statement.setString(7, cliente.getCelular());
			statement.setString(8, cliente.getRua());
			statement.setString(9, cliente.getNumRua());
			statement.setString(10, cliente.getComplemento());
			statement.setString(11, cliente.getCidade());
			statement.setString(12, cliente.getSexo());
			statement.setString(13, cliente.getProfissao());
			statement.setString(14, cliente.geteCivil());
			statement.setString(15, cliente.getCliDesde());
			statement.setInt(16, cliente.getId());
			statement.executeUpdate();
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\nErro de Banco de dados!");
		}
	}
	
	public int nUltimaFicha(){
		int nFicha = 0;
		String sql;
		
		sql = "select * from cont_de_clientes."
				+ "cliente order by id;";
	
	
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.execute();
			
			ResultSet set = statement.getResultSet();
			while (set.next()) {
				nFicha = set.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\nErro de Banco de dados!");
		}
		
		return nFicha;
	}
}