package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Pivot extends Subsystem {
	
	 Potentiometer pivot = RobotMap.pivot;
	 Victor motor6 = RobotMap.motor6;
	 Victor motor7 = RobotMap.motor7;
	 double tolerance = 1; //how close to target is acceptable, in degrees
	 int state = 0; //position state of arm
	 double difference; 
	 double proportionDist = 30; 
	
	public  double getAngle() {
		return pivot.get();
	}
	
	public  int getState() {
		return state;
	}
	public  void setMotor(double speed) {
		motor6.set(speed);
		motor7.set(speed);
	}
	public boolean changeAngle(double angle, int stateIn) {
		state = stateIn;
		difference = angle - pivot.get();
		
		if (difference > tolerance) {
			setMotor(difference/proportionDist);
		} 
		else if (difference < -tolerance) {
			setMotor(difference/proportionDist);
		} else {
			return true;
		}
		return false;
		
		
		
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
