/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myInterface;

import domain.Circle;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Christian
 */
public class Window extends Application{
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private GraphicsContext gc1;
    private Circle circle;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fractal");
        initComponents(primaryStage);
        primaryStage.show();
    }
    private void initComponents(Stage primaryStage) throws FileNotFoundException{
        this.circle=new Circle();
        // Contenedor principal donde se alojarán todos los elementos
        Group group = new Group();  
        // Creación de una zona de dibujo (canvas) de 200 x 150 puntos
        Canvas canvas = new Canvas(650, 650);
        // Obtención del contexto gráfico del canvas anterior que permitirá
        //  realizar posteriormente los dibujos
        gc1 = canvas.getGraphicsContext2D();
        // Se añade el canvas al contenedor principal (root)
        group.getChildren().add(canvas);
        Scene scene = new Scene(group, 650, 650);
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Segunda Obra: Fractal");
        drawFractal();
    }
    public void drawFractal(){
        int x=circle.getX();
        int y=circle.getY();
//        int x1=8;
//        int y1=30;
//        for (int i = 0; i < 22; i++) {
//            for (int j = 1; j <81; j++) {
//                if (j%2!=0) {
//                    gc1.strokeOval(x, y, circle.getSize(), circle.getSize());
//                } else {
//                    gc1.fillOval(x, y, circle.getSize(), circle.getSize());
//                }
//                x+=x1;
//            }
//            y+=y1;
//            x=circle.getX();
//        }

//        for (int i = 0; i < 10; i++) {
//            y=0;
//            gc1.strokeOval(circle.getX(), circle.getY(), circle.getSize(),circle.getSize());
////            gc1.fillOval(circle.getX(), circle.getY(), circle.getSize(),circle.getSize());
//            if (i>=4) {
//                gc1.scale(1.5, 1.5);
//            }else{
//                gc1.scale(-1.5, -1.5);
//            } 
//            y+=100;
//        }
        int size=circle.getSize();
        //se puede hacer una figura rellena y otra no o ambas
        for (int i = 0; i < 35; i++) {
            y=circle.getY();
            gc1.strokeOval(y, y, size,size);
//            gc1.fillOval(y, y, size,size); 
            y+=50;
            gc1.strokeOval(y, y, size,size);
//            gc1.fillOval(y, y, size,size);
            size+=60;
            y=circle.getY();
            gc1.strokeOval(y, y, size,size);
//            gc1.fillOval(y, y, size,size); 
            y+=50;
            gc1.strokeOval(y, y, size,size);
//            gc1.fillOval(y, y, size,size);
            size+=60;
        }
        
    }
}
