package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTable;

import logica.GestorCuestionarios;
import logica.Pregunta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ModificarCrearCuestionario {

	private JFrame frmCreacionmodificacionCuestionario;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JPanel panel_1;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JButton btnAnadirPregunta;
	private int idCuestionario = -1;
	private JTable table;
	private JButton btnEliminarPregunta;
	private String usuario;
	private LinkedList<Pregunta> listaPreguntas;


	//Constructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCrearCuestionario window = new ModificarCrearCuestionario("david");
					window.frmCreacionmodificacionCuestionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModificarCrearCuestionario(String pUsuario) {
		usuario = pUsuario;
		initialize();
	}
	public ModificarCrearCuestionario(String pUsuario, int pIdCuestionario) {
		usuario = pUsuario;
		idCuestionario = pIdCuestionario;	
		listaPreguntas = GestorCuestionarios.getGestorCuestionarios().obtenerPreguntasCuestionario(idCuestionario);
		initialize();
	}


	//Getter to call the window
	public JFrame getFrmCreacionmodificacionCuestionario() {
		return frmCreacionmodificacionCuestionario;
	}
	

	//Window
	private void initialize() {
		frmCreacionmodificacionCuestionario = new JFrame();
		frmCreacionmodificacionCuestionario.setTitle("Creacion/Modificacion Cuestionario");
		frmCreacionmodificacionCuestionario.setBounds(100, 100, 488, 455);
		frmCreacionmodificacionCuestionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frmCreacionmodificacionCuestionario.getContentPane().add(panel, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(20);
		
		if (idCuestionario != 0) {
			String nombre = GestorCuestionarios.getGestorCuestionarios().obtenerNombreCuestionario(idCuestionario);
			textFieldNombre.setText(nombre);	
		}		
		
		panel_1 = new JPanel();
		frmCreacionmodificacionCuestionario.getContentPane().add(panel_1, BorderLayout.SOUTH);
		

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmCreacionmodificacionCuestionario.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		actualizarTabla();
		
		btnAnadirPregunta = new JButton("A\u00F1adir pregunta");
		btnAnadirPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Añadimos pregunta
				AnadirPreguntaACuestionario frame = new AnadirPreguntaACuestionario(idCuestionario);
				frame.getFrmAnadirPregunta().setVisible(true);
				frmCreacionmodificacionCuestionario.dispose();
			}
		});
		panel_1.add(btnAnadirPregunta);
		
		btnEliminarPregunta = new JButton("Eliminar Pregunta");
		btnEliminarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Borramos la pregunta seleccionada
				if (idCuestionario != -1){
					int aux = table.getSelectedRow();
					int idPregunta = listaPreguntas.get(aux).getId();
					GestorCuestionarios.getGestorCuestionarios().eliminarPreguntaDeCuestionario(idPregunta, idCuestionario);
					actualizarTabla();
				}
			}
		});
		panel_1.add(btnEliminarPregunta);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Guardamos los datos que existan en pantalla
				if (idCuestionario == -1){
					GestorCuestionarios.getGestorCuestionarios().nuevoCuestionario(textFieldNombre.getText(), usuario);
				}
				else {
					GestorCuestionarios.getGestorCuestionarios().modificarCuestionario(textFieldNombre.getText(), idCuestionario);
				}
				ConfiguracionCuestionario frame = new ConfiguracionCuestionario(usuario);
				frame.getFrmConfiguracinCuestionario().setVisible(true);
				frmCreacionmodificacionCuestionario.dispose();
			}
		});
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfiguracionCuestionario frame = new ConfiguracionCuestionario(usuario);
				frame.getFrmConfiguracinCuestionario().setVisible(true);
				frmCreacionmodificacionCuestionario.dispose();
			}
		});
		panel_1.add(btnCancelar);
		
	}
	
	private void actualizarTabla(){
		//Cargar datos
		if (idCuestionario != -1) {
			//Cargamos el nombre
			listaPreguntas = GestorCuestionarios.getGestorCuestionarios().obtenerPreguntasCuestionario(idCuestionario);
			String nombre = GestorCuestionarios.getGestorCuestionarios().obtenerNombreCuestionario(idCuestionario);
			textFieldNombre.setText(nombre);
			
			
			String[] columnNames = {"ID", "Pregunta"};
			Object[][] data = new Object[listaPreguntas.size()][2];
			
			for (int i = 0; i < listaPreguntas.size(); i++) {
				data[i][0]= listaPreguntas.get(i).getId();
				data[i][1]= listaPreguntas.get(i).getTitulo();
			}
			
			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);
		}
	}
}
