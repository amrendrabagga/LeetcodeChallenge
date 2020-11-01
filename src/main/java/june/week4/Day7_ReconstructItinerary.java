package june.week4;

import java.util.*;

public class Day7_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();

        for(List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            flights.get(ticket.get(0)).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        visit("JFK", flights, res);
        return res;
    }

    private void visit(String airport, Map<String, PriorityQueue<String>> flights, List<String> res) {
        PriorityQueue<String> queue = flights.get(airport);
        while(queue!=null && !queue.isEmpty()) {
            visit(queue.poll(), flights, res);
        }
        res.add(0, airport);
    }
}
