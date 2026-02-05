package graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class ensignant extends JFrame {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_4;
	private JTable table;
	DefaultTableModel model;
	Connection con;
	private JTable table_1;
	private JTable table_2;
	private JRadioButton rdbtnNewRadioButton;
	
	
	ArrayList < Integer > ensgid = new ArrayList<>();
	
	public ensignant() {
		setTitle("AN SCHOLL");
		setSize(1200,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1196, 713);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1186, 81);
		panel_1.setBackground(new Color(74, 31, 61));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllev = new JLabel("ENSIGNANT ");
		lbllev.setForeground(new Color(168, 79, 84));
		lbllev.setFont(new Font("Dialog", Font.BOLD, 30));
		lbllev.setBounds(71, 3, 247, 59);
		panel_1.add(lbllev);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_2.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_2.setBackground(new Color(168, 79, 84));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
				model.setRowCount(0);
				populateTable();
			}
		});
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_2.setBackground(new Color(168, 79, 84));
		panel_2_1_2.setBounds(396, 20, 128, 39);
		panel_1.add(panel_2_1_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("  SUPPRIME ");
		lblNewLabel_4_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_2.setBounds(0, 0, 128, 39);
		panel_2_1_2.add(lblNewLabel_4_2);
		
		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_3.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_3.setBackground(new Color(168, 79, 84));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updatetb();
				model.setRowCount(0);
				populateTable();
				
			}
		});
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_3.setBackground(new Color(168, 79, 84));
		panel_2_1_3.setBounds(560, 20, 134, 39);
		panel_1.add(panel_2_1_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("    ÉDIT ");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_3.setBounds(10, 0, 128, 39);
		panel_2_1_3.add(lblNewLabel_4_3);
		
		JPanel panel_2_1_4 = new JPanel();
		panel_2_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_4.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_4.setBackground(new Color(168, 79, 84));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
				
			}
		});
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_4.setBackground(new Color(168, 79, 84));
		panel_2_1_4.setBounds(968, 20, 128, 39);
		panel_1.add(panel_2_1_4);
		
		JLabel lblNewLabel_4_4 = new JLabel("   SEARCH");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_4.setBounds(0, 0, 128, 39);
		panel_2_1_4.add(lblNewLabel_4_4);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(74, 31, 61));
		textField_1.setBounds(754, 20, 188, 39);
		panel_1.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(754, 59, 188, 25);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new menu().setVisible(true);dispose();
			}
		});
		lblNewLabel_1.setBounds(0, 0, 61, 51);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ensignant.class.getResource("/photo/left return.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 81, 330, 632);
		panel_2.setBackground(new Color(168, 79, 84));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_1.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1.setBackground(new Color(168, 79, 84));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_4.setText("");
				textField_7.setText("");
				textField_3.setText("");
				textField_2.setText("");
			}
		});
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_1.setBackground(new Color(168, 79, 84));
		panel_2_1_1.setBounds(172, 527, 128, 39);
		panel_2.add(panel_2_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("    CLEAR");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(0, 0, 128, 39);
		panel_2_1_1.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1.setBackground(new Color(168, 79, 84));
			}
			
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				inserten();
				populateTable();
				textField.setText("");
				textField_4.setText("");
				textField_7.setText("");
				textField_3.setText("");
				textField_2.setText("");
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(168, 79, 84));
		panel_2_1.setBounds(10, 527, 128, 39);
		panel_2.add(panel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("   AJOUTER ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4.setBounds(0, 0, 128, 39);
		panel_2_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("NOM");
		lblNewLabel_4_2_1.setBounds(10, 34, 83, 32);
		panel_2.add(lblNewLabel_4_2_1);
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1.setBackground(new Color(74, 31, 61));
		
		textField = new JTextField();
		textField.setBounds(103, 34, 185, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("PRENOM");
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1.setBounds(10, 87, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 87, 185, 32);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("DATE");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2.setBounds(10, 144, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 147, 185, 32);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("NAISSANCE ");
		lblNewLabel_4_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1.setBounds(10, 162, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1);
		
		JLabel lblNewLabel_4_2_1_2_2 = new JLabel("MODULÉ ");
		lblNewLabel_4_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_2.setBounds(10, 311, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2_2);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("ENSIGNE ");
		lblNewLabel_4_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1_1.setBounds(10, 329, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1_1);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("GENDER");
		lblNewLabel_4_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_1.setBounds(10, 204, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(103, 258, 185, 32);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_4_2_1_1_1_1 = new JLabel("TÉLÉPHONE ");
		lblNewLabel_4_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_1_1.setBounds(10, 258, 96, 32);
		panel_2.add(lblNewLabel_4_2_1_1_1_1);
		
		rdbtnNewRadioButton = new JRadioButton("HOMME");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Unispace", Font.BOLD, 16));
		rdbtnNewRadioButton.setForeground(new Color(74, 31, 61));
		rdbtnNewRadioButton.setBounds(103, 212, 88, 21);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemme = new JRadioButton("FEMME");
		rdbtnFemme.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnFemme);
		rdbtnFemme.setFont(new Font("Unispace", Font.BOLD, 16));
		rdbtnFemme.setForeground(new Color(74, 31, 61));
		rdbtnFemme.setBounds(212, 212, 88, 21);
		panel_2.add(rdbtnFemme);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 320, 185, 32);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 45, 13);
		panel.add(lblNewLabel);

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anis?user=root&password=anisroot");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    model = new DefaultTableModel();
	    model.addColumn("Nom");
	    model.addColumn("Prenom");
	    model.addColumn("Date de naissance");
	    model.addColumn("Téléphone");
	    model.addColumn("Genre");
	    model.addColumn("Module enseigné");
	    
	    populateTable();
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 81, 856, 632);
		panel.add(scrollPane);
		
		table_2 = new JTable(model);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
				textField_2.setText(table_2.getValueAt(table_2.getSelectedRow(), 1).toString());
		        textField_3.setText(table_2.getValueAt(table_2.getSelectedRow(), 2).toString());
		        textField_7.setText(table_2.getValueAt(table_2.getSelectedRow(), 3).toString());
		        textField_4.setText(table_2.getValueAt(table_2.getSelectedRow(), 5).toString());
		        String genre = table_2.getValueAt(table_2.getSelectedRow(), 4).toString();

		   
		        if (genre.equals("HOMME")) {
		            rdbtnNewRadioButton.setSelected(true);
		        } else if (genre.equals("FEMME")) {
		            rdbtnFemme.setSelected(true);
		        }
				
				
				
			}
		});
		scrollPane.setViewportView(table_2);
		
	    

	}
	
	
	private void populateTable() {
	    try {
	        String query = "SELECT * FROM enseigne";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	ensgid.add(resultSet.getInt("idensg"));
	            String nom = resultSet.getString("first_name");
	            String prenom = resultSet.getString("last_name");
	            String dateNaissance = resultSet.getString("date_of_birth");
	            String telephone = resultSet.getString("phone_number");
	            String genre = resultSet.getString("gender");
	            String moduleEnseigne = resultSet.getString("module_taught");

	            model.addRow(new Object[]{ nom, prenom, dateNaissance, telephone, genre, moduleEnseigne});
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	}
	
	private void inserten() {
	    try {
	        String query = "insert into enseigne (first_name,last_name,date_of_birth,phone_number,gender,module_taught) values (?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, textField.getText());
	        preparedStatement.setString(2, textField_2.getText());
	        preparedStatement.setString(3, textField_3.getText());
	        preparedStatement.setString(4, textField_7.getText());
	        String gg;
	        if(rdbtnNewRadioButton.isSelected()) {
	        	gg = "HOMME";
	        }else {gg = "FEMME";}
	        preparedStatement.setString(5, gg);
	        preparedStatement.setString(6, textField_4.getText());
	        
	        preparedStatement.executeUpdate();
	        JOptionPane.showMessageDialog(this, "added successfully");


	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	}
	
	private void updatetb() {
	    try {
	        int selectedRow = table_2.getSelectedRow();

	        if (selectedRow != -1) {
	            String query = "update enseigne set first_name=?,last_name=?,date_of_birth=?,phone_number=?,gender=?,module_taught=? where idensg=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, textField.getText());
	            preparedStatement.setString(2, textField_2.getText());
	            preparedStatement.setString(3, textField_3.getText());
	            preparedStatement.setString(4, textField_7.getText());
	            String gg;
	            if (rdbtnNewRadioButton.isSelected()) {
	                gg = "HOMME";
	            } else {
	                gg = "FEMME";
	            }
	            preparedStatement.setString(5, gg);
	            preparedStatement.setString(6, textField_4.getText());
	            preparedStatement.setInt(7, ensgid.get(selectedRow));

	            preparedStatement.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Mise à jour effectuée avec succès");
	        } else {
	            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à mettre à jour.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	private void delete() {
	    try {
	        int selectedRow = table_2.getSelectedRow();

	        if (selectedRow != -1) { 
	            String query = "delete from enseigne where idensg=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setInt(1, ensgid.get(selectedRow));
	            preparedStatement.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Supprimé avec succès");          
	            // Après la suppression, supprimez la ligne du modèle
	            model.removeRow(selectedRow);
	            // Enlevez également l'ID de la liste ensgid
	            ensgid.remove(selectedRow);
	        } else {
	            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private void search() {
	    String searchTerm = textField_1.getText().trim();

	    if (!searchTerm.isEmpty()) {
	        // Effacez le modèle de la table avant d'ajouter les résultats de la recherche
	        model.setRowCount(0);

	        try {
	            String query = "SELECT * FROM enseigne WHERE first_name = ?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, searchTerm);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                ensgid.add(resultSet.getInt("idensg"));
	                String nom = resultSet.getString("first_name");
	                String prenom = resultSet.getString("last_name");
	                String dateNaissance = resultSet.getString("date_of_birth");
	                String telephone = resultSet.getString("phone_number");
	                String genre = resultSet.getString("gender");
	                String moduleEnseigne = resultSet.getString("module_taught");

	                model.addRow(new Object[]{ nom, prenom, dateNaissance, telephone, genre, moduleEnseigne});
	            }

	            if (model.getRowCount() == 0) {
	                JOptionPane.showMessageDialog(this, "Aucun résultat trouvé pour : " + searchTerm);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Veuillez entrer un terme de recherche.");
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
