package chinesechess.settings;

import chinesechess.chessMain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

public class settingviewController {

    private chessMain chessmain;
    public boolean borderon = false;
    public boolean opton = true;
    public boolean fullon = false;
    public boolean minion = false;
    public double musicvolum;
    public double sfxvolum;
    public File bgm;
    public File savedic;
    public boolean autosaveon = true;
    public boolean commandon = false;

    @FXML
    private CheckBox commandcheck;

    @FXML
    private TextField saveselect;

    @FXML
    private Slider musicslider;

    @FXML
    private TextField bgmselect;

    @FXML
    private Button backbutton;

    @FXML
    private AnchorPane toppane;

    @FXML
    private CheckBox optcheck;

    @FXML
    private CheckBox fullcheck;

    @FXML
    private Slider sfxslider;

    @FXML
    private CheckBox autosavecheck;

    @FXML
    private CheckBox bordercheck;

    @FXML
    private CheckBox minicheck;


    @FXML
    private void initialize() throws IOException {

        readconfig();

        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);

        toppane.setOnMousePressed(event -> {

            x.set(event.getX());
            y.set(event.getY());

        });

        toppane.setOnMouseDragged(event -> {

                chessmain.getStage().setX(event.getScreenX() - x.get());

                if(event.getScreenY() - y.get() < 0) {
                    chessmain.getStage().setY(0);
                }else {
                    chessmain.getStage().setY(event.getScreenY() - y.get());
                }

        });

        backbutton.setOnAction(event -> {

            try {
                saveconfig();
                chessmain.showmainview();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        bordercheck.setSelected(borderon);

        bordercheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                borderon = newValue;

            }
        });

        optcheck.setSelected(opton);

        optcheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                opton = newValue;

            }
        });

        fullcheck.setSelected(fullon);

        fullcheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                fullon = newValue;

            }
        });

        minicheck.setSelected(minion);

        minicheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                minion = newValue;

            }
        });

        autosavecheck.setSelected(autosaveon);

        autosavecheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                autosaveon = newValue;

            }
        });

        commandcheck.setSelected(commandon);

        commandcheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                commandon = newValue;

            }
        });

        bgmselect.setText(bgm.getName());

        bgmselect.setOnMouseClicked(event -> {
            
            Stage loads = new Stage();

            FileChooser loadfc = new FileChooser();

            loadfc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("音乐文件", "*.mp3","*.flac","*.wav"));

            loadfc.setInitialDirectory(new File("./"));

            bgm = loadfc.showOpenDialog(loads);

            bgmselect.setText(bgm.getName());

        });

        musicslider.setMax(1.0);

        musicslider.setMin(0.0);

        musicslider.setValue(musicvolum);

        musicslider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {


                musicvolum = (double)newValue;

            }
        });

        sfxslider.setMax(1.0);

        sfxslider.setMin(0.0);

        sfxslider.setValue(sfxvolum);

        sfxslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {


                sfxvolum = (double)newValue;

            }
        });

        saveselect.setText(savedic.getName());

        saveselect.setOnMouseClicked(event -> {

            Stage loads = new Stage();

            DirectoryChooser loadfc = new DirectoryChooser();


            loadfc.setInitialDirectory(new File("./"));

            savedic = loadfc.showDialog(loads);

            saveselect.setText(savedic.getName());

        });

    }

    public void readconfig() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("resources/config")), StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(isr);

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

        bgm = new File(str);

        str = br.readLine();

        savedic = new File(str);

        isr.close();
        br.close();
    }

    public void saveconfig() throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("resources/config"));

        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write(String.valueOf(borderon)+"\n");
        osw.write(String.valueOf(opton)+"\n");
        osw.write(String.valueOf(fullon)+"\n");
        osw.write(String.valueOf(minion)+"\n");
        osw.write(String.valueOf(autosaveon)+"\n");
        osw.write(String.valueOf(commandon)+"\n");
        osw.write(String.valueOf(musicvolum)+"\n");
        osw.write(String.valueOf(sfxvolum)+"\n");
        osw.write(bgm.getCanonicalPath()+"\n");
        osw.write(savedic.getCanonicalPath()+"\n");

        osw.close();

        fos.close();

    }

    public void setmain(chessMain chessmain){
        this.chessmain = chessmain;
    }

    public settingviewController() {
    }
}
