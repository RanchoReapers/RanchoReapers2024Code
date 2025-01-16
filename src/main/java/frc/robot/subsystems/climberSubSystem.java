package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climberSubSystem extends SubsystemBase {

    CANSparkMax climbLeft;
    CANSparkMax climbRight;

    public climberSubSystem(int canID_right,int canID_left) {
        climbRight = new CANSparkMax(canID_right, CANSparkMax.MotorType.kBrushless);
        climbLeft = new CANSparkMax(canID_left, CANSparkMax.MotorType.kBrushless);

        climbLeft.setInverted(true);
    }

    public void climbControl(boolean xPress, boolean yPress) {
        if (xPress == true && yPress != true) {
          climbRight.setVoltage(8);
          climbLeft.setVoltage(8);
        }
        else if (yPress == true && xPress != true) {
          climbRight.setVoltage(-8);
          climbLeft.setVoltage(-8);
        }
        else {
          climbRight.stopMotor();
          climbLeft.stopMotor();
        }

      }

      public void endMotors() {
        climbRight.stopMotor();
        climbLeft.stopMotor();
      }
}
