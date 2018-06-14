package swing;

public class Entry {
	public static void main(String[] args) throws InterruptedException {
	    World world = new MyWorld(700, 700);
	    world.setVisible(true);
	    world.timer();
	}
}
