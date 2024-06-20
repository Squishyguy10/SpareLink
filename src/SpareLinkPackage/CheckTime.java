package SpareLinkPackage;

import java.time.LocalTime;

public class CheckTime {
    // return true if the time is within the given range
    public static boolean isTimeWithinRange(LocalTime time, LocalTime startTime, LocalTime endTime) {
        if(startTime.isBefore(endTime) || startTime.equals(endTime)) {
            return !time.isBefore(startTime) && !time.isAfter(endTime);
        }
        else {
            return !time.isBefore(startTime) || !time.isAfter(endTime);
        }
    }

    // get the block that the current time corresponds to
    public static int getBlock(LocalTime time, int day) {
        // day 2 blocks are differnet from day 1
        if(day==1){
            if(isTimeWithinRange(time, LocalTime.of(8, 55), LocalTime.of(10, 10))) {
                return 0;
            }
            if(isTimeWithinRange(time, LocalTime.of(10, 15), LocalTime.of(11, 30))) {
                return 1;
            }
            if(isTimeWithinRange(time, LocalTime.of(12, 20), LocalTime.of(13, 35))) {
                return 2;
            }
            if(isTimeWithinRange(time, LocalTime.of(13, 40), LocalTime.of(14, 55))) {
                return 3;
            }
        }
        else{
            if(isTimeWithinRange(time, LocalTime.of(8, 55), LocalTime.of(10, 10))) {
                return 1;
            }
            if(isTimeWithinRange(time, LocalTime.of(10, 15), LocalTime.of(11, 30))) {
                return 0;
            }
            if(isTimeWithinRange(time, LocalTime.of(12, 20), LocalTime.of(13, 35))) {
                return 3;
            }
            if(isTimeWithinRange(time, LocalTime.of(13, 40), LocalTime.of(14, 55))) {
                return 2;
            }
        }
        // -1 if it is not in a school block
        return -1;
    }
}