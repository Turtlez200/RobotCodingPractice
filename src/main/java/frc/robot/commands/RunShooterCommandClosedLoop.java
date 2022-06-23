// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ShooterSubsystemClosedLoop;

public class RunShooterCommandClosedLoop extends CommandBase {

  private ShooterSubsystemClosedLoop SHOOTER_SUBSYSTEM_CLOSED_LOOP;


  /** Creates a new RunShooterCommand. */
  public RunShooterCommandClosedLoop(ShooterSubsystemClosedLoop shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.SHOOTER_SUBSYSTEM_CLOSED_LOOP=shooter;

    addRequirements(SHOOTER_SUBSYSTEM_CLOSED_LOOP);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SHOOTER_SUBSYSTEM_CLOSED_LOOP.setShooterSpeed(ShooterSubsystemClosedLoop.targetVelocity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SHOOTER_SUBSYSTEM_CLOSED_LOOP.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
