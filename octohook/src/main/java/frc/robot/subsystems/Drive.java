// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

import java.util.FormatFlagsConversionMismatchException;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class Drive extends SubsystemBase {

    //Motores
    public TalonSRX motorFrontRight = new TalonSRX(FRconstant);
    public TalonSRX motorBackRight = new TalonSRX(BRconstant);
    public TalonSRX motorFrontLeft = new TalonSRX(FLconstant);
    public TalonSRX motorBackLeft = new TalonSRX(BLconstant);
  
    public TalonSRX motortest = new TalonSRX(0);


  /** Creates a new ExampleSubsystem. */
  public Drive() {
  }

  public void mDrive(){
    double motores = (control1.getRawAxis(1));
    double turn = (control1.getRawAxis(4));
    
    
    

    motorFR = speedRamp(motorFR, motores);
    motorBR = speedRamp(motorFR, motores);
    motorFL = speedRamp(motorFL, motores);
    motorBL = speedRamp(motorBL, motores);

    finalFR = (motorFR - turn);
    finalBR = (motorBR - turn);
    finalFL = (-motorFL + turn);
    finalBL = (-motorBL + turn);
    


    motorFrontRight.set(ControlMode.PercentOutput, finalFR);
    motorBackRight.set(ControlMode.PercentOutput, finalBR);
    motorFrontLeft.set(ControlMode.PercentOutput, finalFL);
    motorBackLeft.set(ControlMode.PercentOutput,  finalBL);
    motortest.set(ControlMode.PercentOutput, 0);

    ePiston = control1.getRawButton(3);

    compressor1.enableDigital();
    piston1.set(ePiston);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
