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
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class InicioSesion {

	private JFrame frmLogicgroup;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;

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
		frmLogicgroup.setBounds(100, 100, 335, 191);
		frmLogicgroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmLogicgroup.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n");
		lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblInicioDeSesin);
		
		JPanel panel_1 = new JPanel();
		frmLogicgroup.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		
		JButton btnSalir = new JButton("   Salir   ");
		panel_1.add(btnSalir);
		
		JPanel panel_2 = new JPanel();
		frmLogicgroup.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblUsuario = new JLabel("Usuario:     ");
		panel_3.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		panel_3.add(textFieldUsuario);
		textFieldUsuario.setColumns(15);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		panel_4.add(lblContrasea);
		
		textFieldContrasena = new JTextField();
		panel_4.add(textFieldContrasena);
		textFieldContrasena.setColumns(15);
	}
}
