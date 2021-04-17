import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;


public class ExGUISwing_01 extends JFrame {
    protected JButton
            buttonPW,
            buttonAM,
            buttonFM,
            buttonCD,
            buttonUp,
            buttonDown
    ;
    protected JPanel panel;
    protected JLabel label;
    JButton[] buttons;
    public ExGUISwing_01() {
        super("Car Audio");
        this.setSize(370, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        // PanelとLabel
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.panel.setLocation(85,0);
        this.panel.setSize(200, 110);
        this.label = new JLabel("Power off");
        this.label.setFont(new Font("Dialog", Font.BOLD, 30));
        this.label.setForeground(new Color(0, 100, 0));
        this.label.setLocation(25, 50);
        this.label.setSize(170, 40);
        this.panel.add(this.label);
        // Button オブジェクトと位置設定
        this.buttonPW = new JButton("PW");
        this.buttonAM = new JButton("AM");
        this.buttonAM.setLocation(0, 40);
        this.buttonFM = new JButton("FM");
        this.buttonFM.setLocation(0, 80);
        this.buttonCD = new JButton("CD");
        this.buttonCD.setLocation(300, 0);
        this.buttonUp = new JButton("Up");
        this.buttonUp.setLocation(300, 40);
        this.buttonDown = new JButton("Down");
        this.buttonDown.setLocation(300, 80);

        this.buttons = new JButton[]{
                this.buttonPW,
                this.buttonAM,
                this.buttonFM,
                this.buttonCD,
                this.buttonUp,
                this.buttonDown
        };
        for (JButton button: this.buttons) {
            button.setSize(70, 30);
        }
        Component[] components = new Component[this.buttons.length + 1];
        System.arraycopy(this.buttons, 0, components, 0, this.buttons.length);
        components[this.buttons.length] = this.panel;
        for (Component comp: components) {
            this.add(comp);
        }
    }

    public static void main(String[] argv) {
        JFrame f = new ExGUISwing_01();
        f.setVisible(true);
    }
}
