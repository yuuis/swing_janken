package swing;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import org.w3c.dom.css.Rect;

import javax.swing.JLabel;

public class Actor {
	int x;
	int y;
	int rotation = 0;
	String image;
	World world;
	JLabel label;
	private Rect boundingRect;
    private int[] boundingXs = new int[4];
    private int[] boundingYs = new int[4];
	
	public Actor(String imagepath) {
        this.image = imagepath;
        ImageIcon icon = new ImageIcon(this.image);
		label = new JLabel(icon);
		label.setPreferredSize(new Dimension(10, 10));

	}
	
	public void move(int distance) {
        double radians = Math.toRadians(rotation);
        int dx = (int) Math.round(Math.cos(radians) * distance);
        int dy = (int) Math.round(Math.sin(radians) * distance);
        setLocation(x + dx, y + dy);
    }
	
	public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	protected Actor getOneIntersectingObject() {
    	for (Actor ac : world.actors) {
			if(Math.abs(ac.x - this.x) <= 10 && Math.abs(ac.y - this.y) <= 10 && ac != this) {
    			return ac;
    		}
		}
    	return null;
    }
	
	public boolean isAtEdge() {
        return (x <= 0 || y <= 0 || x + 70 > world.getWidth() || y + 100 > world.getHeight());
    }
	
	public void act() {
		
	}
	
	public World getWorld() {
		return world;
	}
	
	public void turn(int amount) {
		setRotation(rotation + amount);
	}
	
	public void setRotation(int rotation) {
        if (rotation >= 360) {
            if (rotation < 720) {
                rotation -= 360;
            }
            else {
                rotation = rotation % 360;
            }
        }
        else if (rotation < 0) {
            if (rotation >= -360) {
                rotation += 360;
            }
            else {
                rotation = 360 + (rotation % 360);
            }
        }
        
        if (this.rotation != rotation) {
            this.rotation = rotation;
            boundingRect = null;
        }
    }
	
	public JLabel repaint() {
		label.setBounds(x, y, 100, 100);
		return label;
		
	}
	
	public void setWorld(World world) {
		this.world = world;
	}

}
