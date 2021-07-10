package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable {

	@FXML
	private TextField txtNumberInput;
	@FXML
	private Button btGuess;
	@FXML
	private Button btRestart;
	@FXML
	private Label labelTriesLeft;
	@FXML
	private Label labelAnswer;
	
	public void onBtGuessAction() {
		System.out.println("onBtGuessAction");
	}
	
	public void onBtRestartAction() {
		System.out.println("onBtRestartAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
	}
	
	public void initializeNodes() {
		
	}

	
	
}
