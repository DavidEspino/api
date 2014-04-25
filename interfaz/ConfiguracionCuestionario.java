package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

public class ConfiguracionCuestionario {

	private JFrame frmConfiguracinCuestionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguracionCuestionario window = new ConfiguracionCuestionario();
					window.frmConfiguracinCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfiguracionCuestionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfiguracinCuestionario = new JFrame();
		frmConfiguracinCuestionario.setTitle("Configuraci\u00F3n de Cuestionario");
		frmConfiguracinCuestionario.setBounds(100, 100, 450, 300);
		frmConfiguracinCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfiguracinCuestionario.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmConfiguracinCuestionario.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnAadirCuestionario = new JButton("A\u00F1adir Cuestionario");
		panel.add(btnAadirCuestionario);
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmConfiguracinCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
