package ihm.corriges;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class EuroDollar
{
	private final double OneDollarInEuro = 1.4237;
	private final JTextField dollarText = new JTextField(),
			euroText = new JTextField();
	private final JLabel dollarLabel = new JLabel("Dollars"),
			euroLabel = new JLabel("Euros");

	private KeyListener getKeyListener(final JTextField source,
			final JTextField target, final double rate)
	{
		return new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				convert(source, target, rate);
			}
		};
	}

	private void convert(JTextField source, JTextField target, double rate)
	{
		try
		{
			double k = new Double(source.getText()).doubleValue();
			k *= rate;
			target.setText((new Double(k)).toString());
		}
		catch (NumberFormatException ex)
		{
			if (target != null)
				target.setText("");
		}
	}

	private JPanel getMainPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(dollarLabel);
		panel.add(euroLabel);
		panel.add(dollarText);
		panel.add(euroText);
		return panel;
	}

	public EuroDollar()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Convertisseur Euros/Dollars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setContentPane(getMainPanel());
		euroText.addKeyListener(getKeyListener(euroText, dollarText,
				OneDollarInEuro));
		dollarText.addKeyListener(getKeyListener(dollarText, euroText,
				1 / OneDollarInEuro));
		frame.pack();
	}

	public static void main(String[] args)
	{
		new EuroDollar();
	}
}
