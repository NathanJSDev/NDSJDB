package stages;

import LDatabaseControllers.LDBController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    public static LDBController LDBController = new LDBController();

    public static Parent[] parents = new App().getMainView();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public Parent[] getMainView(){
        try {
            Parent[] pa = new Parent[8];
            pa[0] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb.fxml")).load();
            pa[1] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-dbs.fxml")).load();
            pa[2] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-conf.fxml")).load();
            pa[3] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-ldbm-viewer.fxml")).load();
            pa[4] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-nldbm-dbn.fxml")).load();
            pa[5] = new FXMLLoader(getClass().getResource("../scenes/gtlELC.fxml")).load();
            pa[6] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-nldbm-dbt.fxml")).load();
            pa[7] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-nldbm-dbte.fxml")).load();

            return pa;
        } catch (Exception e) {
            return null;
        }
    }

    public static Stg primaryStage = new Stg();
    public static Stg dialog = new Stg();

    @Override
    public void start(Stage ps) throws Exception {
        primaryStage.setStg(ps);
        primaryStage.setScene(new Scene(parents[0]));
        primaryStage.setResizable(false);
        primaryStage.setStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("NDSJDB v1.0");
        primaryStage.show();

        dialog.setStg(new Stage(StageStyle.TRANSPARENT));
        dialog.setResizable(false);
        dialog.setScene(new Scene(parents[5]));
        dialog.setTitle("Open this external link?");

    }
}