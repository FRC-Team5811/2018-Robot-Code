package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;

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
		currentLeft = Robot.driveSUB.monitorCurrentIntakeLeft();   //update current readings for intake motors
		currentRight = Robot.driveSUB.monitorCurrentIntakeRight();
		
		Robot.ledsub.colorInward();   //LEDs rainbow while intaking
		System.out.println("cycles " + cyclesOn); 
		cyclesOn++; //increment the cycles that the intake has been running
		
		if (cyclesOn > Intake.intSpikeWait) { //if the intake has been on long enough to avoid the initial spike
			if (currentLeft > Intake.currentThreshold || currentRight > Intake.currentThreshold) { //if one of the motors is drawing too much current
				cyclesSpike++; 
			} else if (!intakeOff) {
				Robot.intake.intakeLeftIn();
				Robot.intake.intakeRightIn();
			}
			if (cyclesSpike > Intake.timeout) { 
				Robot.intake.haltLeft();
				Robot.intake.haltRight();
				//command = new PosExchange();   //not working yet too annoying when we didn't have a cube and the intake raised itself up too high. 
				//command.start();               //A sensor to detect possession of a cube could solve this
				Robot.ledsub.flash();
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
