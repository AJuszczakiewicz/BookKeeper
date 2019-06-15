package book.keeper;

import book.keeper.database.db_utils.DbManager;
import book.keeper.utils.FxmlUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML_PATH = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.setProperty("file.encoding", "UTF-8");
        Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML_PATH);
       

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primaryStage.show();

        DbManager.initDatabase();
    }
}
