import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRecord extends Actor
{
    /**
     * Act - do whatever the GameRecords wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    private String playerName;
    private int score;

    public GameRecord(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRecord that = (GameRecord) o;
        return score == that.score && Objects.equals(playerName, that.playerName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(playerName, score);
    }*/
}
