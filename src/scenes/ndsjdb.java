package scenes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import stages.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ndsjdb implements Initializable{

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
    void GTlink(MouseEvent event) {
        System.out.println("gtl");
    }
    
    @FXML
    void close(ActionEvent event) {
        System.out.println("close");
        App.primaryStage.close();
    }

    @FXML
    void configurations(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[2]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }

    @FXML
    void createDB(MouseEvent event) {
        System.out.println("createDB");
    }

    @FXML
    void createLDB(MouseEvent event) {
        System.out.println("createLDB");
    }

    @FXML
    void databases(MouseEvent event) {
        App.primaryStage.getStg().getScene().setRoot(App.parents[1]);
        App.primaryStage.setScene(App.primaryStage.getStg().getScene());
    }
    
    @FXML
    void SeeAllDatabases(ActionEvent event) {
        System.out.println("SeeAllDatabases");
        App.primaryStage.setScene(new Scene(App.parents[1]));
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

    @SuppressWarnings("undefined")
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
