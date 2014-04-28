package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import logica.Pregunta;

public class ConsultarCuestionarioX {

	private JFrame frmConsultarCuestionarioX;
	private LinkedList<Pregunta> lp;
	private int act;
	private DefaultListModel<String> modelo;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCuestionarioX window = new ConsultarCuestionarioX();
					window.frmConsultarCuestionarioX.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ConsultarCuestionarioX(LinkedList<Pregunta> pLPreguntas, int actual) {
		lp = pLPreguntas;
		act = actual;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarCuestionarioX = new JFrame();
		frmConsultarCuestionarioX.setTitle("Consultar Cuestionario X");
		frmConsultarCuestionarioX.setBounds(100, 100, 450, 266);
		frmConsultarCuestionarioX.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultarCuestionarioX.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sur = new JPanel();
		frmConsultarCuestionarioX.getContentPane().add(panel_sur, BorderLayout.SOUTH);
		panel_sur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				act++;
				if(act>= lp.size()){
					act =0;
				}
				actualizarModelo(act);
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				act--;
				if(act < 0){
					act = lp.size()-1;
				}
				actualizarModelo(act);
			}
		});
		panel_sur.add(btnAtras);
		panel_sur.add(btnSiguiente);
		
		JPanel panel_norte = new JPanel();
		frmConsultarCuestionarioX.getContentPane().add(panel_norte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Titulo pregunta");
		panel_norte.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		frmConsultarCuestionarioX.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultListModel<String>();
		actualizarModelo(act);
		
		JList<String> list = new JList<String>(modelo);
		scrollPane.setViewportView(list);
		
		
		frmConsultarCuestionarioX.setVisible(true);
	}

	private void actualizarModelo(int act) {
		modelo.removeAllElements();
		LinkedList<String> listaRespuestas = lp.get(act).getRespuestas();
		for (String string : listaRespuestas) {
			modelo.addElement(string);
		}
	}

}
