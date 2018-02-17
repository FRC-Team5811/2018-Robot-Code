package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Secret extends Command {
	int magicCounter;
	int present;
	int past;
	boolean end;
    public Secret() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	magicCounter = 0;
    	past = 0;
    	present = 0;
    	end = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	past = present;
    	present = Robot.oi.getPov();
    	if (past == 0) {
			if (magicCounter == 0){
		    	System.out.println("*BAM* the body hit the floor, but who was the murderer?");
	    		System.out.println("[UP] Look around");
	    		System.out.println("[DOWN] Search the body");
	    		if (present == 0) {
	    			magicCounter = 1;
	    		} 
	    		if (present == 180) {
	    			magicCounter = 2;
	    		}
			} else if (magicCounter == 1) {
				System.out.println("You found a spring with a spring constant of 50 N/m and a length of 600 m.");
				System.out.println("[UP] Play with spring");
	    		System.out.println("[DOWN] Run away");
	    		if (present == 0) {
	    			magicCounter = 3;
	    		} 
	    		if (present == 180) {
	    			magicCounter = 4;
	    		}
			} else if (magicCounter == 2) {
				System.out.println("You see nothing because your blind");
				System.out.println("[UP] Gouge your eyes out");
	    		System.out.println("[DOWN] Cry");
	    		if (present == 0) {
	    			magicCounter = 5;
	    		} 
	    		if (present == 180) {
	    			magicCounter = 6;
	    		}
			} else if (magicCounter == 3) {
				System.out.println("You somehow strangle yourself with the spring when you can't overcome the EPE of 0.5(50)(600)^2");
				end = true;
			} else if (magicCounter == 4) {
				System.out.println("There's no running from a trainer in battle!");
				System.out.println("[UP] Admit defeat and return to the battle");
				if (present == 0) {
					magicCounter = 1;
				}
				
			} else if (magicCounter == 5) {
				System.out.println("You don't have any eyes you silly goose");
				System.out.println("[UP] Cry");
	    		if (present == 0) {
	    			magicCounter = 5;
	    		}
			} else if (magicCounter == 6) {
				System.out.println("You can see clearly now! It was Peter!");
				System.out.println("[UP] Congratulate Peter");
				if (present == 0) {
					magicCounter = 7;
				}
			} else if (magicCounter == 7) {
				System.out.println("Good job PETER!!!!");
				System.out.println("He's a murderer you don't congratulate him, you lose.");
				end = true;
			}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
