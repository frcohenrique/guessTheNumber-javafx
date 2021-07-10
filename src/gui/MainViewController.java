package gui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import gui.utils.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable {

	private Integer randomNumber;
	private Integer tries = 10;
	
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
		int numberInput = Integer.parseInt(txtNumberInput.getText());
		if (numberInput != randomNumber) {
			tries -= 1;
			if (tries == 0) {
				labelAnswer.setText("You lost! The answer was " + String.valueOf(randomNumber));
				disableComponents();
			}
			else {
				labelAnswer.setText("Incorrect. Try again!");
				labelTriesLeft.setText(String.valueOf(tries));
			}
		}
		else {
			labelAnswer.setText("You got it! The number was" + String.valueOf(randomNumber));
			disableComponents();
		}
		System.out.println("onBtGuessAction");
	}
	
	public void onBtRestartAction() {
		resetGame();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		initializeNodes();
		
	}
	
	public void initializeNodes() {
		
		Constraints.setTextFieldMax(txtNumberInput, 3);
		Constraints.setTextFieldToInteger(txtNumberInput);
		labelTriesLeft.setText(String.valueOf(tries));
		createRandomNumber();
		
	}
	
	private void resetGame() {
		labelTriesLeft.setText("");
		labelAnswer.setText("");
		this.tries = 5;
		btGuess.setVisible(true);
		txtNumberInput.setEditable(true);
		txtNumberInput.setText("");
		createRandomNumber();
	}
	
	private void disableComponents() {
		btGuess.setVisible(false);
		txtNumberInput.setEditable(false);
	}

	public void createRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(5);
		randomNumber = number;
	}
	
	
}
