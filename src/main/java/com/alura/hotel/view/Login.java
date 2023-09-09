
package com.alura.hotel.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.hotel.Controller.UserController;
import com.alura.hotel.Dao.userDAO;
import com.alura.hotel.Model.User;

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
import java.util.List;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	private UserController userController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		this.userController = new UserController();
		
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
		imgHotel.setIcon(new ImageIcon(Login.class.getResource("/images/Hotel6.jpg")));
		
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
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);
		
		JLabel labelTitulo = new JLabel("INICIAR SESIÓN");
		labelTitulo.setBackground(new Color(0, 255, 255));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(SystemColor.textHighlight);
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(65, 149, 279, 26);
		panel.add(labelTitulo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 393, 324, 2);
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
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 353, 324, 32);
		panel.add(txtContrasena);
		
		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(65, 219, 107, 26);
		panel.add(LabelUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(SystemColor.textInactiveText);
		lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasea.setBounds(65, 316, 140, 26);
		panel.add(lblContrasea);
		
		final JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login(txtUsuario.getText());
			}
		});
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setBounds(0, 0, 122, 44);
		btnLogin.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/lOGO-50PX.png")));
		lblNewLabel_1.setBounds(166, 60, 48, 59);
		panel.add(lblNewLabel_1);
		
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
		
		JPanel NuevoUsuariobtn = new JPanel();
		NuevoUsuariobtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NuevoUsuariobtn.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				NuevoUsuariobtn.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				NuevoUsuario newUser = new NuevoUsuario();
				newUser.setVisible(true);
				dispose();
			}
		});
		NuevoUsuariobtn.setLayout(null);
		NuevoUsuariobtn.setBackground(SystemColor.textHighlight);
		NuevoUsuariobtn.setBounds(213, 431, 174, 44);
		panel.add(NuevoUsuariobtn);
		
		JLabel lblNuevoUsuario = new JLabel("NUEVO USUARIO");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setForeground(SystemColor.controlLtHighlight);
		lblNuevoUsuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNuevoUsuario.setBounds(0, 0, 174, 44);
		NuevoUsuariobtn.add(lblNuevoUsuario);
		lblNuevoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}
	

	private void Login(String username) {
	     
	    User user = userController.getUserByUserName(username.toLowerCase());

        String contrase = new String (txtContrasena.getPassword());
        try {
        if(txtUsuario.getText().equals(user.getUserName()) && contrase.equals(user.getPassword())){
            MenuUsuario menu = new MenuUsuario();
            menu.setVisible(true);
            dispose();	 
        }else {
            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
        }
        }catch(NullPointerException e) {
        	JOptionPane.showMessageDialog(new JFrame(), "Usuario o Contraseña no válido");
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
