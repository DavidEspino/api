package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class RellenarCuestionario {

	private JFrame frmRellenarCuestionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RellenarCuestionario window = new RellenarCuestionario();
					window.frmRellenarCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RellenarCuestionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRellenarCuestionario = new JFrame();
		frmRellenarCuestionario.setTitle("Rellenar Cuestionario");
		frmRellenarCuestionario.setBounds(100, 100, 450, 300);
		frmRellenarCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRellenarCuestionario.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 414, 240);
		frmRellenarCuestionario.getContentPane().add(scrollPane);
	}

}
