package visao.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.JTextField;
import modelagem.Cliente;

import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;

import controle.cliente.ControleTelasClientes;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import visao.agendamento.TelaVendas;

public class TelaBuscarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel PanelPrincipal = new JPanel();
	private JTextField txtBuscarNome;
	private ObjectTableModel<Cliente> modeloTabela;
	private AnnotationResolver aR;
	private JButton btnBuscar;
	private JButton BtnSelecionar;
	private JButton BtnCancelar;
	private JTable tabela;
	private JTextField txtBuscarNFicha;
	private String tipoDeTela;
	private TelaVendas tVendas;

	public TelaBuscarCliente() {
		this(null, null);
	}

	public TelaBuscarCliente(ControleTelasClientes contTelaCli,
			String tipoDeTela) {
		super();
		this.tipoDeTela = tipoDeTela;

		setResizable(false);
		setTitle("Buscar");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PanelPrincipal, BorderLayout.CENTER);
		PanelPrincipal.setLayout(null);

		aR = new AnnotationResolver(Cliente.class);
		modeloTabela = new ObjectTableModel<Cliente>(aR, "nFicha,nome");

		txtBuscarNome = new JTextField();
		txtBuscarNome.setBounds(98, 11, 317, 20);
		PanelPrincipal.add(txtBuscarNome);
		txtBuscarNome.setColumns(10);

		txtBuscarNFicha = new JTextField();
		txtBuscarNFicha.setBounds(122, 34, 139, 20);
		PanelPrincipal.add(txtBuscarNFicha);
		txtBuscarNFicha.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(contTelaCli);
		btnBuscar.setBounds(425, 21, 89, 23);
		PanelPrincipal.add(btnBuscar);

		tabela = new JTable(modeloTabela);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
		esquerda.setHorizontalAlignment(SwingConstants.LEFT);
		tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);

		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(300);

		JScrollPane scrollPaneTabela = new JScrollPane(tabela);
		scrollPaneTabela.setBounds(10, 65, 504, 263);
		PanelPrincipal.add(scrollPaneTabela);

		JLabel lblBuscarNome = new JLabel("Buscar Nome: ");
		lblBuscarNome.setBounds(10, 14, 89, 14);
		PanelPrincipal.add(lblBuscarNome);

		JLabel lblBuscarNDa = new JLabel("Buscar n\u00BA da ficha: ");
		lblBuscarNDa.setBounds(10, 37, 114, 14);
		PanelPrincipal.add(lblBuscarNDa);

		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setHgap(50);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BtnSelecionar = new JButton("Selecionar");
				BtnSelecionar.addActionListener(contTelaCli);
				BtnSelecionar.setActionCommand("OK");
				buttonPane.add(BtnSelecionar);
				getRootPane().setDefaultButton(BtnSelecionar);
			}
			{
				BtnCancelar = new JButton("Cancelar");
				BtnCancelar.addActionListener(contTelaCli);
				BtnCancelar.setActionCommand("Cancel");
				buttonPane.add(BtnCancelar);
			}
		}
	}

	public JTextField getTxtBuscarnome() {
		return txtBuscarNome;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getButtonSelecionar() {
		return BtnSelecionar;
	}

	public JButton getBtnCancelar() {
		return BtnCancelar;
	}

	public ObjectTableModel<Cliente> getModeloTabela() {
		return modeloTabela;
	}

	public JTable getTabela() {
		return tabela;
	}

	public JTextField getTxtBuscarNFicha() {
		return txtBuscarNFicha;
	}

	public String getTipoDeTela() {
		return tipoDeTela;
	}

	public TelaVendas gettVendas() {
		return tVendas;
	}

	public void settVendas(TelaVendas tVendas) {
		this.tVendas = tVendas;
	}
}
