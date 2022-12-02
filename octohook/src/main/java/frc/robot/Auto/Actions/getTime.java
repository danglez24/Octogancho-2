package frc.robot.Auto.Actions;

import edu.wpi.first.wpilibj.Timer;

public class getTime{
  double absoluteTimer;
  double relativeTimer;

  public void startInitTimer(){
    absoluteTimer = Timer.getFPGATimestamp();
  }
  public void startRelativeTimer (){
    relativeTimer = Timer.getFPGATimestamp();
  }
  public double getInitTimer(){
    return absoluteTimer;
  }
  public double getRelativeTimer(){
    return relativeTimer;
  }
}