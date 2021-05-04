import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;


class SortableDataStore implements Comparable<SortableDataStore> {
    protected String productItem, noItem, orderInfo;

    public SortableDataStore(String p, String n, String o) {
        productItem = p;
        noItem = n;
        orderInfo = o;
    }

    public String toString() {
        return productItem + ", " + noItem + ", " + orderInfo;
    }

    @Override
    public int compareTo(SortableDataStore o) {
        int[] compares = {
                this.productItem.compareTo(o.productItem),
                this.noItem.compareTo(o.noItem),
                this.orderInfo.compareTo(o.orderInfo)
        };
        for (int comp: compares) {
            if(comp != 0){
                return comp;
            }
        }
        return 0;
    }


    // fill in the area to implement Comparable interface

} // end of DataStore


/******
 This provides only the sample code for Java GUI shape.
 You should fill in all the code for envent handling and other operation.
 *****/
public class ProductOrder extends JFrame {
    protected String list_Contents = "";
    protected final int capacity = 20;
    protected LinkedBlockingQueue<SortableDataStore> v
            = new LinkedBlockingQueue<>(capacity);

    protected JPanel topp, leftp, rightp, bottomp, centerup, centerdown;
    protected JButton putb, showb, sortb, clearb;
    protected JLabel title, noorder, orderinfo;
    protected JList<String> plist;
    protected JTextField nofield, infofield;
    protected JTextArea contentsarea;
    protected String[] data = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
    protected int lastIndex = -1;

    public ProductOrder() {
        getContentPane().setLayout(new BorderLayout());
        topp = new JPanel();
        leftp = new JPanel();
        rightp = new JPanel();
        bottomp = new JPanel();
        centerup = new JPanel();
        centerdown = new JPanel();

        getContentPane().add(topp, "North");
        getContentPane().add(leftp, "West");
        getContentPane().add(rightp, "Center");
        getContentPane().add(bottomp, "South");

        title = new JLabel("Product Order");
        title.setFont(new Font("Product Order", Font.BOLD, 20));
        topp.add(title);

        plist = new JList<>(data);
        plist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        plist.addListSelectionListener(this::productItemListener);
        leftp.add(plist);

        noorder = new JLabel("No. of Order Items");
        orderinfo = new JLabel("Order Information");
        nofield = new JTextField();
        infofield = new JTextField();

        putb = new JButton("Put into Cart");
        putb.addActionListener(this::putButtonListener);
        sortb = new JButton("Sort Items");
        sortb.addActionListener(this::sortButtonListener);
        clearb = new JButton("Reset Cart");
        clearb.addActionListener(this::resetButtonListener);

        centerup.setLayout(new GridLayout(2, 2));
        centerup.add(noorder);
        centerup.add(orderinfo);
        centerup.add(nofield);
        centerup.add(infofield);
        centerdown.setLayout(new GridLayout(1, 2));
        centerdown.add(putb);
        centerdown.add(sortb);
        centerdown.add(clearb);

        rightp.setLayout(new GridLayout(2, 1));
        rightp.add(centerup);
        rightp.add(centerdown);

        showb = new JButton("Show Cart");
        showb.addActionListener(this::showButtonListener);


        contentsarea = new JTextArea(10, 1);
        bottomp.setLayout(new GridLayout(1, 2));
        bottomp.add(showb);
        bottomp.add(contentsarea);

    }  // Product Order constructor


    /*****
     Fill in code for event listeners.
     You can use inner classes for the listeners.
     *****/
    private void productItemListener(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            int FirstIndex = event.getFirstIndex();
            int LastIndex = event.getLastIndex();
            if (this.lastIndex == FirstIndex) {
                this.lastIndex = LastIndex;
            } else {
                this.lastIndex = FirstIndex;
            }
            this.list_Contents = this.data[this.lastIndex];
        }

    }

    private void putButtonListener(ActionEvent event) {
        SortableDataStore data = new SortableDataStore(
                list_Contents,
                nofield.getText(),
                infofield.getText()
        );
        try {
            v.add(data);
        } catch (IllegalStateException ignored) {
            v.poll();
            v.add(data);
        }
    }

    private void sortButtonListener(ActionEvent event) {
        Stream<SortableDataStore> stream = v.stream().sorted();
        v = new LinkedBlockingQueue<>(capacity);
        stream.forEachOrdered(dataStore -> v.add(dataStore));
        showList();
    }

    private void resetButtonListener(ActionEvent event) {
        v.clear();
        contentsarea.setText("");
    }

    private void showButtonListener(ActionEvent event) {
        showList();
    }

    private void showList() {
        contentsarea.setText("");
        for (SortableDataStore data : v) {
            contentsarea.append(data.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        ProductOrder f = new ProductOrder();
        f.setTitle("Product Order");
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
} // end of ProductOrder

