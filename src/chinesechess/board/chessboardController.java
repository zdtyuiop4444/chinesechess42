package chinesechess.board;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

public class chessboardController {
    @FXML
    private Group Advisorbl;

    @FXML
    private Group Cannonbl;

    @FXML
    private Group Chariotbl;

    @FXML
    private Group Elephantbl;

    @FXML
    private Group Advisorrr;

    @FXML
    private Group Soldierrll;

    @FXML
    private Group Soldierrrr;

    @FXML
    private Group Chariotbr;

    @FXML
    private Group Elephantrr;

    @FXML
    private Group Cannonbr;

    @FXML
    private Group Horserl;

    @FXML
    private Group Soldierrl;

    @FXML
    private Group Elephantrl;

    @FXML
    private BorderPane root;

    @FXML
    private Group Generalb;

    @FXML
    private Group Advisorbr;

    @FXML
    private Group Soldierbll;

    @FXML
    private Group Soldierbrr;

    @FXML
    private Group Horserr;

    @FXML
    private Group Soldierrc;

    @FXML
    private GridPane gameboard;

    @FXML
    private Group Horsebl;

    @FXML
    private Group Soldierbl;

    @FXML
    private Group Generalr;

    @FXML
    private Group Horsebr;

    @FXML
    private Group Soldierbc;

    @FXML
    private Group Soldierrr;

    @FXML
    private Group Advisorrl;

    @FXML
    private Group Cannonrl;

    @FXML
    private Group Chariotrl;

    @FXML
    private Group Elephantbr;

    @FXML
    private Group Chariotrr;

    @FXML
    private Group Soldierbr;

    @FXML
    private Group Cannonrr;

    @FXML
    private Button savebutton;

    @FXML
    private Button loadbutton;

    @FXML
    private Button regretbutton;

    @FXML
    private Button defeatbutton;

    @FXML
    private Button sendbutton;

    @FXML
    private TextArea loglist;

    @FXML
    private TextArea inputarea;

    @FXML
    private TextFlow turnshower;

    @FXML
    private FlowPane bdead;

    @FXML
    private FlowPane rdead;

    @FXML
    private void initialize() {
        root.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
    }

    public chessboardController(){

    }
}
