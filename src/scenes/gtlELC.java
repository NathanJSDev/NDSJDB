package scenes;

import javafx.fxml.FXML;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import stages.App;

public class gtlELC {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void MoveablePanePress(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void MoveablePaneDrag(MouseEvent event){
        App.dialog.getStg().setX(event.getScreenX() - xOffset);
        App.dialog.getStg().setY(event.getScreenY() - yOffset);
    }

    @FXML
    void open(ActionEvent event) throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("https://github.com/NathanJSDev/NDSJDB"));
    }

    @FXML
    void cancel(ActionEvent event) {
        App.dialog.close();
    }

    @FXML
    void close(ActionEvent event) {
        App.dialog.close();
    }

    @FXML
    void minimize(ActionEvent event) {
        App.dialog.getStg().setIconified(true);
    }

}
