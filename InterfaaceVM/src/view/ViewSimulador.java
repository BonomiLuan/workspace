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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.TextArea;


public class ViewSimulador {

	private JFrame frame;
	private Arquivo instrucoes = new Arquivo();
	private JTable tabelaIntrucoes = new JTable();
	private JTable tabelaPilha = new JTable();
	private JPanel janelaConteudoPilha = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JPanel janelaInstrucoes = new JPanel();
	private JPanel janelaSaida = new JPanel();

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
		frame.setBounds(100, 100, 800, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		menuBar();
		janelaInstrucoes();
		janelaConteudoPilha();
		janelaDeSaida();
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(249, 612, 89, 23);
		frame.getContentPane().add(btnContinuar);
	}
	
	private void menuBar() {
		frame.setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(e -> instrucoes.lerArquivo(tabelaIntrucoes));
		mnFile.add(mntmAbrir);
		
		JMenu mnExecutar = new JMenu("Executar");
		menuBar.add(mnExecutar);
		
		JMenuItem mntmCompilar = new JMenuItem("Compilar");
		mnExecutar.add(mntmCompilar);
		
		JMenuItem mntmDebuggar = new JMenuItem("Debuggar");
		mnExecutar.add(mntmDebuggar);
		
		JMenuItem mntmStepByStep = new JMenuItem("Step by Step");
		mnExecutar.add(mntmStepByStep);
	}
	
	private void janelaInstrucoes(){
		janelaInstrucoes.setBorder(new LineBorder(Color.BLACK));
		janelaInstrucoes.setBounds(10, 11, 570, 370);
		frame.getContentPane().add(janelaInstrucoes);
		janelaInstrucoes.setLayout(null);
		
		JLabel lblInstrucoes = new JLabel("Instru\u00E7\u00F5es a serem executadas pela MV");
		lblInstrucoes.setBounds(148, 6, 273, 17);
		lblInstrucoes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstrucoes.setForeground(Color.BLUE);
		janelaInstrucoes.add(lblInstrucoes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 550, 325);
		janelaInstrucoes.add(scrollPane);
		
		checkBoxDebbugger(scrollPane);
		tabelaInstrucoes(scrollPane);
				
	}
	
	private void checkBoxDebbugger(JScrollPane scrollPane) {
		JCheckBoxMenuItem checkBoxDebugger = new JCheckBoxMenuItem("New check item");
		scrollPane.setRowHeaderView(checkBoxDebugger);
	}
	
	private void tabelaInstrucoes(JScrollPane scrollPane) {
		tabelaIntrucoes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"index", "Instru\u00E7\u00E3o", "Atributo #1", "Atributo #2", "Coment\u00E1rio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tabelaIntrucoes);
	}
	
	private void janelaConteudoPilha(){
		janelaConteudoPilha.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaConteudoPilha.setBounds(590, 11, 184, 590);
		frame.getContentPane().add(janelaConteudoPilha);
		janelaConteudoPilha.setLayout(null);
		
		JLabel lblContedoDaPilha = new JLabel("Conte\u00FAdo da Pilha");
		lblContedoDaPilha.setBounds(26, 6, 126, 17);
		lblContedoDaPilha.setForeground(Color.BLUE);
		lblContedoDaPilha.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaConteudoPilha.add(lblContedoDaPilha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 164, 545);
		janelaConteudoPilha.add(scrollPane);
		
		tabelaPilha.setModel(new DefaultTableModel(
			new Object[][] {				
			},
			new String[] {
				"Index", "Conte\u00FAdo"
			}
		));
		scrollPane.setViewportView(tabelaPilha);
	}
	
	private void janelaDeSaida() {
		janelaSaida.setBorder(new LineBorder(new Color(0, 0, 0)));
		janelaSaida.setBounds(10, 391, 570, 210);
		frame.getContentPane().add(janelaSaida);
		janelaSaida.setLayout(null);
		
		JLabel lblJanelaDeSada = new JLabel("Janela de Sa\u00EDda");
		lblJanelaDeSada.setBounds(232, 6, 126, 17);
		lblJanelaDeSada.setForeground(Color.BLUE);
		lblJanelaDeSada.setFont(new Font("Tahoma", Font.BOLD, 14));
		janelaSaida.add(lblJanelaDeSada);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 550, 168);
		janelaSaida.add(scrollPane);
		
		TextArea textJanelaSaida = new TextArea();
		scrollPane.setViewportView(textJanelaSaida);
	}
}
