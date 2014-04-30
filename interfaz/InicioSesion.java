package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.GestorLogin;
import java.awt.Color;

public class InicioSesion extends JFrame {

	private JFrame frmLogicgroup;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldContrasena;

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
		frmLogicgroup.setBounds(100, 100, 335, 209);
		frmLogicgroup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frmLogicgroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panels
		JPanel panel = new JPanel();
		frmLogicgroup.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frmLogicgroup.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		frmLogicgroup.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		//Labels and textfields
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n");
		lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblInicioDeSesin);
		
		JLabel lblUsuario = new JLabel("Usuario:     ");
		panel_3.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		panel_3.add(textFieldUsuario);
		textFieldUsuario.setColumns(15);
		
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		panel_4.add(lblContrasea);
		
		passwordFieldContrasena = new JPasswordField();
		panel_4.add(passwordFieldContrasena);
		passwordFieldContrasena.setColumns(15);
		
		
		final JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		panel_5.add(lblError);
		
		
		//Buttons
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textFieldUsuario.getText();
				if (usuario.isEmpty()){
					lblError.setText("Error Usuario vacio");
				}
				else if (passwordFieldContrasena.getPassword().length==0) {
					lblError.setText("Error contraseña vacia");
				}
				else {
					String tipo = GestorLogin.getMiGestorLogin().login(usuario, passwordFieldContrasena.getPassword().toString());
					if (tipo == "fallo"){
						lblError.setText("Contraseña o usuario incorrectos");
					}
					else if (tipo == "rellenador") {
						RellenarCuestionario frame = new RellenarCuestionario(usuario);
						frame.setVisible(true);
						frmLogicgroup.dispose();
					}
					else if (tipo == "contestador") {
						ConfiguracionCuestionario frame = new ConfiguracionCuestionario(usuario);
						frame.setVisible(true);
						frmLogicgroup.dispose();
					}
					else if (tipo == "consultor") {
						//ConsultarCuestionario frame = new ConsultarCuestionario(usuario);
						new ConsultarCuestionario();
						//frame.setVisible(true);
						//dispose();
						frmLogicgroup.dispose();
					}
					else{
						lblError.setText("Error desconocido");
					}
				}
			}
		});
		panel_1.add(btnAceptar);
		
		
		
		
		JButton btnSalir = new JButton("   Salir   ");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnSalir);
	}
}
