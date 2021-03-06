// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;


public class AutoAlignDrive extends CommandBase {
  /** Creates a new AutoAlignDrive. */
  private final Limelight limelight;
  private final Drive drive;
  private double[] speeds;
  public AutoAlignDrive(Limelight limelight, Drive drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.limelight = limelight;
    this.drive = drive;
    addRequirements(limelight, drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speeds = limelight.getSpeeds();
    drive.rawMotorPower(speeds[0], speeds[1]);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*limelight.ledOn();
    speeds = limelight.getSpeeds();
    drive.setPower(speeds[0], speeds[1]);*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}