package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Pivot extends Subsystem {
	
	static Potentiometer pivot = RobotMap.pivot;
	static Victor motor6 = RobotMap.motor6;
	static Victor motor7 = RobotMap.motor7;
	static double tolerance = 1; //how close to target is acceptable, in degrees
	static int state = 0; //position state of arm
	static double difference; 
	
	public static double getAngle() {
		return pivot.get();
	}
	
	public static int getState() {
		return state;
	}
	
	public static void changeAngle(double angle, int stateIn) {
		state = stateIn;
		difference = angle - pivot.get();
		
		if (difference > 0) {
			
		}
		
		
		
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
