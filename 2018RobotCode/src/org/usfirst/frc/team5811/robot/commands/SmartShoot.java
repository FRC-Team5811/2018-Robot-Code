package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class SmartShoot extends Command {
	int state;
	double power;
	 
	//Intake intake = Robot.intake;
	//Pivot pivot = Robot.pivot;
	public SmartShoot(double power){
		setInterruptible(true);
	//	requires(Robot.intake);
		//this.start();
		this.power = power;
	}
	protected void initialize(){
		 state = Robot.pivot.getState();
	}
	protected void execute(){
		Robot.intake.outtake(this.power);
	}
	protected void end(){
		Robot.intake.haltLeft();
		Robot.intake.haltRight();
		Command endCommand = new PosDown();
		endCommand.start();
	}
	protected void interrupted(){
		end();
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
