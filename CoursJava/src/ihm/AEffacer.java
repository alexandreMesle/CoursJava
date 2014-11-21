package ihm;
//
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
//
public class AEffacer
{
//	JTextField operandTextField = new JTextField("Valeur ?"), 
//			resultTextField = new JTextField();
//	JFrame frame = new JFrame();
//
//	public void keyPressed(KeyEvent e)
//	{
//	}
//
//	public void keyReleased(KeyEvent e)
//	{
//		try
//		{
//			int k = Integer.parseInt(operandTextField.getText());
//			k *= k;
//			resultTextField.setText(Integer.toString(k));
//		} catch (Exception ex)
//		{
//			if (resultTextField != null)
//				resultTextField.setText("");
//		}
//	}
//
//	public void keyTyped(KeyEvent e)
//	{
//	}
//
//	public void actionPerformed(ActionEvent e)
//	{
//		int k = Integer.parseInt(operandTextField.getText());
//		k *= k;
//		resultTextField.setText(Integer.toString(k));
//	}
//
//	private JPanel getPanel()
//	{
//		JPanel myPanel = new JPanel();
//		myPanel.setLayout(new GridLayout(2, 1));
//		//myPanel.setLayout(new GridLayout(1, 3));
//		operandTextField.addKeyListener(this);
//		myPanel.add(operandTextField);
//		myPanel.add(computeSquareButton);
//		myPanel.add(resultTextField);
//		
//		computeSquareButton.addActionListener(this);
//		
//		
//		resultTextField.setEnabled(false);
//		myPanel.add(new JLabel("Calcul de carré"));
//		return myPanel;
//	}
//	
//	public EcouteurClavier()
//	{
//		super();
//		frame.setTitle("Square computer !");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setContentPane(getPanel());
//		frame.setVisible(true);
//		frame.pack();
//	}
//
//	public static void main(String[] args)
//	{
//		new EcouteurClavier();
//	}
}