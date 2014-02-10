package controle.vendas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controle.cliente.ControleTelasClientes;
import controle.cliente.clienteDAO;

import modelagem.Cliente;
import modelagem.Venda;

import visao.cliente.TelaBuscarCliente;
import visao.cliente.TelaCadastroCliente;
import visao.vendas.TelaVendas;

public class ControleVendas implements ActionListener{
	private TelaVendas tVendas;
	private vendaDAO VBD;
	
	public ControleVendas(TelaVendas tva) {
		this.tVendas = tva;
	}
	
	public void actionPerformed(ActionEvent evt) {
		//Abrir a tela de busca de clientes
		if(evt.getActionCommand().equals("Buscar") == true){
			TelaBuscarCliente tbc = new TelaBuscarCliente(null, "Venda");
			tbc.settVendas(tVendas);
			tbc.setVisible(true);
		}
		//sair da tela de vendas
		if(evt.getActionCommand().equals("Sair") == true){
			tVendas.dispose();
		}
		//adiciona nova venda ao liente buscado ou recebido pela tela de cadastro de cliente
		if(tVendas.getCliente().getNome() != null  && evt.getActionCommand().equals("Adicionar")){
			if(tVendas.getTxtProduto().getText().equals("") == false && tVendas.getTxtValor().getText().equals("") == false &&
					tVendas.getTxtData().getText().equals("  /  /    ") == false){
				String textValVenda = tVendas.getTxtValor().getText().replace(",", ".");
				double valorVenda = Double.parseDouble(textValVenda);
			
				VBD = new vendaDAO();
				VBD.inserir(new Venda(-1, tVendas.getCliente().getId(), tVendas.getTxtProduto().getText(), 
					valorVenda, tVendas.getTxtDescricao().getText(), 
					tVendas.getTxtData().getText()), tVendas.getCliente());
				tVendas.getBtnPegarVendasNoBanco().doClick();
				
				tVendas.getTxtDescricao().setText("");
				tVendas.getTxtProduto().setText("");
				tVendas.getTxtValor().setText("");
				tVendas.getTxtProduto().grabFocus();
			}else{
				JOptionPane.showMessageDialog(null, "Campos produto, valor ou data faltam ser Preenchidos!");
			}
		}
		//remove todas as vendas selecionada na jtable(tabelaVendas) da tela de vendas
		if(tVendas.getCliente().getNome() != null  && evt.getActionCommand().equals("Remover") == true){
			Venda venda; 
			VBD = new vendaDAO();
			if(tVendas.getTabelaVendas().getSelectedRowCount() <= 1){
			venda = tVendas.getModeloTabela().getValue(tVendas.getTabelaVendas().getSelectedRow());
			VBD.removerVenda(venda);
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			}else{
				for(int i = 0; i < tVendas.getTabelaVendas().getSelectedRowCount(); i++){
					venda = tVendas.getModeloTabela().getValue(tVendas.getTabelaVendas().getSelectedRows()[i]);
					VBD.removerVenda(venda);
				}
				JOptionPane.showMessageDialog(null, "Removidas com sucesso!");
			}
			tVendas.getBtnPegarVendasNoBanco().doClick();
		}
		//pega no banco todas as vendas que tem o id_cliente igual ao id do cliente
		if(evt.getActionCommand().equals("PegarVendasNoBanco") == true){
				VBD = new vendaDAO();
				tVendas.getModeloTabela().clear();
				tVendas.getModeloTabela().addAll(VBD.buscarVenda(tVendas.getCliente().getId()));
				tVendas.getLblValorTotalComprado().setText("R$ "+String.valueOf(CalcularTotalComprado()));
				tVendas.repaint();
		}
	}
	//calcula o total dos produtos que esta na tabelaVendas de um cliente
	private double CalcularTotalComprado(){
		double total = 0;
		
		for(int i = 0; i < tVendas.getModeloTabela().getData().size(); i++){
			total += tVendas.getModeloTabela().getData().get(i).getValor();
		}
		
		return total;
	}

}
