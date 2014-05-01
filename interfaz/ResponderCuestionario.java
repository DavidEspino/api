package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Cuestionario;

import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class ResponderCuestionario {

	private JFrame frmResponderCuestionario;
	private Cuestionario cuestionario;
	private JTextField textRespLarga;
	private JTextField textField;
	private JLayeredPane layeredPane;//aqui meto los distintos paneles de cada tipo de respuesta
	private LinkedList<String[]> respuestas=new LinkedList<String[]>() ;

/*
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
*/
	//constructora
	public ResponderCuestionario(Cuestionario pCuestionario, String pUsuario) {
		cuestionario=pCuestionario;
		initialize();
	}



	//creo la ventana
	private void initialize() {
		frmResponderCuestionario = new JFrame();
		frmResponderCuestionario.setTitle("Responder Cuestionario");
		frmResponderCuestionario.setBounds(100, 100, 450, 300);
		frmResponderCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResponderCuestionario.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		/**
		 * @author HelenJ
		 */
		JPanel panelTituloProgreso = new JPanel();
		frmResponderCuestionario.getContentPane().add(panelTituloProgreso, BorderLayout.NORTH);
		panelTituloProgreso.setLayout(new BoxLayout(panelTituloProgreso, BoxLayout.X_AXIS));
			String tituloCuestionario=cuestionario.getNombre();
			JLabel lblTiruloCuestionario = new JLabel(tituloCuestionario);
			panelTituloProgreso.add(lblTiruloCuestionario);
			
			JProgressBar progressBar = new JProgressBar();
			panelTituloProgreso.add(progressBar);
		
		
		layeredPane = new JLayeredPane();
		frmResponderCuestionario.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);
		
		
		//layeredPane.setLayer(Component, int);//Cambia la capa del componente. El segundo  argumento indica la capa
		
			//panel para preguntas de tipo test
			JPanel panelPregTest = new JPanel();
			panelPregTest.setBounds(0, 0, 433, 228);
			layeredPane.add(panelPregTest);
			panelPregTest.setLayout(new BoxLayout(panelPregTest, BoxLayout.Y_AXIS));
			
				JLabel lblPreguntaTest = new JLabel("");
				panelPregTest.add(lblPreguntaTest);
				
				JRadioButton rdbtnResUno = new JRadioButton("");
				panelPregTest.add(rdbtnResUno);
				
				JRadioButton rdbtnResDos = new JRadioButton("");
				panelPregTest.add(rdbtnResDos);
				
				JRadioButton rdbtnResTres = new JRadioButton("");
				panelPregTest.add(rdbtnResTres);
				
				JRadioButton rdbtnResCuatro = new JRadioButton("");
				panelPregTest.add(rdbtnResCuatro);
			
			
			//panel para preguntas de tipo satisfaccion
			JPanel panelPregSatis = new JPanel();
			panelPregSatis.setBounds(0, 0, 433, 228);
			layeredPane.add(panelPregSatis);
			panelPregSatis.setLayout(new BoxLayout(panelPregSatis, BoxLayout.Y_AXIS));
			
				JLabel lblPreguntaSatis = new JLabel("New label");
				panelPregSatis.add(lblPreguntaSatis);
				
				JRadioButton rdbtnUno = new JRadioButton("1");
				panelPregSatis.add(rdbtnUno);
				
				JRadioButton rdbtnDos = new JRadioButton("2");
				panelPregSatis.add(rdbtnDos);
				
				JRadioButton rdbtnTres = new JRadioButton("3");
				panelPregSatis.add(rdbtnTres);
				
				JRadioButton rdbtnCuatro = new JRadioButton("4");
				panelPregSatis.add(rdbtnCuatro);
				
				JRadioButton rdbtnCinco = new JRadioButton("5");
				panelPregSatis.add(rdbtnCinco);
			

			
			//panel para pregunta larga
			JPanel panelPregLarga = new JPanel();
			panelPregLarga.setBounds(0, 0, 433, 228);
			layeredPane.add(panelPregLarga);
			panelPregLarga.setLayout(new BoxLayout(panelPregLarga, BoxLayout.Y_AXIS));
			
				JLabel lblPreguntaLarga = new JLabel("New label");
				panelPregLarga.add(lblPreguntaLarga);
				
				textRespLarga = new JTextField();
				panelPregLarga.add(textRespLarga);
				textRespLarga.setColumns(30);
			

			
			//panel para pregunta corta
			JPanel panelPregCorta = new JPanel();
			panelPregCorta.setBounds(0, 0, 433, 228);
			layeredPane.add(panelPregCorta);
			panelPregCorta.setLayout(new BoxLayout(panelPregCorta, BoxLayout.Y_AXIS));
			
				JLabel lblPreguntaCorta = new JLabel("New label");
				panelPregCorta.add(lblPreguntaCorta);
				
				textField = new JTextField();
				panelPregCorta.add(textField);
				textField.setColumns(10);

		
				
		//panel de los botones
		JPanel panelBotones = new JPanel();
		frmResponderCuestionario.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			//muestra la pregunta anterior
			JButton btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			panelBotones.add(btnAnterior);
			
			//muestra la siguiente pregunta
			JButton btnSiguiente = new JButton("Siguiente");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//guardo la respuesta en respuestas
					String[] unaRes=null;
					if(layeredPane.getLayout().toString().equals("panelPregLarga")){
						unaRes[0]="corta_larga";
						//unaRes[1]=lblPreguntaLarga.getText();
						//respuestas.add();
					}else if(layeredPane.getLayout().toString().equals("panelPregSatis")){
						
					}else if(layeredPane.getLayout().toString().equals("panelPregTest")){
						
					}
				}
			});
			panelBotones.add(btnSiguiente);
				
	}
	private String[] obtenerPregunta(){
		String[] pregunta = null;//en la pos pregunta(0) se indica el tipo de pregunta
		
		return pregunta;
		
	}
	
}
