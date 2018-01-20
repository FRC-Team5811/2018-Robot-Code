package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	static Victor leftMotor = RobotMap.motor4;
	static Victor rightMotor = RobotMap.motor5;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
