package actionevent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.regex.Pattern;

public class CustomerKYC extends JFrame implements ActionListener {
	JLabel success, error, lbl_fullname, lbl_email, lbl_contact, lbl_address, selectedFileLabel;
	JButton submit, reset, chooseFile;
	JPanel panel;
	JTextField full_name, email, contact, address;
	JComboBox<String> gender;
	JFileChooser select_file;
	JCheckBox accept;
	
	public CustomerKYC() {
		setTitle("DAV KYC Form");
		setBounds(100, 150, 900, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 10, 8, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		// Full Name
		lbl_fullname = new JLabel("Full Name: ");
		full_name = new JTextField();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		panel.add(lbl_fullname, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.8;
		panel.add(full_name, gbc);


		// Email
		lbl_email = new JLabel("Email: ");
		email = new JTextField();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		panel.add(lbl_email, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.8;
		panel.add(email, gbc);


		// Contact
		lbl_contact = new JLabel("Contact: ");
		contact = new JTextField();

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.2;
		panel.add(lbl_contact, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.8;
		panel.add(contact, gbc);


		// Address
		lbl_address = new JLabel("Address: ");
		address = new JTextField();

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		panel.add(lbl_address, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.8;
		panel.add(address, gbc);


		// Gender
		gender = new JComboBox<>();
		gender.addItem("Female");
		gender.addItem("Male");
		gender.addItem("Others");

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.2;
		panel.add(new JLabel("Gender: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.8;
		panel.add(gender, gbc);


		// File chooser
		select_file = new JFileChooser();

		chooseFile = new JButton("Choose File");
		selectedFileLabel = new JLabel("No file selected");

		JPanel filePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		filePanel.add(chooseFile);
		filePanel.add(selectedFileLabel);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.2;
		panel.add(new JLabel("Document: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 0.8;
		panel.add(filePanel, gbc);

		chooseFile.addActionListener(this);
		
		// Terms
		accept = new JCheckBox();

		JLabel terms = new JLabel(
		    "I accept all the terms and conditions of DAV College."
		);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 0.2;
		panel.add(accept, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.weightx = 0.8;
		panel.add(terms, gbc);


		// Buttons
		reset = new JButton("RESET");
		submit = new JButton("SUBMIT");

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 0.5;
		panel.add(reset, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.weightx = 0.5;
		panel.add(submit, gbc);


		// Event listeners
		reset.addActionListener(this);
		submit.addActionListener(this);

		// Add panel
		add(panel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == reset) {
			resetForm();
		} else if (e.getSource() == submit) {
			try {
				submitForm();
			} catch (Exception error) {
				System.err.println(error.getStackTrace());
			}
		} else if(e.getSource() == chooseFile) {

			int result = select_file.showOpenDialog(this);

		    if(result == JFileChooser.APPROVE_OPTION) {

		        File selectedFile = select_file.getSelectedFile();

		        System.out.println(
		            "Selected File: " + selectedFile.getAbsolutePath()
		        );

		        selectedFileLabel.setText(selectedFile.getName());
		    }
	    }
	}
	
	public void resetForm() {
		int status = JOptionPane.showConfirmDialog(rootPane, "Reset KYC Form", 
				"Do you want to reset form?", JOptionPane.OK_CANCEL_OPTION);
		if(status == 0) { // status 0 means OK and status 2 means CANCEL
			full_name.setText("");
			email.setText("");
			contact.setText("");
			address.setText("");
		}
	}
	
	public void submitForm() throws Exception{
		if(!accept.isSelected()) {
			JOptionPane.showMessageDialog(rootPane, "Please accept the terms and conditions first");
		} else {
			String input_name = full_name.getText();
			String input_email = email.getText();
			String input_contact = contact.getText();
			String input_address = address.getText();
			// for Validating Email address: RegularExpression
			String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			if(!Pattern.matches(email_regex, input_email)) {
				JOptionPane.showMessageDialog(rootPane, "Invalid Email Format");
				return;
			}
			// for validating Nepali Phone number: RegularExpression
			String contact_regex = "^(97|98)[0-9]{8}$";
			if(!Pattern.matches(contact_regex, input_contact)) {
				JOptionPane.showMessageDialog(rootPane, "Invalid Contact Format");
				return;
			}
			String input_gender = gender.getSelectedItem().toString();
			try {
				File selectedFile = select_file.getSelectedFile();

				if(selectedFile == null) {

				    JOptionPane.showMessageDialog(
				        rootPane,
				        "Please select a file first"
				    );

				} else {

				    String file_name = selectedFile.getName();

				    System.out.println("File Name: " + file_name);
				    System.out.println("Full Name: " + input_name);
				    System.out.println("Email: " + input_email);
				    System.out.println("Address: " + input_address);
				    System.out.println("Contact: " + input_contact);
				    System.out.println("Gender: " + input_gender);
				}
			} catch(Exception e) {
				System.err.println(e.getStackTrace());
			}
		}
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new CustomerKYC();
			}
		});
	}
}
