import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a choses dataset
 */
public class DataScene extends Scene {

  private NBA[] franchise;     

  /*
  *Constructor 
  */
  public DataScene() {
    franchise = createFranchise();
  }

  /** 
  *Returns a 1D array of Person objects using the txt files in this project 
  */
  public NBA[] createFranchise() {
    String[] teamsArray = FileReader.toStringArray("teams.txt");
    String[] arenasArray = FileReader.toStringArray("arenas.txt");
    int[] capacityArray = FileReader.toIntArray("capacity.txt");
    int[] winsArray = FileReader.toIntArray("wins.txt");
    
    
    NBA[] franchiseArray = new NBA[teamsArray.length];
    for (int i = 0; i < teamsArray.length; i++) {
      franchiseArray[i] = new NBA(teamsArray[i], arenasArray[i], capacityArray[i], winsArray[i]);
    }

    return franchiseArray;
  }

  /**
   * Top-level method to draw the animation
   */
public void drawScene() {

    for (NBA t : franchise) {
      clear("blue");
        /*
         * Draw the team image and relevant information for each team.
         * The image is displayed first, followed by the team name, arena,
         * capacity, and whether the team has won a championship.
         */
        drawImage("download.png", 100, 50, 200);
        setTextStyle(Font.MONO, FontStyle.BOLD);
        setTextHeight(25);

        /*
        *Draw the team name, arena, and capacity
        */
       
        drawText(t.getTeam(), 80, 300);
        drawText(t.getArena(), 80, 335);
        drawText("Capacity: " + t.getCapacity(), 80, 370);

        
      /*Display if the team has won a championship
      */
        if (t.getWins() > 0) {
            drawText("Won a championship? YES", 50, 30);
          playSound("Party-Horn-Sound-Effect-_-ezmp3.cc-_.wav");
          
        } else {
            drawText("Won a championship? NO", 50, 30);
          playSound("Ping-sound-effect-_-ezmp3.cc-_.wav");
          
        }

        /*
        *Pause to give the user time to view the information
        */
        /*
         * The pause time is 0.7 
         * This ensures the user can read the information before moving to the next team.
         */
        pause(0.7);
    }
}
}