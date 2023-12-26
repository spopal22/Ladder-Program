import java.awt.*;
import javax.swing.*;
	 
public class ladderProgram extends JPanel {
	 
	public void paintComponent(Graphics g) {

		     g.setColor(Color.blue);
		     g.fillRect(100, 0, 100, 120);

		     g.setColor(Color.green);
		     g.fillRect(0,120, 200, 20);

		     g.setColor(Color.red);
		     int[] xy=getCoordinates();
		     g.drawLine(xy[0],xy[1],xy[2],xy[3]);
		     //Make an illustration of the ladder leaning against a home
		 
		  }		 
	 private int[] getCoordinates() {
			  //Creates a random ladder size
			  //Sets range between 15-25 feet
			  int hyp = (int)(Math.random() * 11) + 15;
			  System.out.println("Random size of the ladder: "+hyp);
			  //random ladder angle
			  //Sets angle range between 60-75
			  int angle = (int)(Math.random() * 16) + 60;
			  System.out.println("The random number of degrees of the angle where the ladder leans against the side of the house is: "+angle);
			  //Convert the degrees to radians
			  double rad=Math.toRadians(angle);
			  System.out.println("The corresponding radians of the angle is: "+Math.round(rad*10)/10.0);
			  //Code for height
			  double height=Math.sin(rad)*hyp;
			  System.out.println("The calculated height of the ladder up the house is: "+Math.round(height*10)/10.0);
			  //Code for distance
			  double distance = Math.sqrt(Math.pow(hyp, 2) - Math.pow(height, 2));	
			  System.out.println("The calculated distance the ladder is from the house is: "+Math.round(distance*10)/10.0);
			  //Setting coordinates for the ladder
			  int scaling=5;
			  int[] x= {(int)(100-distance*scaling),120,100,(int)(120-height*scaling)};
			 
			  return x;
			

		}

	public static void main(String[] args) {
			//Code for the pop-up
		    JFrame frame = new JFrame("Ladder Program");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setBackground(Color.white);
		    frame.setSize(400, 400);
		    //Dialog box
		    int choice=JOptionPane.showConfirmDialog(null,
		            "Do you need a ladder?", "Ladder Program",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    
		    //If user selects yes
		    if (choice == JOptionPane.YES_OPTION)
		    {
		    	ladderProgram panel = new ladderProgram();
		    	frame.add(panel);
			    frame.setVisible(true);
		    }
		    else //If user selects no
		    	System.exit(0);
		    
		  }
		}
	