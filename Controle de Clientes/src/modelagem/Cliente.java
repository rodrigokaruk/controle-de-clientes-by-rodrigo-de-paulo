package modelagem;

import com.towel.el.annotation.Resolvable;

public class Cliente {
	private int id = -1;
	@Resolvable(colName = "Nome")
	private String nome;
	@Resolvable(colName = "Nº da ficha")
	private int nFicha;
	private String nascimento;
	private String telefone;
	private String celular;
	private String rg;
	private String cpf;
	private String rua;
	private String numRua;
	private String complemento;
	private String cidade;
	private String sexo;
	private String profissao;
	private String eCivil;
	private String cliDesde;
	
	
	public Cliente() {
		
	}

	

	public Cliente(int id, int nFicha, String nome, String nascimento,
			String telefone, String celular, String rg, String cpf, String rua,
			String numRua, String complemento, String cidade, String sexo,
			String profissao, String eCivil, String cliDesde) {
		super();
		this.id = id;
		this.nome = nome;
		this.nFicha = nFicha;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.rua = rua;
		this.numRua = numRua;
		this.complemento = complemento;
		this.cidade = cidade;
		this.sexo = sexo;
		this.profissao = profissao;
		this.eCivil = eCivil;
		this.cliDesde = cliDesde;
	}



	public int getId() {
		return id;
	}

	public int getnFicha() {
		return nFicha;
	}

	public String getProfissao() {
		return profissao;
	}

	public String geteCivil() {
		return eCivil;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCelular() {
		return celular;
	}

	public String getRua() {
		return rua;
	}

	public String getNumRua() {
		return numRua;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getCliDesde() {
		return cliDesde;
	}

}
