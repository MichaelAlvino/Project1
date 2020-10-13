package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    VBox root;
    Label topLabel;
    static ObservableList<MainItem> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.root = FXMLLoader.load(getClass().getResource("container.fxml"));


        dataInit();
        primaryStage.setTitle("Java Process Manager");

        primaryStage.setScene(new Scene(this.root));
        primaryStage.setOnHidden(event -> Platform.exit());
        primaryStage.show();
    }

    public static void dataInit(){
        data.clear();
        ProcessHandle.allProcesses().forEach(process -> dataInsert(process));
    }

    public static void dataInsert(ProcessHandle process){
        data.add(new MainItem(process.pid(), text(process.info().totalCpuDuration()), text(process.info().user()), text(process.info().startInstant()), text(process.info().command())));
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
