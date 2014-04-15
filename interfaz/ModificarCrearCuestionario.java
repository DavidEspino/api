package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;

public class ModificarCrearCuestionario {

	private JFrame frmCreacionmodificacionCuestionario;
	private JTextField textField;
	private final JScrollPane scrollPane = new JScrollPane();

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
		frmCreacionmodificacionCuestionario.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(106, 11, 69, 20);
		frmCreacionmodificacionCuestionario.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 11, 129, 20);
		frmCreacionmodificacionCuestionario.getContentPane().add(textField);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 58, 414, 290);
		frmCreacionmodificacionCuestionario.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(10, 383, 414, 23);
		frmCreacionmodificacionCuestionario.getContentPane().add(btnNewButton);
	}
}
