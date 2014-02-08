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
		if(evt.getActionCommand().equals("Buscar") == true){
			TelaBuscarCliente tbc = new TelaBuscarCliente(null, "Venda");
			tbc.settVendas(tVendas);
			tbc.setVisible(true);
		}
		
		if(evt.getActionCommand().equals("Sair") == true){
			tVendas.dispose();
		}
		
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
				
				tVendas.getTxtData().setText("");
				tVendas.getTxtDescricao().setText("");
				tVendas.getTxtProduto().setText("");
				tVendas.getTxtValor().setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Campos produto, valor ou data faltam ser Preenchidos!");
			}
		}
		
		if(tVendas.getCliente().getNome() != null  && evt.getActionCommand().equals("Remover") == true){
			
		}
		
		if(evt.getActionCommand().equals("PegarVendasNoBanco") == true){
				VBD = new vendaDAO();
				tVendas.getModeloTabela().clear();
				tVendas.getModeloTabela().addAll(VBD.buscarVenda(tVendas.getCliente()));
				tVendas.repaint();
		}
	}

}
