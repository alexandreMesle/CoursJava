package ihm.corriges;

import javax.swing.*;

import java.awt.event.*;

public class FormaterDisqueDur
{
	JButton formater = new JButton("Formater le disque dur");

	protected void ajouterListener(ActionListener a)
	{
		formater.addActionListener(a);
	}

	public FormaterDisqueDur()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Gestionnaire du disque dur");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(formater);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new FormaterDisqueDur();
	}
}
