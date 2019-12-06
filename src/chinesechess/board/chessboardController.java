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
    public char[][] game = new char[9][10];
    public char overmore = '0';
    public int errorline = '0';


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

                loadfc.setInitialDirectory(new File("./"));

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

    public void initgame(){

        for (int i = 0; i < 16; i++) {

            try {
                bdead.getChildren().add(black[i]);
            } catch (IllegalArgumentException ie){
               continue;
            };

        }

        for (int i = 0; i < 16; i++) {
            try {
                rdead.getChildren().add(red[i]);
            } catch (IllegalArgumentException ie) {
                continue;
            };
        }

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

        String filename = gamemap.getName();
        int num = 0;
        int line = 0;

        String str = "";

        while ((str = br.readLine()) != null) {
            line++;
            str = str.split("#")[0];
            if (!chessstart&&!mataover && str.charAt(0) == '@') {
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
                    showalert("缺少行棋方数据",filename,line-2);
                    return;
                }
                if (!str.equals("")) {
                    showalert("空白符丢失",filename,line);
                    return;
                }
                chessstart = true;
                mataover = false;
                continue;
            }

            if (chessstart) {

                if (num == 11) {

                    if (!str.equals("")) {
                        showalert("棋局长度错误",filename,line);
                        return;
                    }

                }

                if (num == 5 && str.charAt(0) != '-'){

                    showalert("楚河汉界缺失",filename,line);

                    return;

                }

                if (str.length() != 9 && num!=11) {

                    showalert("棋局宽度错误",filename,line);
                    return;

                } else if (num!=11) {
                    if (num < 5) {

                        for (int i = 0; i < 9; i++) {
                            game[i][num] = str.charAt(i);
                        }

                    }else if (num > 5){

                        for (int i = 0; i < 9; i++) {
                            game[i][num-1] = str.charAt(i);
                        }

                    }

                    num++;

                }

            }

            if (chessover) {

                if (!str.equals("")) {
                    showalert("空白符丢失",filename,line);
                    return;
                }
                
            }

        }

        if (num != 11) {

            showalert("棋局长度错误",filename,line);
            return;

        }

        try {
            resetgame();
        } catch (ArrayIndexOutOfBoundsException ea) {
            switch (overmore) {
                case 'G':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','將');
                    return;
                case 'A':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','士');
                    return;
                case 'E':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','象');
                    return;
                case 'H':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','馬');
                    return;
                case 'C':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','車');
                    return;
                case 'N':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','砲');
                    return;
                case 'S':
                    showalert("棋子数量错误", filename, line+errorline-10,'黑','卒');
                    return;
                case 'g':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','帥');
                    return;
                case 'a':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','仕');
                    return;
                case 'e':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','相');
                    return;
                case 'h':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','傌');
                    return;
                case 'c':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','俥');
                    return;
                case 'n':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','炮');
                    return;
                case 's':
                    showalert("棋子数量错误", filename, line+errorline-10,'红','兵');
                    return;
                case '!':
                    showalert("不要往棋盘上放奇怪的东西", filename, line+errorline-10);
                    return;
            }
        }
        resetgame();

        loglist.appendText("读取成功\n");

        showalert("读取成功");

        fr.close();
        br.close();

    }

    public void resetgame() throws ArrayIndexOutOfBoundsException {

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

                switch (game[j][i]){
                    case 'G' :
                        overmore = 'G';
                        try {
                            gameboard.getChildren().add(G[Gcount]);;
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(G[Gcount],j,i);
                        Gcount++;
                        break;
                    case 'A' :
                        overmore = 'A';
                        try {
                            gameboard.getChildren().add(A[Acount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(A[Acount],j,i);
                        Acount++;
                        break;
                    case 'E' :
                        overmore = 'E';
                        try {
                            gameboard.getChildren().add(E[Ecount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(E[Ecount],j,i);
                        Ecount++;
                        break;
                    case 'H' :
                        overmore = 'H';
                        try {
                            gameboard.getChildren().add(H[Hcount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(H[Hcount],j,i);
                        Hcount++;
                        break;
                    case 'C' :
                        overmore = 'C';
                        try {
                            gameboard.getChildren().add(C[Ccount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(C[Ccount],j,i);
                        Ccount++;
                        break;
                    case 'N' :
                        overmore = 'N';
                        try {
                            gameboard.getChildren().add(N[Ncount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(N[Ncount],j,i);
                        Ncount++;
                        break;
                    case 'S' :
                        overmore = 's';
                        try {
                            gameboard.getChildren().add(S[Scount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(S[Scount],j,i);
                        Scount++;
                        break;
                    case 'g' :
                        overmore = 'g';
                        try {
                            gameboard.getChildren().add(g[gcount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(g[gcount],j,i);
                        gcount++;
                        break;
                    case 'a' :
                        overmore = 'a';
                        try {
                            gameboard.getChildren().add(a[acount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(a[acount],j,i);
                        acount++;
                        break;
                    case 'e' :
                        overmore = 'e';
                        try {
                            gameboard.getChildren().add(e[ecount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(e[ecount],j,i);
                        ecount++;
                        break;
                    case 'h' :
                        overmore = 'h';
                        try {
                            gameboard.getChildren().add(h[hcount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(h[hcount],j,i);
                        hcount++;
                        break;
                    case 'c' :
                        overmore = 'c';
                        try {
                            gameboard.getChildren().add(c[ccount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(c[ccount],j,i);
                        ccount++;
                        break;
                    case 'n' :
                        overmore = 'n';
                        try {
                            gameboard.getChildren().add(n[ncount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(n[ncount],j,i);
                        ncount++;
                        break;
                    case 's' :
                        overmore = 's';
                        try {
                            gameboard.getChildren().add(s[scount]);
                        } catch (IllegalArgumentException ignored){

                        };
                        GridPane.setConstraints(s[scount],j,i);
                        scount++;
                        break;
                    case '.' :
                        break;
                    default:
                        overmore = '!';
                        GridPane.setConstraints(G[2],j,i);;
                        break;
                }


            }
        }

    }

    public void showalert(String content) {

        Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);

        gamealert.setHeaderText(content);

        gamealert.setContentText("您的文件读取成功");

        gamealert.show();

    }

    public void showalert(String content,String filename,int line) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setHeaderText(content);

        gamealert.setContentText("错误发生在文件"+filename+"的第"+line+"行。");

        gamealert.show();

    }

    public void showalert(String content,String filename,int line,char side,char type) {

        Alert gamealert = new Alert(Alert.AlertType.WARNING);

        gamealert.setHeaderText(content);

        gamealert.setContentText("错误发生在文件"+filename+"的第"+line+"行。\n"+side+"方的"+type+"过多。");

        gamealert.show();

    }

    public void kill(int[] pos) {


    }

    public void move(int[] posb, int[] posa) {

    }


}
