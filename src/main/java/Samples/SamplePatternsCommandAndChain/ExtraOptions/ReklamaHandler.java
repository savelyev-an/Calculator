package Samples.SamplePatternsCommandAndChain.ExtraOptions;

import Samples.SamplePatternsCommandAndChain.Operation;

/**
 * Created by User on 08.11.2016.
 */
public class ReklamaHandler extends Handler{
	public ReklamaHandler(int userMask) {
		this.userMask=userMask;
	}

	@Override
	protected void doExtraOption(Operation operation) {
		System.out.println("");
		System.out.println("А теперь реклама на нашем РАДИО !");
	}
}
