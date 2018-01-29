package org.usfirst.frc.team5811.robot;

import org.usfirst.frc.team5811.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5811.robot.commands.GrabNavX;
import org.usfirst.frc.team5811.robot.commands.HaltIntake;
import org.usfirst.frc.team5811.robot.commands.IntakeInward;
import org.usfirst.frc.team5811.robot.commands.PosDown;
import org.usfirst.frc.team5811.robot.commands.ledOFF;
import org.usfirst.frc.team5811.robot.commands.SmartShoot;
import org.usfirst.frc.team5811.robot.commands.ledCOLOR;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	static Joystick joy1 = new Joystick(0);
	JoystickButton a = new JoystickButton(joy1, 2);
	JoystickButton b = new JoystickButton(joy1, 3);
	AxisButton leftJoyY = new AxisButton(joy1, 1);
	AxisButton leftJoyX = new AxisButton(joy1, 0);
	AxisButton rightJoyY = new AxisButton(joy1, 3);
	AxisButton rightJoyX = new AxisButton(joy1, 2);
	AxisButton righttrigger = new AxisButton(joy1,4);
	
	static Joystick joy2 = new Joystick(1);
	JoystickButton aManip = new JoystickButton(joy2, 2);
	JoystickButton bManip = new JoystickButton(joy2, 3);
	JoystickButton yManip = new JoystickButton(joy2, 4);
	JoystickButton xManip = new JoystickButton(joy2, 1);
	
	
	public OI() {
	
		
	//	righttrigger.whileHeld(new GrabNavX());
		leftJoyY.whileHeld(new ArcadeDrive());
		rightJoyX.whileHeld(new ArcadeDrive());
		leftJoyX.whileHeld(new ArcadeDrive());
		rightJoyY.whileHeld(new ArcadeDrive());
		a.whileHeld(new ledCOLOR());
		b.whileHeld(new ledOFF());
		//b.whenPressed(new GrabNavX());
		
		//yManip.whileHeld(new SmartShoot());
		//aManip.whenPressed(new IntakeInward());
		//aManip.whenPressed(new PosDown());
		if(aManip.get()){
			new IntakeInward();
		}else if(yManip.get()){
			new SmartShoot();	
		}else{
			new HaltIntake();
		}
		
		
		
		//bManip.whenPressed(new HaltIntake());
		
	}
	
	public static double getLeftY() {
		return joy1.getRawAxis(1);
	}
	public static double getRightY() {
		return joy1.getRawAxis(3);
	}
	public static double getLeftX(){
		return joy1.getRawAxis(0);
	}
	public static double getRightX(){
		return joy1.getRawAxis(2);
	}
}
