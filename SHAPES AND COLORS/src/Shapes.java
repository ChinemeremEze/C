
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/*
 * The Shapes class in which other shapes extend from
 *
 * @author David Ezeakudolu
 */
public abstract class Shapes {

    /**
     *startX and startY are the center x and y of each shape
     * linewidth is the width of the stroke
     */
    private double startX, startY, lineWidth;
    /**
     * The color gives colors to the fill and outline of all shapes
     */
    private Color fillColor, strokeColor;
/**
 * 
 * @param startX start x of a shape
 * @param startY start y of a shape
 * @param lineWidth stroke width of a shape
 * @param fillColor fill color off a shape
 * @param strokeColor stroke color of a shape
 */
    public Shapes(double startX, double startY, double lineWidth, Color fillColor, Color strokeColor) {
        this.startX= startX;
        this.startY = startY;
        this.lineWidth = lineWidth;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }
/**
 * 
 * @return the start x of the shape
 */
    public double getStartX() {
        return startX;
    }
/**
 * 
 * @param startX the start x of a shape
 */
    public void setStartX(double startX) {
        this.startX = startX;
    }
/**
 * 
 * @return start y of a shape
 */
    public double getStartY() {
        return startY;
    }
/**
 * 
 * @param startY start y of a shape
 */
    public void setStartY(double startY) {
        this.startY = startY;
    }
/**
 * 
 * @return the stroke color of a shape
 */
    public Color getStrokeColor() {
        return strokeColor;
    }
/**
 * 
 * @param strokeColor stroke color of a shape
 */
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }
/**
 * 
 * @return fill color off a shape
 */
    public Color getFillColor() {
        return fillColor;
    }
/**
 * 
 * @param fillColor fill color off a shape
 */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
/**
 * @return stroke width of a shape
 */
    public double getLineWidth() {
        return lineWidth;
    }
/**
 * 
 * @param lineWidth stroke width of a shape
 */
    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
/**
 * Draws the shape
 * @param gc 
 */
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(getLineWidth());
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
    }
/**
 * 
 * @return 
 */

}
