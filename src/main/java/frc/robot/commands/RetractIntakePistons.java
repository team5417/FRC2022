// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class RetractIntakePistons extends CommandBase {
  /** Creates a new RetractPistons. */
  private final Intake intake;
  private boolean isRunning = false;

  public RetractIntakePistons(Intake intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = intake;
    addRequirements(this.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isRunning = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.intake.retractPistons();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    isRunning = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public boolean isRunning() {
    return isRunning;
  }
}
