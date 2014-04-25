package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

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
		frmCuestionarioX.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmCuestionarioX.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConsultarSeleccion = new JButton("Consultar Seleccion");
		panel.add(btnConsultarSeleccion);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmCuestionarioX.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
