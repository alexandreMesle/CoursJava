package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class TestGridLayout implements ActionListener
{
	ArrayList<JButton> jButtons;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Click on " + ((JButton) e.getSource()).getText());
	}

	public TestGridLayout()
	{
		JFrame frame = new JFrame();
		jButtons = new ArrayList<JButton>();
		frame.setTitle("One More Window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2));
		jButtons.add(new JButton("North-West"));
		jButtons.add(new JButton("North-East"));
		jButtons.add(new JButton("South-West"));	
		jButtons.add(new JButton("South-East"));
		for (JButton jButton : jButtons)
		{
			JPanel jPanel = new JPanel();
			jPanel.add(jButton);
			frame.getContentPane().add(jPanel);
			jButton.addActionListener(this);
		}
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestGridLayout();
	}
}
