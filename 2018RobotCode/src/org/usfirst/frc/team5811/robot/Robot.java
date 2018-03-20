
package org.usfirst.frc.team5811.robot;

import org.usfirst.frc.team5811.robot.commands.AutoLeft;
import org.usfirst.frc.team5811.robot.commands.AutoLeftSwitchExchange;
import org.usfirst.frc.team5811.robot.commands.AutoRight;
import org.usfirst.frc.team5811.robot.commands.AutoRightSwitchExchange;
import org.usfirst.frc.team5811.robot.commands.CompOn;
import org.usfirst.frc.team5811.robot.commands.GoNoGoTest;
import org.usfirst.frc.team5811.robot.commands.LineCrossAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchLeftAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchLeftAutoExtended;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchRightAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchrightAutoExtended;
import org.usfirst.frc.team5811.robot.subsystems.Arms;
import org.usfirst.frc.team5811.robot.subsystems.Camera;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;
import org.usfirst.frc.team5811.robot.subsystems.NavX;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;
import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Arms arms;
	// hi
	double autoSelecter;

	double autoNumber;

	public static String gameData;

	char firstLetter;
	char secondLetter;

	Command autonomousCommand;
	// Compressor compressor;

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
		arms = new Arms();

		oi = new OI();
		
		RobotMap.ultra.setAutomaticMode(true);
		
		// SmartDashboard.getNumber("Auto Number", 0.0);
		//
		//
		// SmartDashboard.putData("Auto mode", chooser);
		//
		// chooser.addObject("Line Cross Auto", new LineCrossAuto());
		// chooser.addDefault("Center Auto choosing auto", new CenterAutoChooser());
		// chooser.addObject("Go No Go Right", new GoNoGoAutoMasterRight());
		// chooser.addObject("Go No Go Left", new GoNoGoAutoMasterLeft());
		// chooser.addObject("SAFETY AUTO", new SafetyAuto());
		// chooser.addObject("Left Auto DO NOT USE", new AutoLeft());
		// chooser.addObject("Right Auto DO NOT USE", new AutoRight());
		// chooser.addObject("Test Auto DO NOT USE" , new TestAuto());
		// chooser.addObject("Go no go test DO NOT USE", new GoNoGoTest());
		// System.out.print("I'm not slow?");

		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
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

		arms.close();

		// gamedata = null;

		// compressor = new Compressor(0);
		// compressor.setClosedLoopControl(false);

		// chooser.addDefault("Drive Straight", new DriveAuto(100, 100, 100));
		// chooser.addObject("Drive", new DriveAuto(1,1,1));
		// UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

	}

	@Override
	public void disabledInit() {
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// while(gameData == null) {
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// //waiting for letter
		// }

	}


	@Override
	public void disabledPeriodic() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null || gameData == "") {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			// waiting for letter
		}
		//autoNumber = SmartDashboard.getNumber("DB/Slider 0", 0.0);
		// System.out.println("Game data string:" + gameData);
//		Scheduler.getInstance().run();
		autoNumber = SmartDashboard.getNumber("AUTO SELECTION USE THIS ONE: ", 0.0);
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
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
		
		System.out.println("AUTONUMBER: " + autoNumber);
		
		driveSUB.fullReset();
		
//		if (RobotMap.pivot.get() < -200 || RobotMap.pivot.get() > 10) {
//			System.out.println("POTENTIOMETER ERROR CHECK CONNECTION");
//		}
		
		
	}

	@Override
	public void autonomousInit() {
		arms.close();
		navx.reset(); // reseting navx hardware
		driveSUB.fullReset(); // reseting angle storing variables
		driveSUB.motorReset();
		encoders.reset();
		
		
		// autoSelecter = SmartDashboard.getNumber("DB/Slider 0", 0.5);
		// System.out.print(autoSelecter);
		//
		//
		//
		// //chooser.addObject("Test auto routine", new TestAuto());
		//// chooser.addDefault("Test", new TurnAuto(40, 0.7));
		//
		// if(autoSelecter == 0.0 ){
		// autonomousCommand = (Command)new AutoLeft();
		// } else if(autoSelecter == 1.0 ){
		// autonomousCommand = (Command)new AutoRight();
		// }
		// autonomousCommand = chooser.getSelected();
		// if(chooser.getSelected() == (Command)new CenterAutoMaster()){
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// while(gameData.length() == 0) {
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// //waiting for letter
		// }
		// }
		// pick side with while
		// if L
		// run autoRight
		//

//		while (gameData == null || gameData == "") {
//			gameData = DriverStation.getInstance().getGameSpecificMessage();
//		}

		firstLetter = Robot.gameData.charAt(0);
		secondLetter = Robot.gameData.charAt(1);
		if (autoNumber == 0.0) { // Center Auto
			if (firstLetter == 'L') {
				autonomousCommand = new AutoLeft();
			} else if (firstLetter == 'R') {
				autonomousCommand = new AutoRight();
			}
		} else if (autoNumber == 0.5) { // Left Auto
			if (firstLetter == 'L') {
				autonomousCommand = new GoNoGoTest();
			} else if (firstLetter == 'R') {
				autonomousCommand = new LineCrossAuto(); // need
			}

		} else if (autoNumber == 1.0) { // Right Auto
			if (firstLetter == 'R') {
				autonomousCommand = new GoNoGoTest();
			} else if (firstLetter == 'L') {
				autonomousCommand = new LineCrossAuto(); // need
			}

		} else if (autoNumber == 1.5) { // Corner Right
			if (firstLetter == 'R') {
				autonomousCommand = new OutsideSwitchRightAuto();
			} else if (firstLetter == 'L') {
				autonomousCommand = new LineCrossAuto(); // need
			}
		} else if(autoNumber == 2.0) { //corner Left
			if (firstLetter == 'L') {
				autonomousCommand = new OutsideSwitchLeftAuto();
			} else if (firstLetter == 'R') {
				autonomousCommand = new LineCrossAuto(); // need
			}
		}else if (autoNumber == 2.5) { // 2 cube corner right
		
			if (firstLetter == 'R') {
				autonomousCommand = new OutsideSwitchrightAutoExtended();
			} else if (firstLetter == 'L') {
				autonomousCommand = new LineCrossAuto();
			}
		}
		 else if (autoNumber == 3.0) { // 2 cube corner Left
			if (firstLetter == 'L') {
				autonomousCommand = new OutsideSwitchLeftAutoExtended();
			} else if (firstLetter == 'R' ) {
				autonomousCommand = new LineCrossAuto();
			}
		
		}else if(autoNumber == 3.5) {
			if (firstLetter == 'L') {
				autonomousCommand = new AutoLeftSwitchExchange();
			} else if (firstLetter == 'R' ) {
				autonomousCommand = new AutoRightSwitchExchange();
			}
		}
		 
		 else { // Default
			autonomousCommand = new LineCrossAuto();
			System.out.println("line cross");
		}

		// autonomousCommand = chooser.getSelected();
		//
		
		
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}

	}

	@Override
	public void autonomousPeriodic() {
//		Scheduler.getInstance().run();
		Robot.ledsub.autoColor();
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
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
		SmartDashboard.putNumber("AUTO SELECTION USE THIS ONE: ", autoNumber);
		
//		if (pivot.safety()) {
//			new StopPivot();
//			System.out.println("PIVOT DISABLED");
//		}

	}

	@Override
	public void teleopInit() {
		navx.reset(); // reseting navx hardware
		driveSUB.fullReset(); // reseting angle storing variables
		encoders.reset();
		
		arms.close();
		
		driveSUB.motorReset();
		
		// System.out.println("Navx: " + navx.grabValues());
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override 
	public void robotPeriodic() { //Is this for real?
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopPeriodic() {
//		Scheduler.getInstance().run();
		// compressor.setClosedLoopControl(true);
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy2.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		Robot.ledsub.yellow();
		new CompOn();//
		
		System.out.println(RobotMap.ultra.getRangeInches());
		
	//	System.out.println(Robot.driveSUB.returnCX());

		// System.out.println(navx.grabValues());
//		if (pivot.safety()) {
//			new StopPivot();
//			System.out.println("PIVOT DISABLED");
//		}
	}

	@Override
	public void testPeriodic() {
		// LiveWindow.run();
	}
}
