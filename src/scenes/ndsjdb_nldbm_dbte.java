package scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import stages.App;

public class ndsjdb_nldbm_dbte {

    @FXML
    private Button canTouch;

    @FXML
    private TextField colN;

    @FXML
    private ChoiceBox<?> colSK;

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

        String PathIndex = App.LDBController.getUSER_DIR() + App.LDBController.getSEPARATOR() + App.LDBController.getDATABASES_FOLDER() + App.LDBController.getSEPARATOR() + App.LDBController.getInstantWorksFolder() + App.LDBController.getSEPARATOR() + "tables.csv";
        String Path = App.LDBController.getUSER_DIR() + App.LDBController.getSEPARATOR() + App.LDBController.getDATABASES_FOLDER() + App.LDBController.getSEPARATOR() + App.LDBController.getInstantWorksFolder() + App.LDBController.getSEPARATOR() + ".dat";

        try {
            System.out.println(PathIndex);
            System.out.println(Path);

            App.primaryStage.getStg().getScene().setRoot(App.parents[0]);
            App.primaryStage.setScene(App.primaryStage.getStg().getScene());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
