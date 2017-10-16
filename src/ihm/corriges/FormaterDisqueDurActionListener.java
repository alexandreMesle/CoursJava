package ihm.corriges;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaterDisqueDurActionListener extends FormaterDisqueDur
		implements ActionListener
{
	public FormaterDisqueDurActionListener()
	{
		super();
		ajouterListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Formatage en cours.");
	}
	
	public static void main(String[] args)
	{
		new FormaterDisqueDurActionListener();
	}

}
