package Samples.SamplePatternsCommandAndChain.Commands;

/**
 * Created by User on 08.11.2016.
 * команда сложения переданных аргументов
 */
public class Add implements Command{
	@Override
	public int execute(int[] args) {
		int result = 0;
		for (int k: args) {
			result=result+k;
		}
		return result;
	}
}


