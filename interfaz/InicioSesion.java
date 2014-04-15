package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;

public class InicioSesion {

	private JFrame frmLogicgroup;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion window = new InicioSesion();
					window.frmLogicgroup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogicgroup = new JFrame();
		frmLogicgroup.setTitle("LogicGroup");
		frmLogicgroup.setBounds(100, 100, 246, 195);
		frmLogicgroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogicgroup.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(91, 49, 129, 20);
		frmLogicgroup.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 80, 129, 20);
		frmLogicgroup.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(12, 80, 69, 20);
		frmLogicgroup.getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(12, 49, 69, 20);
		frmLogicgroup.getContentPane().add(lblUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio de sesi\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 210, 27);
		frmLogicgroup.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(10, 123, 210, 23);
		frmLogicgroup.getContentPane().add(btnNewButton);
	}
}
