/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Interval i : intervals){
            while(!queue.isEmpty() && i.start>=queue.peek()){
                queue.poll();
            }
            queue.offer(i.end);
            max = Math.max(queue.size(), max);
        }
        return max;
    }
}
