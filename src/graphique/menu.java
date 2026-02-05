package graphique;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JFrame {


	Connection con ;
	public menu() {
		
 

		setTitle("AN SCHOLL");
		setSize(1200,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		

		
		JPanel avocats = new JPanel();
		avocats.setBounds(442, 276, 145, 139);
		avocats.setToolTipText("asdfafadsfasf");
		avocats.setBackground(new Color(216, 216, 216));
		avocats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	mouseEnter(avocats);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	mouseExit(avocats);
            }
 
            public void mousePressed(java.awt.event.MouseEvent evt) {    	
            	new ensignant().setVisible(true);
            	dispose();
            	
            }
        });
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(avocats);
		avocats.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(menu.class.getResource("/photo/tt.png")));
		lblNewLabel_5.setBounds(41, 10, 74, 101);
		avocats.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_2_1_1_2 = new JLabel(" ensignant ");
		lblNewLabel_3_2_1_1_2.setForeground(new Color(74, 31, 61));
		lblNewLabel_3_2_1_1_2.setFont(new Font("Ubuntu", Font.BOLD, 23));
		lblNewLabel_3_2_1_1_2.setBounds(10, 106, 135, 33);
		avocats.add(lblNewLabel_3_2_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1540, 238);
		panel.setBackground(new Color(74, 31, 61));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logiciel De Gestion D'une Ecole Prive");
		lblNewLabel.setForeground(new Color(168, 79, 84));
		lblNewLabel.setBounds(10, 10, 605, 73);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(27, 10, 111, 100);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_2_1 = new JLabel("vous trouvez tous les services ici");
		lblNewLabel_2_1.setForeground(new Color(168, 79, 84));
		lblNewLabel_2_1.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(20, 76, 294, 34);
		panel.add(lblNewLabel_2_1);
		
		JPanel ELEVE = new JPanel();
		ELEVE.setBounds(269, 276, 145, 139);
		ELEVE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ELEVE.setBackground(new Color(200, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ELEVE.setBackground(new Color(216, 216, 216));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dispose(); new eleve_v().setVisible(true);
				
			}
		});
		ELEVE.setLayout(null);
		ELEVE.setBackground(new Color(216, 216, 216));
		getContentPane().add(ELEVE);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(menu.class.getResource("/photo/student11.png")));
		lblNewLabel_7.setBounds(34, 0, 87, 107);
		ELEVE.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("eleve");
		lblNewLabel_3_2_1_1.setForeground(new Color(74, 31, 61));
		lblNewLabel_3_2_1_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_3_2_1_1.setBounds(40, 106, 81, 33);
		ELEVE.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("                                                                               BY ANIS ~ TL'n");
		lblNewLabel_2_1_1.setForeground(new Color(168, 79, 84));
		lblNewLabel_2_1_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(892, 669, 294, 34);
		getContentPane().add(lblNewLabel_2_1_1);
		
		JPanel parrametre = new JPanel();
		parrametre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new scolarité().setVisible(true);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				parrametre.setBackground(new Color(200, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				parrametre.setBackground(new Color(216, 216, 216));
			}
		});
		parrametre.setLayout(null);
		parrametre.setToolTipText("asdfafadsfasf");
		parrametre.setBackground(new Color(216, 216, 216));
		parrametre.setBounds(619, 276, 145, 139);
		getContentPane().add(parrametre);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(menu.class.getResource("/photo/v.png")));
		lblNewLabel_10.setBounds(45, 10, 65, 86);
		parrametre.add(lblNewLabel_10);
		
		JLabel lblNewLabel_3_2_1_1_5_1 = new JLabel("scolarité");
		lblNewLabel_3_2_1_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1_1_5_1.setForeground(new Color(74, 31, 61));
		lblNewLabel_3_2_1_1_5_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_3_2_1_1_5_1.setBounds(10, 106, 125, 33);
		parrametre.add(lblNewLabel_3_2_1_1_5_1);
		
		JPanel rendezVous = new JPanel();
		rendezVous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new info().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				rendezVous.setBackground(new Color(200, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rendezVous.setBackground(new Color(216, 216, 216));
			}
		});
		rendezVous.setLayout(null);
		rendezVous.setBackground(new Color(216, 216, 216));
		rendezVous.setBounds(525, 445, 145, 139);
		getContentPane().add(rendezVous);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(menu.class.getResource("/photo/ll.png")));
		lblNewLabel_3.setBounds(34, 10, 81, 100);
		rendezVous.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2_1_1_3 = new JLabel(" AN SCHOLL");
		lblNewLabel_3_2_1_1_3.setForeground(new Color(74, 31, 61));
		lblNewLabel_3_2_1_1_3.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_3_2_1_1_3.setBounds(0, 106, 135, 33);
		rendezVous.add(lblNewLabel_3_2_1_1_3);
		
		JPanel domaines = new JPanel();
		domaines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new cour().setVisible(true);;
				dispose();
			}


			@Override
			public void mouseEntered(MouseEvent e) {
				domaines.setBackground(new Color(200, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				domaines.setBackground(new Color(216, 216, 216));
			}
		});
		domaines.setLayout(null);
		domaines.setBackground(new Color(216, 216, 216));
		domaines.setBounds(798, 276, 145, 139);
		getContentPane().add(domaines);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(menu.class.getResource("/photo/pp.png")));
		lblNewLabel_6.setBounds(40, 15, 60, 81);
		domaines.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("programme");
		lblNewLabel_3_2_1.setForeground(new Color(74, 31, 61));
		lblNewLabel_3_2_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_3_2_1.setBounds(10, 106, 135, 33);
		domaines.add(lblNewLabel_3_2_1);
				
		
		
		
		setVisible(true);

		
	}
	
	

	
	public static ImageIcon changeScale(ImageIcon img) {
		Image simg = img.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		return new ImageIcon(simg);
		
	}
	
	
	public void mouseEnter(JPanel p) {
		p.setBackground(new Color(200, 200, 200));

	}
	
	public void mouseExit(JPanel p) {
		p.setBackground(new Color(216, 216, 216));

	}
}
