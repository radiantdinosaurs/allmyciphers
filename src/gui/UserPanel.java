package gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ciphers.*;
import util.DimensionUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UserPanel extends JPanel implements ActionListener {
	/********************************************
	 * Local Variables
	 ********************************************/

	private JPanel row1, row2, row3, row4, content;
	private JButton encrypt, decrypt, clear;
	private JComboBox cipherOptions;
	private JTextArea console;
	private JTextField keywordField, messageField, resultField;
	private JLabel resultLabel;
	private JScrollPane scroll;
	private ArrayList<String> cipherTypes;
	private Caesar caesar;
	private Vigenere vigenere;
	private Atbash atbash;
	final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int fontSize = DimensionUtil.computerBaseFontSize(screenSize.width, screenSize.height);
	Font font = new Font("Arial", Font.PLAIN,fontSize);

	@SuppressWarnings("unchecked")
	public UserPanel(){
		vigenere = new Vigenere();
		caesar = new Caesar();
		atbash = new Atbash();
		cipherOptions = new JComboBox(getCipherNames().toArray());
		cipherOptions.addActionListener(this);
		cipherOptions.setFont(font);
		createKeywordField();
		createMessageField();
		createEncryptButton();
		createDecryptButton();
		createClearButton();
		createConsole();
		add(createFirstRow());
		add(createSecondRow());
		add(createThirdRow());
		add(createFourthRow());
		setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/2));
		setVisible(true);
	}

	private ArrayList<String> getCipherNames() {
		ArrayList<String> cipherNames = new ArrayList<>();
		cipherNames.add(Vigenere.class.getSimpleName());
		cipherNames.add(Caesar.class.getSimpleName());
		cipherNames.add(Atbash.class.getSimpleName());

		return cipherNames;
	}

	private JTextField createKeywordField() {
		keywordField = new JTextField("Keyword here...",15);
		keywordField.setMargin(new Insets(5,5,5,5));
		keywordField.setFont(font);
		return keywordField;
	}

	private JPanel createFirstRow() {
		row1 = new JPanel();
		row1.setLayout(new GridBagLayout());
		row1.add(cipherOptions);
		row1.add(keywordField);
		row1.setVisible(true);
		return row1;
	}

	private JButton createEncryptButton() {
		encrypt = new JButton("encrypt");
		encrypt.setFont(font);
		encrypt.addActionListener(this);
		return encrypt;
	}

	private JButton createDecryptButton() {
		decrypt = new JButton("decrypt");
		decrypt.addActionListener(this);
		decrypt.setFont(font);
		return decrypt;
	}

	private JButton createClearButton() {
		clear = new JButton("Clear");
		clear.addActionListener(this);
		clear.setFont(font);
		return clear;
	}

	private JTextField createMessageField() {
		messageField = new JTextField("Message here...", 20);
		messageField.setMargin(new Insets(5,5,5,5));
		messageField.setFont(font);
		return messageField;
	}

	private JPanel createSecondRow() {
		row2 = new JPanel();
		row2.setLayout(new FlowLayout());
		row2.add(messageField);
		row2.add(encrypt);
		row2.add(decrypt);
		row2.add(clear);
		return row2;
	}

	private JTextArea createConsole() {
		console = new JTextArea(10, 75);
		console.setEditable(false);
		console.setMargin(new Insets(10,10,10,10));
		console.setFont(font);
		console.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		return console;
	}

	private JPanel createThirdRow() {
		scroll = new JScrollPane(console);
		row3 = new JPanel();
		row3.setLayout(new FlowLayout());
		row3.add(scroll);
		return row3;
	}

	private JLabel createResultLabel() {
		resultLabel = new JLabel("Your results");
		resultLabel.setFont(font);
		resultLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		return resultLabel;
	}

	private JTextField createResultField() {
		resultField = new JTextField("Your results come out here...", 50);
		resultField.setEditable(false);
		resultField.setMargin(new Insets(3,3,3,3));
		resultField.setFont(font);
		return resultField;
	}

	private JPanel createFourthRow() {
		row4 = new JPanel();
		row4.setLayout(new FlowLayout());
		row4.add(createResultLabel());
		row4.add(createResultField());
		return row4;
	}

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
		else if(e.getSource()== encrypt){
			String keyword = keywordField.getText().trim();
			String message = messageField.getText().trim();
			String option = (String)cipherOptions.getSelectedItem();
			String result;
			if(option.equals("Vigenere")) result = vigenere.cryptify(keyword, message, console);
			else if(option.equals("Caesar")) result = caesar.checkForErrorAndPrintEncoded(Integer.parseInt(keyword), message);
			else if(option.equals("Atbash")) result = atbash.encode(message);
			else result = "";
			//clearFields();
			resultField.setText(result);
		}//end elseif
		else if(e.getSource()== decrypt){
			String keyword = keywordField.getText().trim();
			String message = messageField.getText().trim();
			String option = (String)cipherOptions.getSelectedItem();
			String result;
			if(option.equals("Vigenere")) result = vigenere.decryptify(keyword, message, console);
			else if(option.equals("Caesar")) result = caesar.checkForErrorAndPrintDecoded(Integer.parseInt(keyword), message);
			else if(option.equals("Atbash")) result = atbash.decode(message);
			else result = "";
			resultField.setText(result);

		}
	}//end actionPerformed

}
