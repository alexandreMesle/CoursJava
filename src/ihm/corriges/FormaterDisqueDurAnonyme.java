package ihm.corriges;

import java.awt.event.*;

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
