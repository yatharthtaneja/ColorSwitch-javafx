package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.*;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroScreen implements Initializable {
    @FXML private AnchorPane rootAnchorPane;
    @FXML private Group ring;
    @FXML private Arc topleftcurve;
    @FXML private Circle introBall;
    private Stage Currentstage;
    private static AudioClip Background;
    public void setStage(Stage stage){
        Currentstage=stage;
    }
    public void setBackground(AudioClip background){
        if(Background==null)
            Background=background;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(ring,0,360,4,topleftcurve.getLayoutX(),topleftcurve.getLayoutY());
        MoveBall(introBall, ring, 4, -100);
    }
    public void MoveBall(Circle c1, Group s1, int cycle , int movey){
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new VLineTo(movey));
        PathTransition pt = new PathTransition();
        pt.setNode(c1);
        pt.setDuration(Duration.millis(500));
        pt.setPath(path);
        pt.setAutoReverse(true);
        pt.setCycleCount(cycle);
        Path path2 = new Path();
        path2.getElements().add(new MoveTo(0,0));
        path2.getElements().add(new VLineTo(2.6*movey));
        PathTransition pt2 = new PathTransition();
        pt2.setNode(c1);
        pt2.setDuration(Duration.millis(500));
        pt2.setPath(path2);
        pt2.setAutoReverse(true);
        pt2.setCycleCount(1);
        SequentialTransition st = new SequentialTransition(pt,pt2);
        st.play();
        st.setOnFinished(event -> {
            try {
                LoadMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void rotateTransition(Group g1,int duration){
        RotateTransition rt = new RotateTransition();
        rt.setAxis(Rotate.Z_AXIS);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setDuration(Duration.seconds(duration));
        rt.setNode(g1);
        rt.play();
    }

    public void setRotate(Group a1, int start, int end, int duration , double centerx , double centery) {
        Rotate rt2 = new Rotate(0,centerx,centery);
        a1.getTransforms().add(rt2);
        Timeline timeline= new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rt2.angleProperty(),start)),
                new KeyFrame(Duration.seconds(duration), new KeyValue(rt2.angleProperty(),end)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void LoadMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/GameMenu.fxml"));
        Parent root =loader.load();
        GameMenu controller = (GameMenu) loader.getController();
        controller.setBackground(Background);
        controller.setStage(Currentstage);
        Scene scene = new Scene(root,450,800);
        Currentstage.setScene(scene);
        Currentstage.setResizable(false);
        Currentstage.show();
    }

    public Group getGroup(){
        return ring;
    }
}
