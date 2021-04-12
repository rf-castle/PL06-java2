import java.awt.*;

class MyCanvas extends Canvas {
    protected Point center;
    protected int radius;
    MyCanvas(Point center, int radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.drawRect(5, 0, 370, 200);
        g.setColor(Color.red);
        g.drawOval(
                this.center.x - this.radius,
                this.center.y - this.radius,
                2 * this.radius, 2 * this.radius
        );
        g.setColor(Color.black);
        g.drawString("The circle:", 120, 75);
        g.drawString(
                String.format(
                    "center = (%d,%d);", this.center.x, this.center.y
                ),
                160, 110
        );
        g.drawString("radius = " + this.radius, 160, 140);

    }
}

public class ExGUIAWT_01 extends Frame {
    protected MyCanvas canvas;
    protected Point center = new Point(200, 100);
    protected int radius = 100;
    ExGUIAWT_01(String title){
        super(title);
        this.canvas = new MyCanvas(this.center, this.radius);
        this.setSize(400, 300);
        this.add(this.canvas);
    }

    public static void main(String[] args) {
        new ExGUIAWT_01("Ex#1: Step1").setVisible(true);
    }
}