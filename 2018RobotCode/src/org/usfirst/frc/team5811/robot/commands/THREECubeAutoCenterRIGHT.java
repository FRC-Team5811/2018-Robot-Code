package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class THREECubeAutoCenterRIGHT extends CommandGroup {
	int waitTime = 35;
	double driveTime1Right = 27.6; //was 3000 pulses, now inches
	double driveDirection1Right = -0.45;
	double turnAngle1Right = 40;
	double turnDirection1Right = 0.8;
	double DT2Right = 64.4; //was 7000 pulses, now inches
	double DD2Right = -0.45;
	double TA2Right = 40;
	double TD2Right = -0.9;
	double DT3Right = 39.6; //was 3000 pulses, now inches
	double DD3Right = -0.45;
	
	double turn1Angle = 90;
	double turn1Direction = 0.8;
	
	double turnAngle2 = 45;
	double turnDirection2 = -0.8;
	
	double turnAngle3 = 45;
	double turnDirection3 = 0.8;
	
	double turnAngle4 = 45;
	double turnDirection4 = -0.8;

    public THREECubeAutoCenterRIGHT() {
		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);

		addSequential(new FullAutoReset());
		addSequential(new DriveAuto(driveTime1Right, driveDirection1Right));
		System.out.println("First move");
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(turnAngle1Right, turnDirection1Right));
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(DT2Right, DD2Right));
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(TA2Right, TD2Right));
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(DT3Right, DD3Right), 3);
		addSequential(new FullStop(waitTime));
		addSequential(new SmartShoot(), 1);
		
		addSequential(new FullStop(waitTime));
		addSequential(new DriveAuto(12.5, 0.6));
		addSequential(new PosDown());
		addSequential(new TurnAuto(turn1Angle, turn1Direction));
		addSequential(new DriveAuto(20, 0.7),2);
		addParallel(new IntakeInward());
		//addSequential(new VisionCube(), 3);
//		addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle2, turnDirection2));
		addSequential(new SmartShoot(), 1);
//		addSequential(new PosDown());
		addSequential(new TurnAuto(turnAngle3, turnDirection3));
		addSequential(new DriveAuto(5, 0.7),2);
		addParallel(new IntakeInward());
		//addSequential(new VisionCube(), 3);
//		addSequential(new PosStore());
		addSequential(new TurnAuto(turnAngle4, turnDirection4));
		addSequential(new SmartShoot(), 1);
    }
}
