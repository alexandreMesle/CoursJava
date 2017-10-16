package ihm.corriges;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Calculatrice
{
	private JLabel resultLabel = new JLabel("0");
	private ArrayList<JButton> buttons = new ArrayList<>();
	private JFrame frame = new JFrame();
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
	}

	private void addOperator(char operator)
	{
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
		panel.add(resultLabel, BorderLayout.NORTH);
		panel.add(getButtonsPanel(), BorderLayout.SOUTH);
		return panel;
	}

	private ActionListener addDigitListener(final int j)
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

	private JButton getOperatorButton(final char operator)
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
		buttonsPanel.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < 10; i++)
		{
			int digit = (i + 1) % 10;
			JButton button = new JButton("" + digit);
			button.addActionListener(addDigitListener(digit));
			buttons.add(button);
		}
		buttons.add(getOperatorButton('+'));
		buttons.add(getOperatorButton('-'));
		buttons.add(getOperatorButton('*'));
		buttons.add(getOperatorButton('/'));
		buttons.add(getOperatorButton('='));
		for (JButton button : buttons)
			buttonsPanel.add(button);
		return buttonsPanel;

	}

	public Calculatrice()
	{
		frame.setTitle("Calculatrice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(getMainPanel());
		frame.setVisible(true);
		frame.pack();
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
