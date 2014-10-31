package ihm;

import javax.swing.*;
import java.awt.event.*;

public class FormaterDisqueDurNonAnonyme extends JFrame
{
    public FormaterDisqueDurNonAnonyme()
    {
	setTitle("Gestionnaire du disque dur");
	setSize(100, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	JButton formater = new JButton("Formater le disque dur");
	getContentPane().add(formater);
	formater.addActionListener(new AffichageFormatage());
	setVisible(true);
    }
    
    public static void main(String[] args)
    {
	FormaterDisqueDurNonAnonyme f = new FormaterDisqueDurNonAnonyme();
    }
}

class AffichageFormatage implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
	System.out.println("Formatage en cours.");	
    }    
}
