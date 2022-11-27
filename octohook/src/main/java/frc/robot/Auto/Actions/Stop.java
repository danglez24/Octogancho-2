package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class Stop {
    Drive mAutoDrive = new Drive();

    public void stopAction(){
        mAutoDrive.motoresAuto(0, 0, 0, 0);
    }
    
}
