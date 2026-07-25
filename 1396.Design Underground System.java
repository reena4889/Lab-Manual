import java.util.*;

class UndergroundSystem {

    // Stores check-in information: id -> (stationName, time)
    private Map<Integer, CheckIn> checkInMap;

    // Stores travel statistics: "start-end" -> (totalTime, tripCount)
    private Map<String, Trip> tripMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        tripMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);

        String route = checkIn.station + "-" + stationName;
        int travelTime = t - checkIn.time;

        Trip trip = tripMap.getOrDefault(route, new Trip());
        trip.totalTime += travelTime;
        trip.tripCount++;

        tripMap.put(route, trip);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Trip trip = tripMap.get(route);

        return (double) trip.totalTime / trip.tripCount;
    }

    // Helper class for check-in data
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for trip statistics
    class Trip {
        int totalTime;
        int tripCount;

        Trip() {
            totalTime = 0;
            tripCount = 0;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id, stationName, t);
 * obj.checkOut(id, stationName, t);
 * double param_3 = obj.getAverageTime(startStation, endStation);
 */
