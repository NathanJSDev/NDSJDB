package stages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    public static Parent[] parents = new App().getMainView();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public Parent[] getMainView(){
        try {
            Parent[] pa = new Parent[6];
            pa[0] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb.fxml")).load();
            pa[1] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-dbs.fxml")).load();
            pa[2] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-conf.fxml")).load();
            pa[3] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-ldbm.fxml")).load();
            // pa[4] = new FXMLLoader(getClass().getResource("../scenes/ndsjdb-cdbs.fxml")).load();
            pa[5] = new FXMLLoader(getClass().getResource("../scenes/gtlELC.fxml")).load();

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

    static void writeOn(String Path, String text) throws FileNotFoundException {
        final File file = new File(Path);

        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.print(text);
            System.out.println("Dados gravados com sucesso em: " + Path);
        } catch (IOException e) {
            System.out.println("File not created!!\nCause: ");
            e.printStackTrace();
        }
    }

}