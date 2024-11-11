package DAA;
import java.util.Scanner;
public class Fibonacci
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value of n: ");
		int n =sc.nextInt();
		long starttime=System.nanoTime();
		System.out.println("Non recursive: "+fibnonrec(n));
		long endtime=System.nanoTime();
		System.out.println("Time required: "+(endtime-starttime));
		
		starttime=System.nanoTime();
		System.out.println("Non recursive: "+fibrec(n));
		endtime=System.nanoTime();
		System.out.println("Time required: "+(endtime-starttime));
		sc.close();
	}
	public static int fibnonrec(int n)
	{
		if(n<=1)
		{
			return n;
		}
		int prev2=0, prev1=1, current=0;
		for(int i=2; i<=n; i++)
		{
			current=prev2+prev1;
			prev2=prev1;
			prev1=current;
		}
		return current;
	}
	public static int fibrec(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return fibrec(n-2)+fibrec(n-1);
	}
}