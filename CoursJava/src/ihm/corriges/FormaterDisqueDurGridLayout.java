package ihm.corriges;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FormaterDisqueDurGridLayout
{
	public FormaterDisqueDurGridLayout()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Gestionnaire du disque dur");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton formater = new JButton("Formater le disque dur");
		final JLabel label = new JLabel("");
		formater.addActionListener(getActionListener(label));
		frame.getContentPane().setLayout(new GridLayout(2, 1));
		frame.getContentPane().add(formater);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		frame.pack();
	}

	private ActionListener getActionListener(final JLabel label)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				label.setText("Formatage en cours.");
			}
		};
	}

	public static void main(String[] args)
	{
		new FormaterDisqueDurGridLayout();
	}
}
