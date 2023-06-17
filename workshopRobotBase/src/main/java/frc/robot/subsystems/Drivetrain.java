package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    private static final Drivetrain instance = new Drivetrain();

    public static Drivetrain getInstance() {
        return instance;
    }

    private CANSparkMax r1 = new CANSparkMax(1, MotorType.kBrushless); // right motor id 0
    private CANSparkMax r2 = new CANSparkMax(2, MotorType.kBrushless); // right motor id 1
    private CANSparkMax l1 = new CANSparkMax(3, MotorType.kBrushless); // left motor id 2
    private CANSparkMax l2 = new CANSparkMax(4, MotorType.kBrushless); // left motor id 3


    public Drivetrain() { // Constructor: Use an external controller object for local use
        // left side must be inverted to reflect proper output
        r1.setInverted(false); // do not invert right
        r2.setInverted(false); // do not invert right
        l1.setInverted(true); // invert left
        l2.setInverted(true); //invert left
        r1.setIdleMode(IdleMode.kCoast);
        r2.setIdleMode(IdleMode.kCoast);
        l1.setIdleMode(IdleMode.kCoast);
        l2.setIdleMode(IdleMode.kCoast);
        r1.burnFlash();
        r2.burnFlash();
        l1.burnFlash();
        l2.burnFlash();
    }

    @Override //Overridden because this is inherited from SubsystemBase
    public void periodic() { // runs every 20ms
        //arcadeDrive(controller.getRightX(), controller.getLeftY()); // set the drive motors using controller inputs and arcadeDrive() method
    }

    /**
     * control drive motors with throttle and rotational velocity
     * @param rotation value must be within [-1, 1]
     * @param throttle value must be within [-1, 1]
     */
    public void arcadeDrive(double rotation, double throttle) { // control drive motors with throttle and rotational velocity
        double rightSpeed = throttle - rotation; // calculation for right motor speed
        double leftSpeed = throttle + rotation; // calculation for left motor speed
        r1.set(rightSpeed); // set right motor
        r2.set(rightSpeed); // set right motor
        l1.set(leftSpeed); // set left motor
        l2.set(leftSpeed); // set left motor
    }

    private void driveForward() {
        r1.set(1);
        r2.set(1);
        l1.set(1);
        l2.set(1);
    }
}
