package visao.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import controle.paciente.ControleTelasClientes;
import modelagem.Cliente;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaCadastroCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cli;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ControleTelasClientes controleTelaCliente;
	private JTextField textFieldNome;
	private JFormattedTextField textFieldCpf;
	private JTextField textFieldRg;
	private JFormattedTextField textFieldDataDeNasc;
	private JTextField textFieldRua;
	private JTextField textFieldNumRua;
	private JTextField textFieldComplemento;
	private JTextField textFieldCidade;
	private JFormattedTextField textFieldTelefone;
	private JFormattedTextField textFieldCelular;
	private JRadioButton rdbtnMas;
	private JRadioButton rdbtnFem;
	private JButton buttonNovo;
	private JButton buttonPesquisar;
	private JButton btnSalvar;
	private JButton btnDesfazer;
	private JButton btnFechar;
	private JPanel panelButtoesBaixo;
	private JTextField textFieldNdaficha;
	private JTextField textFieldECivil;
	private JTextField textFieldProfissao;
	private JLabel lblnUltimaFicha;
	private JButton btnPegarUltimaFicha;
	
	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { try { TelaCadastroCliente dialog
	 * = new TelaCadastroCliente();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}

	public TelaCadastroCliente() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Clientes");
		setBounds(100, 100, 850, 585);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		controleTelaCliente = new ControleTelasClientes(this);

		{
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 42, 694, 2);
			contentPanel.add(separator);
		}

		JLabel lblNome = new JLabel("*Nome: ");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(10, 58, 46, 14);
		contentPanel.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(67, 55, 431, 20);
		contentPanel.add(textFieldNome);
		textFieldNome.setColumns(10);

		JPanel panelButoesCima = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButoesCima.getLayout();
		flowLayout.setVgap(8);
		flowLayout.setHgap(50);
		panelButoesCima.setBounds(0, 1, 486, 40);
		contentPanel.add(panelButoesCima);

		buttonNovo = new JButton("Novo");
		buttonNovo.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/icons/add.jpg")));
		buttonNovo.addActionListener(controleTelaCliente);
		panelButoesCima.add(buttonNovo);

		buttonPesquisar = new JButton("Pesquisar clientes");
		buttonPesquisar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/icons/search-small.png")));
		buttonPesquisar.addActionListener(controleTelaCliente);
		panelButoesCima.add(buttonPesquisar);

		panelButtoesBaixo = new JPanel();
		FlowLayout fl_panelButtoesBaixo = (FlowLayout) panelButtoesBaixo
				.getLayout();
		fl_panelButtoesBaixo.setHgap(30);
		fl_panelButtoesBaixo.setAlignment(FlowLayout.LEFT);
		panelButtoesBaixo.setBounds(10, 513, 824, 32);
		contentPanel.add(panelButtoesBaixo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/icons/checked-16x16.png")));
		btnSalvar.addActionListener(controleTelaCliente);
		panelButtoesBaixo.add(btnSalvar);

		btnDesfazer = new JButton("Desfazer");
		btnDesfazer.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/icons/close.png")));
		btnDesfazer.addActionListener(controleTelaCliente);
		panelButtoesBaixo.add(btnDesfazer);

		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/icons/cancel.png")));
		btnFechar.addActionListener(controleTelaCliente);
		panelButtoesBaixo.add(btnFechar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 500, 824, 2);
		contentPanel.add(separator);

		JLabel lblNDaFicha = new JLabel("*N\u00BA da Ficha: ");
		lblNDaFicha.setBounds(512, 57, 74, 14);
		contentPanel.add(lblNDaFicha);

		textFieldNdaficha = new JTextField();
		textFieldNdaficha.setEditable(false);
		textFieldNdaficha.setBounds(596, 55, 88, 20);
		contentPanel.add(textFieldNdaficha);
		textFieldNdaficha.setColumns(10);

		JTabbedPane tabbedPanePaciente = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePaciente.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPanePaciente.setBounds(10, 97, 824, 392);
		contentPanel.add(tabbedPanePaciente);

		JPanel panelDados = new JPanel();
		tabbedPanePaciente.addTab("Dados", null, panelDados, null);
		panelDados.setLayout(null);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(10, 25, 46, 14);
		panelDados.add(lblCpf);

		textFieldCpf = new JFormattedTextField(setMascara("###.###.###-##"));
		textFieldCpf.setBounds(56, 22, 159, 20);
		panelDados.add(textFieldCpf);
		textFieldCpf.setEditable(false);
		textFieldCpf.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textFieldCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG: ");
		lblRg.setBounds(250, 25, 46, 14);
		panelDados.add(lblRg);

		textFieldRg = new JTextField();
		textFieldRg.setBounds(296, 22, 202, 20);
		panelDados.add(textFieldRg);
		textFieldRg.setEditable(false);
		textFieldRg.setColumns(10);

		JLabel lblSexo = new JLabel("*Sexo:");
		lblSexo.setBounds(283, 66, 46, 14);
		panelDados.add(lblSexo);

		rdbtnMas = new JRadioButton("Masculino");
		rdbtnMas.setBounds(325, 62, 89, 23);
		panelDados.add(rdbtnMas);
		rdbtnMas.setEnabled(false);
		buttonGroup.add(rdbtnMas);

		rdbtnFem = new JRadioButton("Feminino");
		rdbtnFem.setBounds(416, 62, 82, 23);
		panelDados.add(rdbtnFem);
		rdbtnFem.setEnabled(false);
		buttonGroup.add(rdbtnFem);

		JLabel lblDataDeNascimento = new JLabel("*Data de nascimento: ");
		lblDataDeNascimento.setBounds(252, 109, 136, 14);
		panelDados.add(lblDataDeNascimento);

		textFieldDataDeNasc = new JFormattedTextField(setMascara("##/##/####"));
		textFieldDataDeNasc.setBounds(386, 105, 112, 20);
		panelDados.add(textFieldDataDeNasc);
		textFieldDataDeNasc.setEditable(false);
		textFieldDataDeNasc.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textFieldDataDeNasc.setColumns(10);

		JLabel lblEndereco = new JLabel("Rua: ");
		lblEndereco.setBounds(10, 149, 66, 14);
		panelDados.add(lblEndereco);

		textFieldRua = new JTextField();
		textFieldRua.setBounds(56, 146, 290, 20);
		panelDados.add(textFieldRua);
		textFieldRua.setEditable(false);
		textFieldRua.setColumns(10);

		JLabel lblN = new JLabel("N\u00BA: ");
		lblN.setBounds(377, 149, 46, 14);
		panelDados.add(lblN);

		textFieldNumRua = new JTextField();
		textFieldNumRua.setBounds(412, 146, 86, 20);
		panelDados.add(textFieldNumRua);
		textFieldNumRua.setEditable(false);
		textFieldNumRua.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(10, 190, 89, 14);
		panelDados.add(lblComplemento);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(115, 187, 159, 20);
		panelDados.add(textFieldComplemento);
		textFieldComplemento.setEditable(false);
		textFieldComplemento.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(300, 190, 46, 14);
		panelDados.add(lblCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(356, 187, 142, 20);
		panelDados.add(textFieldCidade);
		textFieldCidade.setEditable(false);
		textFieldCidade.setColumns(10);

		JLabel lblTelefone = new JLabel("*Telefone: ");
		lblTelefone.setBounds(10, 232, 74, 14);
		panelDados.add(lblTelefone);

		textFieldTelefone = new JFormattedTextField(
				setMascara("(##) ####-####"));
		textFieldTelefone.setBounds(85, 229, 150, 20);
		panelDados.add(textFieldTelefone);
		textFieldTelefone.setEditable(false);
		textFieldTelefone.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textFieldTelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Telefone 2: ");
		lblCelular.setBounds(258, 232, 74, 14);
		panelDados.add(lblCelular);

		textFieldCelular = new JFormattedTextField(setMascara("(##) ####-####"));
		textFieldCelular.setBounds(333, 229, 165, 20);
		panelDados.add(textFieldCelular);
		textFieldCelular.setEditable(false);
		textFieldCelular.setFocusLostBehavior(JFormattedTextField.COMMIT);
		textFieldCelular.setColumns(10);

		JLabel lblECivil = new JLabel("E. Civil: ");
		lblECivil.setBounds(10, 108, 46, 14);
		panelDados.add(lblECivil);

		textFieldECivil = new JTextField();
		textFieldECivil.setBounds(65, 105, 150, 20);
		panelDados.add(textFieldECivil);
		textFieldECivil.setEditable(false);
		textFieldECivil.setColumns(10);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o: ");
		lblProfisso.setBounds(10, 66, 66, 14);
		panelDados.add(lblProfisso);

		textFieldProfissao = new JTextField();
		textFieldProfissao.setBounds(78, 63, 178, 20);
		panelDados.add(textFieldProfissao);
		textFieldProfissao.setEditable(false);
		textFieldProfissao.setColumns(10);

		JLabel lblCamobrig = new JLabel(
				"Campos com * s\u00E3o obrigat\u00F3rios!");
		lblCamobrig.setBounds(10, 311, 423, 20);
		panelDados.add(lblCamobrig);
		lblCamobrig.setForeground(Color.RED);

		JLabel lblCliDesde = new JLabel("Cliente desde: ");
		lblCliDesde.setBounds(10, 274, 89, 14);
		panelDados.add(lblCliDesde);

		JLabel lblCliDataEnt = new JLabel("");
		lblCliDataEnt.setBounds(99, 274, 127, 14);
		panelDados.add(lblCliDataEnt);

		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(null);
		tabbedPanePaciente.addTab("Vendas", null, panelCompras, null);

		JButton btnNovaVenda = new JButton("Adicionar ou remover venda ao cliente");
		btnNovaVenda.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNovaVenda.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/icons/add.jpg")));
		btnNovaVenda.addActionListener(controleTelaCliente);
		btnNovaVenda.setBounds(12, 12, 799, 337);
		btnNovaVenda.setActionCommand("Nova Venda");
		panelCompras.add(btnNovaVenda);
		
		JLabel lblUltimaFichaCadastrada = new JLabel("Ultima Ficha Cadastrada: ");
		lblUltimaFichaCadastrada.setBounds(512, 12, 148, 16);
		contentPanel.add(lblUltimaFichaCadastrada);
		
		lblnUltimaFicha = new JLabel("noString");
		lblnUltimaFicha.setBounds(655, 12, 88, 16);
		btnPegarUltimaFicha = new JButton();
		btnPegarUltimaFicha.addActionListener(controleTelaCliente);
		btnPegarUltimaFicha.setActionCommand("nUltimaFicha");
		btnPegarUltimaFicha.doClick();
		contentPanel.add(lblnUltimaFicha);

	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldRua() {
		return textFieldRua;
	}

	public JTextField getTextFieldRg() {
		return textFieldRg;
	}

	public JTextField getTextFieldTelefone() {
		return textFieldTelefone;
	}

	public JTextField getTextFieldCelular() {
		return textFieldCelular;
	}

	public JTextField getTextFieldDataDeNasc() {
		return textFieldDataDeNasc;
	}

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldCpf() {
		return textFieldCpf;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public JTextField getTextFieldNumRua() {
		return textFieldNumRua;
	}

	public JTextField getTextFieldNdaficha() {
		return textFieldNdaficha;
	}

	public JTextField getTextFieldProfissao() {
		return textFieldProfissao;
	}

	public JTextField getTextFieldECivil() {
		return textFieldECivil;
	}

	public JRadioButton getRdbtnMas() {
		return rdbtnMas;
	}

	public JRadioButton getRdbtnFem() {
		return rdbtnFem;
	}

	public JButton getBtnNovo() {
		return buttonNovo;
	}

	public JButton getBtnPesquisar() {
		return buttonPesquisar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnDesfazer() {
		return btnDesfazer;
	}

	public JButton getBtnFechar() {
		return btnFechar;
	}

	public JPanel getPanelButtoesBaixo() {
		return panelButtoesBaixo;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public JLabel getLblNultimaficha() {
		return lblnUltimaFicha;
	}

	public JButton getBtnPegarUltimaFicha() {
		return btnPegarUltimaFicha;
	}
}
