package ihm;

import javax.swing.*;
import java.awt.*;

public class TestGridLayout
{
	private JLabel labelTitre;
	
	private JPanel getTitrePanel()
	{
		JPanel panel = new JPanel();
		panel.add(getLabelTitre());
		return panel;
	}

	private JPanel getBoutonsPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(getBouton("North-West"));
		panel.add(getBouton("North-East"));
		panel.add(getBouton("South-West"));
		panel.add(getBouton("South-East"));
		return panel;		
	}

	private JPanel getMainPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(getTitrePanel(), BorderLayout.NORTH);
		panel.add(getBoutonsPanel(), BorderLayout.SOUTH);
		return panel;
	}
	
	private JLabel getLabelTitre()
	{
		labelTitre = new JLabel("Le Titre");
		return labelTitre;
	}
	
	private JButton getBouton(String titre)
	{
		JButton bouton = new JButton(titre);
		bouton.addActionListener((e) -> 
		{
			labelTitre.setText(titre);
		});
		return bouton;
	}
	
	public TestGridLayout()
	{
		JFrame frame = new JFrame("Une fonction par panel, une fonction par composant");
		frame.setContentPane(getMainPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestGridLayout();
	}
}
