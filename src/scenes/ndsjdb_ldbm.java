package scenes;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import LDatabaseControllers.Encrypter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import stages.App;

public class ndsjdb_ldbm implements Initializable{

    @FXML
    private HBox ItArea;

    @FXML
    private BorderPane ItAreaParent;

    @FXML
    void GTlink(MouseEvent event){
        App.dialog.show();  
    }

    @FXML
    void scrolling(ScrollEvent event) {
        if (event.getDeltaY()<0 && (ItArea.getPrefHeight()>ItAreaParent.getHeight())) {
            System.out.println("sf");
        }else if (event.getDeltaY()>0 && (ItArea.getPrefHeight()>ItAreaParent.getHeight())) {
            System.out.println("sdvfd");
        }
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
        }else{
            App.primaryStage.getStg().setFullScreen(true);
        }
    }

    @FXML
    void minimize(ActionEvent event) {
        App.primaryStage.getStg().setIconified(true);
    }

    private String FileName = "ldbmtest.txt";
    private String FilePath = "Demo";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<BorderPane> bpl = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(App.class.getResource("../DataBases/"+FilePath+"/"+FileName).toURI()))){
            
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }

            String EncText = sb.toString();

            Encrypter decrypter = new Encrypter();

            String[] DecTextCols = decrypter.Decrypt(EncText).split(":|¨");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
