package chinesechess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class chessMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent Root = FXMLLoader.load(getClass().getResource("board/chessboard.fxml"));
        stage.setTitle("Chinese chess 42");
        stage.getIcons().clear();
        stage.getIcons().add(new Image("/chinesechess/images/42.png"));
        stage.setScene(new Scene(Root));
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}
