package controle;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import visao.TelaInicial;
import visao.TelaSobre;
import visao.cliente.TelaCadastroCliente;
import visao.vendas.TelaVendas;
import controle.conexao;

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
		
		if(evt.getSource() == ti.getBtnContCli() || evt.getSource() == ti.getMntmCliente()){
			new TelaCadastroCliente().setVisible(true);
		}
		
		if(evt.getSource() == ti.getBtnVendas() || evt.getSource() == ti.getMntmVendas()){
			new TelaVendas().setVisible(true);
		}
		if(evt.getActionCommand().equals("Configuracoes") == true){
			JOptionPane.showMessageDialog(null, "Abrirá o arquivo BDconfig.txt!\n" +
					"	na primeira linha coloque o usuário do banco\n" +
					"	na segunda a senha do banco\n" +
					"obs: lembrando que deve ser criado a database 'ContClientBD' exatamente assim\n" +
					"com 4 letras maiusculas e executado a Query no seu PostgreSQL.\n\n" +
					"As alterações somente terão efeito apos reiniciar o programa!");
			try {
				if(new File("BDconfig.txt").exists() == false){
					Connection connection = conexao.getInstace().getConnection();
				}
				Runtime.getRuntime().exec("explorer BDconfig.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}

}
