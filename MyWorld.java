package swing;

public class MyWorld extends World {
    public MyWorld(int width, int hight) {
        super(width, hight); 
        Actor flog = new Flog("/Users/yuuis/tut/first_semester/応用プログラミング3/rat/images/frog.png");
        addObject(flog, 10, 10);
        flog.setWorld(this);
        
        Actor rat = new Rat("/Users/yuuis/tut/first_semester/応用プログラミング3/rat/images/mouse.png");
        addObject(rat, 500, 10);
        rat.setWorld(this);
    }
}