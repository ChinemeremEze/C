


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
public class Circle extends Shapes {

    /**
     * Radius of the circle
     */
    private double radius;
    /**
     * Start of the circle
     */
    private double cx, cy;

    /**
     *
     * @param cx center x of a shape
     * @param cy center y of a shape
     * @param lineWidth stroke width of a shape
     * @param radius radius of the circle
     * @param fillColor fill color off a shape
     * @param strokeColor stroke color of a shape
     */
    public Circle(double cx, double cy, double lineWidth, double radius, Color fillColor, Color strokeColor) {
        super(cx, cy, lineWidth, fillColor, strokeColor);
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    /**
     *
     * @param newR new radius of the circle
     */
    public void setRadius(double newR) {
        this.radius = newR;
    }

    /**
     *
     * @return the start x
     */
    public double getCx() {
        return cx;
    }

    /**
     *
     * @return the start y
     */
    public double getCy() {
        return cy;
    }

    /**
     *Draws the Circle
     * @param gc
     */
    @Override
    public void draw(GraphicsContext gc) {
        double hr = radius / 2;
        super.draw(gc);
        gc.fillOval(cx - hr, cy - hr, radius * 2, radius * 2);
        gc.strokeOval(cx - hr, cy - hr, radius * 2, radius * 2);
        
    }
    
}
