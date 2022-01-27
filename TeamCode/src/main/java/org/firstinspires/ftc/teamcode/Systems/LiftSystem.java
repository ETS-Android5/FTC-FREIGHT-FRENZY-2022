package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class LiftSystem extends SystemBase {
    private final int LEVEL_DIFF_IN_TICKS = 200;
    private final double LIST_SPEED = 0.8;

    private DcMotor _liftMotor;
    private Gamepad _gamepad;
    private Telemetry _telemetry;

    public LiftSystem(DcMotor motor, Gamepad gamepad, Telemetry telemetry) {
        _liftMotor = motor;
        _gamepad = gamepad;
        _telemetry = telemetry;
    }

    @Override
    public void run() {
        if (_gamepad.a) {
            _telemetry.addData("Status", "lift goes to first level");
            _telemetry.update();
            int pos = _liftMotor.getPosition();
            int ticks = LEVEL_DIFF_IN_TICKS - pos;
            // drive to posision
            // DriveToPositionAndStopAsync([motor], ticks, speed);
        }
        else
            _liftMotor.setPower(0);
    }
}