package modelagem;

import com.towel.el.annotation.Resolvable;

public class Venda {
	private int id;
	private int id_cliente;
	@Resolvable(colName = "Produto")
	private String nomeProd;
	@Resolvable(colName = "Valor R$")
	private double valor;
	@Resolvable(colName = "Descrição")
	private String descricao;
	@Resolvable(colName = "Data")
	private String data;
	

	public Venda() {
		super();
	}
	
	
	
	public Venda(int id, int id_cliente, String nome, double valor,
			String descricao, String data) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.nomeProd = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.data = data;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getCodigo() {
		return id_cliente;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData() {
		return data;
	}

}
