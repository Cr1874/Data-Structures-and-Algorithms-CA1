/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package bloodtestscheduler;

/**
 *
 * @author Conno
 */

public class TesterApplicant {
    private String name;
    private int age;
    private String priority;
    private String gpDetails;
    private boolean wardPat;

    public TesterApplicant(String name, int age, String priority, String gpDetails, boolean wardPat) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.gpDetails = gpDetails;
        this.wardPat = wardPat;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isWardPat() {
        return wardPat;
    }

    public String getDetails() {
        return "Name: " + name + ", Age: " + age + ", Priority: " + priority + ", GP: " + gpDetails +
                ", From Hospital ward: " + (wardPat ? "Yes" : "No");
    }
}
