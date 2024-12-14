package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Button;
import model.Model;
import view.MainWindowLogic;

public class Controller implements Observer{

	Model m;
	MainWindowLogic wl;



	public Controller(Model m,MainWindowLogic wl) {
		this.m = m;
		m.addObserver(this);
		this.wl = wl;
		wl.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {

		if(o==wl & arg instanceof String) { //When a button is clicked
			String input = (String) arg;

			if (input.matches("[+\\-*/]")) {
				handleOperation(input);
			} else if (input.equals("=")) {
				handleCalculation();
			} else {
				m.appendToInput(input); // Append the clicked number to the input
				wl.displayInput(m.getCurrentExpression());
			}
		}

		if (o==m) {
			wl.displayInput(m.getCurrentExpression());
			wl.displayResult(m.getResult());
		}
	}

	private void handleOperation(String opp){
		double currentValue = Double.parseDouble(m.getCurrentExpression().trim().split(" ")[0]);

		m.setFirstInput(currentValue);
		m.setOperation(opp);
		wl.displayInput(m.getCurrentExpression());
	}
	private void handleCalculation(){
		double currentValue = Double.parseDouble(m.getCurrentExpression().trim().split(" ")[2]);
		m.setLastInput(currentValue);
		m.calculate();

	}
}