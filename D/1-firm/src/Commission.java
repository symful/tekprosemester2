//********************************************************************
//  Commission.java
//
//  Represents an hourly employee that also earns commission on sales.
//********************************************************************

public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate;

    //-----------------------------------------------------------------
    //  Sets up a commissioned employee using the specified information.
    //-----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate, double commissionRate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0.0;
    }

    //-----------------------------------------------------------------
    //  Adds the specified sales amount to this employee's total sales.
    //-----------------------------------------------------------------
    public void addSales(double totalSales)
    {
        this.totalSales += totalSales;
    }

    //-----------------------------------------------------------------
    //  Computes and returns the pay for this commissioned employee,
    //  which is the hourly payment plus commission on sales.
    //-----------------------------------------------------------------
    @Override
    public double pay()
    {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0.0;
        return payment;
    }

    //-----------------------------------------------------------------
    //  Returns information about this commissioned employee as a string.
    //-----------------------------------------------------------------
    @Override
    public String toString()
    {
        String result = super.toString();
        result += "\nTotal sales: " + totalSales;
        return result;
    }
}
