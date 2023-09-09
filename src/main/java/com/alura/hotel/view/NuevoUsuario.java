
package com.alura.hotel.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.hotel.Controller.UserController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class NuevoUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JPasswordField confirmarContrasena;
	private UserController userController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario();
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
	public NuevoUsuario() {
		
		this.userController =  new UserController();
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(415, 0, 373, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JPanel btnexit = new JPanel();
		btnexit.setBounds(310, 0, 63, 36);
		panel_1.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 63, 36);
		btnexit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);		
		
		JLabel imgHotel = new JLabel("");
		imgHotel.setBounds(-127, -206, 640, 832);
		panel_1.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(NuevoUsuario.class.getResource("/images/Hotel5.jpg")));
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					 txtUsuario.setText("");
					 txtUsuario.setForeground(Color.black);
			        }
			        if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
			        	txtContrasena.setText("********");
			        	txtContrasena.setForeground(Color.gray);
			        }
					if (String.valueOf(confirmarContrasena.getPassword()).isEmpty()) {
			    	confirmarContrasena.setText("********");
			    	confirmarContrasena.setForeground(Color.gray);
			    	}
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 161, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(65, 197, 324, 2);
		panel.add(separator);
		
		JLabel labelTitulo = new JLabel("NUEVO USUARIO");
		labelTitulo.setBackground(new Color(0, 255, 255));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(SystemColor.textHighlight);
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(110, 56, 279, 26);
		panel.add(labelTitulo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 300, 324, 2);
		panel.add(separator_1);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setText("********");
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
		        }
		        if (txtUsuario.getText().isEmpty()) {
		        	txtUsuario.setText("Ingrese su nombre de usuario");
		        	txtUsuario.setForeground(Color.gray);
		        }
				if (String.valueOf(confirmarContrasena.getPassword()).isEmpty()) {
		    	confirmarContrasena.setText("********");
		    	confirmarContrasena.setForeground(Color.gray);
				}
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 258, 324, 32);
		panel.add(txtContrasena);
		
		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(65, 124, 107, 26);
		panel.add(LabelUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(SystemColor.textInactiveText);
		lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasea.setBounds(65, 221, 140, 26);
		panel.add(lblContrasea);
		
		final JPanel btnCrearUsuario = new JPanel();
		btnCrearUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearUsuario.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearUsuario.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = txtUsuario.getText().toLowerCase();
				String password = new String(txtContrasena.getPassword()).toLowerCase();
				String password2 = new String(confirmarContrasena.getPassword()).toLowerCase();
				
				if(password.equals(password2) && !txtUsuario.getText().isEmpty()) {
					userController.saveUser(username, password);
					UsuarioCreado newUser = new UsuarioCreado();
					newUser.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Por favor revisa el Usuario o Contraseña");
				}

			}
		});
		btnCrearUsuario.setBackground(SystemColor.textHighlight);
		btnCrearUsuario.setBounds(65, 431, 188, 44);
		panel.add(btnCrearUsuario);
		btnCrearUsuario.setLayout(null);
		btnCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("CREAR USUARIO");
		lblNewLabel.setBounds(0, 0, 188, 44);
		btnCrearUsuario.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
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
		header.setBackground(SystemColor.window);
		header.setBounds(4, 0, 784, 36);
		panel.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(48, 35, 48, 59);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(NuevoUsuario.class.getResource("/images/lOGO-50PX.png")));
		
		JLabel lblConfirmarContrasea = new JLabel("CONFIRMAR CONTRASEÑA");
		lblConfirmarContrasea.setForeground(SystemColor.textInactiveText);
		lblConfirmarContrasea.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblConfirmarContrasea.setBounds(65, 324, 279, 26);
		panel.add(lblConfirmarContrasea);
		
		confirmarContrasena = new JPasswordField();
		confirmarContrasena.setForeground(SystemColor.activeCaptionBorder);
		confirmarContrasena.setFont(new Font("Dialog", Font.PLAIN, 16));
		confirmarContrasena.setText("********");
		confirmarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(confirmarContrasena.getPassword()).equals("********")) {
					confirmarContrasena.setText("");
					confirmarContrasena.setForeground(Color.black);
		        }
			if (txtUsuario.getText().isEmpty()) {
	        	txtUsuario.setText("Ingrese su nombre de usuario");
	        	txtUsuario.setForeground(Color.gray);
	        }if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
	        	txtContrasena.setText("********");
	        	txtContrasena.setForeground(Color.gray);
	        }
		}});

		confirmarContrasena.setBounds(65, 360, 324, 32);
		confirmarContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(confirmarContrasena);


		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(SystemColor.textHighlight);
		separator_1_1.setBounds(65, 402, 324, 2);
		panel.add(separator_1_1);
	}
	
	private void Login() {
		 String Usuario= "admin";
	     String Contraseña="admin";

	        String contrase=new String (txtContrasena.getPassword());

	        if(txtUsuario.getText().equals(Usuario) && contrase.equals(Contraseña)){
	            MenuUsuario menu = new MenuUsuario();
	            menu.setVisible(true);
	            dispose();	 
	        }else {
	            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
	        }
	} 
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }//GEN-LAST:event_headerMousePressed

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
