package sample;




import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class Controller {
    @FXML
    public TableColumn ID;
    public TableColumn CPU;
    public TableColumn User;
    public TableColumn StartInstant;
    public TableColumn CMD;
    public TableView tv;


    @FXML
    private void initialize(){
        this.ID.setCellValueFactory(new PropertyValueFactory<MainItem,Long>("ID"));

        this.CPU.setCellValueFactory(new PropertyValueFactory<MainItem,String>("CPU"));
        this.CPU.setCellFactory(TextFieldTableCell.forTableColumn());

        this.User.setCellValueFactory(new PropertyValueFactory<MainItem,String>("User"));
        this.User.setCellFactory(TextFieldTableCell.forTableColumn());

        this.StartInstant.setCellValueFactory(new PropertyValueFactory<MainItem,String>("StartInstant"));
        this.StartInstant.setCellFactory(TextFieldTableCell.forTableColumn());

        this.CMD.setCellValueFactory(new PropertyValueFactory<MainItem,String>("CMD"));
        this.CMD.setCellFactory(TextFieldTableCell.forTableColumn());

        this.tv.setItems(Main.data);
    }


    public void refresh(ActionEvent actionEvent) {
        Main.dataInit();
    }

    public void nProcess(ActionEvent actionEvent) {
        try {
            AnchorPane newWindow = FXMLLoader.load(getClass().getResource("newProcess.fxml"));
            Scene scene = new Scene(newWindow);
            Stage stage = new Stage();
            stage.setTitle("Add New");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
}
