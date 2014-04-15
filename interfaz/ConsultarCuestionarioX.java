package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ConsultarCuestionarioX {

	private JFrame frmConsultarCuestionarioX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCuestionarioX window = new ConsultarCuestionarioX();
					window.frmConsultarCuestionarioX.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarCuestionarioX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarCuestionarioX = new JFrame();
		frmConsultarCuestionarioX.setTitle("Consultar Cuestionario X");
		frmConsultarCuestionarioX.setBounds(100, 100, 450, 266);
		frmConsultarCuestionarioX.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultarCuestionarioX.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo Pregunta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 8, 414, 23);
		frmConsultarCuestionarioX.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(10, 194, 414, 23);
		frmConsultarCuestionarioX.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 434, 2);
		frmConsultarCuestionarioX.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Respuesta 1");
		lblNewLabel_1.setBounds(10, 55, 172, 23);
		frmConsultarCuestionarioX.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRespuesta = new JLabel("Respuesta 2");
		lblRespuesta.setBounds(10, 90, 172, 23);
		frmConsultarCuestionarioX.getContentPane().add(lblRespuesta);
		
		JLabel lblRespuesta_1 = new JLabel("Respuesta 3");
		lblRespuesta_1.setBounds(10, 126, 172, 23);
		frmConsultarCuestionarioX.getContentPane().add(lblRespuesta_1);
		
		JLabel lblRespuesta_2 = new JLabel("Respuesta 4");
		lblRespuesta_2.setBounds(10, 160, 172, 23);
		frmConsultarCuestionarioX.getContentPane().add(lblRespuesta_2);
	}

}
