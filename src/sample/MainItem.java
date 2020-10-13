package sample;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainItem {
    private SimpleLongProperty ID;
    private SimpleStringProperty CPU,User,StartInstant,CMD;

    public MainItem(Long ID, String CPU, String User, String StartInstant, String CMD){
        this.ID = new SimpleLongProperty(ID);
        this.CPU = new SimpleStringProperty(CPU);
        this.User = new SimpleStringProperty(User);
        this.StartInstant = new SimpleStringProperty(StartInstant);
        this.CMD = new SimpleStringProperty(CMD);
    }

    public long getID() {
        return ID.get();
    }

    public void setID(long ID) {
        this.ID.set(ID);
    }

    public String getCPU() {
        return CPU.get();
    }

    public void setCPU(String CPU) {
        this.CPU.set(CPU);
    }

    public String getUser() {
        return User.get();
    }


    public void setUser(String user) {
        this.User.set(user);
    }

    public String getStartInstant() {
        return StartInstant.get();
    }

    public void setStartInstant(String startInstant) {
        this.StartInstant.set(startInstant);
    }

    public String getCMD() {
        return CMD.get();
    }

    public void setCMD(String CMD) {
        this.CMD.set(CMD);
    }
}
