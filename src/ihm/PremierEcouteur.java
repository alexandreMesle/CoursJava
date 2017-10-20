package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class PremierEcouteur implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Click on " + ((JButton) e.getSource()).getText());
	}

	public PremierEcouteur()
	{
		JFrame frame = new JFrame();
		ArrayList<JButton> jButtons = new ArrayList<>();
		frame.setTitle("My third window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		jButtons.add(new JButton("my First JButton"));
		jButtons.add(new JButton("my Second JButton"));
		jButtons.add(new JButton("my Third JButton"));
		for (JButton jButton : jButtons)
		{
			frame.getContentPane().add(jButton);
			jButton.addActionListener(this);
		}
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new PremierEcouteur();
	}
}
