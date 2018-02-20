package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OutsideSwitchLeftAuto extends CommandGroup {

    public OutsideSwitchLeftAuto() {
    	int waitTime = 35;
    	double driveTime1Right = 10000;
    	double DD1R = -0.6;
       
        requires(Robot.driveSUB);
        requires(Robot.navx);
        requires(Robot.encoders);
        
        addSequential(new DriveAuto(driveTime1Right, DD1R), 5);
    	addSequential(new FullStop(waitTime));
    	
    	
    	
    }
}
