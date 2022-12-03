// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ballIntake;
import frc.robot.subsystems.boxIntake;
import frc.robot.Auto.Actions.getTime;
import frc.robot.Auto.Actions.Stop;
import frc.robot.Auto.Actions.Left;
import frc.robot.Auto.Actions.Right;
import frc.robot.Auto.Actions.Forward;
import frc.robot.Auto.Actions.ActBallIntake;
import frc.robot.Auto.Actions.ActBoxIntake;
import frc.robot.Auto.Actions.Backward;
import frc.robot.Auto.Actions.DisBallIntake;
import frc.robot.Auto.Actions.DisBoxIntake;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  //Imports
  Drive Movement = new Drive();
  ballIntake ballIntake = new ballIntake();
  boxIntake boxIntake = new boxIntake();

  //Acciones del autónomo

  getTime AutoTimer = new getTime();
  Stop stopAction = new Stop();
  Forward moveFor = new Forward();
  Backward moveBack = new Backward();
  Right turnRight = new Right();
  Left turnLeft = new Left();
  ActBallIntake ballOn = new ActBallIntake();
  DisBallIntake ballOff = new DisBallIntake();
  ActBoxIntake boxOn = new ActBoxIntake();
  DisBoxIntake boxOff = new DisBoxIntake();

 

  //NeumÃ¡tica
  Compressor compressor1 = new Compressor(0,PneumaticsModuleType.CTREPCM); //creas el objeto compresor para poder usarlo
  public final Solenoid piston1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0); //declaracion del piston
  
  //Variables
  
  boolean ePiston = false;
  double speed = 0;
  double getTurn = 0;
  
  

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    compressor1.enableDigital();

  }
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    
    AutoTimer.getInitTimer();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    /*AutoTimer.getRelativeTimer();

    double difTime = AutoTimer.getInitTimer()-AutoTimer.getRelativeTimer();

    if (difTime < 0.5){
      moveFor.moveForwardAction();
    }
    else if(difTime > 0.6 && difTime < 1.1){
      moveBack.moveBackwardAction();
    }
    else if(difTime > 1.2 && difTime < 1.5){
      turnRight.moveRightAction();
    }
    else if(difTime > 1.6 && difTime < 2.1){
      moveBack.moveBackwardAction();
    }
    else{
      stopAction.stopAction();
    }
*/
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {


    double speed = (Constants.control1.getRawAxis(1));
    double getTurn = (Constants.control1.getRawAxis(4));

    Movement.mDrive(speed, getTurn);


    boolean ButtonY = Constants.control1.getRawButton(4);

    ballIntake.mballIntake(ButtonY);

    
    boolean ButtonA = Constants.control1.getRawButton(1);

    boxIntake.mBoxIntake(ButtonA);

    
    ePiston = Constants.control1.getRawButton(3);

    compressor1.enableDigital();
    piston1.set(ePiston);  

  

}

//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


public void variableOutput(){

  
}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
