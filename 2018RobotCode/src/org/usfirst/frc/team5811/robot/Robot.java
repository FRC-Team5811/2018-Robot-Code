
package org.usfirst.frc.team5811.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5811.robot.commands.AutoDriveAcc;
import org.usfirst.frc.team5811.robot.commands.AutoLeft;
import org.usfirst.frc.team5811.robot.commands.AutoRight;
import org.usfirst.frc.team5811.robot.commands.CenterAutoMaster;
import org.usfirst.frc.team5811.robot.commands.CompOn;
import org.usfirst.frc.team5811.robot.commands.TestAuto;
import org.usfirst.frc.team5811.robot.commands.TurnAuto;
import org.usfirst.frc.team5811.robot.commands.DriveAuto;
import org.usfirst.frc.team5811.robot.commands.GoNoGoAutoMasterLeft;
import org.usfirst.frc.team5811.robot.commands.GoNoGoAutoMasterRight;
import org.usfirst.frc.team5811.robot.commands.GoNoGoTest;
import org.usfirst.frc.team5811.robot.commands.HaltIntake;
import org.usfirst.frc.team5811.robot.commands.IntakeInward;
import org.usfirst.frc.team5811.robot.commands.RampExtend;
import org.usfirst.frc.team5811.robot.commands.SafetyAuto;
import org.usfirst.frc.team5811.robot.commands.SmartShoot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;
import org.usfirst.frc.team5811.robot.subsystems.NavX;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;
import org.usfirst.frc.team5811.robot.subsystems.Ramp;
import org.usfirst.frc.team5811.robot.subsystems.Camera;
import com.kauailabs.navx.frc.AHRS;


public class Robot extends IterativeRobot {

	public static DriveTrain driveSUB;
	public static LEDS ledsub;
	public static NavX navx;
	public static Encoders encoders;
	public static Intake intake;
	public static Pivot pivot;
	public static Ramp ramp;
	public static OI oi;
	public static Camera camera;
	//hi
	double autoSelecter;
	String gameData;
	char firstLetter;

	
	
	String gamedata;
	
	char readData;

	Command autonomousCommand;
	//Compressor compressor;
	
	SendableChooser<Command> chooser = new SendableChooser<>();


	@Override
	public void robotInit() {
	
		driveSUB = new DriveTrain();
		ledsub = new LEDS();
		navx = new NavX();
		encoders = new Encoders();
		intake = new Intake();
		pivot = new Pivot();
		ramp = new Ramp();
		camera = new Camera();
		oi = new OI();

		
		SmartDashboard.putData("Auto mode", chooser);
		chooser.addObject("Center Auto choosing auto", new CenterAutoMaster());
		chooser.addDefault("Left Auto DO NOT USE", new AutoLeft());
		chooser.addObject("Right Auto DO NOT USE", new AutoRight());
		chooser.addObject("Test Auto DO NOT USE" , new TestAuto());
		chooser.addObject("Go No Go Right", new GoNoGoAutoMasterRight());
		chooser.addObject("Go No Go Left", new GoNoGoAutoMasterLeft());
		chooser.addObject("SAFETY AUTO", new SafetyAuto());
		chooser.addObject("Go no go test", new GoNoGoTest());
		
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal());
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal());
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy1.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		
	
		intake.armsClose();
//		
		
		//gamedata = null;
		
		//compressor = new Compressor(0);
		//compressor.setClosedLoopControl(false);
	
//		chooser.addDefault("Drive Straight", new DriveAuto(100, 100, 100)); 
		//chooser.addObject("Drive", new DriveAuto(1,1,1));
		//UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		intake.armsClose();
		navx.reset(); //reseting navx hardware
		driveSUB.fullReset(); //reseting  angle storing variables
		encoders.reset();
		
//		autoSelecter = SmartDashboard.getNumber("DB/Slider 0", 0.5);
//		System.out.print(autoSelecter);
//
//		
//		
//		//chooser.addObject("Test auto routine", new TestAuto());
////		chooser.addDefault("Test", new TurnAuto(40, 0.7));
//		
//		if(autoSelecter == 0.0 ){
//			autonomousCommand = (Command)new AutoLeft();
//		} else if(autoSelecter == 1.0 ){
//			autonomousCommand = (Command)new AutoRight();
//		}
		autonomousCommand = chooser.getSelected();
		if(chooser.getSelected() == (Command)new CenterAutoMaster()){
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			while(gameData.length() == 0) {
				gameData = DriverStation.getInstance().getGameSpecificMessage();
				//waiting for letter
			}
		}
				pick side with while 
					if L
						run autoRight
					
		
		
		if (autonomousCommand != null){
			autonomousCommand.start();
		}
		
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal());
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal());
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy1.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());

	}

	@Override
	public void teleopInit() {
		
		intake.armsClose();

		//System.out.println("Navx: " + navx.grabValues());
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//compressor.setClosedLoopControl(true);
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal());
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal());
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy2.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", -Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		
		new CompOn();//
		
		
		

		//System.out.println(navx.grabValues());
		
		
		

	}


	@Override
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
