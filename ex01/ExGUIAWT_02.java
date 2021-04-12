import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
    Button[] buttons;
    ExGUIAWT_02(String title) {
        super(title);
        buttons = new Button[]{
                new Button("Increase r (r <= 100)"),
                new Button("Decrease r (r >= 10)")
        };
        Panel panel = new Panel();
        for (Button button: this.buttons) {
            button.addActionListener(this);
            panel.add(button);
        }

        this.add(panel, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button) {
            Button button = (Button)source;
            int index = Arrays.asList(this.buttons).indexOf(button);
            if(index == 0){
                if(this.canvas.radius >= 100){
                    return;
                }
                this.canvas.radius++;

            }
            else if(index == 1){
                if(this.canvas.radius <= 10){
                    return;
                }
                this.canvas.radius--;
            }
            else{
                return;
            }
            this.canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new ExGUIAWT_02("Ex#1: Step 2").setVisible(true);
    }
}
