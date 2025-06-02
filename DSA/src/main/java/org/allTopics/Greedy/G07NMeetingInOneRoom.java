package org.allTopics.Greedy;

// Problem Link :- https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

// Problem Description;-
/*
You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i
and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single
meeting room, when only one meeting can be held in the meeting room at a particular time.

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4),
(5,7) and (8,9)
Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Input: start[] = [1, 2], end[] = [100, 99]
Output: 1

Constraints:
1 ≤ n ≤ 10^5
0 ≤ start[i] < end[i] ≤ 10^6

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(n)

Company Tags
Flipkart Amazon Microsoft MakeMyTrip Cisco

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class G07NMeetingInOneRoom {
    class Meetings{
        private int start;
        private int end;
        private int meetingId; // in case in 1 of the questions, they are asking us to return the meeting.
        Meetings(int s, int e, int idx){
            this.start=s;
            this.end = e;
            this.meetingId = idx;
        }
    }
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    // TC:- O(NlogN), SC:- O(N)
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ArrayList<Meetings> al = new ArrayList<>();
        for(int i=0;i<start.length;i++) al.add(new Meetings(start[i], end[i],i));

        // Simply sort on basis of endTime.
        Collections.sort(al, new Comparator<Meetings>(){
            @Override
            public int compare(Meetings m1, Meetings m2){
                return m1.end - m2.end;
            }
        });

        int endTime=al.get(0).end;
        int meeting=1;
        for(int i=1;i<al.size();i++){
            if(al.get(i).start>endTime){
                meeting++;
                // startTime = al.get(i).start;
                endTime = al.get(i).end;
            }
        }
        return meeting;
    }
}
