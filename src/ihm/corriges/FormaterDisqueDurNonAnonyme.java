package ihm.corriges;

import java.awt.event.*;

public class FormaterDisqueDurNonAnonyme extends FormaterDisqueDur
{
	public FormaterDisqueDurNonAnonyme()
	{
		super();
		ajouterListener(new AffichageFormatage());
	}

	public static void main(String[] args)
	{
		new FormaterDisqueDurNonAnonyme();
	}
}

class AffichageFormatage implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Formatage en cours.");
	}
}
