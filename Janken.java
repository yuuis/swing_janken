package swing;

import java.util.Random;

interface Janken {
    
    public int getId();

    default public JankenHand decide() {
        Random rondom = new Random();
        int hand = rondom.nextInt(3);
        JankenHand return_hand = null;
        switch(hand) {
            case 0:
                return_hand = JankenHand.goo; 
                break;
            case 1:
                return_hand = JankenHand.choki;
                break;
            case 2:
                return_hand = JankenHand.pa; 
                break;
        }
        return return_hand;
    }

    default public JankenResult battle(JankenHand my_hand, JankenHand enemy_hand) {
        JankenResult result = null;
        switch(my_hand) {
            case goo:
                switch (enemy_hand) {
                    case goo:
                        result = JankenResult.draw;
                        System.out.println(JankenResult.draw);
                        break;
                    case choki:
                        result = JankenResult.win;
                        System.out.println(JankenResult.win);
                        break;
                    case pa:
                        result = JankenResult.lose;
                        System.out.println(JankenResult.lose);
                        break;
                }
                break;
            case choki:
                switch (enemy_hand) {
                    case goo:
                        result = JankenResult.lose;
                        System.out.println(JankenResult.lose);
                        break;
                    case choki:
                        result = JankenResult.draw;
                        System.out.println(JankenResult.draw);
                        break;
                    case pa:
                        result = JankenResult.win;
                        System.out.println(JankenResult.win);
                        break;
                }
                break;
            case pa:
                switch (enemy_hand) {
                    case goo:
                        result = JankenResult.win;
                        System.out.println(JankenResult.win);
                        break;
                    case choki:
                        result = JankenResult.lose;
                        System.out.println(JankenResult.lose);
                        break;
                    case pa:
                        result = JankenResult.draw;
                        System.out.println(JankenResult.draw);
                        break;
                }
                break;
        }
        return result;
    }

    default public void moveForResult(JankenResult result, Actor actor, Actor me) {
        if(result == JankenResult.win){
            actor.setLocation(300, 200);
        }
        if(result == JankenResult.lose){
            me.setLocation(300, 200);
        }
        if(result == JankenResult.draw){
            actor.setLocation(0, 0);
            me.setLocation(600, 400);
        }
    }

    static public int generateId() {
        int id = IDGenerator.getId();
        return id;
    }
}