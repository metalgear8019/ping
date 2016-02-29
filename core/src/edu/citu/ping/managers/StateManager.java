package edu.citu.ping.managers;

import com.badlogic.gdx.Gdx;

import edu.citu.ping.Ping;
import edu.citu.ping.literals.Constants;

/**
 * Created by metalgear8019 on 2/29/16.
 */
public class StateManager {
    private static StateManager INSTANCE;
    private Ping game;

    public int ballX;
    public int ballY;

    public Player p1;
    public Player p2;
    public Player winner;

    public class Player {
        public static final int PING = 0;
        public static final int PONG = 1;

        public int x;
        public int y;
        public String name;
        private int score;

        public Player(int playerType) {
            switch (playerType) {
                default:
                case PING:
                    x = Ping.WIDTH / 2;
                    y = Ping.HEIGHT - 100;
                    name = "Ping";
                    break;
                case PONG:
                    x = Ping.WIDTH / 2;
                    y = 100;
                    name = "Pong";
                    break;
            }
            score = 0;
        }

        public String serialize() {
            return name + Constants.SEMICOLON +
                    score + Constants.SEMICOLON +
                    x + Constants.SEMICOLON +
                    y + Constants.SEMICOLON;
        }

        public void deserialize(String csv) {
            String[] values = csv.split(Constants.SEMICOLON);
            if (values.length == 4) {
                try {
                    name = values[0];
                    score = Integer.parseInt(values[1]);
                    x = Integer.parseInt(values[2]);
                    y = Integer.parseInt(values[3]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void incrementScore() {
            score++;
        }

        public void decrementScore() {
            score--;
        }

        public void resetScore() {
            score = 0;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + "'s score: " + score;
        }
    }

    public StateManager(Ping g) {
        game = g;
        p1 = new Player(Player.PING);
        p2 = new Player(Player.PONG);
    }

    public static StateManager initialize(Ping g) {
        INSTANCE = new StateManager(g);
        return INSTANCE;
    }

    public static StateManager get() {
        return INSTANCE;
    }
}
