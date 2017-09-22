package heritage;

import java.util.ArrayList;
@SuppressWarnings("unused")

interface Animal
{
	// Getter pour le champ nom
	public void setNom(String nom);

	// Setter pour le champ nom
	public String getNom();

	// Affiche le cri de l'animal
	public String cri();
}

//TODO Décommentez le code ci-dessous pour le compléter

//public class ExempleAnimaux
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Animal> animaux = new ArrayList<>();
//		animaux.add(new Chat("Ronron"));
//		animaux.add(new Chien("Médor"));
//		animaux.add(new Vache("Huguette"));
//		for (Animal animal : animaux)
//			System.out.println(animal.cri());
//	}
//}
//
//class Chat implements Animal
//{
//}
//
//class Chien implements Animal
//{
//}
//
//class Vache implements Animal
//{
//}
