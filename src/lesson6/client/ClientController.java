package lesson6.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController {

    @FXML public TextArea textArea;
    @FXML public TextField textField;
    @FXML public Button sendButton;
    @FXML public ListView<String> userList;

    public void sendMessage() {  // пишем сообщение в чат
        if(!textField.getText().isEmpty()) { // чтобы пустая строка не попадала на экран ввода
            textArea.appendText(textField.getText());
            textArea.appendText(System.lineSeparator()); // пишем текст , переносит на новую строку
            textField.clear();
        }
    }
}