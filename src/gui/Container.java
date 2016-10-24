package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Container extends JFrame {

    private static final long serialVersionUID = 1L;
    final static int WIDTH = 720, HEIGHT = 480;
    private String title = "AllMyCiphers";
    private JScrollPane scroll;
    private UserPanel upanel;
    private Menu menu;

    public void init(){

        Dimension monitorDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int monitorHeight = monitorDimension.height;
        final int monitorWidth = monitorDimension.width;

        setTitle(title);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(monitorWidth/2, monitorHeight/2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        upanel = new UserPanel();
        menu = new Menu();

        scroll = new JScrollPane(upanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(monitorWidth/2, monitorHeight/2));
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        add(scroll);
        setJMenuBar(menu);

        setVisible(true);

        pack();

    }
}
