package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestGridLayout implements ActionListener
{
	JButton[] jButtons;

	public void actionPerformed(ActionEvent e)
	{
		int k = 0;
		while (jButtons[k++] != e.getSource());
		System.out.println("click on JButton " + k);
	}

	public TestGridLayout()
	{
		JFrame frame = new JFrame();
		jButtons = new JButton[4];
		frame.setTitle("One More Window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2));
		jButtons[0] = new JButton("my First JButton");
		jButtons[1] = new JButton("my Second JButton");
		jButtons[2] = new JButton("my Third JButton");
		jButtons[3] = new JButton("my Fourth JButton");
		for (int i = 0; i < 4; i++)
		{
			frame.getContentPane().add(jButtons[i]);
			jButtons[i].addActionListener(this);
		}
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new TestGridLayout();
	}
}
