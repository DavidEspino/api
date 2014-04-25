package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class ConsultarCuestionario {

	private JFrame frmConsultarCuestionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCuestionario window = new ConsultarCuestionario();
					window.frmConsultarCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarCuestionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarCuestionario = new JFrame();
		frmConsultarCuestionario.setTitle("Consultar Cuestionario");
		frmConsultarCuestionario.setBounds(100, 100, 450, 300);
		frmConsultarCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmConsultarCuestionario.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frmConsultarCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
