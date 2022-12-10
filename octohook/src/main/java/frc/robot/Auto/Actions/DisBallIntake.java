package frc.robot.Auto.Actions;

import frc.robot.subsystems.ballIntake;

public class DisBallIntake {
    ballIntake mDisBallIntake = new ballIntake();

    public void ballIntakeDisable(){
        mDisBallIntake.mBallOutake(false);
    }
}
