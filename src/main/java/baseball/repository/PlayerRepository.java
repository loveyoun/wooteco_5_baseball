package baseball.repository;

import baseball.domain.Player;

public class PlayerRepository {

    private Player player;

    public void setPlayer(int firstNum, int secondNum, int thirdNum) {
        this.player = new Player(firstNum, secondNum, thirdNum);
    }

    public Player getPlayer() {
        return this.player;
    }

}
