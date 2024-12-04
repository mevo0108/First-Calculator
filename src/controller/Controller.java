package controller;

import java.util.Observable;
import java.util.Observer;

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
		if (o==m) {
			int result = m.getResult();
			wl.display(result);

		}else
			if(o==wl) {
				m.calculate();
		}

	}

}
