package view;

import controller.Arquivo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


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
		
		Arquivo instrucoes = new Arquivo("a.txt");
		
		janelaInstrucoes(instrucoes);
		janelaConteudoPilha(instrucoes);
		janelaDeEntrada(instrucoes);
		janelaDeSaida(instrucoes);	
		janelaBreakPoints(instrucoes);
		

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(235, 613, 89, 23);
		frame.getContentPane().add(btnContinuar);
	}
	
	private void janelaInstrucoes(Arquivo instrucoes){
		
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
				{instrucoes.getLinha(0), null, null, null, null},
				{instrucoes.getLinha(1), null, null, null, null},
				{instrucoes.getLinha(2), null, null, null, null},
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
	
	private void janelaConteudoPilha(Arquivo instrucoes){
		
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
				{instrucoes.getLinha(0), null},
				{instrucoes.getLinha(1), null},
				{instrucoes.getPalavra(0, 0), instrucoes.getPalavra(0, 1)},
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
	
	private void janelaDeEntrada(Arquivo instrucoes) {
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
		
		List conteudoJanelaEntrada = new List();
		conteudoJanelaEntrada.setBounds(10, 29, 170, 171);
		janelaEntrada.add(conteudoJanelaEntrada);
		
	}
	
	private void janelaDeSaida(Arquivo instrucoes) {
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
		
		List conteudoJanelaSaida = new List();
		conteudoJanelaSaida.setBounds(10, 29, 170, 171);
		conteudoJanelaSaida.add(instrucoes.getLinha(0));
		janelaSaida.add(conteudoJanelaSaida);
	}
	
	private void janelaBreakPoints(Arquivo instrucoes) {
		JPanel janelaBreakPoints = new JPanel();
		janelaBreakPoints.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaBreakPoints.setBounds(430, 392, 150, 210);
		frame.getContentPane().add(janelaBreakPoints);
		janelaBreakPoints.setLayout(null);
		
		JLabel lblBreakPoints = new JLabel("Break Point's");
		lblBreakPoints.setBounds(31, 6, 91, 17);
		lblBreakPoints.setForeground(Color.BLUE);
		lblBreakPoints.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaBreakPoints.add(lblBreakPoints);
		
		List conteudoBreackPoint = new List();
		conteudoBreackPoint.setBounds(10, 29, 130, 171);
		janelaBreakPoints.add(conteudoBreackPoint);
	}
}
