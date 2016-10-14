package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PremierEcouteur implements ActionListener
{
	JButton[] jButtons;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int k = 0;
		while (jButtons[k++] != e.getSource());
		System.out.println("click on JButton " + k);
	}

	public PremierEcouteur()
	{
		JFrame frame = new JFrame();
		jButtons = new JButton[3];
		frame.setTitle("My third window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		jButtons[0] = new JButton("my First JButton");
		jButtons[1] = new JButton("my Second JButton");
		jButtons[2] = new JButton("my Third JButton");
		for (int i = 0; i < 3; i++)
		{
			frame.getContentPane().add(jButtons[i]);
			jButtons[i].addActionListener(this);
		}
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new PremierEcouteur();
	}
}
