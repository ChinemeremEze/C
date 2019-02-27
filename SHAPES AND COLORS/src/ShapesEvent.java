
import java.util.ArrayList;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Shape application using mouse events.
 *
 * @author David Ezeakudolu
 */
public class ShapesEvent extends Application {

    // TODO: Instance Variables for View Components and Model
    /**
     * GraphicsContext to design the canvas and shapes
     */
    private GraphicsContext gc;
    /**
     * Buttons that have different outcomes for the applications
     */
    private Button circle, rectangle, line, toBack, toFront, delete, clear, reset, widthButton, undo;
    /**
     * Color picker adds a color panel for all shapes
     */
    private ColorPicker outline, fill;
    /**
     * width sets the stroke width of all shapes
     */
    private TextField width;
    /**
     * Labels for the application
     */

    private Label instruction, outlinelabel, filllabel, widthlabel, object,
            left, right1, right2, deletelabel;
    /**
     * Start position of x and y axis
     */
    //private double startx, starty;
    //Current shape and selected shape
    Shapes currentShape;
    Shapes selectedShape;
    private String shapeSelected = "circle";
    /**
     * An arraylist of SHapes
     */

    ArrayList<Shapes> slist = new ArrayList<Shapes>();
    /**
     * The linewidth of the shape
     */
    private int newWidth = 5;

    // TODO: Private Event Handlers and Helper Methods
    //Sets a new line width fo each shape
    private void setWidth(ActionEvent e) {
        try {
            newWidth = Integer.parseInt(width.getText());
        } catch (InputMismatchException ef) {
            new Alert(Alert.AlertType.WARNING, "Invalid Line Width").showAndWait();
        } catch (NumberFormatException d) {
            new Alert(Alert.AlertType.WARNING, "Number Format Exception").showAndWait();
        } catch (Exception t) {
            new Alert(Alert.AlertType.WARNING, t.getMessage()).showAndWait();
        }
    }
//Clears the sreen

    private void clearHandler(ActionEvent e) {
        gc.clearRect(0, 0, 1000, 400);
        gc.setFill(Color.AQUA);
        gc.fillRect(0, 0, 1000, 400);
        slist.clear();
        for (Shapes cc : slist) {
            cc.draw(gc);
        }
    }
//Deletes the selected rectangle

    private void deleteHandler(ActionEvent e) {
        if (slist.size() > 0) {
            slist.remove(selectedShape);
            drawAll();
        }
    }
//Undo the last event

    private void undoHandler(ActionEvent e) {
        if (slist.size() > 0) {
            slist.remove(slist.size() - 1);
            drawAll();
        }
    }
//Moves the selected shape front

    public void toFrontHandler(ActionEvent e) {
        if (slist.size() > 0) {
            slist.add(0, currentShape);
            drawAll();
        }
    }
//circle handler

    private void circleHandler(ActionEvent e) {
        shapeSelected = "circle";
    }
//rectangle handler

    private void rectangleHandler(ActionEvent e) {
        shapeSelected = "rectangle";
    }
//lineHandler

    private void linesHandler(ActionEvent e) {
        shapeSelected = "line";
    }
//press handler controls the application whenever it is pressed

    private void pressHandler(MouseEvent me) {
        if (me.getButton() == MouseButton.PRIMARY) {
            if (shapeSelected.equals("circle")) {
                currentShape = new Circle(me.getX(), me.getY(), 5, 1, fill.getValue(), outline.getValue());
            } else if (shapeSelected.equals("rectangle")) {
                currentShape = new Rectangle(me.getX(), me.getY(), 1, 1, 10, 1, fill.getValue(), outline.getValue());
            } else if (shapeSelected.equals("line")) {
                currentShape = new Lines(me.getX(), me.getY(), 2, 1, 1, fill.getValue(), outline.getValue());
            }
        }
    }
//realse handler controls the application whenever it is realsed

    private void releaseHandler(MouseEvent me) {
        double mx = me.getX();
        double my = me.getY();
        double newR = Math.sqrt(Math.pow(currentShape.getStartX() - mx, 2)
                + Math.pow(currentShape.getStartY() - my, 2));
        if (me.getButton() == MouseButton.PRIMARY) {
            if (shapeSelected.equals("circle")) {
                ((Circle) currentShape).setRadius(newR);
            } else if (shapeSelected.equals("rectangle")) {
                ((Rectangle) currentShape).setEx(mx);
                ((Rectangle) currentShape).setEy(my);
            } else if (shapeSelected.equals("line")) {
                ((Lines) currentShape).setEx(mx);
                ((Lines) currentShape).setEy(my);
            }
        }

        currentShape.setLineWidth(newWidth);
        currentShape.setFillColor(fill.getValue());
        currentShape.setStrokeColor(outline.getValue());
        slist.add(currentShape);
        drawAll();

    }
//draghandler controls the application whenever it is dragged

    private void dragHandler(MouseEvent me) {
        double mx = me.getX();
        double my = me.getY();
        double newR = Math.sqrt(Math.pow(currentShape.getStartX() - mx, 2)
                + Math.pow(currentShape.getStartY() - my, 2));
        if (me.getButton() == MouseButton.PRIMARY) {
            if (shapeSelected == "circle") {
                ((Circle) currentShape).setRadius(newR);
            } else if (shapeSelected == "rectangle") {
                ((Rectangle) currentShape).setEx(mx);
                ((Rectangle) currentShape).setEy(my);
            } else if (shapeSelected == "line") {
                ((Lines) currentShape).setEx(mx);
                ((Lines) currentShape).setEy(my);
            }
        }

        currentShape.setLineWidth(newWidth);
        currentShape.setFillColor(fill.getValue());
        currentShape.setStrokeColor(outline.getValue());
        drawAll();
        currentShape.draw(gc);

    }
//Redraws the sreen and all shapes

    public void drawAll() {
        gc.clearRect(0, 0, 1000, 400);
        gc.setFill(Color.AQUA);
        gc.fillRect(0, 0, 1000, 400);
        for (Shapes cc : slist) {
            cc.draw(gc);
        }

    }
// Selectes a rectangle when clicked

    public void selectedObject(MouseEvent me) {
        double mx = me.getX();
        double my = me.getY();
        double newR = Math.sqrt(Math.pow(currentShape.getStartX() - mx, 2)
                + Math.pow(currentShape.getStartY() - my, 2));
        if (me.getButton() == MouseButton.SECONDARY) {
            for (Shapes s : slist) {

                if (s instanceof Rectangle) {
                    if (mx >= s.getStartX() && mx <= ((Rectangle) s).getEx() && my >= s.getStartY() && my <= ((Rectangle) s).getEy()) {
                        selectedShape = s;
                        gc.setFill(Color.BLACK);
                        gc.fillRect(s.getStartX(), s.getStartY(), ((Rectangle) s).getEx() - s.getStartX(), ((Rectangle) s).getEy() - s.getStartY());

                    }
                }
            }
        }
    
    }
        /**
         * @param stage The main stage
         * @throws Exception
         */
        @Override
        public void start
        (Stage stage) throws Exception {
            //  stage.setTitle("Shapes"); // window title he
            Group root = new Group();
            Canvas canvas = new Canvas(1000, 600);
            gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BURLYWOOD);
            gc.fillRect(0, 400, 1000, 200);

            Scene scene = new Scene(root);
            root.getChildren().add(canvas);
            stage.setTitle("ShapesApp"); // set the window title here
            stage.setScene(scene);
            // TODO: Add your GUI-building code here
            Canvas c = new Canvas(1000, 400);
            gc = c.getGraphicsContext2D();
            gc.setFill(Color.AQUA);
            gc.fillRect(0, 0, 1000, 400);
            // 1. Create the model
            // 2. Create the GUI components
            circle = new Button("Circle");
            rectangle = new Button("Rectangle");
            line = new Button("Line");
            toBack = new Button("to Back");
            undo = new Button("UNDO");
            toFront = new Button("to Front");
            delete = new Button("Delete");
            clear = new Button("Clear");
            widthButton = new Button("Set Width");
            reset = new Button("Reset Shape Color");
            instruction = new Label("INSTRUCTIONS");
            outlinelabel = new Label("Outline");
            filllabel = new Label("Fill");
            widthlabel = new Label("Stroke Width");
            object = new Label("Selected Object");
            left = new Label("**Left mouse click and draw to a new object");
            right1 = new Label("**Right mouse click to select object");
            right2 = new Label("**Right mouse click and drag to move selected object");
            deletelabel = new Label("**Delete/Move to Front-Back usings Buttons");
            outline = new ColorPicker(Color.BLUE);
            fill = new ColorPicker(Color.RED);
            width = new TextField("Width");
            // 3. Add components to the root
            root.getChildren().addAll(c, circle, rectangle, line, toBack, toFront,
                    delete, clear, reset, outline, fill, width, instruction, outlinelabel, undo, filllabel,
                    widthlabel, object, left, right1, right2, widthButton, deletelabel);
            // 4. Configure the components (colors, fonts, size, location)
            circle.relocate(20, 450);
            rectangle.relocate(100, 450);
            line.relocate(200, 450);
            clear.relocate(450, 450);
            delete.relocate(530, 520);
            outlinelabel.relocate(50, 490);
            filllabel.relocate(220, 490);
            widthlabel.relocate(340, 490);
            outline.relocate(20, 520);
            fill.relocate(180, 520);
            undo.relocate(500, 570);
            toFront.relocate(450, 520);
            toBack.relocate(610, 520);
            width.relocate(330, 520);
            reset.relocate(520, 450);
            widthButton.relocate(330, 550);
            width.setPrefWidth(50);
            object.relocate(490, 490);
            instruction.relocate(750, 430);
            left.relocate(700, 450);
            right1.relocate(700, 470);
            right2.relocate(700, 490);
            deletelabel.relocate(700, 510);
            // 5. Add Event Handlers and do final setup
            widthButton.setOnAction(this::setWidth);
            undo.setOnAction(this::undoHandler);
            toFront.setOnAction(this::toFrontHandler);
            circle.setOnAction(this::circleHandler);
            rectangle.setOnAction(this::rectangleHandler);
            line.setOnAction(this::linesHandler);
            clear.setOnAction(this::clearHandler);
            delete.setOnAction(this::deleteHandler);
            c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
            c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
            c.addEventHandler(MouseEvent.MOUSE_CLICKED, this::selectedObject);
            c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
            //c.addEventHandler(MouseEvent., this::dragHandler);
            // 6. Show the stage
            stage.show();
        }
        /**
         * Make no changes here.
         *
         * @param args unused
         */
    public static void main(String[] args) {
        launch(args);
    }
}
