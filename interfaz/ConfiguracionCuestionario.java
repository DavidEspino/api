package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

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
		frmConfiguracinCuestionario.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("A\u00F1adir Cuestionario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 228, 414, 23);
		frmConfiguracinCuestionario.getContentPane().add(btnNewButton);
	}
}
