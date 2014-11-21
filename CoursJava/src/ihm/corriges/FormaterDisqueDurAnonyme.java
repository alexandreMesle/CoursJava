package ihm.corriges;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaterDisqueDurAnonyme extends FormaterDisqueDur
{
	public FormaterDisqueDurAnonyme()
	{
		super();
		ajouterListener(getActionListener());
	}

	private ActionListener getActionListener()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Formatage en cours.");
			}
		}; 
	}
	
	public static void main(String[] args)
	{
		new FormaterDisqueDurAnonyme();
	}
}
