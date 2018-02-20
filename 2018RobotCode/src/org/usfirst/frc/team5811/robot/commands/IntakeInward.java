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
	Command command;

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
				
			} else if (!intakeOff) {
				Robot.intake.intakeLeftIn();
				Robot.intake.intakeRightIn();
			}
			if (cyclesSpike > Intake.timeout) {
				Robot.intake.haltLeft();
				Robot.intake.haltRight();
				//command = new PosExchange(); //not working yet
				//command.start();
				intakeOff = true;
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
