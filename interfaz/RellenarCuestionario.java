package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

public class RellenarCuestionario {

	private JFrame frmRellenarCuestionario;

	//Constructora
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RellenarCuestionario window = new RellenarCuestionario(null);
					window.frmRellenarCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RellenarCuestionario(String usuario) {
		initialize();
	}


	//Getter para llamar desde otra ventana
	public JFrame getFrmRellenarCuestionario() {
		return frmRellenarCuestionario;
	}

	//window
	private void initialize() {
		frmRellenarCuestionario = new JFrame();
		frmRellenarCuestionario.setTitle("Rellenar Cuestionario");
		frmRellenarCuestionario.setBounds(100, 100, 450, 300);
		frmRellenarCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRellenarCuestionario.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmRellenarCuestionario.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("   Salir   ");
		panel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmRellenarCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
