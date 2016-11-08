package Samples.SamplePatternsCommandAndChain.Commands;

/**
 * Created by User on 08.11.2016.
 * команда деления первого аргумента на следующие
 */
public class Div implements Command{
	@Override
	public int execute(int[] args) {
		int result =0;
		boolean isFirstTaken=false;
		for (int k: args) {
			if (isFirstTaken)
				result=result/k;
			else {
				isFirstTaken=true;
				result=k;
			}
		}
		return result;
	}
}
