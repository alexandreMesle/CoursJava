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
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new JButton("my First JButton"));
		container.add(new JButton("my Second JButton"));
		container.add(new JButton("my Third JButton"));
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new PremiersJButtons();
	}
}
