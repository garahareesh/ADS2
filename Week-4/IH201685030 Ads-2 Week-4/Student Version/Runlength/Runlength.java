public class Runlength
{
	private static final int R=256;
	private  static final int lg_r=8;
	Runlength()
	{

	}
	public static void expand()
	{
		boolean old=false;
		while(!BinaryStdIn.isEmpty())
		{
			int run=BinaryStdIn.readInt(lg_r);
			for(int i=0;i<run;i++)
				BinaryStdOut.write(old);
			old=!old;
		}
		BinaryStdOut.close();
	}
	public static void compress()
	{
		char run=0;
		boolean b=false;
		while(!BinaryStdIn.isEmpty())
		{
			boolean old=BinaryStdIn.readBoolean();
			if(old!=b)
			{
				BinaryStdOut.write(run,lg_r);
				run=1;
				b=!b;
			}
			else
			{
				if(run==R-1)
				{
					BinaryStdOut.write(run,lg_r);
					run=0;
					BinaryStdOut.write(run,lg_r);
				}
				run++;
			}

		}
		BinaryStdOut.write(run,lg_r);
		BinaryStdOut.close();
	}
	public static void main(String[] args) {
		compress();
		// else if(args[0].equals("+")) expand();
		// else throw new IllegalArgumentException("Illegal Commond Line argument");
	}
}