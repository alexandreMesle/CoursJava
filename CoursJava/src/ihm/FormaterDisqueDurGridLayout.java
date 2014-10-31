package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FormaterDisqueDurGridLayout extends JFrame
{    
    public FormaterDisqueDurGridLayout()
    {
	setTitle("Gestionnaire du disque dur");
	setSize(100, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	JButton formater = new JButton("Formater le disque dur");
	final JLabel label = new JLabel("");
	formater.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    label.setText("Formatage en cours.");
		}
	    }
	    );
	getContentPane().setLayout(new GridLayout(2, 1));
	getContentPane().add(formater);
	getContentPane().add(label);
	setVisible(true);
    }
    
    public static void main(String[] args)
    {
	FormaterDisqueDurGridLayout f = new FormaterDisqueDurGridLayout();
    }
}

