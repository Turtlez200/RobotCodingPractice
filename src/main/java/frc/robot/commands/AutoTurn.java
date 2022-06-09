// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurn extends CommandBase {

  DriveSubsystem DRIVE_SUBSYSTEM;
  double Degrees;
  double encoderDegreesLeft, encoderDegreesRight;
  boolean finished;

  /** Creates a new AutoTurn. */
  public AutoTurn(DriveSubsystem drive, double deg) {
    addRequirements(drive);
    DRIVE_SUBSYSTEM=drive;
    Degrees=deg;
    finished=false;

    if (Degrees<0){ //if want to go left (negative degrees)
      encoderDegreesLeft=DRIVE_SUBSYSTEM.getLeftPosition()-(Degrees/360.0)*4096;
      if (encoderDegreesLeft<0){
          encoderDegreesLeft=4096+encoderDegreesLeft;
      }

      encoderDegreesRight=DRIVE_SUBSYSTEM.getRightPosition()+(Degrees/360.0)*4096;
      if (encoderDegreesRight>4096){
        encoderDegreesRight=encoderDegreesRight-4096;
      }
    }
    else{ //if you want to go right
      encoderDegreesLeft=DRIVE_SUBSYSTEM.getLeftPosition()+(Degrees/360.0)*4096;
      if (encoderDegreesLeft>4096){
          encoderDegreesLeft=encoderDegreesLeft-4096;
      }

      encoderDegreesRight=DRIVE_SUBSYSTEM.getRightPosition()-(Degrees/360.0)*4096;
      if (encoderDegreesRight<0){
        encoderDegreesRight=4096+encoderDegreesRight;
      }
    }
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!(DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft-200 && DRIVE_SUBSYSTEM.getLeftPosition()<encoderDegreesLeft+200) && !(DRIVE_SUBSYSTEM.getRightPosition()>encoderDegreesRight-200 && DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight+200)){
        if (Degrees<0){ //left
          if (DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft-200 || DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight+200)
          {
              DRIVE_SUBSYSTEM.set(0, -0.1);
          }
          if (DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft+200 || DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight-200){
            DRIVE_SUBSYSTEM.set(0, 0.1);
          }
        }
        else{
          if (DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft-200 || DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight+200)
          {
              DRIVE_SUBSYSTEM.set(0, 0.1);
          }
          if (DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft+200 || DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight-200){
            DRIVE_SUBSYSTEM.set(0, -0.1);
          }
        }
    }
    else{
      finished=true;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
