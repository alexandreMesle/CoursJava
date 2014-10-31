package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Carre extends JFrame implements KeyListener
{
    JTextField operandTextField;
    JLabel resultTextField;

    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e)
    {
	try
	{
        int k = Integer.parseInt(operandTextField.getText());
        k *= k;
        resultTextField.setText(Integer.toString(k));
	}
	catch(Exception ex)
	{
	if(resultTextField != null)
		resultTextField.setText("");
	}
    }

    public void keyTyped(KeyEvent e){}

    public Carre()
    {
        super();
        setSize(200, 200);
        setTitle("Square computer !");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setLayout(new GridLayout(2, 2));
	getContentPane().add(new JLabel("x = "));
        operandTextField = new JTextField();
        operandTextField.addKeyListener(this);
        getContentPane().add(operandTextField);
	getContentPane().add(new JLabel("x^2 = "));
        resultTextField = new JLabel();
        getContentPane().add(resultTextField);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Carre();
    }
}
