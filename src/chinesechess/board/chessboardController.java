package chinesechess.board;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class chessboardController {
    @FXML
    public Circle carbli;
    @FXML
    private BorderPane root;
    @FXML
    public GridPane gameboard;
    @FXML
    private Circle carbl;

    private DoubleProperty em = new SimpleDoubleProperty(80);

    @FXML
    private void initialize() {
        root.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                em.set(newValue.doubleValue()/10);
            }
        });
    }

    public chessboardController(){

    }
}
