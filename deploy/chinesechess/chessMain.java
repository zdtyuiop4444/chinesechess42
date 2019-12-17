package chinesechess;

import chinesechess.board.chessboardController;
import chinesechess.mainview.mainviewController;
import chinesechess.settings.settingviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class chessMain extends Application {

    private Stage stage;
    private Scene scene;
    public boolean borderon = false;
    public boolean opton = true;
    public boolean fullon = false;
    public boolean minion = false;
    public double musicvolum;
    public double sfxvolum;
    public Media bgm;
    public File savedic;
    public boolean autosaveon = true;
    public boolean commandon = false;

    public MediaPlayer bgmplay;

    @Override
    public void start(Stage primarystage) throws Exception{

            readconfig();

        try {

            bgmplay = new MediaPlayer(bgm);

            bgmplay.setVolume(musicvolum);

            bgmplay.setAutoPlay(true);

            bgmplay.setCycleCount(-1);

        }catch (NullPointerException ne){

            bgmplay = null;

        }
        stage = primarystage;
        stage.setTitle("Chinese chess 42");
        stage.getIcons().clear();
        stage.getIcons().add(new Image("/chinesechess/resources/42.png"));
        if (!borderon) {
            stage.initStyle(StageStyle.TRANSPARENT);
        }
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setResizable(false);
        showmainview();
        primarystage.show();

    }

    public void showmainview() throws IOException {

        mainviewController mc = (mainviewController)replaceSceneContent("mainview/mainview.fxml");

        mc.setmain(this);

        readconfig();

        if (borderon) {
            stage.setResizable(false);
        }

    }

    public void showboardview() throws IOException {

        chessboardController cc = (chessboardController)replaceSceneContent("board/chessboard.fxml");

        cc.setmain(this);

        readconfig();

        if (fullon){
            stage.setFullScreen(true);
//            stage.setMinHeight(1080);
//            stage.setMinWidth(1920);
        }

        if (borderon) {
            stage.setResizable(true);
        }

        if (minion) {
            cc.getRoot().setScaleX(0.8);
            cc.getRoot().setScaleY(0.8);
        }

    }

    public void showsettingview() throws IOException {

        settingviewController sc = (settingviewController) replaceSceneContent("settings/settingview.fxml");

        sc.setmain(this);

        readconfig();

    }

    private Object replaceSceneContent(String fxmlFile) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(chessMain.class.getResource(fxmlFile));
        BorderPane bp = null;
        bp = (BorderPane) loader.load();

        bp.setBackground(new Background(new BackgroundFill((Color.valueOf("#696969")), new CornerRadii(15), null)));

        scene = new Scene(bp);

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);

        if (bgmplay != null) {
            bgmplay.stop();
        }

        if (bgm != null) {
            bgmplay = new MediaPlayer(bgm);

            bgmplay.setVolume(musicvolum);

            bgmplay.setAutoPlay(true);

            bgmplay.setCycleCount(-1);
        }

        return loader.getController();

    }

    public void readconfig() throws IOException {

        FileReader fr = new FileReader(new File("src/chinesechess/settings/config"));

        BufferedReader br = new BufferedReader(fr);

        String str = "";

        str = br.readLine();

        if (str.equals("true")){
            borderon = true;
        }else if (str.equals("false")){
            borderon = false;
        }

        str = br.readLine();

        if (str.equals("true")){
            opton = true;
        }else if (str.equals("false")){
            opton = false;
        }

        str = br.readLine();

        if (str.equals("true")){
            fullon = true;
        }else if (str.equals("false")){
            fullon = false;
        }

        str = br.readLine();

        if (str.equals("true")){
            minion = true;
        }else if (str.equals("false")){
            minion = false;
        }

        str = br.readLine();

        if (str.equals("true")){
            autosaveon = true;
        }else if (str.equals("false")){
            autosaveon = false;
        }

        str = br.readLine();

        if (str.equals("true")){
            commandon = true;
        }else if (str.equals("false")){
            commandon = false;
        }

        str = br.readLine();

        musicvolum = Double.parseDouble(str);

        str = br.readLine();

        sfxvolum = Double.parseDouble(str);

        str = br.readLine();

        try {

            File musi = new File(str);

            bgm = new Media(musi.toURI().toString());
        }catch (Exception e){

            bgm = null;

        }
        str = br.readLine();

        savedic = new File(str);

        fr.close();
        br.close();
    }

    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {

        launch(args);

    }
}
