package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import logica.Cuestionario;
import logica.Pregunta;

import javax.swing.JList;

public class CuestionarioX {

	private JFrame frmCuestionarioX;
	private Cuestionario cuestionario;
	private JList<Pregunta> list;
	private LinkedList<Pregunta> lp;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuestionarioX window = new CuestionarioX(null);
					window.frmCuestionarioX.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public CuestionarioX(Cuestionario c) {
		cuestionario = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCuestionarioX = new JFrame();
		frmCuestionarioX.setTitle("Cuestionario "+cuestionario.getNombre());
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
		
		DefaultListModel<Pregunta> modelo = new DefaultListModel<Pregunta>();
		lp = cuestionario.getPreguntas();
		for (Pregunta pregunta : lp) {
			modelo.addElement(pregunta);
		}
		
		list = new JList<Pregunta>(modelo);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ConsultarCuestionarioX(lp, list.getSelectedIndex());
			}
		});
		
		
		frmCuestionarioX.setVisible(true);
	}

}
