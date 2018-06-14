package swing;

public class Entry {
	public static void main(String[] args) throws InterruptedException {
	    World world = new MyWorld(600, 600);
	    world.setVisible(true);
	    world.timer();
	}
}
