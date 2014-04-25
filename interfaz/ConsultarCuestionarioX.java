package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frmConsultarCuestionarioX.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Titulo pregunta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		frmConsultarCuestionarioX.getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frmConsultarCuestionarioX.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblPregunta = new JLabel("Pregunta1");
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPregunta);
		
		JLabel lblPregunta_1 = new JLabel("Pregunta2");
		lblPregunta_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPregunta_1);
		
		JLabel lblPregunta_2 = new JLabel("Pregunta3");
		lblPregunta_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPregunta_2);
		
		JLabel lblPregunta_3 = new JLabel("Pregunta4");
		lblPregunta_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPregunta_3);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSiguiente = new JButton("Siguiente");
		panel_1.add(btnSiguiente);
		
		JButton btnAtras = new JButton("Atras");
		panel_1.add(btnAtras);
	}

}
