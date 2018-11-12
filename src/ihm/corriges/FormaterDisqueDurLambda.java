package ihm.corriges;

import java.awt.event.ActionListener;

public class FormaterDisqueDurLambda extends FormaterDisqueDur
{
	public FormaterDisqueDurLambda()
	{
		super();
		ajouterListener(getActionListener());
	}

	private ActionListener getActionListener()
	{
		return (e) -> {System.out.println("Formatage en cours.");};
	}

	public static void main(String[] args)
	{
		new FormaterDisqueDurLambda();
	}
}
