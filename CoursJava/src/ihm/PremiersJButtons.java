package ihm;

import javax.swing.*;
import java.awt.*;

public class PremiersJButtons extends JFrame
{
    public PremiersJButtons()
    {
	super();
	setTitle("My third window !");
	setSize(200, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new FlowLayout());
	getContentPane().add(new JButton("my First JButton"));  
	getContentPane().add(new JButton("my Second JButton"));
	getContentPane().add(new JButton("my Third JButton"));
	setVisible(true);
    }

    public static void main(String[] args)
    {
	new PremiersJButtons();
    }
}
