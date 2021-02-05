package Assign_7;
import java.util.*;
import BasicIO.*;
import static BasicIO.Formats.*;
/** 
 * 
 * @author Kawshar Patel
 * 
 * @version 2019-11-29
 *
 *  */

public class Raisess {
  
  
  private ASCIIDataFile    teamData;     // data file for employee info
  private BasicForm         display;     // form for user input
  private ASCIIOutputFile  newTeamData;  // data file for updated emp info
  private ReportPrinter     report;      // printer for report
  
  /** The constructor does the annual raises for a small company generating a
    * report.                                                                  */
 public Raisess ( ) {
    Team anTeam;          //invoking the previously made class to extract details
    String  teamName;    //team name
    int gFor ;             // goals against
    int  gAgainst;            // goals for
    int  points;      //points
    int button;        //a variable for two buttons,that is bye and enter
    teamData= new ASCIIDataFile();
    display = new BasicForm("ENTER","BYE");   //creating two buttons for the form
    newTeamData = new ASCIIOutputFile();
    report = new ReportPrinter();
    buildForm();          //calling the build form method to create a form
    setUpReport();        //calling the setupreport method to set up the report from the form
    for(;;){
      anTeam=new Team(teamData);
      if(teamData.isEOF()) break;
      fillForm(anTeam);         //calling the method to fill the form created
      button=display.accept(); //user input
      gFor = display.readInt();
      gAgainst = display.readInt();
      if(button==1) break;
      points=anTeam.getPoints();
      writeDetail(anTeam,gFor,gAgainst,points);
      anTeam.play(gFor,gAgainst);
      anTeam.write(newTeamData);
    }
    teamData.close();
    newTeamData.close();
    display.close();
    report.close();
    
  };  // constructor
  
  
  /** This method builds the form for user input */
  
  private void buildForm ( ) {
    display.setTitle("NHL..");
    display.addTextField("teamName","Team",13,40,10);
    display.addTextField("gFor","For",5,10,50);
    display.addTextField("gAgainst","Against",5,100,50);
    
  };  // buildForm
  
  
  /** This method fills in the fields of the form for the Employee.
    * 
    * */
  
  private void fillForm ( Team anTeame ) {
    
    display.clearAll();
    display.setEditable("teamName",false);
    display.writeString("teamName",anTeame.getTeamName());
  };  // fillForm
  
  /** This method sets up the report, adding all fields. */
  
  private void setUpReport ( ) {
    
    report.setTitle("NHL Hockey Statistics");
    report.addField("teamName","Teams",15);
    report.addField("gF","For",9);
    report.addField("gA","Against",9);
    report.addField("points","Points",9);
    
  };  // setUpReport
  
  
  /** This method generates a report detail line.
    * */
  
  private void writeDetail ( Team anTeame,int gFor, int gAgainst, int points ) {
    
    report.writeString("teamName",anTeame.getTeamName());
    report.writeInt("gF",gFor);
    report.writeInt("gA",gAgainst);
    report.writeInt("points",points);
    
  };  // writeDetail
  
  public static void main ( String[] args ) { Raisess r = new Raisess(); };
  
  
}  // Raises