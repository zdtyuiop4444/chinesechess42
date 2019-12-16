package chinesechess.board;

import chinesechess.chessMain;
import com.sun.glass.ui.CommonDialogs;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

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
    private Button exitbutton;

    @FXML
    private Button sendbutton;

    @FXML
    private Button closebutton;

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

    @FXML
    private VBox rightpane;

    @FXML
    private FlowPane leftpane;

    @FXML
    private TextFlow showerborder;

    private chessMain chessmain;

    public List<Circle> possibleindicater = new ArrayList<>();

    public List<Group> pieces = new ArrayList<>();

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
    public char[][] game = new char[9][10];
    public char overmore = '0';
    public int errorline = 0;
    public int totalsteps = 0;
    public char dady = '0';
    public char baba = '0';
    public List<String> gamelog = new ArrayList<>();
    public List<String> deads = new ArrayList<>();
    public int[] activepos = new int[2];


    @FXML
    private void initialize() throws IOException {

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

        pieces.addAll(Arrays.asList(black));

        pieces.addAll(Arrays.asList(red));

        for (Group pic : pieces) {

            pic.setOnMouseClicked(event -> {

                recallpossible();

                activepos[0] = GridPane.getColumnIndex(pic);
                activepos[1] = GridPane.getRowIndex(pic);

                showpossible(activepos);

            });

        }

        for (int i = 0; i < 20; i++) {

            possibleindicater.add(new Circle());

            Circle temp = possibleindicater.get(i);

            temp.setFill(Paint.valueOf("transparent"));
            temp.setRadius(33);
            temp.setStroke(Paint.valueOf("#57BD06"));
            temp.setStrokeType(StrokeType.INSIDE);
            temp.setStrokeWidth(4.0);
            temp.scaleXProperty().bind(root.heightProperty().multiply(0.1 / 72));
            temp.scaleYProperty().bind(root.heightProperty().multiply(0.1 / 72));
            temp.setOpacity(0.5);

            temp.setOnMouseClicked(event -> {

                int[] pos = new int[2];

                pos[0] = GridPane.getColumnIndex(temp);
                pos[1] = GridPane.getRowIndex(temp);

                move(activepos, pos, game[activepos[0]][activepos[1]]);

            });

        }

        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);

        leftpane.setOnMousePressed(event -> {

            x.set(event.getX());
            y.set(event.getY());

        });

        leftpane.setOnMouseDragged(event -> {

            chessmain.getStage().setX(event.getScreenX() - x.get());

            chessmain.getStage().setY(event.getScreenY() - y.get());

        });

        rightpane.setOnMousePressed(event -> {

            x.set(event.getX());
            y.set(event.getY());

        });

        rightpane.setOnMouseDragged(event -> {

            chessmain.getStage().setX(event.getScreenX() - x.get() - gameboard.getWidth() - 300);

            chessmain.getStage().setY(event.getScreenY() - y.get());

        });

        loadbutton.setOnAction(event -> {

            Stage loads = new Stage();

            FileChooser loadfc = new FileChooser();

            loadfc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("棋局文件", "*.chessboard"), new FileChooser.ExtensionFilter("棋谱文件", "*.chessmoveseq"));

            loadfc.setInitialDirectory(new File("./"));

            File in = loadfc.showOpenDialog(loads);

            if (in.getName().substring(in.getName().lastIndexOf(".")).equals(".chessboard")) {
                try {
                    readmap(in, false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (in.getName().substring(in.getName().lastIndexOf(".")).equals(".chessmoveseq")) {
                try {
                    readmoveseq(in);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        savebutton.setOnAction(event -> {

            Stage saves = new Stage();

            FileChooser savefc = new FileChooser();

            savefc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("棋局文件", "*.chessboard"), new FileChooser.ExtensionFilter("棋谱文件", "*.chessmoveseq"));

            savefc.setInitialDirectory(new File("./"));

            File out = savefc.showSaveDialog(saves);

            if (out.getName().substring(out.getName().lastIndexOf(".")).equals(".chessboard")) {
                try {
                    savemap(out);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (out.getName().substring(out.getName().lastIndexOf(".")).equals(".chessmoveseq")) {
                try {
                    savemoveseq(out);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        regretbutton.setOnAction(event -> {

            regret();

        });

        exitbutton.setOnAction(event -> {

            try {
                chessmain.showmainview();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        closebutton.setOnAction(event -> {

            Platform.exit();

        });

        readmap(new File("src/chinesechess/board/basicgame.chessboard"), true);

    }

    public void setmain(chessMain chessmain) {
        this.chessmain = chessmain;
    }

    public chessboardController() {

    }

    public void showpossible(int[] pos) {

        char type;
        char types;
        boolean uend = false;
        boolean dend = false;
        boolean lend = false;
        boolean rend = false;

        List<int[]> possiblepos = new ArrayList<>();

        if (dady == 'b') {
            if (Character.isUpperCase(game[pos[0]][pos[1]])) {
                types = 'C';
            }else{
                types = game[pos[0]][pos[1]];
            }
        } else if (dady == 'r'){
            if (Character.isLowerCase(game[pos[0]][pos[1]])) {
                types = 'c';
            }else{
                types = game[pos[0]][pos[1]];
            }
        }else{
            types = game[pos[0]][pos[1]];
        }

        type = game[pos[0]][pos[1]];

        switch (types) {
            case 'G':

                if (pos[1] - 1 >= 0 && !Character.isUpperCase(game[pos[0]][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0], pos[1] - 1});

                }

                if (pos[1] + 1 < 3 && !Character.isUpperCase(game[pos[0]][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0], pos[1] + 1});

                }

                if (pos[0] - 1 > 2 && !Character.isUpperCase(game[pos[0] - 1][pos[1]])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1]});

                }

                if (pos[0] + 1 < 6 && !Character.isUpperCase(game[pos[0] + 1][pos[1]])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1]});

                }

                break;

            case 'g':

                if (pos[1] - 1 > 6 && !Character.isLowerCase(game[pos[0]][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0], pos[1] - 1});

                }

                if (pos[1] + 1 < 10 && !Character.isLowerCase(game[pos[0]][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0], pos[1] + 1});

                }

                if (pos[0] - 1 > 2 && !Character.isLowerCase(game[pos[0] - 1][pos[1]])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1]});

                }

                if (pos[0] + 1 < 6 && !Character.isLowerCase(game[pos[0] + 1][pos[1]])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1]});

                }

                break;

            case 'A':

                if (pos[0] - 1 > 2 && pos[1] - 1 >= 0 && !Character.isUpperCase(game[pos[0] - 1][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1] - 1});

                }

                if (pos[0] - 1 > 2 && pos[1] + 1 < 3 && !Character.isUpperCase(game[pos[0] - 1][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1] + 1});

                }

                if (pos[0] + 1 < 6 && pos[1] - 1 >= 0 && !Character.isUpperCase(game[pos[0] + 1][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1] - 1});

                }

                if (pos[0] + 1 < 6 && pos[1] + 1 < 3 && !Character.isUpperCase(game[pos[0] + 1][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1] + 1});

                }

                break;

            case 'a':

                if (pos[0] - 1 > 2 && pos[1] - 1 > 6 && !Character.isLowerCase(game[pos[0] - 1][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1] - 1});

                }

                if (pos[0] - 1 > 2 && pos[1] + 1 < 10 && !Character.isLowerCase(game[pos[0] - 1][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0] - 1, pos[1] + 1});

                }

                if (pos[0] + 1 < 6 && pos[1] - 1 > 6 && !Character.isLowerCase(game[pos[0] + 1][pos[1] - 1])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1] - 1});

                }

                if (pos[0] + 1 < 6 && pos[1] + 1 < 10 && !Character.isLowerCase(game[pos[0] + 1][pos[1] + 1])) {

                    possiblepos.add(new int[]{pos[0] + 1, pos[1] + 1});

                }

                break;

            case 'E':

                if (pos[0] - 2 >= 0 && pos[1] - 2 >= 0 && !Character.isUpperCase(game[pos[0] - 2][pos[1] - 2])) {

                    if (game[pos[0] - 1][pos[1] - 1] == '.') {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] - 2});
                    }

                }

                if (pos[0] - 2 >= 0 && pos[1] + 2 < 5 && !Character.isUpperCase(game[pos[0] - 2][pos[1] + 2])) {

                    if (game[pos[0] - 1][pos[1] + 1] == '.') {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] + 2});
                    }

                }

                if (pos[0] + 2 < 9 && pos[1] - 2 >= 0 && !Character.isUpperCase(game[pos[0] + 2][pos[1] - 2])) {

                    if (game[pos[0] + 1][pos[1] - 1] == '.') {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] - 2});
                    }

                }

                if (pos[0] + 2 < 9 && pos[1] + 2 < 5 && !Character.isUpperCase(game[pos[0] + 2][pos[1] + 2])) {

                    if (game[pos[0] + 1][pos[1] + 1] == '.') {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] + 2});
                    }

                }

                break;

            case 'e':

                if (pos[0] - 2 >= 0 && pos[1] - 2 > 4 && !Character.isLowerCase(game[pos[0] - 2][pos[1] - 2])) {

                    if (game[pos[0] - 1][pos[1] - 1] == '.') {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] - 2});
                    }

                }

                if (pos[0] - 2 >= 0 && pos[1] + 2 < 10 && !Character.isLowerCase(game[pos[0] - 2][pos[1] + 2])) {

                    if (game[pos[0] - 1][pos[1] + 1] == '.') {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] + 2});
                    }

                }

                if (pos[0] + 2 < 9 && pos[1] - 2 > 4 && !Character.isLowerCase(game[pos[0] + 2][pos[1] - 2])) {

                    if (game[pos[0] + 1][pos[1] - 1] == '.') {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] - 2});
                    }

                }

                if (pos[0] + 2 < 9 && pos[1] + 2 < 10 && !Character.isLowerCase(game[pos[0] + 2][pos[1] + 2])) {

                    if (game[pos[0] + 1][pos[1] + 1] == '.') {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] + 2});
                    }

                }

                break;

            case 'H':

                if (pos[0] - 2 >= 0 && game[pos[0] - 1][pos[1]] == '.') {

                    if (pos[1] - 1 >= 0 && !Character.isUpperCase(game[pos[0] - 2][pos[1] - 1])) {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] - 1});
                    }

                    if (pos[1] + 1 < 10 && !Character.isUpperCase(game[pos[0] - 2][pos[1] + 1])) {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] + 1});
                    }

                }

                if (pos[0] + 2 < 9 && game[pos[0] + 1][pos[1]] == '.') {

                    if (pos[1] - 1 >= 0 && !Character.isUpperCase(game[pos[0] + 2][pos[1] - 1])) {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] - 1});
                    }

                    if (pos[1] + 1 < 10 && !Character.isUpperCase(game[pos[0] + 2][pos[1] + 1])) {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] + 1});
                    }

                }

                if (pos[1] - 2 >= 0 && game[pos[0]][pos[1] - 1] == '.') {

                    if (pos[0] - 1 >= 0 && !Character.isUpperCase(game[pos[0] - 1][pos[1] - 2])) {
                        possiblepos.add(new int[]{pos[0] - 1, pos[1] - 2});
                    }

                    if (pos[0] + 1 < 9 && !Character.isUpperCase(game[pos[0] + 1][pos[1] - 2])) {
                        possiblepos.add(new int[]{pos[0] + 1, pos[1] - 2});
                    }

                }

                if (pos[1] + 2 < 10 && game[pos[0]][pos[1] + 1] == '.') {

                    if (pos[0] - 1 >= 0 && !Character.isUpperCase(game[pos[0] - 1][pos[1] + 2])) {
                        possiblepos.add(new int[]{pos[0] - 1, pos[1] + 2});
                    }

                    if (pos[0] + 1 < 9 && !Character.isUpperCase(game[pos[0] + 1][pos[1] + 2])) {
                        possiblepos.add(new int[]{pos[0] + 1, pos[1] + 2});
                    }

                }

                break;

            case 'h':

                if (pos[0] - 2 >= 0 && game[pos[0] - 1][pos[1]] == '.') {

                    if (pos[1] - 1 >= 0 && !Character.isLowerCase(game[pos[0] - 2][pos[1] - 1])) {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] - 1});
                    }

                    if (pos[1] + 1 < 10 && !Character.isLowerCase(game[pos[0] - 2][pos[1] + 1])) {
                        possiblepos.add(new int[]{pos[0] - 2, pos[1] + 1});
                    }

                }

                if (pos[0] + 2 < 9 && game[pos[0] + 1][pos[1]] == '.') {

                    if (pos[1] - 1 >= 0 && !Character.isLowerCase(game[pos[0] + 2][pos[1] - 1])) {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] - 1});
                    }

                    if (pos[1] + 1 < 10 && !Character.isLowerCase(game[pos[0] + 2][pos[1] + 1])) {
                        possiblepos.add(new int[]{pos[0] + 2, pos[1] + 1});
                    }

                }

                if (pos[1] - 2 >= 0 && game[pos[0]][pos[1] - 1] == '.') {

                    if (pos[0] - 1 >= 0 && !Character.isLowerCase(game[pos[0] - 1][pos[1] - 2])) {
                        possiblepos.add(new int[]{pos[0] - 1, pos[1] - 2});
                    }

                    if (pos[0] + 1 < 9 && !Character.isLowerCase(game[pos[0] + 1][pos[1] - 2])) {
                        possiblepos.add(new int[]{pos[0] + 1, pos[1] - 2});
                    }

                }

                if (pos[1] + 2 < 10 && game[pos[0]][pos[1] + 1] == '.') {

                    if (pos[0] - 1 >= 0 && !Character.isLowerCase(game[pos[0] - 1][pos[1] + 2])) {
                        possiblepos.add(new int[]{pos[0] - 1, pos[1] + 2});
                    }

                    if (pos[0] + 1 < 9 && !Character.isLowerCase(game[pos[0] + 1][pos[1] + 2])) {
                        possiblepos.add(new int[]{pos[0] + 1, pos[1] + 2});
                    }

                }

                break;

            case 'C':
            case 'c':

                uend = false;
                dend = false;
                lend = false;
                rend = false;

                for (int i = 1; i < 10; i++) {

                    if ((pos[0] - i) >= 0 && !lend) {

                        if (game[pos[0] - i][pos[1]] == '.') {
                            possiblepos.add(new int[]{pos[0] - i, pos[1]});
                        } else {

                            if (Character.isUpperCase(type) != Character.isUpperCase(game[pos[0] - i][pos[1]])) {

                                possiblepos.add(new int[]{pos[0] - i, pos[1]});

                            }

                            lend = true;

                        }

                    }

                    if ((pos[0] + i) < 9 && !rend) {

                        if (game[pos[0] + i][pos[1]] == '.') {
                            possiblepos.add(new int[]{pos[0] + i, pos[1]});
                        } else {

                            if (Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0] + i][pos[1]])) {

                                possiblepos.add(new int[]{pos[0] + i, pos[1]});

                            }

                            rend = true;

                        }

                    }

                    if ((pos[1] - i) >= 0 && !uend) {

                        if (game[pos[0]][pos[1] - i] == '.') {
                            possiblepos.add(new int[]{pos[0], pos[1] - i});
                        } else {

                            if (Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0]][pos[1] - i])) {

                                possiblepos.add(new int[]{pos[0], pos[1] - i});

                            }

                            uend = true;

                        }

                    }

                    if ((pos[1] + i) < 10 && !dend) {

                        if (game[pos[0]][pos[1] + i] == '.') {
                            possiblepos.add(new int[]{pos[0], pos[1] + i});
                        } else {

                            if (Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0]][pos[1] + i])) {

                                possiblepos.add(new int[]{pos[0], pos[1] + i});

                            }

                            dend = true;

                        }

                    }

                }

                break;

            case 'N':
            case 'n':

                uend = false;
                dend = false;
                lend = false;
                rend = false;

                for (int i = 1; i < 10; i++) {

                    if ((pos[0] - i) >= 0 && !lend) {

                        if (game[pos[0] - i][pos[1]] == '.') {
                            possiblepos.add(new int[]{pos[0] - i, pos[1]});
                        } else {

                            for (int j = 1; j < 10; j++) {
                                if ((pos[0] - i - j) >= 0) {
                                    if (game[pos[0] - i - j][pos[1]] != '.' && Character.isUpperCase(type) != Character.isUpperCase(game[pos[0] - i - j][pos[1]])) {

                                        possiblepos.add(new int[]{pos[0] - i - j, pos[1]});
                                        break;

                                    }
                                }
                            }

                            lend = true;

                        }

                    }

                    if ((pos[0] + i) < 9 && !rend) {

                        if (game[pos[0] + i][pos[1]] == '.') {
                            possiblepos.add(new int[]{pos[0] + i, pos[1]});
                        } else {

                            for (int j = 1; j < 10; j++) {
                                if ((pos[0] + i + j) < 9) {
                                    if (game[pos[0] + i + j][pos[1]] != '.' && Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0] + i + j][pos[1]])) {

                                        possiblepos.add(new int[]{pos[0] + i + j, pos[1]});
                                        break;

                                    }
                                }
                            }

                            rend = true;

                        }

                    }

                    if ((pos[1] - i) >= 0 && !uend) {

                        if (game[pos[0]][pos[1] - i] == '.') {
                            possiblepos.add(new int[]{pos[0], pos[1] - i});
                        } else {

                            for (int j = 1; j < 10; j++) {
                                if ((pos[1] - i - j) >= 0) {
                                    if (game[pos[0]][pos[1] - i - j] != '.' && Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0]][pos[1] - i - j])) {

                                        possiblepos.add(new int[]{pos[0], pos[1] - i - j});
                                        break;

                                    }

                                }
                            }

                            uend = true;

                        }

                    }

                    if ((pos[1] + i) < 10 && !dend) {

                        if (game[pos[0]][pos[1] + i] == '.') {
                            possiblepos.add(new int[]{pos[0], pos[1] + i});
                        } else {

                            for (int j = 1; j < 10; j++) {
                                if ((pos[1] + i + j) < 10) {
                                    if (game[pos[0]][pos[1] + i + j] != '.' && Character.isUpperCase(type) ^ Character.isUpperCase(game[pos[0]][pos[1] + i + j])) {

                                        possiblepos.add(new int[]{pos[0], pos[1] + i + j});
                                        break;

                                    }

                                }
                            }

                            dend = true;

                        }

                    }

                }

                break;

            case 'S':

                if (pos[1] < 5) {

                    if (!Character.isUpperCase(game[pos[0]][pos[1] + 1])) {

                        possiblepos.add(new int[]{pos[0], pos[1] + 1});

                    }

                }

                if (pos[1] > 4) {

                    if (pos[1] + 1 < 10 && !Character.isUpperCase(game[pos[0]][pos[1] + 1])) {

                        possiblepos.add(new int[]{pos[0], pos[1] + 1});

                    }

                    if (pos[0] - 1 >= 0 && !Character.isUpperCase(game[pos[0] - 1][pos[1]])) {

                        possiblepos.add(new int[]{pos[0] - 1, pos[1]});

                    }

                    if (pos[0] + 1 < 9 && !Character.isUpperCase(game[pos[0] + 1][pos[1]])) {

                        possiblepos.add(new int[]{pos[0] + 1, pos[1]});

                    }
                }

                break;

            case 's':

                if (pos[1] > 4) {

                    if (!Character.isLowerCase(game[pos[0]][pos[1] - 1])) {

                        possiblepos.add(new int[]{pos[0], pos[1] - 1});

                    }

                }

                if (pos[1] < 5) {
                    if (pos[1] - 1 >= 0 && !Character.isLowerCase(game[pos[0]][pos[1] - 1])) {

                        possiblepos.add(new int[]{pos[0], pos[1] - 1});

                    }

                    if (pos[0] - 1 >= 0 && !Character.isLowerCase(game[pos[0] - 1][pos[1]])) {

                        possiblepos.add(new int[]{pos[0] - 1, pos[1]});

                    }

                    if (pos[0] + 1 < 9 && !Character.isLowerCase(game[pos[0] + 1][pos[1]])) {

                        possiblepos.add(new int[]{pos[0] + 1, pos[1]});

                    }
                }

                break;

        }

        fillpossible(possiblepos);

        possiblepos.clear();

    }

    public void fillpossible(List<int[]> pos) {

        int i = 0;

        for (int[] poss : pos) {
            try {
                gameboard.getChildren().add(possibleindicater.get(i));
            } catch (IllegalArgumentException ignore) {

            }
            GridPane.setValignment(possibleindicater.get(i), VPos.CENTER);
            GridPane.setHalignment(possibleindicater.get(i), HPos.CENTER);

            GridPane.setConstraints(possibleindicater.get(i), poss[0], poss[1]);

            i++;

        }

    }

    public void recallpossible() {

        for (Circle c : possibleindicater) {

            try {

                gameboard.getChildren().removeAll(c);

            } catch (IllegalArgumentException ignore) {

            }

        }

    }

    public void initgame() {


        gamelog.clear();
        deads.clear();

        for (int i = 0; i < 16; i++) {

            try {
                bdead.getChildren().add(black[i]);
            } catch (IllegalArgumentException ignored) {
            }

        }

        for (int i = 0; i < 16; i++) {
            try {
                rdead.getChildren().add(red[i]);
            } catch (IllegalArgumentException ignored) {
            }
        }

    }

    public void regret() {

        if (totalsteps == 0||gamelog.size() == 0) {
            showalert("已经回到开局状态", "退无可退");
            return;
        }

        int[] posa = new int[2];
        int[] posb = new int[2];
        char type;

        String str = gamelog.get(gamelog.size() - 1);

        posa[0] = str.charAt(4) - 48;
        posa[1] = str.charAt(6) - 48;
        posb[0] = str.charAt(0) - 48;
        posb[1] = str.charAt(2) - 48;
        type = game[posa[0]][posa[1]];

        nextturn();

        move(posa, posb, type);
        resurrect(posa);

        nextturn();

        gamelog.remove(gamelog.size() - 1);
        gamelog.remove(gamelog.size() - 1);
        totalsteps -= 2;

    }

    public void resurrect(int[] pos) {

        for (int i = deads.size() - 1; i >= 0; i--) {
            if (pos[0] == Integer.parseInt(String.valueOf(deads.get(i).charAt(0))) && pos[1] == Integer.parseInt(String.valueOf(deads.get(i).charAt(2)))) {
                switch (deads.get(i).charAt(4)) {
                    case 'G':
                        for (Group piece : G) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'G';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'A':
                        for (Group piece : A) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'A';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'E':
                        for (Group piece : E) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'E';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'H':
                        for (Group piece : H) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'H';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'C':
                        for (Group piece : C) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'C';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'N':
                        for (Group piece : N) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'N';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'S':
                        for (Group piece : S) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'S';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'g':
                        for (Group piece : g) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'g';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'a':
                        for (Group piece : a) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'a';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'e':
                        for (Group piece : e) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'e';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'h':
                        for (Group piece : h) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'h';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'c':
                        for (Group piece : c) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'c';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 'n':
                        for (Group piece : n) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 'n';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                    case 's':
                        for (Group piece : s) {
                            try {
                                gameboard.getChildren().add(piece);
                                GridPane.setConstraints(piece, pos[0], pos[1]);
                                game[pos[0]][pos[1]] = 's';
                                break;
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        break;
                }
                deads.remove(i);
                break;
            }

        }

    }

    public void savemap(File site) throws IOException {

        FileOutputStream fos = new FileOutputStream(site);

        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        if (turnshower.getText().equals("Red Turn")) {

            osw.write("@LAST_MOVER=BLACK\n");

        } else if (turnshower.getText().equals("Red Turn")) {

            osw.write("@LAST_MOVER=RED\n");

        }

        osw.write("@@\n\n");

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {

                if (i < 5) {
                    str.append(game[j][i]);
                } else if (i == 5) {
                    str.append("-");
                } else {
                    str.append(game[j][i - 1]);
                }

            }

            osw.write(str + "\n");

            str.setLength(0);

        }

        loglist.appendText("棋盘数据保存成功\n");

        showalert("保存成功");

        osw.close();

        fos.close();

    }

    public void readmap(File gamemap, boolean on) throws IOException {

        FileReader fr = new FileReader(gamemap);

        BufferedReader br = new BufferedReader(fr);

        boolean lastmover = false;
        boolean mataover = false;
        boolean chessstart = false;
        boolean chessover = false;

        String filename = gamemap.getName();
        int num = 0;
        int line = 0;

        String str;

        while ((str = br.readLine()) != null) {
            line++;
            str = str.split("#")[0];
            if (!chessstart && !mataover && str.charAt(0) == '@') {
                if (str.charAt(1) == '@') {
                    mataover = true;
                    continue;
                } else {
                    if (str.matches("@LAST_MOVER=BLACK")) {
                        lastmover = true;
                        turnshower.setText("Red Turn");
                        turnshower.setFill(Paint.valueOf("#F09595"));
                        showerborder.setStyle("-fx-border-color: #F09595; -fx-border-insets: 5; -fx-border-width: 5;");
                    } else if (str.matches("@LAST_MOVER=RED")) {
                        lastmover = true;
                        turnshower.setText("Black Turn");
                        turnshower.setFill(Paint.valueOf("#393E46"));
                        showerborder.setStyle("-fx-border-color: #393E46; -fx-border-insets: 5; -fx-border-width: 5;");
                    }
                }
                continue;
            }

            if (mataover) {
                if (!lastmover) {
                    showalert("缺少行棋方数据", filename, line - 2);
                    return;
                }
                if (!str.equals("")) {
                    showalert("空白符丢失", filename, line);
                    return;
                }
                chessstart = true;
                mataover = false;
                continue;
            }

            if (chessstart) {

                if (num == 11) {

                    if (!str.equals("")) {
                        showalert("棋局长度错误", filename, line);
                        return;
                    }

                    chessover = true;

                }

                if (num == 5 && str.charAt(0) != '-') {

                    showalert("楚河汉界缺失", filename, line);

                    return;

                }

                if (str.length() != 9 && num != 11) {

                    showalert("棋局宽度错误", filename, line);
                    return;

                } else if (num != 11) {
                    if (num < 5) {

                        for (int i = 0; i < 9; i++) {
                            game[i][num] = str.charAt(i);
                        }

                    } else if (num > 5) {

                        for (int i = 0; i < 9; i++) {
                            game[i][num - 1] = str.charAt(i);
                        }

                    }

                    num++;

                }

            }

            if (chessover) {

                if (!str.equals("")) {
                    showalert("空白符丢失", filename, line);
                    return;
                }

            }

        }

        if (num != 11) {

            showalert("棋局长度错误", filename, line);
            return;

        }

        try {
            resetgame();
        } catch (ArrayIndexOutOfBoundsException | InterruptedException ea) {
            switch (overmore) {
                case 'G':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '將');
                    return;
                case 'A':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '士');
                    return;
                case 'E':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '象');
                    return;
                case 'H':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '馬');
                    return;
                case 'C':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '車');
                    return;
                case 'N':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '砲');
                    return;
                case 'S':
                    showalert("棋子数量错误", filename, line + errorline - 10, '黑', '卒');
                    return;
                case 'g':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '帥');
                    return;
                case 'a':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '仕');
                    return;
                case 'e':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '相');
                    return;
                case 'h':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '傌');
                    return;
                case 'c':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '俥');
                    return;
                case 'n':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '炮');
                    return;
                case 's':
                    showalert("棋子数量错误", filename, line + errorline - 10, '红', '兵');
                    return;
                case '!':
                    showalert("不要往棋盘上放奇怪的东西", filename, line + errorline - 10);
                    return;
                case '0':
                    readmap(new File("src/chinesechess/board/basicgame.chessboard"), false);
                    return;
            }
        }

        loglist.appendText("棋盘数据读取成功\n");

        if (!on) {
            showalert("棋盘数据读取成功");
        }

        fr.close();
        br.close();

    }

    public void savemoveseq(File site) throws IOException {

        int num = 0;

        int ax;
        int ay;
        int bx;
        int by;

        FileOutputStream fos = new FileOutputStream(site);

        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write("@TOTAL_STEP=" + totalsteps + "\n");

        osw.write("@@\n\n");

        for (String str : gamelog) {
            num++;

            ax = Integer.parseInt(String.valueOf(str.charAt(0)));
            ay = Integer.parseInt(String.valueOf(str.charAt(2)));
            bx = Integer.parseInt(String.valueOf(str.charAt(4)));
            by = Integer.parseInt(String.valueOf(str.charAt(6)));

            if (num % 2 == 1) {
                osw.write((9 - ax) + " " + (10 - ay) + " " + (9 - bx) + " " + (10 - by) + "\n");
            } else {
                osw.write((ax + 1) + " " + (ay + 1) + " " + (bx + 1) + " " + (by + 1) + "\n");
            }
        }

        loglist.appendText("棋谱数据保存成功\n");

        showalert("保存成功");

        osw.close();

        fos.close();

    }

    public void readmoveseq(File gameseq) throws IOException {

        FileReader fr = new FileReader(gameseq);

        BufferedReader br = new BufferedReader(fr);

        String filename = gameseq.getName();
        int num = 0;
        int line = 0;
        int ax;
        int ay;
        int bx;
        int by;
        int stepcatch = 0;
        char target;
        int[] startpos = new int[2];
        int[] endpos = new int[2];
        boolean totalstepdata = false;
        boolean mataend = false;
        boolean stepstart = false;

        String str;

        while ((str = br.readLine()) != null) {
            line++;
            str = str.split("#")[0];

            if (!stepstart && !mataend && str.charAt(0) == '@') {

                str = str.substring(1);

                if (str.startsWith("TOTAL_STEP=")) {
                    try {
                        stepcatch = Integer.parseInt(str.substring(11));
                        totalstepdata = true;
                    } catch (ArrayIndexOutOfBoundsException ae) {
                        showalert("步数数据出错", filename, line);
                        return;
                    }
                    continue;
                }

                if (str.equals("@")) {
                    mataend = true;
                    continue;
                }

            }

            if (mataend) {
                if (!totalstepdata) {
                    showalert("缺少步数数据", filename, line - 2);
                    return;
                }
                if (!str.equals("")) {
                    showalert("空白符丢失", filename, line);
                    return;
                }
                stepstart = true;
                mataend = false;
                continue;
            }

            if (stepstart) {

                num++;
                try {
                    ax = Integer.parseInt(String.valueOf(str.charAt(0)));
                    ay = Integer.parseInt(String.valueOf(str.charAt(2)));
                    bx = Integer.parseInt(String.valueOf(str.charAt(4)));
                    by = Integer.parseInt(String.valueOf(str.charAt(6)));
                } catch (Exception ae) {
                    showalert("棋谱数据异常", filename, line);
                    return;
                }

                if (num % 2 == 1) {
                    startpos[0] = 9 - ax;
                    startpos[1] = 10 - ay;
                    endpos[0] = 9 - bx;
                    endpos[1] = 10 - by;
                } else {
                    startpos[0] = ax - 1;
                    startpos[1] = ay - 1;
                    endpos[0] = bx - 1;
                    endpos[1] = by - 1;
                }

                if (startpos[0] > 8 || endpos[0] > 8 || startpos[1] > 9 || endpos[1] > 9 || startpos[0] < 0 || endpos[0] < 0 || startpos[1] < 0 || endpos[1] < 0) {

                    showalert("位置在边界外", filename, line);
                    return;

                }

                target = game[startpos[0]][startpos[1]];
                if (num % 2 == 1) {
                    if (Character.isLowerCase(game[endpos[0]][endpos[1]])) {
                        showalert("目标位置存在本方棋子", filename, line);
                        return;
                    }
                    if (Character.isLowerCase(target)) {
                        move(startpos, endpos, target);
                    } else {
                        showalert("起始位置棋子错误，可能是没有棋子或棋子不归属本方", filename, line);
                        return;
                    }
                } else {
                    if (Character.isUpperCase(game[endpos[0]][endpos[1]])) {
                        showalert("目标位置存在本方棋子", filename, line);
                        return;
                    }
                    if (Character.isUpperCase(target)) {
                        move(startpos, endpos, target);
                    } else {
                        showalert("起始位置棋子错误，可能是没有棋子或棋子不归属本方", filename, line);
                        return;
                    }
                }
            }

        }

        if (num == stepcatch) {
            showalert("棋谱数据读取成功");
            loglist.appendText("棋谱数据读取成功\n");
        } else {
            showalert("TOTAL_STEP数据与实际不符", filename, line);
        }

        fr.close();
        br.close();

    }

    public void nextturn() {

        if (turnshower.getText().equals("Black Turn")) {
            turnshower.setText("Red Turn");
            turnshower.setFill(Paint.valueOf("#F09595"));
            showerborder.setStyle("-fx-border-color: #F09595; -fx-border-insets: 5; -fx-border-width: 5;");
        } else if (turnshower.getText().equals("Red Turn")) {
            turnshower.setText("Black Turn");
            turnshower.setFill(Paint.valueOf("#393E46"));
            showerborder.setStyle("-fx-border-color: #393E46; -fx-border-insets: 5; -fx-border-width: 5;");
        }

    }

    public void resetgame() throws ArrayIndexOutOfBoundsException, InterruptedException {

        int Gcount = 0;
        int Acount = 0;
        int Ecount = 0;
        int Hcount = 0;
        int Ccount = 0;
        int Ncount = 0;
        int Scount = 0;
        int gcount = 0;
        int acount = 0;
        int ecount = 0;
        int hcount = 0;
        int ccount = 0;
        int ncount = 0;
        int scount = 0;

        initgame();

        for (int i = 0; i < 10; i++) {
            errorline = i;
            for (int j = 0; j < 9; j++) {

                switch (game[j][i]) {
                    case 'G':
                        overmore = 'G';
                        try {
                            gameboard.getChildren().add(G[Gcount]);

                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(G[Gcount], j, i);
                        Gcount++;
                        break;
                    case 'A':
                        overmore = 'A';
                        try {
                            gameboard.getChildren().add(A[Acount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(A[Acount], j, i);
                        Acount++;
                        break;
                    case 'E':
                        overmore = 'E';
                        try {
                            gameboard.getChildren().add(E[Ecount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(E[Ecount], j, i);
                        Ecount++;
                        break;
                    case 'H':
                        overmore = 'H';
                        try {
                            gameboard.getChildren().add(H[Hcount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(H[Hcount], j, i);
                        Hcount++;
                        break;
                    case 'C':
                        overmore = 'C';
                        try {
                            gameboard.getChildren().add(C[Ccount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(C[Ccount], j, i);
                        Ccount++;
                        break;
                    case 'N':
                        overmore = 'N';
                        try {
                            gameboard.getChildren().add(N[Ncount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(N[Ncount], j, i);
                        Ncount++;
                        break;
                    case 'S':
                        overmore = 's';
                        try {
                            gameboard.getChildren().add(S[Scount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(S[Scount], j, i);
                        Scount++;
                        break;
                    case 'g':
                        overmore = 'g';
                        try {
                            gameboard.getChildren().add(g[gcount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(g[gcount], j, i);
                        gcount++;
                        break;
                    case 'a':
                        overmore = 'a';
                        try {
                            gameboard.getChildren().add(a[acount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(a[acount], j, i);
                        acount++;
                        break;
                    case 'e':
                        overmore = 'e';
                        try {
                            gameboard.getChildren().add(e[ecount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(e[ecount], j, i);
                        ecount++;
                        break;
                    case 'h':
                        overmore = 'h';
                        try {
                            gameboard.getChildren().add(h[hcount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(h[hcount], j, i);
                        hcount++;
                        break;
                    case 'c':
                        overmore = 'c';
                        try {
                            gameboard.getChildren().add(c[ccount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(c[ccount], j, i);
                        ccount++;
                        break;
                    case 'n':
                        overmore = 'n';
                        try {
                            gameboard.getChildren().add(n[ncount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(n[ncount], j, i);
                        ncount++;
                        break;
                    case 's':
                        overmore = 's';
                        try {
                            gameboard.getChildren().add(s[scount]);
                        } catch (IllegalArgumentException ignored) {

                        }

                        GridPane.setConstraints(s[scount], j, i);
                        scount++;
                        break;
                    case '.':
                        break;
                    default:
                        overmore = '!';
                        GridPane.setConstraints(G[2], j, i);
                        break;
                }


            }
        }

        if (Gcount == 0) {

            overmore = '0';
            showalert("黑方无将,您的游戏将被重置", "WDNMD，真就白给啊！");
            Thread.sleep(2000);
            GridPane.setConstraints(G[2], 0, 0);


        } else if (gcount == 0) {

            overmore = '0';
            showalert("红方无将，您的游戏将被重置", "我军必败");
            Thread.sleep(2000);
            GridPane.setConstraints(G[2], 0, 0);

        }

    }

    public BorderPane getRoot() {

        return root;

    }

    public void showalert(String content, String head) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setHeaderText(content);

        gamealert.setContentText(head);

        gamealert.show();

    }

    public void showalert(String content) {

        Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);

        gamealert.setHeaderText(content);

        gamealert.setContentText("您的" + content);

        gamealert.show();

    }

    public void showalert(String content, String filename, int line) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setHeaderText(content);

        gamealert.setContentText("错误发生在文件" + filename + "的第" + line + "行。");

        gamealert.show();

    }

    public void showalert(String content, String filename, int line, char side, char type) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setHeaderText(content);

        gamealert.setContentText("错误发生在文件" + filename + "的第" + line + "行。\n" + side + "方的" + type + "过多。");

        gamealert.show();

    }

    public void winning(char type){

        Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);

        Image image = new Image("/chinesechess/resources/42.png");

        ImageView imageView = new ImageView();

        imageView.setImage(image);

        gamealert.setGraphic(imageView);

        gamealert.setTitle("游戏结束");

        if (type == 'r') {
            gamealert.setHeaderText("黑方胜");
        }else if (type == 'b'){
            gamealert.setHeaderText("红方胜");
        }

        Button restart = (Button)gamealert.getDialogPane().lookupButton(ButtonType.OK);
        Button exit = (Button)gamealert.getDialogPane().lookupButton(ButtonType.CANCEL);

        restart.setText("再来一局！");
        exit.setText("退出游戏");

        restart.setOnAction(event -> {

            try {
                readmap(new File("src/chinesechess/board/basicgame.chessboard"), false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        exit.setOnAction(event -> {

            Platform.exit();

        });

        gamealert.setContentText("您可以选择：");

        gamealert.show();

    }

    public void kill(int[] pos, char type) {

        deads.add(pos[0] + " " + pos[1] + " " + type);

        switch (type) {
            case 'G':
                if (baba == 'b') {
                    for (Group piece : G) {
                        try {
                            if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                                try {
                                    bdead.getChildren().add(piece);
                                } catch (IllegalArgumentException ignored) {
                                }
                                return;
                            }
                        } catch (Exception ignored) {

                        }
                    }
                }else{
                    winning('b');
                    return;
                }
            case 'A':
                for (Group piece : A) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'E':
                for (Group piece : E) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'H':
                for (Group piece : H) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'C':
                for (Group piece : C) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'N':
                for (Group piece : N) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'S':
                for (Group piece : S) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                bdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'g':
                if (baba == 'r') {
                    for (Group piece : g) {
                        try {
                            if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                                try {
                                    rdead.getChildren().add(piece);
                                } catch (IllegalArgumentException ignored) {
                                }
                                return;
                            }
                        } catch (Exception ignored) {

                        }
                    }
                }else{
                    winning('a');
                }
            case 'a':
                for (Group piece : a) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'e':
                for (Group piece : e) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'h':
                for (Group piece : h) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'c':
                for (Group piece : c) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 'n':
                for (Group piece : n) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
            case 's':
                for (Group piece : s) {
                    try {
                        if (GridPane.getColumnIndex(piece) == pos[0] && GridPane.getRowIndex(piece) == pos[1]) {
                            try {
                                rdead.getChildren().add(piece);
                            } catch (IllegalArgumentException ignored) {
                            }
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
        }

    }

    public void move(int[] posa, int[] posb, char type) {

        if (turnshower.getText().equals("Black Turn") && Character.isLowerCase(type)) {
            return;
        }

        if (turnshower.getText().equals("Red Turn") && Character.isUpperCase(type)) {
            return;
        }

        recallpossible();

        if (game[posb[0]][posb[1]] != '.') {
            kill(posb, game[posb[0]][posb[1]]);
            game[posb[0]][posb[1]] = '.';
        }

        game[posa[0]][posa[1]] = game[posb[0]][posb[1]];

        game[posb[0]][posb[1]] = type;

        gamelog.add(posa[0] + " " + posa[1] + " " + posb[0] + " " + posb[1]);

        totalsteps++;

        nextturn();

        switch (type) {
            case 'G':
                for (Group piece : G) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'A':
                for (Group piece : A) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'E':
                for (Group piece : E) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'H':
                for (Group piece : H) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'C':
                for (Group piece : C) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'N':
                for (Group piece : N) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'S':
                for (Group piece : S) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'g':
                for (Group piece : g) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'a':
                for (Group piece : a) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'e':
                for (Group piece : e) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'h':
                for (Group piece : h) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'c':
                for (Group piece : c) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 'n':
                for (Group piece : n) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
            case 's':
                for (Group piece : s) {
                    try {
                        if (GridPane.getColumnIndex(piece) == posa[0] && GridPane.getRowIndex(piece) == posa[1]) {
                            GridPane.setConstraints(piece, posb[0], posb[1]);
                            return;
                        }
                    } catch (Exception ignored) {

                    }
                }
                break;
        }

    }

}
