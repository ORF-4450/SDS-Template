package frc.robot.swervelib;

import java.util.Objects;

/**
 * Additional Mk4 module configuration parameters.
 * <p>
 * The configuration parameters here are used to customize the behavior of the Mk4 swerve module.
 * Each setting is initialized to a default that should be adequate for most use cases.
 */
public class Mk4ModuleConfiguration 
{
    private double nominalDriveVoltage  = 12;    // Voltage compensation value. This is max voltage
                                                 // that will be output by controller. Zero is off.
    private double nominalSteerVoltage  = 12;

    // % output/second. 0 is off.
    private double driveRampRate        = 0.0;
    private double steerRampRate        = 0.0;

    private double driveCurrentLimit    = 80;   // amps.
    private double steerCurrentLimit    = 20;

    // Steer PID values for Neo. Customized by 4450.
    private static final double DEFAULT_NEO_P = 0.5;
    private static final double DEFAULT_NEO_I = 0.0;
    private static final double DEFAULT_NEO_D = 0.05;

    private static final double DEFAULT_500_P = 0.2;
    private static final double DEFAULT_500_I = 0.0;
    private static final double DEFAULT_500_D = 0.1;

    private double steerP = DEFAULT_NEO_P;
    private double steerI = DEFAULT_NEO_I; 
    private double steerD = DEFAULT_NEO_D;

    // Private constructor prevents this class from being created with the new
    // operator. Use the static factory methods below to create new instances.
    private Mk4ModuleConfiguration () {}

    public double getSteerP() { return steerP; }
    public double getSteerI() { return steerI; }
    public double getSteerD() { return steerD; }

    public void setSteerPid(double p, double i, double d)
    {
        steerP = p;
        steerI = i;
        steerD = d;
    }

    public double getNominalDriveVoltage() { return nominalDriveVoltage; }

    public void setNominalDriveVoltage(double nominalVoltage) { this.nominalDriveVoltage = nominalVoltage; }

    public double getNominalSteerVoltage() { return nominalSteerVoltage; }

    public void setNominalSteerVoltage(double nominalVoltage) { this.nominalSteerVoltage = nominalVoltage; }

    public double getDriveCurrentLimit() { return driveCurrentLimit; }

    public void setDriveCurrentLimit(double driveCurrentLimit) { this.driveCurrentLimit = driveCurrentLimit; }

    public double getSteerCurrentLimit() { return steerCurrentLimit; }

    public void setSteerCurrentLimit(double steerCurrentLimit) { this.steerCurrentLimit = steerCurrentLimit; }

    public double getDriveRampRate() { return driveRampRate; }

    public void setDriveRampRate(double rampRate) { this.driveRampRate = rampRate; }

    public double getSteerRampRate() { return steerRampRate; }

    public void setSteerRampRate(double rampRate) { this.steerRampRate = rampRate; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Mk4ModuleConfiguration that = (Mk4ModuleConfiguration) o;

        return Double.compare(that.getNominalDriveVoltage(), getNominalDriveVoltage()) == 0 && 
                              Double.compare(that.getNominalSteerVoltage(), getNominalSteerVoltage()) == 0 &&
                              Double.compare(that.getDriveRampRate(), getDriveRampRate()) == 0 && 
                              Double.compare(that.getSteerRampRate(), getSteerRampRate()) == 0 && 
                              Double.compare(that.getSteerP(), getSteerP()) == 0 && 
                              Double.compare(that.getSteerI(), getSteerI()) == 0 && 
                              Double.compare(that.getSteerD(), getSteerD()) == 0 && 
                              Double.compare(that.getDriveCurrentLimit(), getDriveCurrentLimit()) == 0 && 
                              Double.compare(that.getSteerCurrentLimit(), getSteerCurrentLimit()) == 0;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(getNominalDriveVoltage(), getNominalSteerVoltage(), getDriveCurrentLimit(), 
                            getSteerCurrentLimit(), getDriveRampRate(), getSteerRampRate(), getSteerP(),
                            getSteerI(), getSteerD());
    }

    @Override
    public String toString() 
    {
        return "Mk4ModuleConfiguration{" +
                "nominalDriveVoltage=" + nominalDriveVoltage +
                ", nominalSteerVoltage=" + nominalSteerVoltage +
                ", driveCurrentLimit=" + driveCurrentLimit +
                ", steerCurrentLimit=" + steerCurrentLimit +
                ", driveRampRate=" + driveRampRate +
                ", steerRampRate" + steerRampRate +
                ", p=" + steerP + ", i=" + steerI + ", d=" + steerD +
                '}';
    }

    public static Mk4ModuleConfiguration getDefault500Config()
    {
        Mk4ModuleConfiguration config = new Mk4ModuleConfiguration();

        config.setSteerPid(DEFAULT_500_P, DEFAULT_500_I, DEFAULT_500_D);

        return config;
    }

    public static Mk4ModuleConfiguration getDefaultNeoConfig()
    {
        Mk4ModuleConfiguration config = new Mk4ModuleConfiguration();

        config.setSteerPid(DEFAULT_NEO_P, DEFAULT_NEO_I, DEFAULT_NEO_D);

        return config;
    }
}
