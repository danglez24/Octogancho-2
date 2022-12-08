package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.getTime;
import frc.robot.Auto.Actions.Forward;
import frc.robot.Auto.Actions.Backward;
import frc.robot.Auto.Actions.Right;
import frc.robot.Auto.Actions.Left;
import frc.robot.Auto.Actions.Stop;
import frc.robot.Auto.Actions.ActBallIntake;
import frc.robot.Auto.Actions.DisBallIntake;
import frc.robot.Auto.Actions.ActBoxIntake;
import frc.robot.Auto.Actions.DisBoxIntake;

public class autoTest {
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
    //getTime AutoTime = new getTime();
    //double difTime = AutoTime.getInitTimer() - AutoTime.getRelativeTimer();
  

    public void finalTestAction(double difTime){
        //getTime AutoTime = new getTime();
        //double difTimer = AutoTime.getInitTimer() - AutoTime.getRelativeTimer();
        if (difTime < 1){
            moveFor.moveForwardAction();
          }
          else if(difTime > 1.4 && difTime < 2){
            moveBack.moveBackwardAction();
          }
          else if(difTime > 2.5 && difTime < 3){
            turnRight.moveRightAction();
          }
          else if(difTime > 3.3 && difTime < 3.7){
            turnLeft.moveLeftAction();
          }
          else if(difTime > 3.8 && difTime < 4.3){
            ballOn.ballIntakeActivate();
          }
          else if(difTime > 4.4 && difTime < 4.7){
            ballOff.ballIntakeDisable();
          }
          else if(difTime > 4.8 && difTime < 5.3){
            boxOn.boxIntakeActivate();
          }
          else if(difTime > 5.4 && difTime < 5.8){
            boxOff.boxOut();
          }
          else{
            stopAction.stopAction();
          }
    }
    
}
