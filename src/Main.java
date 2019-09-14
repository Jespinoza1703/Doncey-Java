import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Stage menuWindow;

    /**
     * inicializes the game menu scene as well as the board actual instance with Singleton
     * @param primaryStage first scene
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        menuWindow = primaryStage;
        menuWindow.setWidth(1024);
        menuWindow.setHeight(768);
        changeScenes("layouts/menu.fxml");
        menuWindow.show();
        menuWindow.setResizable(false);
        menuWindow.setOnCloseRequest(e-> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Chenges between scenarios
     * @param scene scenario
     * @throws IOException
     */
    public static void changeScenes(String scene) throws IOException {
        Parent newRoot = FXMLLoader.load(Main.class.getResource(scene));
        Scene newScene = new Scene(newRoot);
        menuWindow.setScene(newScene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
