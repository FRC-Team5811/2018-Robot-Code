package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAutoMaster extends CommandGroup {

	String gameData;
	char firstLetter;
	int waitTime = 35;
	double driveTime1Left = 3000;
	double driveDirection1Left = -0.45;
	double turnAngle1Left = 45;
	double turnDirection1Left = -0.9;
	double DT2Left = 7500;
	double DD2Left = -0.45;
	double TA2Left = 45; 
	double TD2Left = 0.9;
	double DT3Left = 3000;
	double DD3Left = -0.45;
	
	double driveTime1Right = 3000;
	double driveDirection1Right = -0.45;
	double turnAngle1Right = 40;
	double turnDirection1Right = 0.8;
	double DT2Right = 7000;
	double DD2Right = -0.45;
	double TA2Right = 40;
	double TD2Right = -0.9;
	double DT3Right = 3000;
	double DD3Right = -0.45;
	
    public CenterAutoMaster() {
    	
    	requires(Robot.driveSUB);
    	requires(Robot.navx);
    	requires(Robot.encoders);
    	addSequential(new FullAutoReset());
		addSequential(new DriveAuto(driveTime1Left, driveDirection1Left));
		addSequential(new FullStop(waitTime));
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		while(gameData.length() == 0) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			//waiting for letter
		}
		firstLetter = gameData.charAt(0);
		//System.out.println(firstLetter);
    	if(firstLetter == 'L'){
    		//System.out.println("YEE");
    	
    		
    		//System.out.println("First move");
    		
    		
    	
    		
    		addSequential(new TurnAuto(turnAngle1Left, turnDirection1Left));
    		addSequential(new FullStop(waitTime));
    		
    		
    		
    		addSequential(new DriveAuto(DT2Left, DD2Left));
    		addSequential(new FullStop(waitTime));
    		
    		
    		
    		addSequential(new TurnAuto(TA2Left, TD2Left));
    		addSequential(new FullStop(waitTime));
    		
    	
    		
    		addSequential(new DriveAuto(DT3Left, DD3Left),3);
    		addSequential(new FullStop(waitTime));
    		addSequential(new SmartShoot(), 1);
    		
    		
    		System.out.println("lean l");
    	} else if(firstLetter == 'R'){
    	
//    		addSequential(new FullAutoReset());
//    		addSequential(new DriveAuto(driveTime1Right, driveDirection1Right));
//    		//System.out.println("First move");
//    		addSequential(new FullStop(waitTime));
//  
    		
    		addSequential(new TurnAuto(turnAngle1Right, turnDirection1Right));
    		addSequential(new FullStop(waitTime));

    		
    		addSequential(new DriveAuto(DT2Right, DD2Right));
    		addSequential(new FullStop(waitTime));

    		
    		addSequential(new TurnAuto(TA2Right, TD2Right));
    		addSequential(new FullStop(waitTime));
  
    		
    		addSequential(new DriveAuto(DT3Right, DD3Right), 3);
    		addSequential(new FullStop(waitTime));
    		addSequential(new SmartShoot(), 1);
    		

    	}
    	
    }

}
