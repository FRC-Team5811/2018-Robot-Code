package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoNoGoAutoMasterRight extends CommandGroup {
 	String gameData;
	char firstLetter;
	int waitTime = 35;
	double driveTime1Right = 8500;
	double DD1R = -0.7;
    public GoNoGoAutoMasterRight() {
   
    	requires(Robot.driveSUB);
    	requires(Robot.navx);
    	requires(Robot.encoders);
    	addSequential(new FullAutoReset());
		addSequential(new DriveAuto(driveTime1Right, DD1R), 5);
		addSequential(new FullStop(waitTime));
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	while(gameData.length() == 0) {
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
			//waiting for letter
		}
		firstLetter = gameData.charAt(0);
		System.out.println(firstLetter);
		if(firstLetter == 'L') {
		
		}
		if(firstLetter == 'R') {
			addSequential(new SmartShoot(Robot.driveSUB.autoShootPower), 1);
			//Add pivot and launch commands here
		}
    }
}
