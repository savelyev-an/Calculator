package Samples.SamplePatternsCommandAndChain;

import Samples.SamplePatternsCommandAndChain.Commands.Command;

/**
 * Created by User on 08.11.2016.
 */
public class Operation {
	String request;
	String command;
	int[] args;
	int result;

	public String getRequest() {
		return request;
	}

	private void setRequest(String request) {
		this.request = request;
	}

	public String getCommand() {
		return command;
	}

	private void setCommand(String command) {
		this.command = command;
	}

	public int[] getArgs() {
		return args;
	}

	private void setArgs(int[] args) {
		this.args = args;
	}

	public int getResult() {
		return result;
	}

	private void setResult(int result) {
		this.result = result;
	}

	public void proceedRequest (String request) {
		//разбираем строку
		String[] words= request.split(" ");
		String command="";
		if (words.length>0) command=words[0];
		int args[]= new int[words.length-1];
		for (int i=1; i<words.length;i++ ){
			args[i-1]=Integer.parseInt(words[i]);
		}
		this.setRequest(request);
		this.setCommand(command);
		this.setArgs(args);
	}

	public boolean proceedOperation (){
		boolean result =false;
		try {
			Command tmpObject = (Command) Class.forName("Samples.SamplePatternsCommandAndChain.Commands." + command).newInstance();
			this.setResult(tmpObject.execute(args));
			result = true;
		} catch (ClassNotFoundException e) {
			;
		} catch (IllegalAccessException e) {
			;
		} catch (InstantiationException e) {
			;
		}
		return result;
	}
}
