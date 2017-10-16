package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class EcouteurAnonyme
{
	public EcouteurAnonyme()
	{
		JFrame frame = new JFrame();
		ArrayList<JButton> jButtons = new ArrayList<>();
		frame.setTitle("My fourth window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		jButtons.add(new JButton("my First JButton"));
		jButtons.add(new JButton("my Second JButton"));
		jButtons.add(new JButton("my Third JButton"));
		for (JButton button : jButtons)
			frame.getContentPane().add(button);
		jButtons.get(0).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on First JButton");
			}
		});
		jButtons.get(1).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on Second JButton");
			}
		});
		jButtons.get(2).addActionListener(new ActionListener()
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
