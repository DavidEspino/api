package interfaz;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import logica.GestorCuestionarios;

public class AnadirPreguntaACuestionario {

	private JFrame frmAnadirPregunta;
	private int idCuestionario;
	private String usuario;
	
	private JRadioButton rdbtnText = new JRadioButton("Test");
	private JRadioButton rdbtnSatisfaccion = new JRadioButton("Satisfacci\u00F3n");
	private JRadioButton rdbtnPregunta = new JRadioButton("Pregunta Corta");
	private JRadioButton rdbtnPreguntaLarga = new JRadioButton("Pregunta Larga");
	
	private JTextField textFieldPregunta;
	private JTextField textFieldResp1;
	private JTextField textFieldResp2;
	private JTextField textFieldResp3;
	private JTextField textFieldResp4;

	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirPreguntaACuestionario window = new AnadirPreguntaACuestionario(1, "david");
					window.frmAnadirPregunta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	//constructor
	public AnadirPreguntaACuestionario(int pIdCuestionario, String pUsuario) {
		idCuestionario = pIdCuestionario;
		usuario = pUsuario;
		initialize();
	}

	//Getter to call window
	public JFrame getFrmAnadirPregunta() {
		return frmAnadirPregunta;
	}
	
	
	//window
	private void initialize() {
		frmAnadirPregunta = new JFrame();
		frmAnadirPregunta.setBounds(100, 100, 409, 262);
		frmAnadirPregunta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAnadirPregunta.getContentPane().add(panel, BorderLayout.SOUTH);		
		
		JPanel panel_1 = new JPanel();
		frmAnadirPregunta.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		frmAnadirPregunta.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.WEST);
		
		final JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setEnabled(false);
		panel_7.setVisible(false);
		
		
		//Radio buttons
		panel_1.add(rdbtnText);
		panel_1.add(rdbtnSatisfaccion);
		panel_1.add(rdbtnPregunta);
		panel_1.add(rdbtnPreguntaLarga);
		
		//boton tipo pregunta
		rdbtnText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnSatisfaccion.setSelected(false);
				rdbtnPregunta.setSelected(false);
				rdbtnPreguntaLarga.setSelected(false);
				panel_7.setVisible(true);
				panel_7.setEnabled(true);
			}
		});
		rdbtnPreguntaLarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSatisfaccion.setSelected(false);
				rdbtnPregunta.setSelected(false);
				rdbtnText.setSelected(false);
				panel_7.setVisible(false);
				panel_7.setEnabled(false);
			}
		});
		rdbtnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSatisfaccion.setSelected(false);
				rdbtnPreguntaLarga.setSelected(false);
				rdbtnText.setSelected(false);
				panel_7.setVisible(false);
				panel_7.setEnabled(false);
			}
		});
		rdbtnSatisfaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPregunta.setSelected(false);
				rdbtnPreguntaLarga.setSelected(false);
				rdbtnText.setSelected(false);
				panel_7.setVisible(false);
				panel_7.setEnabled(false);
			}
		});
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		//Pregunta
		JLabel lblPregunta = new JLabel("Pregunta:");
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblPregunta);
		
		textFieldPregunta = new JTextField();
		panel_4.add(textFieldPregunta, BorderLayout.CENTER);
		textFieldPregunta.setColumns(30);
		panel_7.setLayout(null);
		

		//Respuesta 1
		JLabel lblRespuesta1 = new JLabel("Respuesta 1:");
		lblRespuesta1.setBounds(10, 11, 80, 14);
		panel_7.add(lblRespuesta1);
		
		textFieldResp1 = new JTextField();
		textFieldResp1.setBounds(97, 9, 202, 17);
		panel_7.add(textFieldResp1);
		textFieldResp1.setColumns(10);
		
		
		//Respuesta 2
		JLabel lblRespuesta2 = new JLabel("Respuesta 2:");
		lblRespuesta2.setBounds(10, 38, 80, 14);
		panel_7.add(lblRespuesta2);
		
		textFieldResp2 = new JTextField();
		textFieldResp2.setBounds(97, 36, 202, 17);
		textFieldResp2.setColumns(10);
		panel_7.add(textFieldResp2);
		
		
		
		//Respuesta 3
		JLabel lblRespuesta3 = new JLabel("Respuesta 3:");
		lblRespuesta3.setBounds(10, 63, 80, 14);
		panel_7.add(lblRespuesta3);
		
		textFieldResp3 = new JTextField();
		textFieldResp3.setBounds(97, 61, 202, 17);
		textFieldResp3.setColumns(10);
		panel_7.add(textFieldResp3);
		
		
		//Respuesta4
		JLabel lblRespuesta4 = new JLabel("Respuesta 4:");
		lblRespuesta4.setBounds(10, 88, 80, 14);
		panel_7.add(lblRespuesta4);
				
		textFieldResp4 = new JTextField();
		textFieldResp4.setBounds(97, 86, 202, 17);
		textFieldResp4.setColumns(10);
		panel_7.add(textFieldResp4);
		
		//Botones
		JButton btnAadirPregunta = new JButton("   A\u00F1adir   ");
		btnAadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirPregunta();
				ModificarCrearCuestionario frame = new ModificarCrearCuestionario(usuario, idCuestionario);
				frame.getFrmCreacionmodificacionCuestionario().setVisible(true);
				frmAnadirPregunta.dispose();
			}
		});
		panel.add(btnAadirPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCrearCuestionario frame = new ModificarCrearCuestionario(usuario, idCuestionario);
				frame.getFrmCreacionmodificacionCuestionario().setVisible(true);
				frmAnadirPregunta.dispose();
			}
		});
		panel.add(btnCancelar);
		
		

	}
	
	private void anadirPregunta(){
		if (rdbtnPregunta.isSelected()) {
			GestorCuestionarios.getGestorCuestionarios().anadirPreguntaCorta(textFieldPregunta.getText(), idCuestionario);
		}
		else if (rdbtnPreguntaLarga.isSelected()) {
			GestorCuestionarios.getGestorCuestionarios().anadirPreguntaLarga(textFieldPregunta.getText(), idCuestionario);
		}
		else if (rdbtnSatisfaccion.isSelected()){
			GestorCuestionarios.getGestorCuestionarios().anadirPreguntaSatisfaccion(textFieldPregunta.getText(), idCuestionario);
		}
		else if (rdbtnText.isSelected()) {
			GestorCuestionarios.getGestorCuestionarios().anadirPreguntaTest(textFieldPregunta.getText(), textFieldResp1.getText(), textFieldResp2.getText(), textFieldResp3.getText(), textFieldResp4.getText(), idCuestionario);
		}
	}
}
