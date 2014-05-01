package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JList;

import logica.Cuestionario;
import logica.GestorCuestionarios;

public class ConsultarCuestionario {

	private JFrame frmConsultarCuestionario;
	private String usuario, tipo;
	private JList<Cuestionario> list;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCuestionario window = new ConsultarCuestionario();
					window.frmConsultarCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @param usuario 
	 */
	public ConsultarCuestionario(String pUsuario, String pTipo) {
		usuario=pUsuario;
		tipo=pTipo;
		initialize();
	}
	
	
	
	//Getter para llamar desde otra ventana
	public JFrame getFrmConsultarCuestionario() {
		return frmConsultarCuestionario;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarCuestionario = new JFrame();
		frmConsultarCuestionario.setTitle("Consultar Cuestionario");
		frmConsultarCuestionario.setBounds(100, 100, 450, 300);
		frmConsultarCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmConsultarCuestionario.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Atras");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioSesion frame = new InicioSesion();
				frame.getFrmLogicgroup().setVisible(true);
				frmConsultarCuestionario.dispose();	
			}
		});		
		panel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frmConsultarCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<Cuestionario> modelo = new DefaultListModel<Cuestionario>();
		LinkedList<Cuestionario> listaCuestionarios = GestorCuestionarios.getGestorCuestionarios().obtenerCuestionarios();
		for (Cuestionario cuestionario : listaCuestionarios) {
			modelo.addElement(cuestionario);
		}
		
		list = new JList<Cuestionario>(modelo);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//aqui dependiendo del tipo de usuario que sea se ira a una pantalla u otra 
				if (tipo.equals("consultor")){
					new CuestionarioX(list.getSelectedValue());
				}
				else if (tipo.equals("contestador")){
					new ResponderCuestionario(list.getSelectedValue(),usuario);
				}
			}
		});
		
		
		
		frmConsultarCuestionario.setVisible(true);
	}

}
