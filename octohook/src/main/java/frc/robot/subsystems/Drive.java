// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class Drive extends SubsystemBase {


  public final TalonSRX motorFrontRight = new TalonSRX(1);
    public final TalonSRX motorBackRight = new TalonSRX(2);
    public final TalonSRX motorFrontLeft = new TalonSRX(3);
    public final TalonSRX motorBackLeft = new TalonSRX(4);
  /** Creates a new ExampleSubsystem. */
  public Drive() {
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
