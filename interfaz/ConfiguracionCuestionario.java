package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConfiguracionCuestionario extends JFrame {

	private JFrame frmConfiguracinCuestionario;

	//Constructora
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguracionCuestionario window = new ConfiguracionCuestionario(null);
					window.frmConfiguracinCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfiguracionCuestionario(String usuario) {
		initialize();
	}
	
	//Getter para llamar el frame desde otra ventana
	public JFrame getFrmConfiguracinCuestionario() {
		return frmConfiguracinCuestionario;
	}

	
	
	//Window
	private void initialize() {
		frmConfiguracinCuestionario = new JFrame();
		frmConfiguracinCuestionario.setTitle("Configuraci\u00F3n de Cuestionarios");
		frmConfiguracinCuestionario.setBounds(100, 100, 450, 300);
		frmConfiguracinCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfiguracinCuestionario.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmConfiguracinCuestionario.getContentPane().add(panel, BorderLayout.SOUTH);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmConfiguracinCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		JButton btnAadirCuestionario = new JButton("A\u00F1adir Cuestionario");
		panel.add(btnAadirCuestionario);
		
		JButton btnAtras = new JButton("      Atras       ");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioSesion frame = new InicioSesion();
				frame.getFrmLogicgroup().setVisible(true);
				frmConfiguracinCuestionario.dispose();
			}
		});
		panel.add(btnAtras);
	}
}
