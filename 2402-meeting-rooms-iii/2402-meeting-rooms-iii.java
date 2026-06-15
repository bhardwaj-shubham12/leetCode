import java.util.*;

class Solution {
    class Meeting implements Comparable<Meeting> {
        long endTime; // Use long to prevent potential overflow
        int room;

        Meeting(int room, long endTime) {
            this.endTime = endTime;
            this.room = room;
        }

        @Override
        public int compareTo(Meeting meet) {
            if (this.endTime == meet.endTime) {
                return Integer.compare(this.room, meet.room);
            }
            return Long.compare(this.endTime, meet.endTime);
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] counter = new int[n];
        
        // Sort meetings by start time
        Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
        
        // Min-heap for rooms that are currently free
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        
        // Min-heap for ongoing meetings (sorted by endTime, then room)
        PriorityQueue<Meeting> ongoingMeetings = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // 1. Free up rooms whose meetings have finished by the current meeting's start time
            while (!ongoingMeetings.isEmpty() && ongoingMeetings.peek().endTime <= start) {
                availableRooms.add(ongoingMeetings.poll().room);
            }

            // 2. If a room is available, take the one with the lowest index
            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                counter[room]++;
                ongoingMeetings.add(new Meeting(room, end));
            } 
            // 3. If no room is available, wait for the earliest meeting to finish
            else {
                Meeting earliestMeeting = ongoingMeetings.poll();
                counter[earliestMeeting.room]++;
                // The delayed meeting starts as soon as the previous one ends
                ongoingMeetings.add(new Meeting(earliestMeeting.room, earliestMeeting.endTime + duration));
            }
        }

        // Find the room with the maximum meetings (break ties with lowest room index)
        int maxMeetings = -1;
        int resultRoom = -1;
        for (int i = 0; i < n; i++) {
            if (counter[i] > maxMeetings) {
                maxMeetings = counter[i];
                resultRoom = i;
            }
        }
        
        return resultRoom;
    }
}