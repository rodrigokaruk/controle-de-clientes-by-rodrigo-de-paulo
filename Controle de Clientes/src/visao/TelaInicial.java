package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controle.ControleTelaInicial;
import controle.DatadeHj;
import controle.RelogioThread;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Label;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;


import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {
	private ControleTelaInicial controleTelaInicial;
	private JMenuItem mntmSair;
	private JButton btnSair;
	private JButton btnVendas;
	private JButton btnContPaci;
	private JMenu mnAjuda;
	private JButton btnConfiguracoes;
	private JMenu mnControle;
	private JMenu mnInicio;
	private JMenuItem mntmSobre;
	private JMenuItem mntmVendas;
	private JMenuItem mntmCliente;
	private JLabel lblVersao;
	private JLabel lblImagem;

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/icons/7813_64x64.png")));
		setTitle("Controle de clientes");
		controleTelaInicial = new ControleTelaInicial(this);
		
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(null);
		
		this.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent arg0) {
				
			}
			public void windowIconified(WindowEvent arg0) {
				
			}
			public void windowDeiconified(WindowEvent arg0) {
				
			}
			public void windowDeactivated(WindowEvent arg0) {
				
			}
			public void windowClosing(WindowEvent arg0) {
				int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", null, JOptionPane.YES_NO_OPTION);
				if(opc == 0){
					System.exit(0);
				}
			}
			public void windowClosed(WindowEvent arg0) {
				
			}
			public void windowActivated(WindowEvent arg0) {
				
			}
		});
		
		getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBounds(0, 631, 994, 23);
		getContentPane().add(splitPane);
		
		JPanel panelDataHora = new JPanel();
		splitPane.setLeftComponent(panelDataHora);
		
		Label label = new Label("-");
		
		panelDataHora.add(DatadeHj.getData());
		panelDataHora.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 0));
		panelDataHora.add(label);
		panelDataHora.add(RelogioThread.getLabel());
		
		JPanel panelCabesalho = new JPanel();
		splitPane.setRightComponent(panelCabesalho);
		panelCabesalho.setLayout(null);
		
		JLabel lblControleDeCliente = new JLabel("Controle de Clientes");
		lblControleDeCliente.setBounds(343, 0, 138, 21);
		panelCabesalho.add(lblControleDeCliente);
		
		lblVersao = new JLabel("ver. 1.0");
		lblVersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersao.setBounds(730, 0, 117, 21);
		panelCabesalho.add(lblVersao);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 994, 619);
		
		
		panel.setLayout(null);
		
		btnContPaci = new JButton("Clientes");
		btnContPaci.addActionListener(controleTelaInicial);
		btnContPaci.setBackground(Color.LIGHT_GRAY);
		btnContPaci.setToolTipText("Cadastrar ou atualizar clientes");
		btnContPaci.setIcon(new ImageIcon(TelaInicial.class.getResource("/icons/10693_64x64.png")));
		btnContPaci.setBounds(30, 129, 150, 60);
		panel.add(btnContPaci);
		
		btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(controleTelaInicial);
		btnVendas.setBackground(Color.LIGHT_GRAY);
		btnVendas.setToolTipText("Consultar vendas");
		btnVendas.setIcon(null);
		btnVendas.setBounds(210, 129, 150, 60);
		panel.add(btnVendas);
		
		btnConfiguracoes = new JButton("Configura\u00E7\u00F5es");
		btnConfiguracoes.setActionCommand("Configuracoes");
		btnConfiguracoes.addActionListener(controleTelaInicial);
		btnConfiguracoes.setBackground(Color.LIGHT_GRAY);
		btnConfiguracoes.setToolTipText("Acessar banco apartir da aplica\u00E7\u00E3o");
		btnConfiguracoes.setIcon(null);
		btnConfiguracoes.setBounds(390, 129, 170, 60);
		panel.add(btnConfiguracoes);
		
		btnSair = new JButton("Sair");
		btnSair.setBackground(Color.LIGHT_GRAY);
		btnSair.addActionListener(controleTelaInicial);
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/icons/43_64x64.png")));
		btnSair.setBounds(590, 129, 135, 60);
		panel.add(btnSair);
		
		getContentPane().add(panel);
		
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(10, 116, 974, 2);
		panel.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(10, 200, 974, 2);
		panel.add(separator2);
		
		
		JPanel panelFundo = new JPanel();
		panelFundo.setBounds(0, -12, 994, 117);
		panel.add(panelFundo);
		panelFundo.setLayout(null);
		
		lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setVerticalAlignment(SwingConstants.TOP);
		lblImagem.setBounds(0, 0, 994, 117);
		lblImagem.setIcon(new ImageIcon(TelaInicial.class.getResource("/icons/Grafica.jpg")));
		panelFundo.add(lblImagem);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(controleTelaInicial);
		mnInicio.add(mntmSair);
		
		mnControle = new JMenu("Controle");
		menuBar.add(mnControle);
		
		mntmCliente = new JMenuItem("Clientes");
		mntmCliente.setName("Clientes");
		mntmCliente.addActionListener(controleTelaInicial);
		mnControle.add(mntmCliente);
		
		mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(controleTelaInicial);
		mnControle.add(mntmVendas);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		mntmSobre.addActionListener(controleTelaInicial);
		
	}
	
	public JMenuItem getMntmSair() {
		return mntmSair;
	}
	public JButton getBtnSair() {
		return btnSair;
	}
	public JButton getBtnVendas() {
		return btnVendas;
	}
	public JButton getBtnContPaci() {
		return btnContPaci;
	}
	public JMenu getMnAjuda() {
		return mnAjuda;
	}
	public JButton getBtnConfiguracoes() {
		return btnConfiguracoes;
	}
	public JMenu getMnCadastrar() {
		return mnControle;
	}
	public JMenu getMnInicio() {
		return mnInicio;
	}
	public JMenuItem getMntmSobre() {
		return mntmSobre;
	}
	public JMenuItem getMntmVendas() {
		return mntmVendas;
	}
	public JMenuItem getMntmCliente() {
		return mntmCliente;
	}
}
