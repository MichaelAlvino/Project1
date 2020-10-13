package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class newProcess {

    public TextField tvpopup;
    public Button add;
    public Button cancel;


    @FXML
    public void add(ActionEvent actionEvent) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder(this.tvpopup.getText());
        pBuilder.start();

    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) this.cancel.getScene().getWindow();
        stage.close();
    }

}
