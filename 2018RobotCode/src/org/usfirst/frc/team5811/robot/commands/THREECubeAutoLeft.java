package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class THREECubeAutoLeft extends CommandGroup {

    public THREECubeAutoLeft() {
		int waitTime = 35;
		double driveTime1Right =  78.233; //originally 8500 pulses converted to 78.233
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
		addSequential(new PosDown());
		addSequential(new TurnAuto(turn1Angle, turn1Direction));
		addSequential(new VisionCube(), 3);
		addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle2, turnDirection2));
		addSequential(new SmartShoot(), 1);
		addSequential(new PosDown());
		addSequential(new TurnAuto(turnAngle3, turnDirection3));
		addSequential(new VisionCube(), 3);
		addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle4, turnDirection4));
		addSequential(new SmartShoot(), 1);
    }
}
