package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AnadirPreguntaACuestionario {

	private JFrame frmAnadirPregunta;

	//constructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirPreguntaACuestionario window = new AnadirPreguntaACuestionario(1);
					window.frmAnadirPregunta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public AnadirPreguntaACuestionario(int idCuestionario) {
		initialize();
	}

	
	//Getter to call window
	public JFrame getFrmAnadirPregunta() {
		return frmAnadirPregunta;
	}
	
	
	//window
	private void initialize() {
		frmAnadirPregunta = new JFrame();
		frmAnadirPregunta.setBounds(100, 100, 450, 300);
		frmAnadirPregunta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAnadirPregunta.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnAadirPregunta = new JButton("A\u00F1adir Pregunta");
		panel.add(btnAadirPregunta);
		
		JButton btnNuevaPregunta = new JButton("Nueva Pregunta");
		panel.add(btnNuevaPregunta);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmAnadirPregunta.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
