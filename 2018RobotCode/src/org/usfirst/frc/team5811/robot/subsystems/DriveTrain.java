package org.usfirst.frc.team5811.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	  Victor motor0 = RobotMap.motor0;
	  Victor motor1 = RobotMap.motor1;
	  Victor motor2 = RobotMap.motor2;
	  Victor motor3 = RobotMap.motor3;
	
	  //PowerDistributionPanel pdp = RobotMap.PDP;
	
	  //NavX navX = Robot.navx;
	
	  float rotationPos = 0;
	
	
	  double kp = 20; //first year programmer is using correct variables instead of "magic numbers"
	  double previousAngle;
	  double kd = 0;
	  double dTerm, pTerm;
	  public double currentAngle;
	  
	  public void navXReset(){   //reseting angle storing variables
		  previousAngle = 0;
		  currentAngle = 0;
	  }
	  
	public void initDefaultCommand() {
		
	}

	public void arcadeDrive(double turn, double throttle) {
		motor0.set(-(throttle - turn));
		motor1.set(-(throttle - turn));
		motor2.set(throttle + turn);
		motor3.set(throttle + turn);
		
		//////System.out.println(pdp.getCurrent(0)+ "   "+pdp.getCurrent(1)+ "   "+pdp.getCurrent(2)+ "   "+pdp.getCurrent(3));
		
		
	}
	public void setCurrentAngle() {
		previousAngle = currentAngle; //setting previous angle
		currentAngle = Robot.navx.grabValues(); //getting current angle
		//System.out.println("SET CURRENT ANGLE: " + currentAngle);
		////System.out.println("desired angle: " + currentAngle);
	}
	
	public double errorCorrect(double desiredAng) {
		double error = Robot.navx.grabValues() - desiredAng;
		System.out.print(Math.abs(error) + "\t      ");
		pTerm = error/kp;
		dTerm = kd*(previousAngle - currentAngle);
		//System.out.println("motor delta: " + motorDelta);
		return pTerm+dTerm;
		
	   
	}
	
	public void autoDriveAcc(double durationAccel, double i,double direction) {
		double motorCorrect = errorCorrect(currentAngle);
		
		//System.out.println("Motor sped: "+((direction*(i/(durationAccel)+0.2)*0.5f) - motorCorrect));
		System.out.println(((direction*(i/(durationAccel)+0.3)) - motorCorrect) +"\t    " +((direction*(i/(durationAccel)+0.3)) - motorCorrect)+
				"\t" + ((-direction*(i/(durationAccel)+0.3)) - motorCorrect)+"\t     " + ((-direction*(i/(durationAccel)+0.3)) - motorCorrect));
		motor0.set((direction*(i/(durationAccel)+0.3)) - motorCorrect);
		motor1.set((direction*(i/(durationAccel)+0.3)) - motorCorrect);
		motor2.set((-direction*(i/(durationAccel)+0.3)) - motorCorrect);
		motor3.set((-direction*(i/(durationAccel)+0.3)) - motorCorrect);
		
	}
	public void autoDriveDec(double durationDecel, double i, double direction){
		double motorCorrect = errorCorrect(currentAngle);
		//kp -= .1;
		System.out.println((direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect) +"\t    " +(direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect)+
				"\t" + (-direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect)+"\t    " + (-direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect));
		//System.out.println("Motor sped: "+(direction*(1-(i/(durationDecel*0.5))*0.5f)-motorCorrect));
		motor0.set(direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect );
		motor1.set(direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect );
		motor2.set(-direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect);
		motor3.set(-direction*(1-(i/(durationDecel)+0.2)*0.5f) - motorCorrect);
	}
	public void autoDriveFlat(double direction){
		//kp += .1;
		double motorCorrect = errorCorrect(currentAngle);
		System.out.println(((direction*1) - motorCorrect) +"\t     " +((direction*1) - motorCorrect)+
				"\t" + ((direction*-1) - motorCorrect)+"\t      " + ((direction*-1) - motorCorrect));
		//System.out.println("Motor sped: "+((direction*1)-motorCorrect));
		motor0.set((direction*1) - motorCorrect);
		motor1.set((direction*1) - motorCorrect);
		motor2.set((direction*-1) - motorCorrect);
		motor3.set((direction*-1) - motorCorrect);
	}
	public void fullStop() {
		////System.out.println(0);
		motor0.set(0);
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		
	}
	public void autoTurnAcc(double finalAngle, double currentAngle, double direction) {
		
		////System.out.println(direction*(currentAngle/finalAngle + 0.2));
//		motor0.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor1.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor2.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor3.set(direction*(i/(durationAccel*0.5))*0.5f);
		motor0.set(direction*(currentAngle/finalAngle + 0.3)* 0.5);
		motor1.set(direction*(currentAngle/finalAngle + 0.3)* 0.5);
		motor2.set(direction*(currentAngle/finalAngle + 0.3)* 0.5);
		motor3.set(direction*(currentAngle/finalAngle + 0.3)* 0.5);

	
		
	}
	public void autoTurnDec(double finalAngle, double currentAngle, double direction){
		////System.out.println(direction*(1-(currentAngle/finalAngle + 0.2)));
//		motor0.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor1.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor2.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor3.set(direction*(i/(durationDecel*0.5))*0.5f);
		motor0.set(direction*(1-(currentAngle/finalAngle)+0.2) * 0.4);
		motor1.set(direction*(1-(currentAngle/finalAngle)+0.2)* 0.4);
		motor2.set(direction*(1-(currentAngle/finalAngle)+0.2)* 0.4);
		motor3.set(direction*(1-(currentAngle/finalAngle)+0.2)* 0.4);
	}
	public void autoTurnFlat(double direction){
		//direction = 0.2;
		////System.out.println(direction*1);
		motor0.set(direction*1);
		motor1.set(direction*1);
		motor2.set(direction*1);
		motor3.set(direction*1);
	}
	
}
