package view;


import java.io.File;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainWindowLogic extends Observable{

	@FXML
	Label resultLabel;

	public void print() {
		System.out.println("helloWolrd");
	}

	public void generate() {
		setChanged();
		notifyObservers();
	}

	public void display(int result) {

		resultLabel.textProperty().set(""+result);
	}

}
