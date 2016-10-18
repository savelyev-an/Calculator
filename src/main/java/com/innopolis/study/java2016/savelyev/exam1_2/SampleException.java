package com.innopolis.study.java2016.savelyev.exam1_2;

/**
 * Created by User on 11.10.2016.
 */


import java.io.FileNotFoundException;
		import java.io.IOException;

public   class SampleException {

	// в методе main() пробрасывается сразу несколько исключений
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// в блоке try-catch перехватываются сразу несколько исключений вызовом дополнительного catch(...)
		try{
			testException(-5);
			testException(-10);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			System.out.println("Необязательный блок, но раз уже написан, то выполнятся будет не зависимо от того было исключение или нет");
		}
		testException(15);
	}
	// тестовый метод создания, обработки и пробрасывания исключения
	public static void testException(int i) throws FileNotFoundException, IOException{
		if(i < 0){
			FileNotFoundException myException = new FileNotFoundException("число меньше 0: " + i);
			throw myException;
		}else if(i > 10){
			throw new IOException("Число должно быть в пределах от 0 до 10");
		}

	}

}