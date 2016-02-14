/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        int n = tickets.length;
        List<String> res = new ArrayList<String>();
        if(tickets == null || n == 0) return res;
        Map<String, PriorityQueue<String>> hm = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!hm.containsKey(tickets[i][0])){
                hm.put(tickets[i][0], new PriorityQueue<String>());
            } 
            hm.get(tickets[i][0]).add(tickets[i][1]);
        }

        String str = "JFK";
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < n; i++) {
            while(!hm.containsKey(str) || hm.get(str).isEmpty()) {
                stack.push(str);
                str = res.remove(res.size()-1);
            }
            res.add(str);
            str = hm.get(str).poll();
        }
        res.add(str);
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
