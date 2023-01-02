class UndergroundSystem {
private:
    map<pair<string,string>,pair<double,int>> averageTimeMp;
    map<int,pair<string,int>> checkInMp;
    
public:
    void checkIn(int id, string stationName, int t) {
        checkInMp[id] = {stationName,t};
    } 
    
    void checkOut(int id, string endStation, int t) {
        string startStation = checkInMp[id].first;
        
        double prevTotalTime = averageTimeMp[{startStation,endStation}].first;
        int prevTotalCustomer = averageTimeMp[{startStation,endStation}].second;
        
        double totalTime = prevTotalTime+(t - checkInMp[id].second);
        int totalCustomer = prevTotalCustomer+1;
        
        averageTimeMp[{startStation,endStation}] = {totalTime, totalCustomer};
    }
    
    double getAverageTime(string startStation, string endStation) {
        double totalTime = averageTimeMp[{startStation,endStation}].first;
        int totalCustomer = averageTimeMp[{startStation,endStation}].second;
        
        return totalTime/totalCustomer;
    }
};
