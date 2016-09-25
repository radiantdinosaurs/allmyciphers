package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener {
/********************************************
 * Local Variables
 ********************************************/
private static final long serialVersionUID = 1L;
private JMenu File, Help;
private JMenuItem Export, Exit, AboutAllMyCiphers;

/********************************************
 * Constructors
 ********************************************/
	public Menu(){
		File = new JMenu("File");
		Help = new JMenu("Help");
		Export = new JMenuItem("Export");
		Export.addActionListener(this);
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		AboutAllMyCiphers = new JMenuItem("About");
		AboutAllMyCiphers.addActionListener(this);
		File.add(Export);
		File.add(Exit);
		Help.add(AboutAllMyCiphers);
		add(File);
		add(Help);
	}


/********************************************
 * Methods
 ********************************************/	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Exit){
			System.exit(0);
		}//endif
	}//end actionPerformed
}//end Menu
