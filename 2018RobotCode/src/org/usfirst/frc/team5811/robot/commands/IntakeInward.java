package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;
import org.usfirst.frc.team5811.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeInward extends Command {
	int cyclesOn, cyclesSpike;
	double currentLeft, currentRight;
	boolean intakeOff;

	public IntakeInward(){
		requires(Robot.intake);
		setInterruptible(true);
		
	}
	@Override
	protected void initialize(){
		cyclesOn = 0;
		cyclesSpike = 0;
		intakeOff = false;
		Robot.intake.intakeLeftIn();
		Robot.intake.intakeRightIn();
	}
	
	@Override
	protected void execute(){
		currentLeft = Robot.driveSUB.monitorCurrentIntakeLeft();
		currentRight = Robot.driveSUB.monitorCurrentIntakeRight();
		
		Robot.ledsub.colorInward();
		System.out.println("cycles " + cyclesOn);
		cyclesOn++;
		
		if (cyclesOn > Intake.intSpikeWait) {
			if (currentLeft > Intake.currentThreshold || currentRight > Intake.currentThreshold) {
				cyclesSpike++;
				if (cyclesSpike > Intake.timeout) {
					Robot.intake.haltLeft();
					Robot.intake.haltRight();
					intakeOff = true;
				}
			} else if (!intakeOff) {
				Robot.intake.intakeLeftIn();
				Robot.intake.intakeRightIn();
			}
		}
	}
	
 	protected void end(){
		Robot.ledsub.off();
		Robot.intake.haltLeft();
		Robot.intake.haltRight();
	}
	
	protected void interrupted(){
		Robot.ledsub.flash();
		end();
	} 
	
	@Override
	protected boolean isFinished() {
		return intakeOff;
	}
	
}
