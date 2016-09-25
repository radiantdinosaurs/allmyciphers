package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class Container extends JFrame {
    /********************************************
     * Local Variables
     ********************************************/
    private static final long serialVersionUID = 1L;
    final static int WIDTH = 720, HEIGHT = 480;

    String title = "AllMyCiphers";
    JScrollPane scroll;
    UserPanel upanel;
    Menu menu;
    /********************************************
     * Constructors
     ********************************************/
    public Container(){
    }//end constructor

    /********************************************
     * Methods
     ********************************************/
    public void init(){
        setTitle(title);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        upanel = new UserPanel();
        menu = new Menu();

        scroll = new JScrollPane(upanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(Container.WIDTH, 0));
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll);
        setJMenuBar(menu);

        setVisible(true);

        pack();

        //upanel.DEBUG();
    }//end init
}