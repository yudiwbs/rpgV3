//variabel2 global
public class GameInfo {
    private Boolean isGameOver = false;
    private Player objPlayer;

    public Player getObjPlayer() {
        return objPlayer;
    }

    public void setObjPlayer(Player objPlayer) {
        this.objPlayer = objPlayer;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }
}
