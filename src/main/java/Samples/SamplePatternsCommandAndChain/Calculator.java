package Samples.SamplePatternsCommandAndChain;

import Samples.SamplePatternsCommandAndChain.ExtraOptions.DbSavingHandler;
import Samples.SamplePatternsCommandAndChain.ExtraOptions.Handler;
import Samples.SamplePatternsCommandAndChain.ExtraOptions.NotifyHandler;
import Samples.SamplePatternsCommandAndChain.ExtraOptions.ReklamaHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by User on 08.11.2016.
 */
public class Calculator {
	private static final int REKLAMA_MASK=1;
	private static final int DBSAVING_MASK=2;
	private static final int EMAIL_MASK=4;
	private  static final String DBSAVING_CONFIG="DBSAVING";
	private  static final String EMAIL_CONFIG="EMAIL";


	private boolean isInterrapted = false;
	private Operation operation;
	private Handler handlerChain;

	private int userMask;

	public void setHandlerChain() {
		Handler temp1,temp2;
		this.handlerChain = new ReklamaHandler(REKLAMA_MASK);
		temp1 = this.handlerChain.setnext(new DbSavingHandler(DBSAVING_MASK));
		temp2= temp1.setnext(new NotifyHandler(EMAIL_MASK));
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator(); // здесь должна быть инициализация цепочки (видимо в конструкторе)
		calculator.start();
	}

	private static void getInformation(){
		System.out.println("Введеная Вами команда недоступна.");
		System.out.println("для справки наберите Help");
		System.out.println("для выхода наберите Exit");
	}

	public void start(){
		Scanner scan = new Scanner(System.in);
		Object result=0;
		setHandlerChain();
		setuserMask();
		while (!isInterrapted) {
			//читаем строку из консоли
			System.out.print("Enter your command: ");
			String request = scan.nextLine();
			System.out.println("You entered: "+request);
			operation=new Operation();
			operation.proceedRequest(request);
			if ("Exit".equals (operation.getCommand()))
				isInterrapted=true;
			else {
				//выполняем команду
				if (operation.proceedOperation()) {
					System.out.println(" RESULT = " + operation.getResult());
					handlerChain.doExtraOptionAndChain(operation,userMask);
				} else {
					getInformation();
				}
			}
		}
	}



	private void setuserMask () {
		int result = REKLAMA_MASK;
		Properties property = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/main/resources/calculator.properties");
			property.load(fis);
			String plugin = property.getProperty("plugins");
			if (plugin != null){
				int temp=0;
				String[] items = plugin.split(",");
				for (String item: items) {
					if (DBSAVING_CONFIG.equals (item.trim())){
						temp=temp+DBSAVING_MASK;
					}
					if (EMAIL_CONFIG.equals (item.trim())){
						temp=temp+EMAIL_MASK;
					}
				}
				if (temp>0) {
					result=temp;
				}
			}
		} catch (IOException e) {
			System.err.println("ОШИБКА: Файл свойств отсуствует!");
		}
		System.out.println("Прочитан конфиг, user_mask устновлен=>"+result );
		userMask=result;
	}




}

