package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Arc extends Shape {
    public Arc(double centerx,double centery,int startangle){
        super(centerx,centery);
        javafx.scene.shape.Arc arc2 = new javafx.scene.shape.Arc();
        arc2.setRadiusX(85.0f);
        arc2.setRadiusY(85.0f);
        arc2.setStartAngle(startangle);
        arc2.setType(ArcType.ROUND);
        arc2.setLayoutY(centery);
        arc2.setLayoutX(centerx);
        arc2.setLength(90.0f);

        javafx.scene.shape.Arc arc1= new javafx.scene.shape.Arc();
        arc1.setLayoutY(centery);
        arc1.setLayoutX(centerx);
        arc1.setRadiusX(100.0f);
        arc1.setRadiusY(100.0f);
        arc1.setStartAngle(startangle);
        arc1.setType(ArcType.ROUND);
        arc1.setLength(90.0f);

        javafx.scene.shape.Shape shape = javafx.scene.shape.Shape.subtract(arc1, arc2);
        setShape(shape);
    }
    public Arc(double centerx,double centery,Color col,int startangle){
        super(centerx,centery,col);
        javafx.scene.shape.Arc arc2 = new javafx.scene.shape.Arc();
        arc2.setRadiusX(85.0f);
        arc2.setRadiusY(85.0f);
        arc2.setStartAngle(startangle);
        arc2.setType(ArcType.ROUND);
        arc2.setLayoutY(centery);
        arc2.setLayoutX(centerx);
        arc2.setLength(90.0f);

        javafx.scene.shape.Arc arc1= new javafx.scene.shape.Arc();
        arc1.setLayoutY(centery);
        arc1.setLayoutX(centerx);
        arc1.setRadiusX(100.0f);
        arc1.setRadiusY(100.0f);
        arc1.setStartAngle(startangle);
        arc1.setType(ArcType.ROUND);
        arc1.setLength(90.0f);

        javafx.scene.shape.Shape shape = javafx.scene.shape.Shape.subtract(arc1, arc2);
        shape.setFill(col);
        shape.setStroke(col);
        setShape(shape);
    }

}