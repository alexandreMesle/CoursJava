package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class PremierEcouteur
{
	public PremierEcouteur()
	{
		JFrame frame = new JFrame();
		ArrayList<JButton> jButtons = new ArrayList<>();
		frame.setTitle("My third window !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		jButtons.add(new JButton("my First JButton"));
		jButtons.add(new JButton("my Second JButton"));
		jButtons.add(new JButton("my Third JButton"));
		for (JButton jButton : jButtons)
		{
			container.add(jButton);
			jButton.addActionListener(new MonEcouteur(jButton.getText()));
		}
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new PremierEcouteur();
	}
}

class MonEcouteur implements ActionListener
{
	String texte;
	 
	MonEcouteur(String texte)
	{
		this.texte = texte;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Click sur le bouton " + texte + " !");
	}
}