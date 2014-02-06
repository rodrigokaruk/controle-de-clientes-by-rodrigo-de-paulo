package controle.agendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controle.paciente.clienteDAO;

import modelagem.Cliente;

import visao.agendamento.TelaVendas;
import visao.cliente.TelaBuscarCliente;

public class ControleVendas implements ActionListener{
	private TelaVendas tVendas;
	private Cliente cliente;
	private vendaDAO VBD;
	
	public ControleVendas(TelaVendas tva, Cliente cli) {
		this.tVendas = tva;
		this.cliente = cli;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("Buscar") == true){
			TelaBuscarCliente tbc = new TelaBuscarCliente();
			tbc.settVendas(tVendas);
			tbc.setVisible(true);
		}
		if(evt.getActionCommand().equals("Sair") == true){
			tVendas.dispose();
		}
		if(evt.getActionCommand().equals("Adicionar")){
			
		}
		if(evt.getActionCommand().equals("PegarVendasNoBanco") == true){
			if(cliente.getNome() != null){
				VBD = new vendaDAO();
				tVendas.getModeloTabela().clear();
				tVendas.getModeloTabela().addAll(VBD.buscarVenda(tVendas.getCliente()));
				tVendas.repaint();
			}
		}
	}

}
