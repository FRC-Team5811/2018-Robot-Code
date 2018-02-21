package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OutsideSwitchLeftAutoExtended extends CommandGroup {

    public OutsideSwitchLeftAutoExtended() {
    	int waitTime = 35;
    	double driveTime1Right = 10000;
    	double DD1R = -0.6;
    	double TA1 = 90;
    	double TD1 = -0.9;
    	double TA2 = 90;
    	double TD2 = 0.9;
     	double DTR2 = 5000;
    	double DDR2 = -0.6;
       
        requires(Robot.driveSUB);
        requires(Robot.navx);
        requires(Robot.encoders);
        
        addSequential(new DriveAuto(driveTime1Right, DD1R), 7);
    	addSequential(new FullStop(waitTime));
    	
    	addSequential(new TurnAuto(TA1, TD1), 3);
    	addSequential(new FullStop(waitTime));
    	
    	addSequential(new SmartShoot(Robot.driveSUB.autoShootPower), 1);
    	addSequential(new FullStop(waitTime));
    	
    	addSequential(new TurnAuto(TA2, TD2), 3);
    	addSequential(new FullStop(waitTime));
    	
        addSequential(new DriveAuto(DTR2, DDR2), 7);
       	addSequential(new FullStop(waitTime));
    }
}
