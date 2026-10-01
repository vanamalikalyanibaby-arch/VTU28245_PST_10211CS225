class UndergroundSystem {

    // Customer ID -> Check-in information
    Map<Integer, CheckIn> checkIns = new HashMap<>();

    // Route -> [total time, number of trips]
    Map<String, int[]> trips = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;

        int travelTime = t - checkIn.time;

        if (!trips.containsKey(route)) {
            trips.put(route, new int[]{0, 0});
        }

        trips.get(route)[0] += travelTime;
        trips.get(route)[1]++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        int[] data = trips.get(route);

        return (double) data[0] / data[1];
    }

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}