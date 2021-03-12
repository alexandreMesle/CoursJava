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
		jButtons.add(new JButton("my Fourth JButton"));
		jButtons.add(new JButton("my Fifth JButton"));
		jButtons.add(new JButton("my Sixth JButton"));
		jButtons.add(new JButton("my Seventh JButton"));
		for (JButton button : jButtons)
			frame.getContentPane().add(button);		
		/* Classe dediee */
		jButtons.get(0).addActionListener(new Ecouteur());
		
		/* Classe anonyme */
		jButtons.get(1).addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click on Second JButton");
			}
		});
		
		/* Classe anonyme dans une fonction */
		jButtons.get(2).addActionListener(getEcouteur());
		
		/* Lambda expression */
		jButtons.get(3).addActionListener(
				(e) -> {System.out.println("click on Third JButton");}
		);
		
		/* Lambda expression dans une fonction */
		jButtons.get(4).addActionListener(getEcouteurLambda());
		
		/* Double colon */
		jButtons.get(5).addActionListener(this::ecouteurDoubleColon);

		/* Double colon dans une fonction*/
		jButtons.get(6).addActionListener(getEcouteurDoubleColon());

		frame.pack();
		frame.setVisible(true);
	}

	private ActionListener getEcouteur()
	{
		return new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("click on Fourth JButton");
			}
		};
	};
	
	private ActionListener getEcouteurDoubleColon()
	{
		return EcouteurAnonyme.this::autreEcouteurDoubleColon;
	}
	
	private ActionListener getEcouteurLambda()
	{
		return (e) -> {System.out.println("click on Fifth JButton");};
	};
	
	private void ecouteurDoubleColon(ActionEvent e)
	{
		System.out.println("click on Sixth JButton");
	};
	
	private void autreEcouteurDoubleColon(ActionEvent e)
	{
		System.out.println("click on Seventh JButton");
	};
	
	public static void main(String[] args)
	{
		new EcouteurAnonyme();
	}
}

class Ecouteur implements ActionListener
{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("click on First JButton");
		}
}
