package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestGridLayout extends JFrame implements ActionListener
{
    JButton[] jButtons;

    public void actionPerformed(ActionEvent e)
    {
	int k = 0;
	while(jButtons[k++] != e.getSource());
	System.out.println("click on JButton " + k);	
    }
    
    public TestGridLayout()
    {
	super();
	jButtons = new JButton[4];
	setTitle("One More Window !");
	setSize(200, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new GridLayout(2, 2));
	jButtons[0] = new JButton("my First JButton");
	jButtons[1] = new JButton("my Second JButton");
	jButtons[2] = new JButton("my Third JButton");
	jButtons[3] = new JButton("my Fourth JButton");
	for (int i = 0 ; i < 4 ; i++)
	    {
		getContentPane().add(jButtons[i]);  
		jButtons[i].addActionListener(this); 
	    }
	setVisible(true);
    }

    public static void main(String[] args)
    {
	new TestGridLayout();
    }
}
