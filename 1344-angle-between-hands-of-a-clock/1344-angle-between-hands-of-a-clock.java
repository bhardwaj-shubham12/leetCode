class Solution {
    private double diffCalc(double hourAngle, double minuteAngle){
        if(hourAngle > minuteAngle){
            return hourAngle - minuteAngle;
        }
        else{
            return minuteAngle - hourAngle;
        }
    }
    public double angleClock(int hour, int minutes) {
        double minuteAngle = ((double)minutes) * (6.0);

        double hourAngleForHour = ((double) hour) * 30.0;

        double hourAngleForMin = (((double)minutes) / 60.0) * 30.0;

        double hourAngle = (hourAngleForHour + hourAngleForMin) % 360;
        //System.out.println("hour Angle:"+hourAngle);
        //System.out.println("minute Angle:"+minuteAngle);

        double diff = diffCalc(hourAngle,minuteAngle);

        if(diff > 180){
            diff = 360 - diff;
        }

        return diff;
    }
}