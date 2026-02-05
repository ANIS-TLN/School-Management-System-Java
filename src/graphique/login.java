package graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;

	public login() {
		
		
		setTitle("AN SCHOLL");
		setSize(900,450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(74, 31, 61));
		panel.setBounds(0, 0, 450, 413);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/photo/scoll.png")));
		lblNewLabel.setBounds(174, 66, 104, 82);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("AN    SCHOLL");
		lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setForeground(new Color(168, 79, 84));
		lblNewLabel_3.setBounds(141, 197, 189, 49);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(168, 79, 84));
		panel_1.setBounds(446, 0, 440, 413);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username.setText("");
			}
		});
		username.addFocusListener(new FocusAdapter() {
			
		});
		username.setForeground(new Color(255, 255, 255));
		username.setCaretColor(new Color(255, 255, 255));
		username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		username.setText("Username");
		username.setBorder(null);
		username.setBackground(new Color(168, 79, 84));
		username.setBounds(167, 93, 188, 39);
		panel_1.add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass.setText("");
			}
		});
		pass.addFocusListener(new FocusAdapter() {
		});
		pass.setForeground(new Color(255, 255, 255));
		pass.setText("PASSWORD");
		pass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		pass.setBorder(null);
		pass.setBackground(new Color(168, 79, 84));
		pass.setBounds(167, 169, 188, 39);
		panel_1.add(pass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(167, 134, 188, 25);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(167, 208, 188, 25);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/photo/icons8-user-50.png")));
		lblNewLabel_1.setBounds(86, 93, 58, 50);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/photo/lock .png")));
		lblNewLabel_2.setBounds(86, 169, 58, 50);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new menu().setVisible(true);
			    dispose();
				if("admin".equals(username.getText()) || "admin".equals(String.valueOf(pass.getPassword())))
				{
				    new menu().setVisible(true);
				    dispose();
				    JOptionPane.showMessageDialog(null, "connection successful avec les donner :)");

					

					
				}
				else if ("".equals(username.getText()) || "".equals(String.valueOf(pass.getPassword())))
				{
					JOptionPane.showMessageDialog(null, "Donner le Nom d'utilisateur et le mot de passe :)", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(162,79,70));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(168, 79, 84));
		panel_2.setBounds(150, 289, 128, 39);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("   Sign In");

		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(0, 0, 128, 39);
		panel_2.add(lblNewLabel_4);
		 
		


	}
	

}
