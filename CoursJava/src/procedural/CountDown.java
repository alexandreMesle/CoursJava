package procedural;

class CountDown
{
	static void countDown(int n)
	{
		while (n >= 0)
		{
			System.out.println(n);
			n--;
		}
	}

	public static void main(String[] args)
	{
		countDown(20);
	}
}
