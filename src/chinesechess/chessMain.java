package chinesechess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class chessMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        BorderPane Root = FXMLLoader.load(getClass().getResource("board/chessboard.fxml"));
        stage.setTitle("Chinese chess 42");
        stage.getIcons().clear();
        stage.getIcons().add(new Image("/chinesechess/images/42.png"));
        Root.setBackground(new Background(new BackgroundFill((Color.valueOf("#696969")),new CornerRadii(15),null)));
        Scene board = new Scene(Root);
        board.setFill(Color.TRANSPARENT);
        stage.setScene(board);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}
