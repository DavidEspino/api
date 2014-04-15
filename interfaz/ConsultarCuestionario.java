package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
		frmConsultarCuestionario.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 414, 240);
		frmConsultarCuestionario.getContentPane().add(scrollPane);
	}

}
