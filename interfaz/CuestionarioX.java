package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CuestionarioX {

	private JFrame frmCuestionarioX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuestionarioX window = new CuestionarioX();
					window.frmCuestionarioX.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CuestionarioX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCuestionarioX = new JFrame();
		frmCuestionarioX.setTitle("Cuestionario X");
		frmCuestionarioX.setBounds(100, 100, 450, 300);
		frmCuestionarioX.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCuestionarioX.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar Selecci\u00F3n");
		btnNewButton.setBounds(10, 228, 414, 23);
		frmCuestionarioX.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 414, 206);
		frmCuestionarioX.getContentPane().add(scrollPane);
	}

}
