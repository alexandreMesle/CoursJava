package ihm.corriges;

import javax.swing.*;
import java.awt.event.*;

public class FormaterDisqueDur extends JFrame implements ActionListener
{
	public FormaterDisqueDur()
	{
		setTitle("Gestionnaire du disque dur");
		setSize(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton formater = new JButton("Formater le disque dur");
		getContentPane().add(formater);
		formater.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Formatage en cours.");
	}

	public static void main(String[] args)
	{
		new FormaterDisqueDur();
	}
}
