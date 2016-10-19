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
import util.DimensionUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * TODO:
 * If you see classes with inconsistent naming schemes, change the names of
 * variables, so they employ the same uniform naming.
 * The reason why you wouldn't change the naming scheme is because of a company
 * coding style guide or if the class is being extensively changed by a peer.
 */
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
	 /**
	  * TODO:
	  * There's a common sentiment that a block of code (code between {})
		* should fit within the height of a monitor (~50 lines).
		* So, for constructors like this, it would be prudent to move sections of
		* it out to methods.
		* Additionally, all of this logic should not be in a constructor, but a
		* separate method, such as "init()".
		* A busy constructor is considered bad practice and is called a
		* "loaded constructor."
	  */
	@SuppressWarnings("unchecked")
	public UserPanel(){
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		final int fontSize = DimensionUtil.computerBaseFontSize(screenSize.width, screenSize.height);
		Font font = new Font("Arial", Font.PLAIN,fontSize);

		vigenere = new Vigenere();
		caesar = new Caesar();
		atbash = new Atbash();

		/**
		 * TODO:
		 * since this section is only initializing the cipher options, you can
		 * export it to a method that returns an ArrayList.
		 * ex.
		 * private ArrayList<String> getCipherNames() {
		 *		ArrayList<String> cipherNames = new ArrayList<>();
		 *		cipherNames.add(Vigenere.class.getSimpleName());
		 *		cipherNames.add(Caesar.class.getSimpleName());
		 *		cipherNames.add(Atbash.class.getSimpleName());
		 *
		 *		return cipherNames;
	 	 * }
		 *
		 * In the example, I use .class.getSimpleName() since I'm assuming the
		 * class name will be the name of the cipher.
		 */
		cipherTypes = new ArrayList<>();
		cipherTypes.add("Vigenere");
		cipherTypes.add("Caesar");
		cipherTypes.add("Atbash");

		/**
		 * TODO:
		 * There various ways to break up the following code, but a simplistic
		 * way would be to split the logic by rows.
		 * So, you would have a method like createFirstRow() that returns a JPanel.
		 * If there are any dependencies, like width or height, you can pass those
		 * as arguments to the method.
		 */
		cipherOptions = new JComboBox(cipherTypes.toArray());
		cipherOptions.addActionListener(this);
		cipherOptions.setFont(font);

		keywordField = new JTextField("Keyword here...",15);
		keywordField.setMargin(new Insets(5,5,5,5));
		keywordField.setFont(font);

		row1 = new JPanel();
		row1.setLayout(new GridBagLayout());
		row1.add(cipherOptions);
		row1.add(keywordField);
		row1.setVisible(true);

		messageField = new JTextField("Message here...", 20);
		messageField.setMargin(new Insets(5,5,5,5));
		messageField.setFont(font);

		Encrypt = new JButton("Encrypt");
		Encrypt.setFont(font);
		Encrypt.addActionListener(this);

		Decrypt = new JButton("Decrypt");
		Decrypt.addActionListener(this);
		Decrypt.setFont(font);

		clear = new JButton("Clear");
		clear.addActionListener(this);
		clear.setFont(font);

		row2 = new JPanel();
		row2.setLayout(new FlowLayout());
		row2.add(messageField);
		row2.add(Encrypt);
		row2.add(Decrypt);
		row2.add(clear);

		console = new JTextArea(10, 75);
		console.setEditable(false);
		console.setMargin(new Insets(10,10,10,10));
		console.setFont(font);
		console.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		scroll = new JScrollPane(console);
		row3 = new JPanel();
		row3.setLayout(new FlowLayout());
		row3.add(scroll);

		row4 = new JPanel();
		row4.setLayout(new FlowLayout());

		resultLabel = new JLabel("Your results");
		resultLabel.setFont(font);
		resultLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));

		resultField = new JTextField("Your results come out here...", 50);
		resultField.setEditable(false);
		resultField.setMargin(new Insets(3,3,3,3));
		resultField.setFont(font);

		row4.add(resultLabel);
		row4.add(resultField);

		add(row1);
		add(row2);
		add(row3);
		add(row4);
		setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/2));

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
			else if(option.equals("Atbash")) result = atbash.encode(message);
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
			else if(option.equals("Caesar")) result = caesar.checkForErrorAndPrintDecoded(Integer.parseInt(keyword), message);
			else if(option.equals("Atbash")) result = atbash.decode(message);
			else result = "";
			resultField.setText(result);

		}
	}//end actionPerformed

}
