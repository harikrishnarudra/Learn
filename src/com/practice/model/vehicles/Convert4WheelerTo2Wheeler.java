package com.practice.model.vehicles;

public class Convert4WheelerTo2Wheeler {

    private FourWheeler get4Wheeler(){
        return new FourWheeler();
        /*return FourWheeler.builder().steeringType("Power")//.numOfWheels(4).spareWheelExists(true).vehicleNumber("4444")
                .childLockSupport(true).build();*/
    }

    private static void printOutput(TwoWheeler twoWheeler){
        /*System.out.println(twoWheeler.getNumOfWheels());
        System.out.println(twoWheeler.isPillionExists());
        System.out.println(twoWheeler.isSpareWheelExists());*/
    }

    public static void main(String[] args) {
        Convert4WheelerTo2Wheeler convert4WheelerTo2Wheeler = new Convert4WheelerTo2Wheeler();
        Vehicle fourWheeler = (Vehicle) convert4WheelerTo2Wheeler.get4Wheeler();
        TwoWheeler twoWheeler = (TwoWheeler)fourWheeler;
        printOutput(twoWheeler);

    }
}
