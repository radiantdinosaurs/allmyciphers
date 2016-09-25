package main;

import javax.swing.UIManager;

import gui.Container;

public class Runner {
/********************************************
 * Main
 ********************************************/
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				UIManager.put("swing.boldMetal",Boolean.FALSE);
				Container ui = new Container();
				ui.init();
			}
		});
	}
}
