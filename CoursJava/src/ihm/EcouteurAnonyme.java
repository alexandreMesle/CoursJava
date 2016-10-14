package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EcouteurAnonyme
{
	public EcouteurAnonyme()
	{
		JFrame frame = new JFrame();
		JButton[] jButtons = new JButton[3];
		frame.setTitle("My fourth window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		jButtons[0] = new JButton("my First JButton");
		jButtons[1] = new JButton("my Second JButton");
		jButtons[2] = new JButton("my Third JButton");
		for (int i = 0; i < 3; i++)
			frame.getContentPane().add(jButtons[i]);
		jButtons[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on First JButton");
			}
		});
		jButtons[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on Second JButton");
			}
		});
		jButtons[2].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on Third JButton");
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new EcouteurAnonyme();
	}
}
