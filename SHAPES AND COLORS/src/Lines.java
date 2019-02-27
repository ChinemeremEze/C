
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author My Computer
 */
public class Lines extends Shapes {

    private double ex, ey;

    /**
     *
     * @param startX center x of a shape
     * @param startY center y of a shape
     * @param ex end x of a shape
     * @param ey end y of a shape
     * @param lineWidth stroke width of a shape
     * @param fillColor fill color off a shape
     * @param strokeColor stroke color of a shape
     */
    public Lines(double startX, double startY, double ex, double ey, double lineWidth, Color fillColor, Color strokeColor) {
        super(startX, startY, lineWidth, fillColor, strokeColor);
        this.ex = ex;
        this.ey = ey;
    }

    /**
     *
     * @param newEx new endx of the line
     */
    public void setEx(double newEx) {
        this.ex = newEx;
    }

    /**
     * @param newEy new endy of the line
     */
    public void setEy(double newEy) {
        this.ey = newEy;
    }
/**
 * gets the endy of the line
 * @return 
 */
    public double getEx() {
        return ex;
    }
/**
 * gets the endy of the line
 * @return 
 */
    public double getEy() {
        return ey;
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.strokeLine(super.getStartX(), super.getStartY(), getEx(), getEy());
    }
}
