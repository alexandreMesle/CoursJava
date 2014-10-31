package ihm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EcouteurClavier extends JFrame implements ActionListener, KeyListener
{
    JButton computeSquareButton;
    JTextField operandTextField, resultTextField;

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

    public void actionPerformed(ActionEvent e)
    {
        int k = Integer.parseInt(operandTextField.getText());
        k *= k;
        resultTextField.setText(Integer.toString(k));
    }

    public EcouteurClavier()
    {
        super();
        setSize(200, 200);
        setTitle("Square computer !");
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
	getContentPane().setLayout(new GridLayout(2, 1));
        computeSquareButton = new JButton("Calculer");
        computeSquareButton.addActionListener(this);
        operandTextField = new JTextField("valeur ?");
        resultTextField = new JTextField();
        resultTextField.setEnabled(false);
	getContentPane().add(new JLabel("Calcul de carré"));
	JPanel myPanel = new JPanel();
        getContentPane().add(myPanel);
	myPanel.setLayout(new GridLayout(1, 3));
        operandTextField.addKeyListener(this);
        myPanel.add(operandTextField);
        myPanel.add(computeSquareButton);
        myPanel.add(resultTextField);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new EcouteurClavier();
    }
}