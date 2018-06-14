package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class World extends JFrame{
	int width;
	int hight;
	int cellSize = 1;
	boolean isBounded = true;
	boolean backgroundIsClassImage;
	List<Actor> actors = new ArrayList<Actor>();
	JPanel panel;
	
    public World(int width, int hight) {
    	this.width = width;
    	this.hight = hight;
    	setTitle("ワールド");
        setBounds(100, 100, width, hight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER); 
    }
    
    public void timer() throws InterruptedException {
    	while(true) {
    		for (Actor ac : actors) {
    			ac.act();
    			ac.setWorld(this);
    			JLabel label = ac.repaint();
    			
    			Thread.sleep(10);
    		}
    	}
    }
	
	public void addObject(Actor actor, int x, int y) {
		actor.x = x;
		actor.y = y;
		actors.add(actor);
		
		JLabel label = actor.label;
		label.setBounds(x, y, 200, 200);
		panel.setLayout(null);
		panel.add(label);
		
		Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);
	    panel.repaint();
    }
	 
}
