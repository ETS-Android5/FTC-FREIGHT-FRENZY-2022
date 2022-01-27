package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.Abstract.SystemBase;

public class DuckSystem extends SystemBase {
    private DcMotor _duckMotor;
    private Gamepad _gamepad;
    private Telemetry _telemetry;

    public DuckSystem(DcMotor motor, Gamepad gamepad, Telemetry telemetry) {
        _duckMotor = motor;
        _gamepad = gamepad;
        _telemetry = telemetry;
    }

    @Override
    public void run() {
        if (_gamepad.x) {
            _telemetry.addData("Status", "x is pressed - Ducks system is running");
            _telemetry.update();
            _duckMotor.setPower(1);
        }
        else 
            _duckMotor.setPower(0);
    }
}