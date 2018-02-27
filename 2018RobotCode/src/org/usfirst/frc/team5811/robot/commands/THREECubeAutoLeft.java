package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class THREECubeAutoLeft extends CommandGroup {

    public THREECubeAutoLeft() {
		int waitTime = 35;
		double driveTime1Right =  100.001; 
		double DD1R = -0.55;
		
		double turn1Angle = 90;
		double turn1Direction = -0.8;
		
		double turnAngle2 = 45;
		double turnDirection2 = 0.8;
		
		double turnAngle3 = 45;
		double turnDirection3 = -0.8;
		
		double turnAngle4 = 45;
		double turnDirection4 = 0.8;
		
		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);

		addSequential(new DriveAuto(driveTime1Right, DD1R), 5);
		addSequential(new FullStop(waitTime));
		addSequential(new SmartShoot(), 1);
		addSequential(new FullStop(waitTime));
		addSequential(new DriveAuto(12.5, 0.6));
		addSequential(new PosDown());
		
		addSequential(new TurnAuto(turn1Angle, turn1Direction));
		addSequential(new DriveAuto(20, 0.7),2);
		addParallel(new IntakeInward(), 1.5);
		//addSequential(new VisionCube(), 3);
		//addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle2, turnDirection2));
		addSequential(new SmartShoot(), 1);
		//addSequential(new PosDown());
		addSequential(new TurnAuto(turnAngle3, turnDirection3));
		addSequential(new DriveAuto(5, 0.7),2);
		addParallel(new IntakeInward(), 1.5);
		//addSequential(new VisionCube(), 3);
		//addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle4, turnDirection4));
		addSequential(new SmartShoot(), 1);
    }
}
