package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ResponderCuestionario {

	private JFrame frmResponderCuestionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponderCuestionario window = new ResponderCuestionario();
					window.frmResponderCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResponderCuestionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResponderCuestionario = new JFrame();
		frmResponderCuestionario.setTitle("Responder Cuestionario");
		frmResponderCuestionario.setBounds(100, 100, 450, 300);
		frmResponderCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResponderCuestionario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo Cuestionario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 152, 26);
		frmResponderCuestionario.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 48, 434, 1);
		frmResponderCuestionario.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(10, 228, 414, 23);
		frmResponderCuestionario.getContentPane().add(btnNewButton);
	}
}
