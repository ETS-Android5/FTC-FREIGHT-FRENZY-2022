package org.firstinspires.ftc.teamcode.Helpers;

public static class EncoderHelper {
    public EncoderHelper() {}

    public static void driveToPositionAndStopAsync(List<BoosteamDcMotor> motors, double cm, double speed)
    {
        new Thread(() => {
            DriveToPositionAndStop(motors, cm, speed);
        });
    }

    public static void driveToPositionAndStop(List<BoosteamDcMotor> motors, double cm, double speed)
    {
        for (DcMotor motor in motors)
        {
            motor.setTargetPosition(motor.getTicksFromCM(cm));
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