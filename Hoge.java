package swing;


public class Hoge extends Actor implements Janken {

    int id;
    
    public Hoge(String image) {
        super(image);
        this.id = Janken.generateId();
    }

    public void act() {
    	move(10);
    	
        if (isAtEdge()) {
            move(-10);
            turn(180);
        }
        
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println(isAtEdge());
    }

    public int getId() {
        return this.id;
    }

}