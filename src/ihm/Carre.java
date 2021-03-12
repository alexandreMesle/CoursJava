package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Carre
{
	private JTextField operandTextField;
	private JLabel resultLabel;

	private void afficheCarre()
	{
		try
		{
			int k = Integer.parseInt(operandTextField.getText());
			k *= k;
			resultLabel.setText("" + k);
		}
		catch (NumberFormatException e)
		{
			resultLabel.setText("");
		}
	}

	private KeyListener getKeyListener()
	{
		return new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				afficheCarre();
			}
		};
	}

	private JLabel getLabelTitre()
	{
		return new JLabel("Calculatrice de carré");
	}

	private JLabel getLabelX()
	{
		return new JLabel("x = ");
	}


	private JLabel getLabelX2()
	{
		return new JLabel("x^2 = ");
	}

	private JLabel getLabelResultat()
	{
		resultLabel = new JLabel();
		return resultLabel;
	}
	
	private JTextField getTextFieldOperand()
	{
		operandTextField = new JTextField();
		operandTextField.addKeyListener(getKeyListener());
		return operandTextField;
	}

	private JPanel getPanelTitre()
	{
		JPanel panel = new JPanel();
		panel.add(getLabelTitre());
		return panel;
	}

	private JPanel getPanelCalculatrice()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(getLabelX());
		panel.add(getTextFieldOperand());
		panel.add(getLabelX2());
		panel.add(getLabelResultat());
		return panel;
	}

	private JPanel getPanelMain()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(getPanelTitre(), BorderLayout.NORTH);
		panel.add(getPanelCalculatrice(), BorderLayout.CENTER);
		return panel;
	}

	public Carre()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Square computer !");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getPanelMain());
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args)
	{
		new Carre();
	}
}
