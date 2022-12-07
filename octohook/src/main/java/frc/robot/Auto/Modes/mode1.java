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


public class mode1 {
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

    public void modeOneAction(double difTime){
        
    }
    
}
