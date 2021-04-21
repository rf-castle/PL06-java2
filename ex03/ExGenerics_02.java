import java.awt.Canvas;
import java.util.ArrayList;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author s1270013 (Your student ID)
 */
public class ExGenerics_02 extends Frame{
	ArrayList<String> num_list = new ArrayList<>();
	private final CVS cvs = new CVS();

	// An inner canvas class 
	private final class CVS extends Canvas {
		@Override
		public void paint(final Graphics g){
			super.paint(g);

			for(int ii = 0 ; ii < num_list.size() ; ii++){
				String s = num_list.get(ii);
				g.drawString(s, 100, ii*20);
			}
		}
	}
	/**
	* Constructor
	* @param title the title of the window
	*/
	public ExGenerics_02(String title){
		super(title);

		add(cvs);
		setSize(420,300);
		num_list.add("1200");
		num_list.add("1400");
		num_list.add("1500");
		num_list.add("1600");
	}
	public static void main(String[] args){
		new ExGenerics_02("ExGenerics_02").setVisible(true);
	}
	public static void p(Object arg){
		System.out.println(arg);
	}
}
