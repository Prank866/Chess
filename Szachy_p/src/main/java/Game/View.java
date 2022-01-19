package Game;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame{

    public View(){
        super("Chess");

        setBounds(200,200,420,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Board szachownica = new Board();
        //szachownica.pokazDane();


        Image logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png")).getImage();
        setIconImage(logo);


        setContentPane(szachownica);
        setVisible(true);
    }

    public static void main(String[] args) {
        new View();
    }
}
