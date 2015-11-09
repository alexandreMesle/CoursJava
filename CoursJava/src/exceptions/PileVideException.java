package exceptions;

public class PileVideException extends Exception
{
	public String toString()
	{
		return "Can't top an empty stack.";
	}
}