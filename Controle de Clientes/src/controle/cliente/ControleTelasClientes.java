package controle.cliente;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelagem.Cliente;

import visao.agendamento.TelaVendas;
import visao.cliente.TelaBuscarCliente;
import visao.cliente.TelaCadastroCliente;

public class ControleTelasClientes implements ActionListener {
	private TelaCadastroCliente tc;
	private TelaBuscarCliente tbc;
	private TelaVendas tVenda;
	private clienteDAO CBD;
	private Cliente cli;
	private JButton btnAlualizar;
	//aux auxilia caso um cliente ja esteja sendo cadastrado para o botao nao limpar os campos e caso
	//tenha um cliente sendo cadastrado fazer o botao desfazer so funcionar caso aperte o botao novo
	private int aux = 0;
	
	
	public ControleTelasClientes(TelaCadastroCliente tc) {
		this.tc = tc;
		tc.getBtnSalvar();
	}

	
	public void actionPerformed(ActionEvent evt) {
		//----------------------------------------------------------------------------
		//Cadastrar novo cliente
		if(evt.getSource() == tc.getBtnNovo()){
			
			if(aux == 0 || aux == 2){
				cli = null;
				tc.setCli(cli);
				tc.getBtnSalvar().setVisible(true);
				if(btnAlualizar != null){
					tc.getPanelButtoesBaixo().remove(0);
					btnAlualizar = null;
				}				
				tc.getTextFieldNdaficha().setEditable(true);
				tc.getTextFieldNdaficha().setText("");
				tc.getTextFieldECivil().setEditable(true);
				tc.getTextFieldECivil().setText("");
				tc.getTextFieldProfissao().setEditable(true);
				tc.getTextFieldProfissao().setText("");
				tc.getTextFieldNome().setEditable(true);
				tc.getTextFieldNome().setText("");
				tc.getTextFieldCpf().setEditable(true);
				tc.getTextFieldCpf().setText("");
				tc.getTextFieldRg().setEditable(true);
				tc.getTextFieldRg().setText("");
				tc.getTextFieldRua().setEditable(true);
				tc.getTextFieldRua().setText("");
				tc.getTextFieldNumRua().setEditable(true);
				tc.getTextFieldNumRua().setText("");
				tc.getTextFieldComplemento().setEditable(true);
				tc.getTextFieldComplemento().setText("");
				tc.getTextFieldCidade().setEditable(true);
				tc.getTextFieldCidade().setText("");
				tc.getTextFieldTelefone().setEditable(true);
				tc.getTextFieldTelefone().setText("");
				tc.getTextFieldCelular().setEditable(true);
				tc.getTextFieldCelular().setText("");
				tc.getTextFieldDataDeNasc().setEditable(true);
				tc.getTextFieldDataDeNasc().setText("");
				tc.getRdbtnMas().setEnabled(true);
				tc.getRdbtnFem().setEnabled(true);
				tc.getButtonGroup().clearSelection();
				aux = 1;
			}else if(aux == 1){
				JOptionPane.showMessageDialog(null, "Clique em desfazer primeiro!");
			}
		}
		
		//-----------------------------------------------------------------------------------
		//desfazer caso tenha um cliente sendo cadastrado
		if(evt.getSource() == tc.getBtnDesfazer()){
			
			if(aux == 1 || aux == 2){
				tc.getTextFieldNdaficha().setEditable(false);
				tc.getTextFieldNdaficha().setText("");
				tc.getTextFieldECivil().setEditable(false);
				tc.getTextFieldECivil().setText("");
				tc.getTextFieldProfissao().setEditable(false);
				tc.getTextFieldProfissao().setText("");
				tc.getTextFieldNome().setEditable(false);
				tc.getTextFieldNome().setText("");
				tc.getTextFieldCpf().setEditable(false);
				tc.getTextFieldCpf().setText("");
				tc.getTextFieldRg().setEditable(false);
				tc.getTextFieldRg().setText("");
				tc.getTextFieldRua().setEditable(false);
				tc.getTextFieldRua().setText("");
				tc.getTextFieldNumRua().setEditable(false);
				tc.getTextFieldNumRua().setText("");
				tc.getTextFieldComplemento().setEditable(false);
				tc.getTextFieldComplemento().setText("");
				tc.getTextFieldCidade().setEditable(false);
				tc.getTextFieldCidade().setText("");
				tc.getTextFieldTelefone().setEditable(false);
				tc.getTextFieldTelefone().setText("");
				tc.getTextFieldCelular().setEditable(false);
				tc.getTextFieldCelular().setText("");
				tc.getTextFieldDataDeNasc().setEditable(false);
				tc.getTextFieldDataDeNasc().setText("");
				tc.getRdbtnMas().setEnabled(false);
				tc.getRdbtnFem().setEnabled(false);
				tc.getButtonGroup().clearSelection();
				
				aux = 0;
				
				cli = null;
				tc.setCli(cli);
				tc.getBtnSalvar().setVisible(true);
				if(btnAlualizar != null){
					tc.getPanelButtoesBaixo().remove(0);
					btnAlualizar = null;
				}
			}
		}
		//-----------------------------------------------------------------------------------
		if(evt.getSource() == tc.getBtnFechar()){
			//fecha a tela e aqui o aux auxilia na confirmacao se estiver um cliente sendo cadastrado
			if(aux == 0 || aux == 2){
				tc.dispose();
			}
			else if(aux == 1){
				int conf = JOptionPane.showConfirmDialog(null, "Tem certeza que quer fechar?\n" +
						"As alterações feitas não foram salvas!");
				if(conf == 0){
					tc.dispose();
				}
			}
		}
		
		//-----------------------------------------------------------------------------------
		//pega os campos da tela e adiciona a classe cliente para salva-la no banco atravez do clienteDAO
		if(evt.getSource() == tc.getBtnSalvar()){
			//verificacao de campos obrigatorios
			if(aux == 1){
				String msg = "Os seguintes campos faltam ser preenchidos:\n";
				
				if(tc.getTextFieldNome().getText().equalsIgnoreCase("") == true){
					msg += "Nome\n";
				}
				if(tc.getTextFieldNdaficha().getText().equalsIgnoreCase("") == true){
					msg += "Número da ficha\n";
				}
				if(tc.getRdbtnMas().isSelected() == false && tc.getRdbtnFem().isSelected() == false){
					msg += "Sexo\n";
				}
				if(tc.getTextFieldDataDeNasc().getText().equals("  /  /    ")){
					msg += "Data de Nascimento\n";
				}
				if(tc.getTextFieldTelefone().getText().equals("(  )     -    ")){
					msg += "Telefone\n";
				}
				if(msg.equals("Os seguintes campos faltam ser preenchidos:\n")){
					String s = "";
					if(tc.getRdbtnMas().isSelected() == true)
						s = "M";
					else if(tc.getRdbtnFem().isSelected() == true)
						s = "F";
					cli = new Cliente(-1 ,Integer.parseInt(tc.getTextFieldNdaficha().getText()) , tc.getTextFieldNome().getText(),tc.getTextFieldDataDeNasc().getText(),
							tc.getTextFieldTelefone().getText(), tc.getTextFieldCelular().getText(),
							tc.getTextFieldRg().getText(), tc.getTextFieldCpf().getText(),
							tc.getTextFieldRua().getText(), tc.getTextFieldNumRua().getText(),
							tc.getTextFieldComplemento().getText(),tc.getTextFieldCidade().getText(), s,
							tc.getTextFieldProfissao().getText(), tc.getTextFieldECivil().getText(),
							"");
					
					CBD = new clienteDAO();
					CBD.inserir(cli);
					
					//Bemscd = Bem sucedido para confirmar se deu certo ele bloqueia os campos de edicao
					if(CBD.getBemscd() == 10){
						tc.getTextFieldNdaficha().setEditable(false);
						tc.getTextFieldECivil().setEditable(false);
						tc.getTextFieldProfissao().setEditable(false);
						tc.getTextFieldNome().setEditable(false);
						tc.getTextFieldCpf().setEditable(false);
						tc.getTextFieldRg().setEditable(false);
						tc.getTextFieldRua().setEditable(false);
						tc.getTextFieldNumRua().setEditable(false);
						tc.getTextFieldComplemento().setEditable(false);
						tc.getTextFieldCidade().setEditable(false);
						tc.getTextFieldTelefone().setEditable(false);
						tc.getTextFieldCelular().setEditable(false);
						tc.getTextFieldDataDeNasc().setEditable(false);
						tc.getRdbtnMas().setEnabled(false);
						tc.getRdbtnFem().setEnabled(false);
						tc.setCli(cli);
						aux = 0;
						tc.getBtnPegarUltimaFicha().doClick();
						cli = null;
					}
				}
				
				if(msg.equals("Os seguintes campos faltam ser preenchidos:\n") == false)
					JOptionPane.showMessageDialog(null, msg);
				
			}else
				JOptionPane.showMessageDialog(null, "Não há um novo paciente para ser salvo!");
		}
		
		//-----------------------------------------------------------------------------------
		//abrir tela de busca de cliente
		if(evt.getSource() == tc.getBtnPesquisar()){
			
			tbc = new TelaBuscarCliente(this,"Novo");
			tbc.setVisible(true);
		}
		//----------------------------------------------------------------------------
		//este botao so aparecera se na tela de busca de clientes for selecionado algum cliente
		if(btnAlualizar != null && evt.getSource() == btnAlualizar){
			//atualizar dados de um cliente ja cadastrado
			String msg = "Os seguintes campos faltam ser preenchidos:\n";
			if(tc.getTextFieldNome().getText().equalsIgnoreCase("") == true){
				msg += "Nome\n";
			}
			if(tc.getTextFieldNdaficha().getText().equalsIgnoreCase("") == true){
				msg += "Número da ficha\n";
			}
			if(tc.getRdbtnMas().isSelected() == false && tc.getRdbtnFem().isSelected() == false){
				msg += "Sexo\n";
			}
			if(tc.getTextFieldDataDeNasc().getText().equals("  /  /    ")){
				msg += "Data de Nascimento\n";
			}
			if(tc.getTextFieldTelefone().getText().equals("(  )     -    ")){
				msg += "Telefone\n";
			}
			if(msg.equals("Os seguintes campos faltam ser preenchidos:\n")){
				String s = "";
				if(tc.getRdbtnMas().isSelected() == true)
					s = "M";
				else if(tc.getRdbtnFem().isSelected() == true)
					s = "F";
				cli = new Cliente(tc.getCli().getId() ,Integer.parseInt(tc.getTextFieldNdaficha().getText()) , tc.getTextFieldNome().getText(),tc.getTextFieldDataDeNasc().getText(),
						tc.getTextFieldTelefone().getText(), tc.getTextFieldCelular().getText(),
						tc.getTextFieldRg().getText(), tc.getTextFieldCpf().getText(),
						tc.getTextFieldRua().getText(), tc.getTextFieldNumRua().getText(),
						tc.getTextFieldComplemento().getText(),tc.getTextFieldCidade().getText(), s,
						tc.getTextFieldProfissao().getText(), tc.getTextFieldECivil().getText(),
						"");
			
				CBD = new clienteDAO();
				CBD.atualizar(cli);
				tc.setCli(cli);
				tc.getBtnPegarUltimaFicha().doClick();
				cli=null;
			}else
				JOptionPane.showMessageDialog(null, msg);
		}
		//------------------------------------------------------------
		//Abre a telaVendas e envia o cliente da tela de Clientes para a mesma adicinar novas vendas
		if(evt.getActionCommand().equals("Nova Venda") == true){
			if(tc.getCli() != null & tc.getTextFieldNome().equals("") == false){
				tVenda = new TelaVendas(tc.getCli());
				tVenda.remove(tVenda.getBtnBuscar());
				tVenda.setVisible(true);
				
			}else{
				JOptionPane.showMessageDialog(null, "Não há cliente para se adicionar vendas!");
			}
		}
		//
		//Pega o numero da ultima ficha cadastrada
		if(evt.getActionCommand().equals("nUltimaFicha" ) == true){
			CBD = new clienteDAO();
			tc.getLblNultimaficha().setText(""+CBD.nUltimaFicha());
		}
		//-----------------------------------------------------------------------------------
		//botoes da tela busca de cliente 
		//busca no banco a lista de clientes para a TelaBuscarClientes
		if(tbc != null && evt.getSource() == tbc.getBtnBuscar()){
			CBD = new clienteDAO();
			tbc.getModeloTabela().clear();
			tbc.getModeloTabela().addAll(CBD.buscarNome(tbc.getTxtBuscarNFicha().getText(),tbc.getTxtBuscarnome().getText()));
			tbc.repaint();
		}
		//-----------------------------------------------------------------------------------
		if(tbc != null && evt.getSource() == tbc.getBtnCancelar()){
			tbc.dispose();
			tbc = null;
		}
		
		//-----------------------------------------------------------------------------------
		//seleciona um cliente na tela de busca de clientes e preenche os campos da telaCadastroCliente
		if(tbc != null && evt.getSource() == tbc.getButtonSelecionar() && tbc.getTipoDeTela().equals("Novo") == true){
			
			try{
				if(tbc.getTabela().getSelectedColumn() != -1){
					cli = null;
					tc.setCli(null);
					
					tc.getTextFieldNdaficha().setEditable(true);
					tc.getTextFieldNdaficha().setText("");
					tc.getTextFieldECivil().setEditable(true);
					tc.getTextFieldECivil().setText("");
					tc.getTextFieldProfissao().setEditable(true);
					tc.getTextFieldProfissao().setText("");
					tc.getTextFieldNome().setEditable(true);
					tc.getTextFieldNome().setText("");
					tc.getTextFieldCpf().setEditable(true);
					tc.getTextFieldCpf().setText("");
					tc.getTextFieldRg().setEditable(true);
					tc.getTextFieldRg().setText("");
					tc.getTextFieldRua().setEditable(true);
					tc.getTextFieldRua().setText("");
					tc.getTextFieldNumRua().setEditable(true);
					tc.getTextFieldNumRua().setText("");
					tc.getTextFieldComplemento().setEditable(true);
					tc.getTextFieldComplemento().setText("");
					tc.getTextFieldCidade().setEditable(true);
					tc.getTextFieldCidade().setText("");
					tc.getTextFieldTelefone().setEditable(true);
					tc.getTextFieldTelefone().setText("");
					tc.getTextFieldCelular().setEditable(true);
					tc.getTextFieldCelular().setText("");
					tc.getTextFieldDataDeNasc().setEditable(true);
					tc.getTextFieldDataDeNasc().setText("");
					tc.getRdbtnMas().setEnabled(true);
					tc.getRdbtnFem().setEnabled(true);
					
					cli = tbc.getModeloTabela().getValue(tbc.getTabela().getSelectedRow());
					tc.getTextFieldNdaficha().setText(String.valueOf(cli.getnFicha()));
					tc.getTextFieldECivil().setText(cli.geteCivil());
					tc.getTextFieldProfissao().setText(cli.getProfissao());
					tc.getTextFieldNome().setText(cli.getNome());
					tc.getTextFieldCpf().setText(cli.getCpf());
					tc.getTextFieldRg().setText(cli.getRg());
					tc.getTextFieldRua().setText(cli.getRua());
					tc.getTextFieldNumRua().setText(cli.getNumRua());
					tc.getTextFieldDataDeNasc().setText(cli.getNascimento());
					tc.getTextFieldComplemento().setText(cli.getComplemento());
					tc.getTextFieldCidade().setText(cli.getCidade());
					tc.getTextFieldTelefone().setText(cli.getTelefone());
					tc.getTextFieldCelular().setText(cli.getCelular());
					if(cli.getSexo().equals("M") == true){
						tc.getRdbtnMas().setSelected(true);
					}else
						tc.getRdbtnFem().setSelected(true);
					tc.setCli(cli);
					tbc.dispose();
					tbc = null;
					cli = null;
					aux = 2;
					
					if(btnAlualizar == null){
						tc.getBtnSalvar().setVisible(false);
						btnAlualizar = new JButton("Atualizar");
						btnAlualizar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icons/edit.jpg")));
						btnAlualizar.addActionListener(this);
						tc.getPanelButtoesBaixo().add(btnAlualizar, 0);
					}
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Selecione um paciente!");
			}
		}
		//------------------------------------------------------------
		//seleciona o cliente na telaBuscaCliente buscado exclusivamente para a telaVendas
		if(tbc != null && evt.getSource() == tbc.getButtonSelecionar() && tbc.getTipoDeTela().equals("Venda") == true){
			
			try{
				if(tbc.getTabela().getSelectedColumn() != -1){
					Cliente cliVenda = tbc.getModeloTabela().getValue(tbc.getTabela().getSelectedRow());
					tbc.gettVendas().setCliente(cliVenda);
					tbc.gettVendas().repaint();
					tbc.dispose();
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Selecione um paciente!");
			}
		}
	}


	public TelaCadastroCliente getTc() {
		return tc;
	}


	public clienteDAO getCBD() {
		return CBD;
	}


	public Cliente getCli() {
		return cli;
	}


	public TelaBuscarCliente getTbc() {
		return tbc;
	}


	public void setTbc(TelaBuscarCliente tbc) {
		this.tbc = tbc;
	}


	public TelaVendas gettVenda() {
		return tVenda;
	}


	public void settVenda(TelaVendas tVenda) {
		this.tVenda = tVenda;
	}
}
