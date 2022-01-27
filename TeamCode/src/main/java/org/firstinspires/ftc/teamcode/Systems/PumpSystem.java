package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class PumpSystem extends SystemBase {
    private BoosteamDcMotor _pumpMotor;
    private Gamepad _gamepad;
    private Telemetry _telemetry;

    public PumpSystem(BoosteamDcMotor motor, Gamepad gamepad, Telemetry telemetry) {
        _pumpMotor = motor;
        _gamepad = gamepad;
        _telemetry = telemetry;
    }

    @Override
    public void run() {
        if (_gamepad.left_trigger > 0) {
            _pumpMotor.setPower(_gamepad.left_trigger);
        }
        else if (_gamepad.right_trigger > 0) {
            _pumpMotor.setPower(_gamepad.right_trigger);
        }
        else
            _pumpMotor.setPower(0);
    }
}