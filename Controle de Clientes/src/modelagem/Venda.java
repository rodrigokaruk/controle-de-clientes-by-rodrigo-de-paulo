package modelagem;

import com.towel.el.annotation.Resolvable;

public class Venda {
	private int id;
	private int id_cliente;
	@Resolvable(colName = "Produto")
	private String nomeProd;
	@Resolvable(colName = "Valor")
	private String valor;
	@Resolvable(colName = "Descrição")
	private String descricao;
	@Resolvable(colName = "Data")
	private String data;
	

	public Venda() {
		super();
	}
	
	
	
	public Venda(int id, int id_cliente, String nome, String valor,
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

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData() {
		return data;
	}

}
