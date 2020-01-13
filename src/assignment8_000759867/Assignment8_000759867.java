package week10code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Basic demonstration of mouse events in action.
 * 
 * @author CHIRAG BARANDA
 */
public class Assignment8_000759867 extends Application {

    final int CANVAS_WIDTH = 1000; //canvas maximum width
    final int CANVAS_HEIGHT = 700; //canvas maximum height
    double x, y; //x and y co-ordinates values
    double radius;  //radius for circle
    private GraphicsContext g; //graphics context object
    private TextField t1,t2,t3,t4,t5,t6; //textfield objects
    
    private void pressHandler(ActionEvent e) { //press handler function call, when user click  on the button "Click mE"
        x = Integer.parseInt(t1.getText()); //getting the value inserted in textfield 1 by user and converting it to interger for x co-ordinate
        y = Integer.parseInt(t2.getText()); //getting the value inserted in textfield 2 by user and converting it to interger for y co-ordinate
        radius = Double.parseDouble(t3.getText()); //geting the radius entred by the user
        System.out.println("Drawn circle at (" + x + "," + y + ")."); 
        int m= Integer.parseInt(t4.getText()) , n = Integer.parseInt(t5.getText()), o= Integer.parseInt(t6.getText());
        /*if(m>255 || n>255 || o>255)
        {
            l4.setText(" Value s no more than 255");
        }
        elsef(m<0 || n<0 || o<0)
        {
            l4.setText("value can not be minus");
        }
        else
        {
            l4.setText("No Errors!!");
        }
        */
        drawCircle(m,n,o); //funcation call for drawing the circle
    }
    
    private void pressHandler(MouseEvent me) { //presshandler, when user click with the mouse left click button
        x = me.getX(); //get the mouse possition x-cord
        y = me.getY(); //get the mouser possion y-cord
        radius = Double.parseDouble(t3.getText()); //get the radius from text field 3, when user click with the mouse
        System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ")."); 
        drawCircle(Integer.parseInt(t4.getText()),Integer.parseInt(t5.getText()),Integer.parseInt(t6.getText())); //call for draw method
    }
    

    private void releaseHandler(MouseEvent me) { // function calls when user release the mouse click
        System.out.println("Released " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
    }

    
    private void draggedHandler(MouseEvent me) { //function call when user drag the mouse
        x = me.getX(); //get the mouse possition x-cord
        y = me.getY();  //get the mouse possition y-cord
        radius = Double.parseDouble(t3.getText()); //getting the value inserted in textfield 2 by user and converting it to interger for y co-ordinate
        System.out.println("x = " + x + " y = " + y);
        drawCircle(Integer.parseInt(t4.getText()),Integer.parseInt(t5.getText()),Integer.parseInt(t6.getText())); //call for draw method
        
    }
    
    private void drawCircle(int a, int b, int c) { //draw method logic
        
        g.setFill(Color.rgb(a, b, c)); //set the color for the circle using the 3 variable passed form the textfields
        g.fillOval(x, y , radius * 20 , radius*20); //drawing the table
        
        
        
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT); // set the size here
        stage.setTitle("Assignment 8"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        
        Canvas c = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        Label l1 = new Label("Location"); //label for location
        Label l2 = new Label("Radius"); //label for the redius
        Label l3 = new Label("Colour:(RGB) "); //label for thr colour
        Label l4 = new Label("  "); //label for the notificaton/eorros, right now its empty label
        Label l5 = new Label("Prepared By CHiRAG BAR@NDA");
        
        //initialize the text fields
        t1 = new TextField("50"); 
        t2 = new TextField("50");
        t3 = new TextField("9");
        t4 = new TextField("100");
        t5 = new TextField("100");
        t6 = new TextField("100");
        
        //create button
        Button btn = new Button("Press mE!");
        
     
        //adding the elements
        root.getChildren().add(c);
        root.getChildren().add(btn);
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(l4);
        root.getChildren().add(l5);
        root.getChildren().add(t1);
        root.getChildren().add(t2);
        root.getChildren().add(t3);
        root.getChildren().add(t4);
        root.getChildren().add(t5);
        root.getChildren().add(t6);
        
        
        g = c.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0, CANVAS_HEIGHT-21, CANVAS_WIDTH, 21);
        
        
        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler); //when user predd the left button
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler); //when user release the left click
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::draggedHandler); //when user drag the cursor
        
        
        //int x7 = input.nextInt();
        //int y7 = input.nextInt();
       
        //set the width
        t1.setPrefWidth(30);
        t2.setPrefWidth(30);
        t3.setPrefWidth(30);
        t4.setPrefWidth(30);
        t5.setPrefWidth(30);
        t6.setPrefWidth(30);
        
        //set the layout x and y for the labels and textfield
        l1.setLayoutX(0);
        l1.setLayoutY(CANVAS_HEIGHT-45);
        t1.setLayoutX(50);
        t1.setLayoutY(CANVAS_HEIGHT-48);
        t2.setLayoutY(CANVAS_HEIGHT-48);
        t2.setLayoutX(80);
        
        
        
        l2.setLayoutX(120);
        l2.setLayoutY(CANVAS_HEIGHT-45);
        t3.setLayoutY(CANVAS_HEIGHT-48);
        t3.setLayoutX(160);
        
        
        l3.setLayoutX(200);
        l3.setLayoutY(CANVAS_HEIGHT-45);
        t4.setLayoutY(CANVAS_HEIGHT-48);
        t4.setLayoutX(270);
        t5.setLayoutY(CANVAS_HEIGHT-48);
        t5.setLayoutX(300);
        t6.setLayoutY(CANVAS_HEIGHT-48);
        t6.setLayoutX(330);
        
        
        
        btn.setLayoutX(380);
        btn.setLayoutY(CANVAS_HEIGHT-48);
        btn.setOnAction(this::pressHandler);
        
        l4.setLayoutX(400);
        l4.setLayoutY(CANVAS_HEIGHT-20);
        l4.setAlignment(Pos.CENTER);
        l5.setLayoutX(CANVAS_WIDTH-200);
        l5.setLayoutY(CANVAS_HEIGHT-20);
        
        stage.show();
    }

    /**
     * 
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
