/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author Conno
 */

public interface PQInterface {
    void enqueue(TesterApplicant applicant);
    
    TesterApplicant dequeue();
    
    String printQueue();
}

