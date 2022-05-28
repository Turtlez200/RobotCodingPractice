// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunConveyerCommand extends CommandBase {
  private ConveyerSubsystem CONVEYER_SUBSYSTEM;
  private IntakeSubsystem INTAKE_SUBSYSTEM;

  /** Creates a new ConveyerCommand. */
  public RunConveyerCommand(ConveyerSubsystem conveyer, IntakeSubsystem intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.CONVEYER_SUBSYSTEM=conveyer;
    this.INTAKE_SUBSYSTEM=intake;

    addRequirements(CONVEYER_SUBSYSTEM);
    addRequirements(INTAKE_SUBSYSTEM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    CONVEYER_SUBSYSTEM.set(0.5);
    INTAKE_SUBSYSTEM.set(-1, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    CONVEYER_SUBSYSTEM.stop();
    INTAKE_SUBSYSTEM.stop();  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
