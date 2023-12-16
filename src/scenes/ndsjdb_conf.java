package scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import stages.App;

public class ndsjdb_conf {

   @FXML
    void GTlink(MouseEvent event) {

    }

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void MoveablePanePress(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void MoveablePaneDrag(MouseEvent event){
        App.primaryStage.getStg().setX(event.getScreenX() - xOffset);
        App.primaryStage.getStg().setY(event.getScreenY() - yOffset);
    }

    @FXML
    void close(ActionEvent event) {
        System.out.println("close");
        App.primaryStage.close();
    }

    @FXML
    void databases(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[1]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void home(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[0]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void maximize(ActionEvent event) {
        System.out.println("maximize");
        if (App.primaryStage.getStg().isFullScreen()) {
            App.primaryStage.getStg().setFullScreen(false);
        }else{
            App.primaryStage.getStg().setFullScreen(true);
        }
    }

    @FXML
    void minimize(ActionEvent event) {
        System.out.println("minimize");
        App.primaryStage.getStg().setIconified(true);
    }


}
