package visao.agendamento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.JTable;

import modelagem.Cliente;
import modelagem.Venda;

import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;

import controle.agendamento.ControleVendas;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaVendas extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AnnotationResolver aR;
	private ObjectTableModel<Venda> modeloTabela;
	private	JTable TabelaAgenda;
	private final JPanel PainelPrincipal = new JPanel();
	private ControleVendas controleVenda;
	private JTextField txtNome;
	private JTextField txtProduto;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JFormattedTextField txtData;
	private JButton btnBuscar;
	private Cliente cliente;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			TelaAgendamento dialog = new TelaAgendamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	private MaskFormatter setMascara(String mascara){
		MaskFormatter mask = null;  
		try{  
			mask = new MaskFormatter(mascara);                    
		}catch(java.text.ParseException ex){}  
		return mask;  
	}
	
	
	public TelaVendas() {
		this(null);
	}
	
	public TelaVendas(Cliente cliente) {
		setBounds(100, 100, 770, 480);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(PainelPrincipal, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		PainelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.cliente = cliente;
		if(this.cliente == null)
			this.cliente = new Cliente();
		
		controleVenda = new ControleVendas(this, this.cliente);
		
		aR = new AnnotationResolver(Venda.class);
		modeloTabela = new ObjectTableModel<Venda>(aR, "data,nomeProd,valor,descricao");
		
		TabelaAgenda = new JTable(modeloTabela);
		TabelaAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
		TabelaAgenda.getColumnModel().getColumn(1).setPreferredWidth(200);
		TabelaAgenda.getColumnModel().getColumn(1).setResizable(false);
		TabelaAgenda.getColumnModel().getColumn(3).setPreferredWidth(400);
		TabelaAgenda.getColumnModel().getColumn(3).setResizable(false);
		PainelPrincipal.setLayout(null);
		
		JScrollPane PainelScroll = new JScrollPane(TabelaAgenda);
		PainelScroll.setBounds(5, 126, 754, 314);
		PainelPrincipal.add(PainelScroll);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(5, 11, 55, 16);
		PainelPrincipal.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(51, 10, 617, 20);
		PainelPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(TelaVendas.class.getResource("/icons/search-small.png")));
		btnBuscar.setToolTipText("Buscar outro cliente");
		btnBuscar.setBounds(679, 9, 74, 22);
		btnBuscar.setActionCommand("Buscar");
		PainelPrincipal.add(btnBuscar);
		btnBuscar.addActionListener(controleVenda);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(5, 40, 55, 16);
		PainelPrincipal.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(59, 38, 341, 20);
		PainelPrincipal.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setBounds(418, 40, 55, 16);
		PainelPrincipal.add(lblData);
		
		txtData = new JFormattedTextField(setMascara("##/##/####"));
		txtData.setBounds(457, 38, 114, 20);
		PainelPrincipal.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o: ");
		lblDescricao.setBounds(5, 68, 74, 16);
		PainelPrincipal.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(69, 66, 684, 20);
		PainelPrincipal.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setBounds(589, 40, 55, 16);
		PainelPrincipal.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(638, 38, 114, 20);
		txtValor.setDocument(new NumerosDecimais(8));
		PainelPrincipal.add(txtValor);
		txtValor.setColumns(10);
		
		
		{
			JPanel PainelBotoes = new JPanel();
			PainelBotoes.setBounds(0, 94, 764, 32);
			PainelPrincipal.add(PainelBotoes);
			PainelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
			{
				JButton BtnAdicionar = new JButton("Adicionar");
				BtnAdicionar.setIcon(new ImageIcon(TelaVendas.class.getResource("/icons/add.jpg")));
				BtnAdicionar.setSelectedIcon(new ImageIcon(TelaVendas.class.getResource("/icons/add.jpg")));
				BtnAdicionar.setActionCommand("Adicionar");
				PainelBotoes.add(BtnAdicionar);
				BtnAdicionar.addActionListener(controleVenda);
				getRootPane().setDefaultButton(BtnAdicionar);
			}
			{
				JButton BtnSair = new JButton("Sair");
				BtnSair.setIcon(new ImageIcon(TelaVendas.class.getResource("/icons/close.png")));
				BtnSair.setSelectedIcon(new ImageIcon(TelaVendas.class.getResource("/icons/close.png")));
				BtnSair.setActionCommand("Sair");
				BtnSair.addActionListener(controleVenda);
				
				JButton btnRemover = new JButton("Remover");
				btnRemover.setIcon(new ImageIcon(TelaVendas.class.getResource("/icons/cancel.png")));
				PainelBotoes.add(btnRemover);
				btnRemover.setActionCommand("Remover");
				btnRemover.addActionListener(controleVenda);
				PainelBotoes.add(BtnSair);
			}
		}
		
		if(this.cliente != null & this.cliente.getNome() != null){
			txtNome.setText(cliente.getNome());
			JButton btnPegarVendasNoBanco = new JButton();
			btnPegarVendasNoBanco.setActionCommand("PegarVendasNoBanco");
			btnPegarVendasNoBanco.addActionListener(controleVenda);
			btnPegarVendasNoBanco.doClick();
			
//			JOptionPane.showMessageDialog(null, cliente.getId());
		}
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ObjectTableModel<Venda> getModeloTabela() {
		return modeloTabela;
	}


	public JTable getTabelaAgenda() {
		return TabelaAgenda;
	}


	public ControleVendas getControleVenda() {
		return controleVenda;
	}


	public JTextField getTxtNome() {
		return txtNome;
	}


	public JTextField getTxtProduto() {
		return txtProduto;
	}


	public JTextField getTxtData() {
		return txtData;
	}


	public JTextField getTxtDescricao() {
		return txtDescricao;
	}


	public JTextField getTxtValor() {
		return txtValor;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
}

class NumerosDecimais extends PlainDocument {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer maxLength;

    public NumerosDecimais(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String texto = getText(0, getLength());

        if (texto.length() < this.maxLength) {
            remove(0, getLength());
            StringBuffer strBuf = new StringBuffer(texto.replaceAll(",", "") + str);

            if (strBuf.length() < 3) {
                strBuf.insert(0, ",");
            } else {
                strBuf.insert(strBuf.length() - 2, ",");
            }

            super.insertString(0, strBuf.toString(), a);
        }
    }
}
