package ihm;

import javax.swing.*;
import java.awt.*;

public class PremiersJButtons
{
	public PremiersJButtons()
	{
		JFrame frame = new JFrame();
		frame.setTitle("My second window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JButton("my First JButton"));
		frame.getContentPane().add(new JButton("my Second JButton"));
		frame.getContentPane().add(new JButton("my Third JButton"));
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new PremiersJButtons();
	}
}
