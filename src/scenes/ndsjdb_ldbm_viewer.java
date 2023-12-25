package scenes;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import LDatabaseControllers.Encrypter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import stages.App;

public class ndsjdb_ldbm_viewer implements Initializable {

    private final String ColumnSeparator = "\"";
    private final String RowSeparator = "\'";
    
    @FXML
    private TableView<String[]> table;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTable();
    }

    ObservableList<String[]> data = FXCollections.observableArrayList();
    String[][] staffArray;
    
    private void refreshTable(){
        staffArray = GetOfFileAndDecrypt("Demo", "ldbmtest.dat");
        data.addAll(Arrays.asList(staffArray));
        data.remove(0);//remove titles from data
        for (int i = 0; i < staffArray[0].length; i++) {
            TableColumn<String[],String> tc = new TableColumn<>(staffArray[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>() {@Override public ObservableValue<String> call(CellDataFeatures<String[], String> p) {return new SimpleStringProperty((p.getValue()[colNo]));}});
            table.getColumns().add(tc);
        }
        table.setItems(data);
    }
    
    private String[][] GetOfFileAndDecrypt(String FilePath,String FileName) {
        final String USER_DIR = System.getProperty("user.dir");
        final String SEPARATOR = System.getProperty("file.separator");
        final String DATABASES_FOLDER = "DataBases";

        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(USER_DIR + SEPARATOR + DATABASES_FOLDER + SEPARATOR + FilePath + SEPARATOR + FileName))) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            String[] a = new Encrypter().Decrypt(sb.toString()).split(ColumnSeparator);
            String[][] b = new String[a.length][];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i].split(RowSeparator);
            }
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}