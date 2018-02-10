package org.usfirst.frc.team5811.robot;

import org.usfirst.frc.team5811.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5811.robot.commands.ArcadeSpeedMod;
import org.usfirst.frc.team5811.robot.commands.GrabNavX;
import org.usfirst.frc.team5811.robot.commands.HaltIntake;
import org.usfirst.frc.team5811.robot.commands.IntakeInward;
import org.usfirst.frc.team5811.robot.commands.PosDown;
import org.usfirst.frc.team5811.robot.commands.PosExchange;
import org.usfirst.frc.team5811.robot.commands.PosSwitchReverse;
import org.usfirst.frc.team5811.robot.commands.RampExtend;
import org.usfirst.frc.team5811.robot.commands.ledOFF;
import org.usfirst.frc.team5811.robot.commands.SmartShoot;
import org.usfirst.frc.team5811.robot.commands.ledCOLOR;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	public Joystick joy1 = new Joystick(0);
	JoystickButton a = new JoystickButton(joy1, 2);
	JoystickButton b = new JoystickButton(joy1, 3);
	AxisButton leftJoyY = new AxisButton(joy1, 1);
	AxisButton leftJoyX = new AxisButton(joy1, 0);
	AxisButton rightJoyY = new AxisButton(joy1, 3);
	AxisButton rightJoyX = new AxisButton(joy1, 2);
	AxisButton righttrigger = new AxisButton(joy1,4);
//	
//	Joystick joy2 = new Joystick(1);
//	JoystickButton aManip = new JoystickButton(joy2, 2);
//	JoystickButton bManip = new JoystickButton(joy2, 3);
//	JoystickButton yManip = new JoystickButton(joy2, 4);
//	JoystickButton xManip = new JoystickButton(joy2, 1);
//	ComboButton RLbumpers = new ComboButton(joy2, 5, 6);
	
	static Joystick joy2 = new Joystick(1);
	static JoystickButton aManip = new JoystickButton(joy2, 2);
	static JoystickButton bManip = new JoystickButton(joy2, 3);
	static JoystickButton yManip = new JoystickButton(joy2, 4);
	JoystickButton xManip = new JoystickButton(joy2, 1);
	static ComboButton RLbumpers = new ComboButton(joy2, 5, 6);
	

	
	public OI() {
	
		
	//	righttrigger.whileHeld(new GrabNavX());
		leftJoyY.whileHeld(new ArcadeDrive());
		rightJoyX.whileHeld(new ArcadeDrive());
		leftJoyX.whileHeld(new ArcadeDrive());
		rightJoyY.whileHeld(new ArcadeDrive());
		a.whileHeld(new ledCOLOR());
		b.toggleWhenPressed(new ArcadeSpeedMod());
		

		
		//b.whenPressed(new GrabNavX());
//		
//		
//		aManip.whenPressed(new IntakeInward());
//		bManip.whenPressed(new HaltIntake());
//		yManip.whileHeld(new SmartShoot());
//		RLbumpers.whenPressed(new RampExtend());
	
		
		
		yManip.whileHeld(new SmartShoot());
		RLbumpers.whenPressed(new RampExtend());
		aManip.toggleWhenPressed(new IntakeInward());
		
		
		
			
		//bManip.whenPressed(new HaltIntake());
		
	}
	
	public double getLeftY() {
		return joy1.getRawAxis(1);
	}
	public double getRightY() {
		return joy1.getRawAxis(3);
	}
	public double getLeftX(){
		return joy1.getRawAxis(0);
	}
	public double getRightX(){
		return joy1.getRawAxis(2);
	}


	
}
