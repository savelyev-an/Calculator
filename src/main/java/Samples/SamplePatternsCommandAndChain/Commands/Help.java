package Samples.SamplePatternsCommandAndChain.Commands;

/**
 * Created by User on 08.11.2016.
 */
public class Help implements Command{
	@Override
	public int execute(int[] args) {
		System.out.println("Для ввода операции наберите 'Комада операнд1 операнд2...' ");
		System.out.println("набор доступных операций можно увидеть в каталоге 'Command'");
		return 0;
	}
}
