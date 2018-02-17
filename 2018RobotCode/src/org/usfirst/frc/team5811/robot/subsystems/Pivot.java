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
	double antiGravScale = 50;
	
	double downAngle = 0;    //Find based on potentiometer offset
	double downTransitionAngle = 45; 
	double switchAngle = 80;  //Find based on potentiometer offset
	double backAngle = 130;    //Find based on potentiometer offset
	double backTransitionAngle = 120; 
	
	double kpDown = .05; //plan to do increase
	double kpUp= .05; //plan to do increase
	
	double downPosTolerance = 5; 
	double switchPosTolerance = -3;
	double backPosTolerance = -5; 
	
	double switchHoldingPower = 0.6;
	
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
	
	public boolean moveToDown(double currentPos) {
		
		if(currentPos>downTransitionAngle) {
			pivotMotor.set(-kpDown*(currentPos-downTransitionAngle));
		} else {
			pivotMotor.set(kpUp*(currentPos-downTransitionAngle));
		}
		
		return (currentPos < downAngle+downPosTolerance);
		
	}
	
	public boolean moveToBack(double currentPos) {
		
		if(currentPos<backTransitionAngle) {
			pivotMotor.set(kpUp*(currentPos-backAngle));
		} else {
			pivotMotor.set(kpDown*(currentPos-backAngle));
		}
		
		return (currentPos < backAngle+backPosTolerance);
		
	}
	
	public boolean moveToSwitch(double currentPos) {
		
		if(currentPos<switchAngle+switchPosTolerance) {
			pivotMotor.set(switchHoldingPower+kpUp*(currentPos-switchAngle));
		} else if(currentPos>switchAngle-switchPosTolerance){
			pivotMotor.set(kpDown*(currentPos-switchAngle));
		} else {
			pivotMotor.set(switchHoldingPower);
		}
		
		return (currentPos < downAngle+downPosTolerance);
		
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
