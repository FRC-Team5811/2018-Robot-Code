package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class THREECubeAutoCenterLEFT extends CommandGroup {
	int waitTime = 35;
	double driveTime1Left = 27.6; //was 3000 pulses, now inches
	double driveDirection1Left = -0.45;
	double turnAngle1Left = 45;
	double turnDirection1Left = -0.9;
	double DT2Left = 69; //was 7500 pulses, now inches
	double DD2Left = -0.45;
	double TA2Left = 40;
	double TD2Left = 0.9;
	double DT3Left = 39.6; //was 3000 pulses, now inches
	double DD3Left = -0.45;
	
	double turn1Angle = 90;
	double turn1Direction = -0.8;
	
	double turnAngle2 = 45;
	double turnDirection2 = 0.8;
	
	double turnAngle3 = 45;
	double turnDirection3 = -0.8;
	
	double turnAngle4 = 45;
	double turnDirection4 = 0.8;

    public THREECubeAutoCenterLEFT() {
		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);

		addSequential(new FullAutoReset());
		addSequential(new DriveAuto(driveTime1Left, driveDirection1Left));
		System.out.println("First move");
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(turnAngle1Left, turnDirection1Left));
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(DT2Left, DD2Left));
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(TA2Left, TD2Left));
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(DT3Left, DD3Left), 3);
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
