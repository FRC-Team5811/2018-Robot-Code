package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class JustDriveStraightAuto extends CommandGroup {
 	String gameData;
	char firstLetter;
	int waitTime = 35;
	double driveTime1Right = 10000;
	double DD1R = 0.7;
    public JustDriveStraightAuto() {
    	requires(Robot.driveSUB);
    	requires(Robot.navx);
    	requires(Robot.encoders);
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
		firstLetter = gameData.charAt(0);
		System.out.println(firstLetter);
		if(firstLetter == 'L' || firstLetter == 'R') {
			addSequential(new DriveAuto(driveTime1Right, DD1R));
			addSequential(new FullStop(waitTime));
		}
    }
}
