package ihm.corriges;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Calculatrice extends JFrame
{
	private JLabel resultLabel;
	private JButton[] buttons;

	private double left = 0;
	private double right = 0;
	private char operator;
	private boolean firstNumber = true;

	private void addDigit(int i)
	{
		if (firstNumber)
		{
			left = 10 * left + i;
			updateScreen(left);
		} 
		else
		{
			right = 10 * right + i;
			updateScreen(right);
		}
		System.out.println(i);
	}

	private void addOperator(char operator)
	{
		System.out.println(operator);
		if (firstNumber)
			firstNumber = false;
		else
		{
			switch (this.operator)
			{
			case '+':
				left += right;
				break;
			case '-':
				left -= right;
				break;
			case '*':
				left *= right;
				break;
			case '/':
				left /= right;
				break;
			case '=':
				;
				break;
			}
			updateScreen(left);
			right = 0;
		}
		this.operator = operator;
	}

	private JPanel getMainPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		resultLabel = new JLabel("0");
		panel.add(resultLabel, BorderLayout.NORTH);
		panel.add(getButtonsPanel(), BorderLayout.SOUTH);
		return panel;
	}
	
	
	private ActionListener addDigitEvent(final int j)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				addDigit(j);
			}
		};
	}
	
	private JButton makeOperatorButton(final char operator)
	{
		JButton button = new JButton("" + operator);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addOperator(operator);
			}
		});
		return button;
	}
	
	private JPanel getButtonsPanel()
	{
		JPanel buttonsPanel = new JPanel();
		buttons = new JButton[10 + 4 + 1];
		buttonsPanel.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < 10; i++)
			buttons[i] = new JButton("" + i);
		for (int i = 0; i < 10; i++)
			buttons[i].addActionListener(addDigitEvent(i));
		buttons[10] = makeOperatorButton('+');
		buttons[11] = makeOperatorButton('-');
		buttons[12] = makeOperatorButton('*');
		buttons[13] = makeOperatorButton('/');
		buttons[14] = makeOperatorButton('=');
		for (int i = 1; i <= 10 + 5; i++)
			buttonsPanel.add(buttons[i]);
		return buttonsPanel;

	}
	
	public Calculatrice()
	{
		setTitle("Calculatrice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(getMainPanel());
		setVisible(true);
		pack();
	}

	private void updateScreen(double value)
	{
		resultLabel.setText((new Double(value)).toString());
	}

	public static void main(String[] args)
	{
		new Calculatrice();
	}
}
