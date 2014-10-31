package ihm;

import javax.swing.*;

public class DeuxiemeFenetre extends JFrame
{
    public DeuxiemeFenetre()
    {
	super();
	setTitle("My second window !");
	setSize(200, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void affiche()
    {
	setVisible(true);
    }

    public static void main(String[] args)
    {
	DeuxiemeFenetre f = new DeuxiemeFenetre();
	f.affiche();
    }
}
