package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenu file, help;
	private JMenuItem export, exit, aboutAllMyCiphers;

	public Menu(){
		file = new JMenu("file");
		help = new JMenu("help");
		export = new JMenuItem("export");
		export.addActionListener(this);
		exit = new JMenuItem("exit");
		exit.addActionListener(this);
		aboutAllMyCiphers = new JMenuItem("About");
		aboutAllMyCiphers.addActionListener(this);
		file.add(export);
		file.add(exit);
		help.add(aboutAllMyCiphers);
		add(file);
		add(help);
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== exit){
			System.exit(0);
		}

	}
}
