package stages;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stg {
    private Stage MainStage = new Stage();
    Stage[] Stages = new Stage[8];

    public Stg(){
        for (Stage stage : Stages) {
            stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
        }
        this.MainStage.setResizable(false);
        this.MainStage.initStyle(StageStyle.UNDECORATED);
        Stages[0] = MainStage;
    }

    public Stage getStg() {
        return MainStage;
    }

    public void setStg(Stage MainStage) {
        this.MainStage = MainStage;
    }

    public void setScene(Scene sc){
        this.MainStage.setScene(sc);
    }

    public void setTitle(String t){
        this.MainStage.setTitle(t);
    }

    public void setResizable(boolean b){
        this.MainStage.setResizable(b);
    }

    public void setStyle(StageStyle ss){
        this.MainStage.initStyle(ss);
    }

    public void show(){
        this.MainStage.show();
    }

    public void close(){
        this.MainStage.close();
    }
}
