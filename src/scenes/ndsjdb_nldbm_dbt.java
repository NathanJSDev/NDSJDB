package scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import stages.App;

public class ndsjdb_nldbm_dbt {

    @FXML
    private Button canTouch;

    @FXML
    private TextField nocTF;

    @FXML
    private TextField tbnTF;

    @FXML
    void GTlink(MouseEvent event) {
        App.dialog.show();
    }

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void MoveablePanePress(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void MoveablePaneDrag(MouseEvent event) {
        App.primaryStage.getStg().setX(event.getScreenX() - xOffset);
        App.primaryStage.getStg().setY(event.getScreenY() - yOffset);
    }

    @FXML
    void close(ActionEvent event) {
        App.primaryStage.close();
    }

    @FXML
    void configurations(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[2]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void home(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[0]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void databases(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[1]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void maximize(ActionEvent event) {
        if (App.primaryStage.getStg().isFullScreen()) {
            App.primaryStage.getStg().setFullScreen(false);
        } else {
            App.primaryStage.getStg().setFullScreen(true);
        }
    }

    @FXML
    void minimize(ActionEvent event) {
        App.primaryStage.getStg().setIconified(true);
    }

    boolean cond1 = false;
    boolean cond2 = false;

    @FXML
    void nextBtn(ActionEvent event) {
        try {
            App.LDBController.createTable(tbnTF.getText(), Integer.parseInt(nocTF.getText()));

            App.primaryStage.getStg().getScene().setRoot(App.parents[7]);
            App.primaryStage.setScene(App.primaryStage.getStg().getScene());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void nocTFA(ActionEvent event) {
        if (nocTF.getText().isEmpty()){
            cond1 = false;    
            canTouch.setDisable(true);
        }else{
            cond1 = true;
            canTouch.setDisable(false);
        }
    }
    
    @FXML
    void tbnTFA(ActionEvent event) {
        if (tbnTF.getText().isEmpty()){
            cond2 = false;
            canTouch.setDisable(true);
        }else{
            cond2 = true;
            canTouch.setDisable(false);
        }
    }

}
