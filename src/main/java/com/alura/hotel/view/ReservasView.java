package com.alura.hotel.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import com.alura.hotel.Controller.ReservationController;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	private ReservationController reservationControl;
	private int valor;
	public static Long id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservasView() {
		
		super("Reserva");
		
		this.reservationControl = new ReservationController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Código que crea los elementos de la interfáz gráfica
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 289, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 289, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 60, 250, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		// Componentes para dejar la interfaz con estilo Material Design
		final JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/images/Ha-100px.png")));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(-185, -476, 1208, 1208);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/images/Hotel12.jpg")));
		
		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 217, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		final JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		
		
		//Campos que guardaremos en la base de datos
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/images/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBackground(new Color(255, 255, 255));
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(new Color(0, 128, 0));
		txtValor.setBounds(68, 328, 289, 33);
		txtValor.setFont(new Font("Dialog", Font.BOLD, 20));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/images/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
				if (txtFechaEntrada.getDate() != null && txtFechaSalida.getDate() != null){
					//Date dateIn = txtFechaEntrada.getDate();
					java.util.Date dateIn = txtFechaEntrada.getDate();
					
					//Date dateOut = txtFechaSalida.getDate();
					java.util.Date dateOut = txtFechaSalida.getDate();
					
					valor = ((valueOfReservation(dateIn, dateOut))-1)*800;
					txtValor.setText("$"+String.valueOf(valor));
				}
				
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);		

		JComboBox<String> txtFormaPago = new JComboBox<String>();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel<String>(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);

		JPanel btnsiguiente = new JPanel();
		btnsiguiente.setToolTipText("");
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {		

					
					java.util.Date dateIn = txtFechaEntrada.getDate(); //Cambio de java.util a java.sql
					java.sql.Date dateInF = new java.sql.Date(dateIn.getTime());

					java.util.Date dateOut = txtFechaSalida.getDate();
					java.sql.Date dateOutF = new java.sql.Date(dateOut.getTime());

					double value = Double.valueOf(valor);
					id = reservationControl.saveReservation(dateInF, dateOutF, value, txtFormaPago.getSelectedItem().toString());
					JOptionPane.showMessageDialog(new JFrame(),"Reserva no." +id +" guardada exitosamente");
					
					RegistroHuesped registro = new RegistroHuesped(id);
					registro.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, no olvides rellenar todos los campos.");
				}

			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("Reservar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 0, 122, 35);
		btnsiguiente.add(lblNewLabel);


	}
		
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	 }
	 
	 private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	 }
	 
	 private int valueOfReservation(Date date, Date date2) {
		    long dateIn = date.getTime();
		    long dateOut = date2.getTime();
		    
		    if (dateOut < dateIn) {
		        long temp = dateIn;
		        dateIn = dateOut;
		        dateOut = temp;
		        JOptionPane.showMessageDialog(null, "La fecha de salida debe ser posterior a la de entrada");
		    }
		    
		    long differenceBtwDates = dateOut - dateIn;
		    int differenceInDays = (int) Math.ceil((double) differenceBtwDates / (24 * 60 * 60 * 1000));
		    
		    return differenceInDays;
	}

  
}
