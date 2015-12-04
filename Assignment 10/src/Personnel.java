import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Personnel extends JApplet {
	
	JButton addButton;
	JTextField nameField;
	JTextField posField;
	JTextField payField;
	
	public void init() {
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		
		
		JLabel nameLabel = new JLabel("Name");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(nameLabel, gbc);
		
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(120,25));
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(nameField, gbc);
		
		JLabel posLabel = new JLabel("Position");
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(posLabel, gbc);
		
		posField = new JTextField();
		posField.setPreferredSize(new Dimension(120,25));
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(posField, gbc);
		
		JLabel payLabel = new JLabel("Hourly Pay Rate");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(payLabel, gbc);
		
		payField = new JTextField();
		payField.setPreferredSize(new Dimension(120,25));
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(payField, gbc);
		
		addButton = new JButton("Add");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		addButton.addActionListener(new Listener());
		add(addButton, gbc);
		
		JLabel prompt = new JLabel("Add Employee");
		prompt.setFont(new Font("Arial", Font.BOLD, 16));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(prompt, gbc);
	}
	
	public class Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == addButton){
				try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/personnel", "root", "");
				
				Statement stmt = con.createStatement();
				
				String sql = "INSERT INTO employee(`name`, `position`, `hourly pay rate`) "
						+ "VALUES('"+ nameField.getText() + "','" + posField.getText() + "','" + payField.getText() + "')";
				
				stmt.executeUpdate(sql);
				
				con.close();
				
				System.exit(0);
				}
				catch(Exception ex){
					System.out.println("ERROR: " + ex.getMessage());
				}
			}
		}
	}

}
