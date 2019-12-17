package chinesechess.mainview;

import chinesechess.chessMain;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class mainviewController {

    @FXML
    private Button startbutton;

    @FXML
    private Button setbutton;

    @FXML
    private Button exitbutton;

    private chessMain chessmain;

    @FXML
    private void initialize() throws IOException{

        startbutton.setOnAction(event -> {

            try {
                chessmain.showboardview();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        setbutton.setOnAction(event -> {

            try {
                chessmain.showsettingview();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        exitbutton.setOnAction(event -> {

            Platform.exit();

        });

    }

    public void setmain(chessMain chessmain){
        this.chessmain = chessmain;
    }

    public mainviewController() {
    }
}
