package visao;
import java.awt.Label;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaSobre extends JDialog {
	
	public TelaSobre(){
		this.setTitle("Sobre!");
		this.setSize(415, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(new Label(" Desenvolvedor:"));
		
		Label label = new Label("      Rodrigo de Paulo Sampaio Barros");
		getContentPane().add(label);
		
		JLabel lblDivulgador = new JLabel("  Apoio:");
		getContentPane().add(lblDivulgador);
		
		JLabel lblGleydsonHudson = new JLabel("     Gleydson Hudson.");
		getContentPane().add(lblGleydsonHudson);
		Label label_1 = new Label("   Vers\u00E3o 1.0");
		label_1.setAlignment(Label.CENTER);
		getContentPane().add(label_1);
		Label label_2 = new Label("Telefone: (88) 9660-0304 / (85) 8679-2353 / (85) 8519-5711 (Hudson)");
		label_2.setAlignment(Label.CENTER);
		getContentPane().add(label_2);
		
	}

}
