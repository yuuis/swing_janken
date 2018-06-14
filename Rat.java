package swing; 

public class Rat extends Actor implements Janken {
    
    int id;
    
    public Rat(String image) {
        super(image);
        this.id = Janken.generateId();
    }

    public void act() {
    	
    	move(5);
        if (isAtEdge()) {
            move(-5);
            turn(270);
        } 
    	
        Actor actor = getOneIntersectingObject();
        Janken janken = null;
        if(actor instanceof Janken) {
            janken = (Janken)actor;
            int my_id = id;
            int enemy_id = janken.getId();
            if(my_id > enemy_id) {
                JankenHand enemy_hand = janken.decide();
                JankenHand my_hand = decide();
                JankenResult result = battle(my_hand, enemy_hand);
                moveForResult(result, actor, this);
            }
        } else if (actor != null && janken == null) {
            setLocation(300, 200);
        } 
    }

    public int getId() {
        return this.id;
    }
}
