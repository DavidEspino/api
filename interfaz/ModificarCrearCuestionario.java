package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ModificarCrearCuestionario {

	private JFrame frmCreacionmodificacionCuestionario;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JPanel panel_1;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCrearCuestionario window = new ModificarCrearCuestionario();
					window.frmCreacionmodificacionCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarCrearCuestionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreacionmodificacionCuestionario = new JFrame();
		frmCreacionmodificacionCuestionario.setTitle("Creacion/Modificacion Cuestionario");
		frmCreacionmodificacionCuestionario.setBounds(100, 100, 450, 455);
		frmCreacionmodificacionCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frmCreacionmodificacionCuestionario.getContentPane().add(panel, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		panel_1 = new JPanel();
		frmCreacionmodificacionCuestionario.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmCreacionmodificacionCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
