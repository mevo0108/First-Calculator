package model;

import java.util.Observable;

public class Model extends Observable{

	private double firstInput, lastInput;
	private String input = new String();
	private double result;
	private String operation = "";
	private String currentExpression = ""; // שומר את מה שהמשתמש הקליד


	public void calculate() {

		switch (operation){
			case "+":
				result = firstInput+lastInput;
				break;
			case "-":
				result = firstInput-lastInput;
				break;
			case "*":
				result = firstInput*lastInput;
				break;
			case "/":
				if (lastInput == 0){
					throw new ArithmeticException("Division By Zero");
				}
				result = (firstInput/lastInput);
				break;
			default:
				throw new IllegalArgumentException("Unknown operation: " + operation);
		}
		currentExpression = String.valueOf(result);
		setChanged();
		notifyObservers();
}

	public void appendToInput(String value) {
		currentExpression += value;
		setChanged();
		notifyObservers(); // Notify observers about the change in input
	}
	public double getResult() {
		return result;
	}

	public void setFirstInput(double value){
		this.firstInput = value;
	}
	public void setLastInput(double value){
		this.lastInput = value;
	}
	public void setOperation(String opp){
		this.operation = opp;
		currentExpression += " " + operation + " ";
	}
	public String getCurrentExpression(){
		return currentExpression;
	}

}
