package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;


public class Right {
    Drive mAutoDrive = new Drive();

    public void moveRightAction(){
        mAutoDrive.motoresAuto(-0.4, -0.4, -0.4, -0.4);
    }
}
