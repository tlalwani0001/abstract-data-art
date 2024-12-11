public class NBA {

/*
  *Instance variables
  */
  
  private String team;
  private String arena;
  private int capacity;
  private int wins;

  /*
  *Paramaterized constructor
  */
  public NBA(String team, String arena, int capacity, int wins) {
    this.team = team;
    this.arena = arena;
    this.capacity = capacity;
    this.wins = wins;
  }

  /*
  *Getter methods
  */
  public String getTeam() {
    return team;
  }

  public String getArena() {
    return arena;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getWins() {
    return wins;
  }
}