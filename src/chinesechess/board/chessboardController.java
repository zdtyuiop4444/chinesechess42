package chinesechess.board;

import com.sun.glass.ui.CommonDialogs;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

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
    private Text turnshower;

    @FXML
    private FlowPane bdead;

    @FXML
    private FlowPane rdead;

    public Group[] black = new Group[16];
    public Group[] red = new Group[16];
    public Group[] G = new Group[1];
    public Group[] C = new Group[2];
    public Group[] H = new Group[2];
    public Group[] E = new Group[2];
    public Group[] A = new Group[2];
    public Group[] N = new Group[2];
    public Group[] S = new Group[5];
    public Group[] g = new Group[1];
    public Group[] c = new Group[2];
    public Group[] h = new Group[2];
    public Group[] e = new Group[2];
    public Group[] a = new Group[2];
    public Group[] n = new Group[2];
    public Group[] s = new Group[5];
    public char[][] game = new char[9][11];


    @FXML
    private void initialize() {

        black[0] = Generalb;
        black[1] = Advisorbl;
        black[2] = Advisorbr;
        black[3] = Elephantbl;
        black[4] = Elephantbr;
        black[5] = Horsebl;
        black[6] = Horsebr;
        black[7] = Chariotbl;
        black[8] = Chariotbr;
        black[9] = Cannonbl;
        black[10] = Cannonbr;
        black[11] = Soldierbll;
        black[12] = Soldierbl;
        black[13] = Soldierbc;
        black[14] = Soldierbr;
        black[15] = Soldierbrr;
        G[0] = Generalb;
        C[0] = Chariotbl;
        C[1] = Chariotbr;
        H[0] = Horsebl;
        H[1] = Horsebr;
        E[0] = Elephantbl;
        E[1] = Elephantbr;
        A[0] = Advisorbl;
        A[1] = Advisorbr;
        N[0] = Cannonbl;
        N[1] = Cannonbr;
        S[0] = Soldierbll;
        S[1] = Soldierbl;
        S[2] = Soldierbc;
        S[3] = Soldierbr;
        S[4] = Soldierbrr;

        red[0] = Generalr;
        red[1] = Advisorrl;
        red[2] = Advisorrr;
        red[3] = Elephantrl;
        red[4] = Elephantrr;
        red[5] = Horserl;
        red[6] = Horserr;
        red[7] = Chariotrl;
        red[8] = Chariotrr;
        red[9] = Cannonrl;
        red[10] = Cannonrr;
        red[11] = Soldierrll;
        red[12] = Soldierrl;
        red[13] = Soldierrc;
        red[14] = Soldierrr;
        red[15] = Soldierrrr;
        g[0] = Generalr;
        c[0] = Chariotrl;
        c[1] = Chariotrr;
        h[0] = Horserl;
        h[1] = Horserr;
        e[0] = Elephantrl;
        e[1] = Elephantrr;
        a[0] = Advisorrl;
        a[1] = Advisorrr;
        n[0] = Cannonrl;
        n[1] = Cannonrr;
        s[0] = Soldierrll;
        s[1] = Soldierrl;
        s[2] = Soldierrc;
        s[3] = Soldierrr;
        s[4] = Soldierrrr;

        loadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage loads = new Stage();

                FileChooser loadfc = new FileChooser();

                loadfc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("棋局文件", "*.chessboard"));

                File in = loadfc.showOpenDialog(loads);

                if (in == null) {
                    return;
                } else {
                    try {
                        readmap(in);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

    }

    public chessboardController() {

    }

    public void readmap(File gamemap) throws IOException {

        FileReader fr = new FileReader(gamemap);

        BufferedReader br = new BufferedReader(fr);

        boolean lastmover = false;
        boolean mataover = false;
        boolean chessstart = false;
        boolean chessover = false;

        int num = 0;

        String str = "";

        while ((str = br.readLine()) != null) {
            str = str.split("#")[0];
            if (!mataover && str.charAt(0) == '@') {
                if (str.charAt(1) == '@') {
                    mataover = true;
                    continue;
                } else {
                    if (str.matches("@LAST_MOVER=BLACK")) {
                        lastmover = true;
                        turnshower.setText("Red Turn");
                        turnshower.setFill(Paint.valueOf("#F09595"));
                    } else if (str.matches("@LAST_MOVER=RED")) {
                        lastmover = true;
                        turnshower.setText("Black Turn");
                        turnshower.setFill(Paint.valueOf("#393E46"));
                    }
                }
                continue;
            }
            if (mataover) {
                if (!lastmover) {
                    showalert("缺少行棋方数据");
                    readmap(new File("basicgame.chessboard"));
                    loglist.appendText("棋局重开\n");
                    return;
                }
                if (!str.equals("")) {
                    showalert("空白符丢失");
                    readmap(new File("basicgame.chessboard"));
                    loglist.appendText("棋局重开\n");
                    return;
                }
                chessstart = true;
                mataover = false;
                continue;
            }

            if (chessstart) {

                if (num == 11) {

                    if (!str.equals("")) {
                        showalert("棋局长度错误");
                        readmap(new File("basicgame.chessboard"));
                        loglist.appendText("棋局重开\n");
                    }

                    return;

                }

                if (str.length() != 9) {

                    showalert("棋局宽度错误");
                    readmap(new File("basicgame.chessboard"));
                    loglist.appendText("棋局重开\n");
                    return;

                } else {

                    for (int i = 0; i < 9; i++) {
                        game[i][num] = str.charAt(i);
                    }

                    num++;

                }

            }

        }

        if (num != 11) {

            showalert("棋局长度错误");
            readmap(new File("basicgame.chessboard"));
            loglist.appendText("棋局重开\n");
            return;

        }

        resetgame();

        loglist.appendText("读取成功\n");

        fr.close();
        br.close();

    }

    public void resetgame() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {


            }
        }

    }

    public void showalert(String content) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setContentText(content);

        gamealert.show();

    }

    public void kill(int[] pos) {


    }

    public void move(int[] posb, int[] posa) {

    }


}
