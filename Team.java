package Assign_7;
import java.io.*;
import BasicIO.*;
/** This class represents an employee in the company.
  * 
  * 
  * 
  * @version 2019-11-29
  *
  *                               */

public class Team {
  
  
  private String  teamName; //team name
  private int gF ;         //goals for the team
  private int  gA;         //goals against the team
  private int  points;     //points to be calculated
  
  
  public Team ( ASCIIDataFile from ) {
    
    teamName  = from.readString();
    if ( ! from.isEOF() ) {
      //reading data from the file
      gF = from.readInt();
      gA = from.readInt();
      points = from.readInt();
    };
    
  };  // constructor
  
  
  /** This method returns the team name.
    * 
    * @return  String  team name.                                        */
  
  public String getTeamName ( ) {
    
    return teamName;
    
  };  // getTeamNmae
  
  
  /** This method returns the goals for the team.
    * 
    * @return  Int goals for.                                          */
  
  public int getGoalsFor ( ) {
    
    return gF;
    
  };  // getGoalsFor
  
  
  /** This method returns the goals against the team.
    * 
    * @return  Int goals against.                                               */
  
  public int getGoalsAgainst ( ) {
    
    return gA;
    
  };  // getGoalsAgainst
  
  /** This method returns the points for the team.
    * 
    * @return  Int points.                                               */
  
  
  public int getPoints ( ) {
    
    return points;
    
  };
  
  public void play ( int gF, int gA ) { 
    
    int  pointss=0;  // gross pay
    
    if ( gF > gA ) {
      pointss= 2;
    }
    else if(gF==gA) {
      pointss=1;
    }
    else{
      pointss=0;
    } 
    points=points+pointss;
  };  //play
  
  /** This method writes the employee information as a line to a text file.
    * 
    * @param  to  file to write to.                                            */
  
  public void write ( ASCIIOutputFile to ) {
    
    to.writeString(teamName);
    to.writeInt(gF);
    to.writeInt(gA);
    to.writeInt(points);
    to.newLine();
    
  };  // write
  
  
}  // Team