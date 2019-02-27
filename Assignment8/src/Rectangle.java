
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
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
public class Rectangle extends Shapes {

    /**
     * Side of a rectangle
     */
    private double cx, cy, ex, ey;

    /**
     *
     * @param cx the center x of the rectangle
     * @param cy the center y of the rectangle
     * @param side the side of a rectangle
     * @param lineWidth the width of the stroke
     * @param fillColor the fillcolor of the rectangle
     * @param strokeColor the strokecolor of the rectangle
     */
    public Rectangle(double cx, double cy, double ex, double ey, double side, double lineWidth, Color fillColor, Color strokeColor) {
        super(cx, cy, lineWidth, fillColor, strokeColor);
        this.cx = cx;
        this.cy = cy;
        this.ex = ex;
        this.ey = ey;
    }
/**
 * 
 * @return the end x of the rectangle
 */
    public double getEx() {
        return ex;
    }
/**
 * 
 * @param ex sets the end x of the rectangle
 */
    public void setEx(double ex) {
        this.ex = ex;
    }
/**
 * 
 * @return gets the end y of the rectangle
 */
    public double getEy() {
        return ey;
    }
/**
 * sets the end y of the rectangle
 * @param ey 
 */
    public void setEy(double ey) {
        this.ey = ey;
    }

    /**
     * Draws the rectangle
     *
     * @param gc
     */
    @Override
    public void draw(GraphicsContext gc) {
        double x, x1, y, y1, minx, maxx, miny,maxy;
        x = getEx();
        x1 = super.getStartX();
        y = getEy();
        y1 = super.getStartY();
        minx = Math.min(x1, x);
        maxx = Math.max(x, x1);
        miny = Math.min(y, y1);
        maxy = Math.max(y, y1);
        super.draw(gc);
        gc.fillRect(super.getStartX(), super.getStartY(), maxx-minx, maxy-miny);
        gc.strokeRect(super.getStartX(), super.getStartY(), maxx-minx, maxy-miny );
    }

}
