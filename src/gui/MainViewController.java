package gui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import gui.utils.Alerts;
import gui.utils.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainViewController implements Initializable {

	private Integer randomNumber;
	private Integer tries = 15;

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
		try {
			guessNumber();
		}catch(NumberFormatException e) {
			Alerts.showAlert("Error!", null, "TextField can't be empty!", AlertType.ERROR);
		}
		
	}

	public void onBtRestartAction() {
		resetGame();
	}

	

	private void resetGame() {
		labelTriesLeft.setText("");
		labelAnswer.setText("");
		this.tries = 15;
		labelTriesLeft.setText(String.valueOf(tries));
		btGuess.setVisible(true);
		txtNumberInput.setEditable(true);
		txtNumberInput.setText("");
		createRandomNumber();
	}
	
	private void guessNumber() {
		int numberInput = Integer.parseInt(txtNumberInput.getText());
		if (numberInput != randomNumber) {
			tries -= 1;
			if (tries == 0) {
				labelTriesLeft.setText("0");
				labelAnswer.setText("You lost! The answer was " + String.valueOf(randomNumber));
				disableComponents();
			} else {
				labelAnswer.setText("Incorrect. Try again!");
				labelTriesLeft.setText(String.valueOf(tries));
			}
		} else {
			labelAnswer.setText("You got it! The number was" + String.valueOf(randomNumber));
			disableComponents();
		}
	}

	private void disableComponents() {
		btGuess.setVisible(false);
		txtNumberInput.setEditable(false);
	}

	private void createRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(51);
		randomNumber = number;
	}

	public void initializeNodes() {

		Constraints.setTextFieldMax(txtNumberInput, 3);
		Constraints.setTextFieldToInteger(txtNumberInput);
		labelTriesLeft.setText(String.valueOf(tries));
		createRandomNumber();

	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initializeNodes();

	}
}
