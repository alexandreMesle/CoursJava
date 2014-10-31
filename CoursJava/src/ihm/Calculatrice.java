package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculatrice extends JFrame
{
    final JLabel resultLabel;
    final JButton[] buttons;
    
    private double left = 0;
    private double right = 0;
    private char operator;
    private boolean firstNumber = true;
	
    private void addDigit(int i)
    {
	if (firstNumber)
	    {
		left = 10*left + i;
		updateScreen(left);
	    }
	else
	    {
		right = 10*right + i;
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
		switch(operator)
		    {
		    case '+' : left += right ; break;
		    case '-' : left -= right ; break;
		    case '*' : left *= right ; break;
		    case '/' : left /= right ; break;
		    case '=' : ; break;
		    }
		updateScreen(left);
		right = 0;
	    }
	this.operator = operator;
    }        
    
    public Calculatrice()
    {
	setTitle("Calculatrice");
	setSize(200, 190);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new BorderLayout());
	setResizable(false);
	resultLabel = new JLabel("0");
	JPanel buttonsPanel = new JPanel();
	getContentPane().add(resultLabel, BorderLayout.NORTH);
	buttons = new JButton[10 + 4 + 1];
	buttonsPanel.setLayout(new GridLayout(5, 3));
	for(int i = 0 ; i < 10 ; i++)
	    buttons[i] = new JButton("" + i);
	for(int i = 0 ; i < 10 ; i++)
	    {
		final int j = i;
		buttons[i].addActionListener(new ActionListener()
		    {
			public void actionPerformed(ActionEvent e)
			{
			    addDigit(j);
			}
		    }
		    );
	    }
	buttons[10] = new JButton("+");
	buttons[10].addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    addOperator('+');
		}
	    }
	    );
	buttons[11] = new JButton("-");
	buttons[11].addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    addOperator('-');
		}
	    }
	    );
	buttons[12] = new JButton("*");
	buttons[12].addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    addOperator('*');
		}
	    }
	    );
	buttons[13] = new JButton("/");
	buttons[13].addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    addOperator('/');
		}
	    }
	    );
	buttons[14] = new JButton("=");
	buttons[14].addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		{
		    addOperator('=');
		}
	    }
	    );
	for(int i = 0 ; i < 10 + 4 + 1 ; i++)
	    buttonsPanel.add(buttons[i]);	
	getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	setVisible(true);
    }
    
    private void updateScreen(double value)
    {
	resultLabel.setText((new Double(value)).toString());
    }
    
    public static void main(String[] args)
    {
	Calculatrice c = new Calculatrice();
    }
}

