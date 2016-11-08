package Samples.SamplePatternsCommandAndChain.ExtraOptions;

import Samples.SamplePatternsCommandAndChain.Operation;

/**
 * Created by User on 08.11.2016.
 */
abstract public class Handler {
	protected int userMask;
	protected Handler next;

	public Handler setnext (Handler handler) {
		this.next=handler;
		return handler;
	}

	public void doExtraOptionAndChain (Operation operation, int userMask){
		if ( (this.userMask & userMask) > 0 ) {
			doExtraOption(operation);
		}

		if (next != null) {
			next.doExtraOptionAndChain(operation, userMask);
		}
	}

	abstract protected  void doExtraOption(Operation operation);
}
