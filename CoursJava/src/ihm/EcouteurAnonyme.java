package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EcouteurAnonyme extends JFrame
{
    public EcouteurAnonyme()
    {
	super();
	JButton[] jButtons = new JButton[3];
	setTitle("My fourth window !");
	setSize(200, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new FlowLayout());
	jButtons[0] = new JButton("my First JButton");
	jButtons[1] = new JButton("my Second JButton");
	jButtons[2] = new JButton("my Third JButton");
	for (int i = 0 ; i < 3 ; i++)
	    getContentPane().add(jButtons[i]);  
	jButtons[0].addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
			System.out.println("click on First JButton");
		    }
		}
		);
	jButtons[1].addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
			System.out.println("click on Second JButton");
		    }
		}
		);
	jButtons[2].addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
			System.out.println("click on Third JButton");
		    }
		}
		);
					   
	setVisible(true);
    }

    public static void main(String[] args)
    {
	new EcouteurAnonyme();
    }
}
