package gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ciphers.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UserPanel extends JPanel implements ActionListener {
	/********************************************
	 * Local Variables
	 ********************************************/
	private JPanel row1, row2, row3, row4, content;
	private JButton Encrypt, Decrypt, clear;
	private JComboBox cipherOptions;
	private JTextArea console;
	private JTextField keywordField, messageField, resultField;
	private JLabel resultLabel;
	private JScrollPane scroll;

	private ArrayList<String> cipherTypes;

	private Caesar caesar;
	private Vigenere vigenere;
	private Atbash atbash;


	/********************************************
	 * Constructors
	 ********************************************/
	@SuppressWarnings("unchecked")
	public UserPanel(){
		vigenere = new Vigenere();
		caesar = new Caesar();
		atbash = new Atbash();

		cipherTypes = new ArrayList<String>();
		cipherTypes.add("Vigenere");
		cipherTypes.add("Caesar");
		cipherTypes.add("Atbash");
		cipherOptions = new JComboBox(cipherTypes.toArray());
		cipherOptions.addActionListener(this);
		keywordField = new JTextField("Keyword here...",15);
		keywordField.setMargin(new Insets(5,5,5,5));
		row1 = new JPanel();
		row1.setPreferredSize(new Dimension(Container.WIDTH, 50));
		row1.setLayout(new FlowLayout());
		row1.add(cipherOptions);
		row1.add(keywordField);
		row1.setVisible(true);

		messageField = new JTextField("Message here...", 20);
		messageField.setMargin(new Insets(5,5,5,5));
		Encrypt = new JButton("Encrypt");
		Encrypt.addActionListener(this);
		Decrypt = new JButton("Decrypt");
		Decrypt.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		row2 = new JPanel();
		row2.setPreferredSize(new Dimension(Container.WIDTH, 50));
		row2.setLayout(new FlowLayout());
		row2.add(messageField);
		row2.add(Encrypt);
		row2.add(Decrypt);
		row2.add(clear);

		console = new JTextArea(10, 75);
		console.setEditable(false);
		console.setMargin(new Insets(10,10,10,10));
		console.setFont(new Font("Courier New",Font.PLAIN,12));
		console.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		scroll = new JScrollPane(console);
		row3 = new JPanel();
		row3.setPreferredSize(new Dimension(Container.WIDTH, 200));
		row3.setLayout(new FlowLayout());
		row3.add(scroll);

		row4 = new JPanel();
		row4.setLayout(new FlowLayout());
		resultLabel = new JLabel("Your results");
		resultLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		resultField = new JTextField("Your results come out here...", 50);
		resultField.setEditable(false);
		resultField.setMargin(new Insets(3,3,3,3));
		resultField.setFont(new Font("Courier New",Font.PLAIN,14));
		row4.add(resultLabel);
		row4.add(resultField);

		add(row1);
		add(row2);
		add(row3);
		add(row4);
		setPreferredSize(new Dimension(Container.WIDTH, 300));
		//setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

		setVisible(true);
	}

	/********************************************
	 * Methods
	 ********************************************/
	public void clearFields(){
		keywordField.setText("");
		console.setText("");
		resultField.setText("");
		messageField.setText("");
	}
	public void DEBUG(){
		System.out.println("row1: "+row1.getSize());
		System.out.println("row2: "+row2.getSize());
		System.out.println("row3: "+row3.getSize());
		System.out.println("content: "+content.getSize());
		System.out.println("userpanel: "+getSize());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear){
			clearFields();
		}//endif
		else if(e.getSource()==cipherOptions){
			String option = (String)cipherOptions.getSelectedItem();
			if(option.equals("Caesar")){

			}
			else if(option.equals("Vigenere")){

			}
			else if(option.equals("Atbash")) {

			}
		}//end elseif
		else if(e.getSource()==Encrypt){
			String keyword = keywordField.getText().trim();
			String message = messageField.getText().trim();
			String option = (String)cipherOptions.getSelectedItem();
			String result;
			if(option.equals("Vigenere")) result = vigenere.cryptify(keyword, message, console);
			else if(option.equals("Caesar")) result = caesar.checkForErrorAndPrintEncoded(Integer.parseInt(keyword), message);
			else if(option.equals("Atbash")) result = atbash.encode(message, console);
			else result = "";
			//clearFields();
			resultField.setText(result);
		}//end elseif
		else if(e.getSource()==Decrypt){
			String keyword = keywordField.getText().trim();
			String message = messageField.getText().trim();
			String option = (String)cipherOptions.getSelectedItem();
			String result;
			if(option.equals("Vigenere")) result = vigenere.decryptify(keyword, message, console);
			else if(option.equals("Caesar")) result = caesar.checkForErrorAndPrintDecoded(Integer.parseInt(keyword), message, console);
			else if(option.equals("Atbash")) result = atbash.decode(message, console);
			else result = "";
			resultField.setText(result);

		}
	}//end actionPerformed

}
