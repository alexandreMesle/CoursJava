package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EuroDollar extends JFrame
{
    final double OneDollarInEuro = 1.4237 ;
    final JTextField dollarText, euroText;
    final JLabel dollarLabel, euroLabel;

    private void convert(JTextField source, JTextField target, double rate)
    {
	try  
	    { 
		double k = new Double(source.getText()).doubleValue(); 
		k *= rate; 
		target.setText((new Double(k)).toString()); 
	    } 
	catch(NumberFormatException ex) 
	    { 
		if(target != null) 
		    target.setText(""); 
	    } 
    }
    
    public EuroDollar()
    {
	getContentPane().setLayout(new GridLayout(2, 2));
	dollarText = new JTextField();
	euroText = new JTextField();
	dollarLabel = new JLabel("Dollars");
	euroLabel = new JLabel("Euros");
	getContentPane().add(dollarLabel);
	getContentPane().add(euroLabel);
	getContentPane().add(dollarText);
	getContentPane().add(euroText);
	setTitle("Convertisseur Euros/Dollars");
	setSize(400, 50);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	euroText.addKeyListener(new KeyListener()
	    {
		public void keyTyped(KeyEvent e){} 	
		public void keyPressed(KeyEvent e){} 
		public void keyReleased(KeyEvent e) 
		{ 
		    convert(euroText, dollarText, OneDollarInEuro);
		} 		
	    }
	    );
	dollarText.addKeyListener(new KeyListener()
	    {
		public void keyTyped(KeyEvent e){} 	
		public void keyPressed(KeyEvent e){} 
		public void keyReleased(KeyEvent e) 
		{ 
		    convert(dollarText, euroText, 1/OneDollarInEuro);
		} 		
	    }
	    );
    }
    
    public static void main(String[] args)
    {
	EuroDollar maFenetre = new EuroDollar();
    }
}
