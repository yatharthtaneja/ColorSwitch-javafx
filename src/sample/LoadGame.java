package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class LoadGame implements Initializable {
    @FXML
    private Button hbutton;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Shape l1,l2,l3,l4;
    @FXML
    private Label Label1,Label2,Label3,Label4,Time1,Time2,Time3,Time4,Score1,Score2,Score3,Score4;
    private Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }
    @FXML
    private Text text;
    private static boolean DarkTheme;
    static boolean SoundOn =true;
    public void setTheme(boolean darktheme){
        DarkTheme=darktheme;
    }
    public void setSoundOn(boolean sound){
        SoundOn=sound;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Player p1 = null,p2=null,p3=null,p4=null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            p1 = (Player) ColorSwitch.Deseriallise("1.save");
            if(p1.getSaveGame()){
                Label1.setText("Score");
                Score1.setText(Integer.toString(p1.getScore()));
                Time1.setText(formatter.format(p1.getDateTime()));
            }
            else {
                Label1.setText("No Game Saved");
                Score1.setText("");
                Time1.setText("");
            }
            p2 = (Player) ColorSwitch.Deseriallise("2.save");
            if(p2.getSaveGame()){
                Label2.setText("Score");
                Score2.setText(Integer.toString(p2.getScore()));
                Time2.setText(formatter.format(p2.getDateTime()));
            }
            else {
                Label2.setText("No Game Saved");
                Score2.setText("");
                Time2.setText("");
            }
            p3 = (Player) ColorSwitch.Deseriallise("3.save");
            if(p3.getSaveGame()){
                Label3.setText("Score");
                Score3.setText(Integer.toString(p3.getScore()));
                Time3.setText(formatter.format(p3.getDateTime()));
            }
            else {
                Label3.setText("No Game Saved");
                Score3.setText("");
                Time3.setText("");
            }
            p4 = (Player) ColorSwitch.Deseriallise("4.save");
            if(p4.getSaveGame()){
                Label4.setText("Score");
                Score4.setText(Integer.toString(p4.getScore()));
                Time4.setText(formatter.format(p4.getDateTime()));
            }
            else {
                Label4.setText("No Game Saved");
                Score4.setText("");
                Time4.setText("");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        addImage(hbutton, "sample/Assets/home_white.png");
        addShadow(l1);addShadow(l2);addShadow(l3);addShadow(l4);
        if(!DarkTheme){
            loadPane.setStyle("-fx-background-color: #FFFFF0");
            addImage(hbutton, "sample/Assets/home.png");
            text.setFill(Color.valueOf("#141518"));
        }
        else{
            loadPane.setStyle("-fx-background-color: #141518");
            addImage(hbutton, "sample/Assets/home_white.png");
            text.setFill(Color.valueOf("#FFFFFF"));
        }
        hbutton.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent e)->{
            try {
                ButtonSound();
                loadButton("FXML/GameMenu.fxml");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Player finalP1 = p1,finalP2 = p2,finalP3 = p3,finalP4 = p4;
        l1.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent e)->{
            try {
                if(finalP1.getSaveGame()){
                    ButtonSound();
                    Game game = new Game();
                    game.setCurrentPlayer(finalP1);
                    game.setSaveLocation(1);
                    game.setStage(stage);
                    game.setSoundOn(SoundOn);
                    game.setTheme(DarkTheme);
                    game.start(stage);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        l2.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent e)->{
            try {
                if(finalP2.getSaveGame()){
                    ButtonSound();
                    Game game = new Game();
                    game.setCurrentPlayer(finalP2);
                    game.setSaveLocation(2);
                    game.setStage(stage);
                    game.setSoundOn(SoundOn);
                    game.setTheme(DarkTheme);
                    game.start(stage);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        l3.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent e)->{
            try {
                if(finalP3.getSaveGame()){
                    ButtonSound();
                    Game game = new Game();
                    game.setCurrentPlayer(finalP3);
                    game.setSaveLocation(3);
                    game.setStage(stage);
                    game.setSoundOn(SoundOn);
                    game.setTheme(DarkTheme);
                    game.start(stage);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        l4.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent e)->{
            try {
                if(finalP4.getSaveGame()){
                    ButtonSound();
                    Game game = new Game();
                    game.setCurrentPlayer(finalP4);
                    game.setSaveLocation(4);
                    game.setStage(stage);
                    game.setSoundOn(SoundOn);
                    game.setTheme(DarkTheme);
                    game.start(stage);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public void addImage(Button b1, String path){
        Image img = new Image(path);
        ImageView view = new ImageView(img);
        view.setFitHeight(60);
        view.setPreserveRatio(true);
        b1.setGraphic(view);
    }
    public void loadButton(String s) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
        Parent root = loader.load();
        GameMenu controller = (GameMenu) loader.getController();
        controller.setStage(this.stage);
        Scene scene = new Scene(root,450,800);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void addShadow(Shape s1) {
        DropShadow shadow = new DropShadow();
        s1.addEventFilter(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            s1.setFill(Color.valueOf("#8E2DE2"));
            s1.setEffect(shadow);
            shadow.setColor(Color.valueOf("#B5EDD0"));
        });
        s1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            s1.setEffect(null);
            s1.setFill(Color.valueOf("#d41e8d"));
        });
    }
    private void ButtonSound(){
        if(SoundOn){
            AudioClip Button=new AudioClip(this.getClass().getResource("Audio/Button.wav").toString());
            Button.play();
        }
    }
}
