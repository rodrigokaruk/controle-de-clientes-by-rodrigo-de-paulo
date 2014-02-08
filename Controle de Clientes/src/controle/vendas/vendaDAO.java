package controle.vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelagem.Cliente;
import modelagem.Venda;
import controle.conexao;

public class vendaDAO {
	private int bemscd = 0;
	
	public int getBemscd() {
		return bemscd;
	}

	public long inserir(Venda venda, Cliente cliente) {
		long id = -1;
		String sql = "insert into cont_de_clientes."
				+ "venda(id_cliente ,produto, data,	valor, descricao)"
				+ " values(?,?,?,?,?)";
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql,
							PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, cliente.getId());
			statement.setString(2, venda.getNomeProd());
			statement.setString(3, venda.getData());
			statement.setDouble(4, venda.getValor());
			statement.setString(5, venda.getDescricao());
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
		venda.setId((int)id);
		return id;
	}
	
	
	public List<Venda> buscarVenda(Cliente cliente){
		String sql;
		Venda venda;
		List<Venda> lista = new ArrayList<Venda>();
		
		sql = "select * from cont_de_clientes."
				+ "venda where id_cliente = ? "
				+"order by id;";
		
		
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cliente.getId());
			statement.execute();
			
			ResultSet set = statement.getResultSet();
			while (set.next()) {
				
				venda = new Venda(set.getInt("id"),set.getInt("id_cliente"), set.getString("produto"),
						set.getDouble("valor"), set.getString("descricao"), set.getString("data"));
				
				lista.add(venda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\nErro de Banco de dados!");
		}
		return lista;
	}
	
	
	public void removerVenda(Venda venda){
		String sql = "delete from cont_de_clientes."
				+ "venda where id = ?;";
		
		Connection connection = conexao.getInstace().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, venda.getId());
			statement.executeUpdate();
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"\nErro de Banco de dados!");
		}
	}
	
	public int nUltimaFicha(){
		int nFicha = 0;
		String sql;
		
		sql = "select * from cont_de_clientes."
				+ "venda order by id;";
	
	
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
