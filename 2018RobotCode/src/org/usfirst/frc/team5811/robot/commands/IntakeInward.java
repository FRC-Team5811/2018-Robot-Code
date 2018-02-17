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
		
		Robot.intake.cyclesOn++;
		
		if(Robot.intake.cyclesOn > Intake.intSpikeWait && Robot.driveSUB.monitorCurrent4() > Intake.currentThreshold){  //Would be nice to make PDP its own subsystem
			Robot.intake.leftOff = true;  
			System.out.println("current spike left" + Robot.driveSUB.monitorCurrent4());
			Robot.intake.haltLeft();
		}else if(!Robot.intake.leftOff){
			Robot.intake.intakeLeftIn();
		}
		if (Robot.intake.cyclesOn > Intake.intSpikeWait && Robot.driveSUB.monitorCurrent5() > Intake.currentThreshold){
			Robot.intake.rightOff = true; 
			System.out.println("current spike right" + Robot.driveSUB.monitorCurrent5());
			Robot.intake.haltRight();
		}else if(!Robot.intake.rightOff){
			Robot.intake.intakeRightIn();
		}
		
		//Alternate version waits for both to have too high a current and then shut off both sides together
		
	}
	
 	protected void end(){
		Robot.intake.haltLeft();
		Robot.intake.haltRight();
		Robot.intake.cyclesOn = 0;
	}
	
	protected void interrupted(){
		end();
	} 
	
	@Override
	protected boolean isFinished() {
		
		if(Robot.intake.leftOff && Robot.intake.rightOff){
			Robot.intake.leftOff = false; //reset variables
			Robot.intake.rightOff = false;
			end(); //not so sure, but think this is correct
			return true; 
		}else{
			return false; 
		}
	
	}
	
}
