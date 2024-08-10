package com.local.coding_practice.PriorityQueue;


import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

public class EmployeeFreeTime {

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(5, 6);
        Interval i3 = new Interval(1, 3);
        Interval i4 = new Interval(4, 10);

        List<Interval> i1List = new ArrayList<>();
        i1List.add(i1);
        i1List.add(i2);

        List<Interval> i2List = new ArrayList<>();
        i2List.add(i3);

        List<Interval> i3List = new ArrayList<>();
        i3List.add(i4);

        List<List<Interval>> listOfInterval = new ArrayList<>();
        listOfInterval.add(i1List);
        listOfInterval.add(i2List);
        listOfInterval.add(i3List);

        List<Interval> result = employeeFreeTime(listOfInterval);
        result.forEach(interval -> System.out.println(interval.start+", "+interval.end));

    }

    private static List<Interval> employeeFreeTime(List<List<Interval>> listOfInterval) {

        //merge into single list
        //List<Interval> allIntervals = new ArrayList<>();
        //for (List<Interval> list : listOfInterval) {
         //   allIntervals.addAll(list);
        //}

        //merge into single list and sort by start time
        List<Interval> allIntervals = listOfInterval.stream().flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(interval -> interval.start)).toList();


        //merge overlapping intervals
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval itv : allIntervals) {
            if (merged.isEmpty() || merged.getLast().end < itv.start) {
                merged.add(itv);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, itv.end);
            }
        }

        //prepare result
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            result.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }

        return result;
    }

}
