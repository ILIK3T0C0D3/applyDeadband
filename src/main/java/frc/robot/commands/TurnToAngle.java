package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToAngle extends CommandBase {
  private final Drivetrain m_drive;
  private final double m_degrees;

  /**
   * Creates a new TurnDegrees. This command will turn your robot for a desired
   * rotation (in
   * degrees) and rotational speed.
   *
   * @param speed   The speed which the robot will drive. Negative is in reverse.
   * @param degrees Degrees to turn. Leverages encoders to compare distance.
   * @param drive   The drive subsystem on which this command will run
   */
  public TurnToAngle(double degrees, Drivetrain drive) {
    m_degrees = degrees;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set motors to stop, read encoder values for starting point
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(0, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_drive.m_gyro.getAngleZ() >= m_degrees)
      return true;
    return false;

  }
}
