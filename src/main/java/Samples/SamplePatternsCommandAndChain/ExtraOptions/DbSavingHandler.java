package Samples.SamplePatternsCommandAndChain.ExtraOptions;

import Samples.SamplePatternsCommandAndChain.Operation;

/**
 * Created by User on 08.11.2016.
 */
public class DbSavingHandler extends Handler {
	public DbSavingHandler(int userMask) {
		this.userMask=userMask;
	}

	@Override
	protected void doExtraOption(Operation operation) {
		System.out.println();
		System.out.println("Скинули в базу данных запрос c клавиатуры => "+(operation.getRequest()));
		System.out.println("распознана команда: "+ operation.getCommand());
		System.out.print("распозаны аргументы: ");
		for (int i : operation.getArgs()) {
			System.out.print(i+ " ");
		}
		System.out.println();
		System.out.println("Результат расчета: "+operation.getResult());
		System.out.println();
	}
}
