package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.TextField;
import javax.swing.JTextPane;

public class ViewSimulador {

	private JFrame frame;
	private JTable tabelaInstrucoes;
	private JTable tabelaConteudoPilha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSimulador window = new ViewSimulador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewSimulador() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		janelaInstrucoes();
		janelaConteudoPilha();
		janelaDeEntrada();
		janelaDeSaida();	
		janelaBreakPoints();
		

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(235, 613, 89, 23);
		frame.getContentPane().add(btnContinuar);
	}
	
	private void janelaInstrucoes(){
		JPanel janelaInstrucoes = new JPanel();
		janelaInstrucoes.setBorder(new LineBorder(Color.BLACK));
		janelaInstrucoes.setBounds(10, 11, 570, 370);
		frame.getContentPane().add(janelaInstrucoes);
		janelaInstrucoes.setLayout(null);
		
		JLabel lblInstrucoes = new JLabel("Instru\u00E7\u00F5es a serem executadas pela MV");
		lblInstrucoes.setBounds(148, 6, 273, 17);
		lblInstrucoes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstrucoes.setForeground(Color.BLUE);
		janelaInstrucoes.add(lblInstrucoes);
		
		tabelaInstrucoes = new JTable();
		tabelaInstrucoes.setBounds(21, 34, 539, 325);
		tabelaInstrucoes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"I", "Instru\u00E7\u00E3o", "Atributo #1", "Atributo #2", "Coment\u00E1rio"
			}
		));
		tabelaInstrucoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaInstrucoes.add(tabelaInstrucoes);
	}
	
	private void janelaConteudoPilha(){
		JPanel janelaConteudoPilha = new JPanel();
		janelaConteudoPilha.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaConteudoPilha.setBounds(590, 11, 184, 590);
		frame.getContentPane().add(janelaConteudoPilha);
		janelaConteudoPilha.setLayout(null);
		
		JLabel lblContedoDaPilha = new JLabel("Conte\u00FAdo da Pilha");
		lblContedoDaPilha.setBounds(26, 6, 126, 17);
		lblContedoDaPilha.setForeground(Color.BLUE);
		lblContedoDaPilha.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaConteudoPilha.add(lblContedoDaPilha);
		
		tabelaConteudoPilha = new JTable();
		tabelaConteudoPilha.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Endere\u00E7o (S)", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tabelaConteudoPilha.getColumnModel().getColumn(0).setResizable(false);
		tabelaConteudoPilha.getColumnModel().getColumn(1).setResizable(false);
		tabelaConteudoPilha.setBounds(10, 43, 164, 536);
		janelaConteudoPilha.add(tabelaConteudoPilha);
	}
	
	private void janelaDeEntrada() {
		JPanel janelaEntrada = new JPanel();
		janelaEntrada.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaEntrada.setBounds(10, 392, 190, 210);
		frame.getContentPane().add(janelaEntrada);
		janelaEntrada.setLayout(null);
		
		JLabel lblJanelaDeEntrada = new JLabel("Janela de Entrada");
		lblJanelaDeEntrada.setBounds(33, 6, 123, 17);
		lblJanelaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJanelaDeEntrada.setForeground(Color.BLUE);
		janelaEntrada.add(lblJanelaDeEntrada);
		
		JPanel estradaDados = new JPanel();
		estradaDados.setBounds(10, 34, 170, 164);
		janelaEntrada.add(estradaDados);
		estradaDados.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 160, 164);
		list.setToolTipText("");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "9", "8", "7", "4", "5", "6", "3", "2", "1"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		estradaDados.add(list);
	}
	
	private void janelaDeSaida() {
		JPanel janelaSaida = new JPanel();
		janelaSaida.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaSaida.setBounds(220, 392, 190, 210);
		frame.getContentPane().add(janelaSaida);
		janelaSaida.setLayout(null);
		
		JLabel lblJanelaDeSada = new JLabel("Janela de Sa\u00EDda");
		lblJanelaDeSada.setBounds(42, 6, 105, 17);
		lblJanelaDeSada.setForeground(Color.BLUE);
		lblJanelaDeSada.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaSaida.add(lblJanelaDeSada);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n7\r\n7\r\n7\r\n7\r\n7\r\n8");
		textPane.setBounds(10, 36, 170, 163);
		janelaSaida.add(textPane);
	}
	
	private void janelaBreakPoints() {
		JPanel janelaBreakPoints = new JPanel();
		janelaBreakPoints.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaBreakPoints.setBounds(430, 392, 150, 210);
		frame.getContentPane().add(janelaBreakPoints);
		janelaBreakPoints.setLayout(null);
		
		JLabel lblBrakPoints = new JLabel("Brak Point's");
		lblBrakPoints.setBounds(33, 6, 83, 17);
		lblBrakPoints.setForeground(Color.BLUE);
		lblBrakPoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaBreakPoints.add(lblBrakPoints);	
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 35, 130, 164);
		janelaBreakPoints.add(panel);
	}
}
