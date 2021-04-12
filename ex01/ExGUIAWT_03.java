import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener {

    ExGUIAWT_03(String title) {
        super(title);
        this.canvas.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        this.canvas.center = new Point(e.getX(), e.getY());
        this.canvas.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }


    public static void main(String[] args) {
        (new ExGUIAWT_03("Ex#1: Step 3")).setVisible(true);
    }
}
