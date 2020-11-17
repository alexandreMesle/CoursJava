package ihm;

import javax.swing.*;
import java.awt.*;

public class TestGridLayout
{
	private JPanel getMainPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(getBouton("North-West"));
		panel.add(getBouton("North-East"));
		panel.add(getBouton("South-West"));
		panel.add(getBouton("South-East"));
		return panel;
	}
	
	private JButton getBouton(String titre)
	{
		JButton bouton = new JButton(titre);
		bouton.addActionListener((e) -> 
		{
			System.out.println("Click sur " + titre);
		});
		return bouton;
	}
	
	public TestGridLayout()
	{
		JFrame frame = new JFrame();
		frame.setContentPane(getMainPanel());
		frame.setTitle("One More Window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestGridLayout();
	}
}
