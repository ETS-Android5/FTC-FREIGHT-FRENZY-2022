package org.firstinspires.ftc.teamcode.Helpers;

public class EncoderHelper {
    public EncoderHelper() {}

    public void DriveToPositionAndStopAsync(List<DcMotor> motors, int ticks, double speed)
    {
        new Thread(() => {
            DriveToPositionAndStop(motors, ticks, speed);
        })
    }

    public void DriveToPositionAndStop(List<DcMotor> motors, int ticks, double speed)
    {
        for (DcMotor motor in motors)
        {
            motor.setTargetPosition(ticks);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        for (DcMotor motor in motors)
        {
            motor.setPower(Math.abs(speed));
        }
        
        Bool isRunning = true;
        while (isRunning) {
            for (DcMotor motor in motors) {
                isRunning = isRunning && motor.isBusy();
            }
        }

        for (DcMotor motor in motors)
        {
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
} 