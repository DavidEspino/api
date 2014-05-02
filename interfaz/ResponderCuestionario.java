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
import logica.GestorCuestionarios;
import logica.Pregunta;
import logica.PreguntaTest;

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
	
	//en String[] habra: 0->idpreg, 1->tipo ,2 ->pregunta, n-1->posi resp del tipo, n->resp
	private LinkedList<String[]> pregRes=new LinkedList<String[]>();
	private String[] auxpre;//aqui se va a encontrar solo la pregunta q se va a ver en el momento
	private int indicePreg;
/**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedList<Cuestionario> x =GestorCuestionarios.getGestorCuestionarios().obtenerCuestionarios();
					Cuestionario c=x.get(0);
					ResponderCuestionario window = new ResponderCuestionario(c, "hpaz");
					window.frmResponderCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//constructora
	public ResponderCuestionario(Cuestionario pCuestionario, String pUsuario) {
		cuestionario=pCuestionario;
		indicePreg=0;
		rellenarLista();// relleno la lista pregRes=new LinkedList<String[]>()
		auxpre=pregRes.get(indicePreg);
		
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
		
		
		//panel para preguntas de tipo test
		JPanel panelPregTest = new JPanel();
		panelPregTest.setBounds(0, 0, 433, 228);
		layeredPane.add(panelPregTest);
		panelPregTest.setLayout(new BoxLayout(panelPregTest, BoxLayout.Y_AXIS));
		
		//panel para preguntas de tipo satisfaccion
		JPanel panelPregSatis = new JPanel();
		panelPregSatis.setBounds(0, 0, 433, 228);
		layeredPane.add(panelPregSatis);
		panelPregSatis.setLayout(new BoxLayout(panelPregSatis, BoxLayout.Y_AXIS));
		
		//panel para pregunta larga
		JPanel panelPregLarga = new JPanel();
		panelPregLarga.setBounds(0, 0, 433, 228);
		layeredPane.add(panelPregLarga);
		panelPregLarga.setLayout(new BoxLayout(panelPregLarga, BoxLayout.Y_AXIS));
		
		
		
		if(auxpre[1].equals("test")){//en String[] habra: 0->idpreg, 1->tipo ,2 ->pregunta, n-1->posi resp del tipo, n->resp
			
			//esto cambia las capas para q se vea solo el panel que quiero mostrar
			layeredPane.setLayer(panelPregTest, new Integer(2));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregSatis, new Integer(1));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregLarga, new Integer(0));//Cambia la capa del componente. El segundo  argumento indica la capa
			
			JLabel lblPreguntaTest = new JLabel(auxpre[2]);
			panelPregTest.add(lblPreguntaTest);

			JRadioButton rdbtnResUno = new JRadioButton(auxpre[3]);
			panelPregTest.add(rdbtnResUno);

			JRadioButton rdbtnResDos = new JRadioButton(auxpre[4]);
			panelPregTest.add(rdbtnResDos);

			JRadioButton rdbtnResTres = new JRadioButton(auxpre[5]);
			panelPregTest.add(rdbtnResTres);

			JRadioButton rdbtnResCuatro = new JRadioButton(auxpre[5]);
			panelPregTest.add(rdbtnResCuatro);
			

		}else if(auxpre[1].equals("satisfaccion")){//en String[] habra: 0->idpreg, 1->tipo ,2 ->pregunta, n-1->posi resp del tipo, n->resp
			
			//esto cambia las capas para q se vea solo el panel que quiero mostrar
			layeredPane.setLayer(panelPregTest, new Integer(0));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregSatis, new Integer(2));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregLarga, new Integer(1));//Cambia la capa del componente. El segundo  argumento indica la capa

			JLabel lblPreguntaSatis = new JLabel(auxpre[2]);
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

		}else if(auxpre[1].equals("corta_larga")){//en String[] habra: 0->idpreg, 1->tipo ,2 ->pregunta, n-1->posi resp del tipo, n->resp
			
			//esto cambia las capas para q se vea solo el panel que quiero mostrar
			layeredPane.setLayer(panelPregTest, new Integer(0));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregSatis, new Integer(1));//Cambia la capa del componente. El segundo  argumento indica la capa
			layeredPane.setLayer(panelPregLarga, new Integer(2));//Cambia la capa del componente. El segundo  argumento indica la capa
			
			JLabel lblPreguntaLarga = new JLabel(auxpre[2]);
			panelPregLarga.add(lblPreguntaLarga);

			textRespLarga = new JTextField();
			panelPregLarga.add(textRespLarga);
			textRespLarga.setColumns(30);
		}
		
				
			/*esta la he quitado porq da lo mismo no tiene sentido diferenciarla las pantallas seran iguales
			 * 
			 * 
			 * //panel para pregunta corta
				
			JPanel panelPregCorta = new JPanel();
			panelPregCorta.setBounds(0, 0, 433, 228);
			layeredPane.add(panelPregCorta);
			panelPregCorta.setLayout(new BoxLayout(panelPregCorta, BoxLayout.Y_AXIS));
			
				JLabel lblPreguntaCorta = new JLabel("New label");
				panelPregCorta.add(lblPreguntaCorta);
				
				textField = new JTextField();
				panelPregCorta.add(textField);
				textField.setColumns(10);
			 */
				
		//panel de los botones
		JPanel panelBotones = new JPanel();
		frmResponderCuestionario.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			//muestra la pregunta anterior
			JButton btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					indicePreg--;
					
				}
			});
			panelBotones.add(btnAnterior);
			
			//muestra la siguiente pregunta
			JButton btnSiguiente = new JButton("Siguiente");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					indicePreg++;
				}
			});
			panelBotones.add(btnSiguiente);
				
	}
	private String[] obtenerPregunta(int pIndice){
		String[] pregunta = null;
		
		return pregunta;
		
	}
	private void rellenarLista(){
		//en String[] habra: 0->idpreg, 1->tipo ,2 ->pregunta, n-1->posi resp del tipo, n->resp
		LinkedList<Pregunta> lp = cuestionario.getPreguntas();
		for (Pregunta pregunta : lp) {
			//modelo.addElement(pregunta);
			String[] p=null;
			p[0]=""+pregunta.getId();
			p[1]=pregunta.getTipoPreg();
			p[2]=pregunta.getTitulo();
			if(p[1].equals("test")){
				PreguntaTest pt=(PreguntaTest) pregunta;
				String [] res=pt.getRespuestasPosibles();
				p[3]=res[0];
				p[4]=res[1];
				p[5]=res[2];
				p[6]=res[3];
			}
			pregRes.add(p);
		}
			
	}
	private void refrescar(){
		
	}
	
}
