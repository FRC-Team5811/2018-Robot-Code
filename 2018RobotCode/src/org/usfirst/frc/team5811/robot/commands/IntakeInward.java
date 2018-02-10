package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;
import org.usfirst.frc.team5811.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeInward extends Command {
	public IntakeInward(){

		//requires(Robot.intake);
		setInterruptible(true);
		//this.start();
		
	}
	@Override
	protected void initialize(){

	}
	@Override
	protected void execute(){
		Robot.intake.intakeIn();
	}
	
 	protected void end(){
		Robot.intake.halt();
	}
	
	protected void interrupted(){

		end();
	} 
	
	@Override
	protected boolean isFinished() {
		
		if(Robot.driveSUB.monitorCurrent4() > 30){
			return true;
		}
		if(Robot.driveSUB.monitorCurrent5() > 30){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	

}
