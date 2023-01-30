// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final CANSparkmax m_rightMotor = new CANSparkmax (0,kBrushed);
  private final CANSparkmax m_leftMotor = new CANSparkmax (0,kBrushed);
  private final DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotor,m_rightMotor);
  public ExampleSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void move(double x, double z){
    m_differentialDrive.arcadeDrive(x,z);
  }
}
