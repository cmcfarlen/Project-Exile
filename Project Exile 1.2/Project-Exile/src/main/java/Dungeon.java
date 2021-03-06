public interface Dungeon 
{
    public String nameOfDungeon = "";
    public int numberOfMinions = 0;
    public int levelOfDifficulty = 1;
    public String[] avaliableLoot = new String[0];
    public Conversation dialogue = new Conversation();
    public Minion[] minionList = new Minion[0];
    public boolean completed = false;
    
    public void fightMinion(Minion minion);
    public void playDialogue(String txt);
    public String getLoot();
    public void playMusic();
    public void remote();
    public void setCompleted(boolean completed);
    public String isCompleted();
}