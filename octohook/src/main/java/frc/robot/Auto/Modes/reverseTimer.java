package frc.robot.Auto.Modes;

import frc.robot.subsystems.Drive;
import frc.robot.Auto.Actions.AutoTimer;
import frc.robot.Auto.Actions.Backward;
import frc.robot.Auto.Actions.Stop;

public class reverseTimer {
    Drive mAutoDrive = new Drive();
    Backward mBackward = new Backward();
    AutoTimer mAutoTimer = new AutoTimer();
    Stop mStop = new Stop();

    public void finalLineTimer(){
        if(mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer()<3){
            mBackward.moveBackwardAction();
        }
        else{
            mStop.stopAction();
        }
    }



}
