package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PremierEcouteur extends JFrame implements ActionListener
{
    JButton[] jButtons;

    public void actionPerformed(ActionEvent e)
    {
	int k = 0;
	while(jButtons[k++] != e.getSource());
	System.out.println("click on JButton " + k);	
    }
    
    public PremierEcouteur()
    {
	super();
	jButtons = new JButton[3];
	setTitle("My fourth window !");
	setSize(200, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new FlowLayout());
	jButtons[0] = new JButton("my First JButton");
	jButtons[1] = new JButton("my Second JButton");
	jButtons[2] = new JButton("my Third JButton");
	for (int i = 0 ; i < 3 ; i++)
	    {
		getContentPane().add(jButtons[i]);  
		jButtons[i].addActionListener(this); 
	    }
	setVisible(true);
    }

    public static void main(String[] args)
    {
	new PremierEcouteur();
    }
}
