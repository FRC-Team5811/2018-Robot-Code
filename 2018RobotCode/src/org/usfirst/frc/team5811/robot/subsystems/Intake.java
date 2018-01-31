package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	 Victor leftMotor = RobotMap.motor4;
	 Victor rightMotor = RobotMap.motor5;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void intakeIn(){
		leftMotor.set(1);
		rightMotor.set(1);
	}
	public void halt(){
		leftMotor.set(0);
		rightMotor.set(0);
	}
	public void outtake(int position){
		position = 1;
		switch(position){
			case 0: //switch
 				leftMotor.set(0.75);
				rightMotor.set(0.75);
			case 1: //backswitch
				leftMotor.set(1);
				rightMotor.set(1);
			case 2: //Exchange
				leftMotor.set(0.5);
				rightMotor.set(0.5);
		
		}
	}
	
}
