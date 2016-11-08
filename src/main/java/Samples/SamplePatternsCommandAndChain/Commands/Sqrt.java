package Samples.SamplePatternsCommandAndChain.Commands;

/**
 * Created by User on 08.11.2016.
 */
public class Sqrt implements Command {
	@Override
	public int execute(int[] args) {
		int result=0;
		if (args.length>0)
			result= (int) Math.sqrt((double) args[0]);
		return result;
	}
}
