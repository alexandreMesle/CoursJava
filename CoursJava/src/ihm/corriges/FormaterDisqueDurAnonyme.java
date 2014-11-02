package ihm.corriges;

import javax.swing.*;
import java.awt.event.*;

public class FormaterDisqueDurAnonyme extends JFrame
{
    
    
    public FormaterDisqueDurAnonyme()
    {
	setTitle("Gestionnaire du disque dur");
	setSize(100, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	JButton formater = new JButton("Formater le disque dur");
	getContentPane().add(formater);
	formater.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    System.out.println("Formatage en cours.");	
		}
	    }
	    );
	setVisible(true);
    }
    
    public static void main(String[] args)
    {
	FormaterDisqueDurAnonyme f = new FormaterDisqueDurAnonyme();
    }
}

