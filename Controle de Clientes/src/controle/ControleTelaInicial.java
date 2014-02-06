package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.TelaInicial;
import visao.TelaSobre;
import visao.cliente.TelaCadastroCliente;
import visao.vendas.TelaVendas;

public class ControleTelaInicial implements ActionListener{
	private TelaInicial ti;
	
	public ControleTelaInicial(TelaInicial ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == ti.getBtnSair() || evt.getSource() == ti.getMntmSair()){
			int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", null, JOptionPane.YES_NO_OPTION);
			if(opc == 0){
				ti.dispose();
				System.exit(0);
			}
		}
		
		if(evt.getSource() == ti.getMntmSobre()){
			new TelaSobre().setVisible(true);
		}
		
		if(evt.getSource() == ti.getBtnContPaci() || evt.getSource() == ti.getMntmCliente()){
			new TelaCadastroCliente().setVisible(true);
		}
		
		if(evt.getSource() == ti.getBtnVendas() || evt.getSource() == ti.getMntmVendas()){
			new TelaVendas().setVisible(true);
		}
	}

}
