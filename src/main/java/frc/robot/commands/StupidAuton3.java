// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class StupidAuton3 extends CommandBase {
  /** Creates a new StupidAuton. */
  private final Drive drive;
  private final Shooter shoot;
  private final Intake intake;
  private final Limelight limelight;
  private int count;
  private double[] wheelSpeeds;
  public StupidAuton3(Drive drive, Shooter shoot, Intake intake, Limelight limelight) {
    this.drive = drive;
    this.shoot = shoot;
    this.intake = intake;
    this.limelight = limelight;
    addRequirements(drive, shoot, intake, limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    count = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //prepare to shoot first ball
    if(count <= 250){
      shoot.setVelocity(2500);
    }
    //shoot first ball, start intake
    else if(count <= 1000){
      shoot.setVelocity(2500);
      intake.runIntestine(1);
    }
    //drive forwards to second ball
    else if(count <= 2000){
      drive.setPower(.6, .6);
    }
    //stop intake, shoot second ball
    else if(count <= 3000) {
      intake.runIntestine(0);
      drive.setPower(0.0, 0.0);
      shoot.setVelocity(2500);  
    }
    //go backwards
    else if(count <= 5000) {
      shoot.setVelocity(0);
      drive.setPower(-0.6, -0.6);
    }
    //Turn 90 deg. right
    else if(count <= 6000) {
      shoot.setVelocity(0);
      drive.setPower(0.6, -0.6);
    }
    // Go forward, intake 1 ball
    else if(count <= 8500) {
      intake.runIntestine(1);
      drive.setPower(0.6, 0.6);
    } 
    // Pause 500 milsec
    else if(count <= 9000) {
      intake.runIntestine(0);
      drive.setPower(0.0, 0.0);
    }
    // Go backward
    else if(count <= 10500) {
      drive.setPower(-0.6, -0.6);
    }
    // Turn left at 65 deg 
    else if(count <= 11220) {
      drive.setPower(-0.6, 0.6);
    }
    // Stop and shoot
    else if(count <= 12220) {
      drive.setPower(0.0, 0.0);
      shoot.setVelocity(2500);
    }
    // Stops robot
    else{
      drive.setPower(0, 0);
      shoot.setPower(0);
      intake.runIntestine(0);
    }
    count+=20;


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setPower(0, 0);
    shoot.setPower(0);
    intake.runIntestine(0);            
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (count > 8750){
      return true;
    }
    return false;
  }
}
