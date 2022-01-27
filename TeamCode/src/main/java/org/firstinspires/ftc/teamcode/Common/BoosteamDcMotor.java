package org.firstinspires.ftc.teamcode.Common;

public class BoosteamDcMotor extends DcMotor {
    static final double PI = 3.1415;
    static final double INCHE_TO_CM_MULTIPLIER = 0.3937;

    public double countsPerMotor;
    public double driveGearReduction;
    public double wheelDiameterCM;

    public BoosteamDcMotor() {
        countsPerMotor = 0;
        drive_gearReduction = 0;
        wheelDiameterCM = 0;
    }

    public void initEmcoderValues(double countsPerMotor, double gearReduction, double wheelDiameterCM)
    {
        countsPerMotor = countsPerMotor;
        drive_gearReduction = gearReduction;
        wheelDiameterCM = wheelDiameterCM;
    }

    public int getTicksFromCM(double length_in_cm)
    {
        return (countsPerMotor * drive_gearReduction) / ( wheelDiameterCM * INCHE_TO_CM_MULTIPLIER * PI);
    }

    public int getTicksFromInches(double length_in_inches)
    {
        return (countsPerMotor * drive_gearReduction) / ( wheelDiameterCM *  PI);
    }
}