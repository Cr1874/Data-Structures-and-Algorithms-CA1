/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.ArrayList;

/**
 *
 * @author Conno
 */

//this class is used to manage the priority queue, which determines who should be next to be done based on priority, age aand if they were in the ward

public class PQElement implements PQInterface {
    private ArrayList<TesterApplicant> queue;

    public PQElement() {
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(TesterApplicant tester) {
        // Insert the element at the correct position to maintain sorting order
        int insertIndex = 0;

        while (insertIndex < queue.size() && compareApplicants(queue.get(insertIndex), tester) > 0) {
            insertIndex++;
        }

        queue.add(insertIndex, tester); // Insert in sorted position
    }

    @Override
    public TesterApplicant dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0); // Remove the highest-priority applicant (front of queue)
    }

    @Override
    public String printQueue() {
        return printQueueRecursive(0);
    }

    // Recursive function to print queue
    private String printQueueRecursive(int index) {
        if (index >= queue.size()) {
            return "";
        }
        return queue.get(index).getDetails() + "\n" + printQueueRecursive(index + 1);
    }

    // this is the method to compare two applicants based on priority, age, and ward status
    private int compareApplicants(TesterApplicant t1, TesterApplicant t2) {
        int p1 = getPriorityValue(t1.getPriority());
        int p2 = getPriorityValue(t2.getPriority());

        if (p1 != p2) {
            return Integer.compare(p2, p1); // Higher priority first
        }
        if (t1.getAge() != t2.getAge()) {
            return Integer.compare(t2.getAge(), t1.getAge()); // Next is older first if priority is the same
        }
        return Boolean.compare(t2.isWardPat(), t1.isWardPat()); // Ward patients first if p+a is same
    }

    private static int getPriorityValue(String priority) { //priority status depending on urgency of patient using switch-case
        switch (priority.toLowerCase()) {
            case "urgent": return 3;
            case "medium": return 2;
            case "low": return 1;
            default: return 0;
        }
    }
}

