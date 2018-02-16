package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Pivot extends Subsystem {
	
	 Potentiometer pivot = RobotMap.pivot;
	 Victor pivotMotor = RobotMap.motor1;
	 double tolerance = 1; //how close to target is acceptable, in degrees
	 int state = 0; //position state of arm
	 double difference; 
	 double proportionDist = 30; 
	 double antiGravHat = -.05;
	 /*         _______
	  *        [__   __]
	  *           | |
	  *           | |
	  *           | |
	  *           | |
	  *           |_|
	  * 
	  */
	 
	 double antiGravScale = 50;
		
	
	public  double getAngle() {
		return pivot.get();
	}
	
	public  int getState() {
		return state;
	}
	public  void setMotor(double speed) {
		pivotMotor.set(speed);
	}
	public boolean changeAngle(double angle, int stateIn) {
		state = stateIn;
		difference = angle - (pivot.get()-30);
		System.out.println("angle;  " + (pivot.get()-30));
		if (difference > tolerance) {
			setMotor(difference/proportionDist);
		} 
		else if (difference < -tolerance) {
			setMotor(difference/proportionDist);
		} else {
			setMotor(0);
			return true;
		}
		return false;
		
		
		
	}
	public void manual(double input) {
		double antiGrav;
		antiGrav = 0;
		if (input < antiGravHat) {
			antiGrav = (-(1/input))/antiGravScale;
		}
		pivotMotor.set((0.5*input)+antiGrav);

	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
