/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jue
 */
public class Member implements Comparable<Member>{
    private String name, idNo, DOB, dateJoin, phoneNo;
    private int aPoints = 0;
    private static int num=0;

    public Member(String ID, String name, String DOB, String dateJoin, String number, int points) {
        this.idNo = ID;
        this.name = name;
        this.DOB = DOB;
        this.dateJoin = dateJoin;
        this.phoneNo = number;
        this.aPoints = points;
        num++;
    }

    public static int getNum(){
    	return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setaPoints(int aPoints) {
        this.aPoints = aPoints;
    }

    public String getID() {
        return this.idNo;
    }

    public String getName() {
        return this.name;
    }

    public String getDOB() {
        return this.DOB;
    }

    public String getDateJoin() {
        return this.dateJoin;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public int getPoints() {
        return this.aPoints;
    }

    public void View() {

        System.out.printf("%-4s\t%-15s\t%-10s\t%-10s\t%-11s\t%s\n", getID(), getName(), getDOB(), getDateJoin(), getPhoneNo(), getPoints());
    }
//****************************************************************************
    public int compareTo(Member m)
    {
    	return this.getName().compareTo(m.getName());
    }


}
