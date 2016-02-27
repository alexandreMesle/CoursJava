package exceptions;

public class PileVideException extends RuntimeException
{
	public String toString()
	{
		return "Can't top an empty stack.";
	}
}