package view;


import java.util.Observable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainWindowLogic extends Observable {

	@FXML
	Label resultLabel;
	@FXML
	private Label inputLabel;
	public boolean plusOrMinus = true;

	@FXML
	private void handleButtonClicked(ActionEvent event) {
		String buttonText = ((Button) event.getSource()).getText();
		setChanged();
		notifyObservers(buttonText);
	}

	public void displayInput(String input) {
		inputLabel.setText(input);
	}

	public void displayResult(double result) {
		resultLabel.setText(String.valueOf(result));
		clearInput();
	}

	public void clearInput() {
		inputLabel.setText("");
	}

}