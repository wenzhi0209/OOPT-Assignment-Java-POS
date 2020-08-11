


import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;


/**
 *
 * @author Jue
 */
public class MemberMenu {

    public static Member[] m;
    Scanner input = new Scanner(System.in);
    String newName, newIDNo, newDOB, newDateJoin, newPhoneNo;
    private String clrBuf;

//ADMINMenu
    public void adminMenu() {
        int option;
        do {
            System.out.println("\n\n\nMembership Page (FOR ADMIN)");
            System.out.println("\nOptions");
            System.out.println("-------");
            System.out.println("1) View");
            System.out.println("2) Add");
            System.out.println("3) Delete");
            System.out.println("4) Modify");
            System.out.println("5) Exit");
            System.out.print("Enter Option : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nMembership List");
                    System.out.printf("%-4s\t%-15s\t%-10s\t%-10s\t%-11s\t%s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
                    for (Member m1 : m) {
                        if (m1 != null) {
                            m1.View();
                        } else if (m1 == null) {
                            System.out.print("");
                        }
                    }
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    ModifyMember();
                    break;
                default:
                    System.out.println("Wrong Option");
            }
        } while (option != 5);
    }
//StaffMenu

    public void staffMenu() {
        int option;
        do {
            System.out.println("\n\n\nMembership Page (FOR Staff)");
            System.out.println("\nOptions");
            System.out.println("-------");
            System.out.println("1) View");
            System.out.println("2) Add");
            System.out.println("3) Exit");
            System.out.print("Enter Option : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nMembership List");
                    System.out.printf("%-4s\t%-15s\t%-10s\t%-10s\t%-11s\t%s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
                    for (Member m1 : m) {
                        if (m1 != null) {
                            m1.View();
                        } else if (m1 == null) {
                            System.out.print("");
                        }
                    }
                    break;
                case 2:
                    addMember();
                    break;
                default:
                    System.out.println("Wrong Option");
            }
        } while (option != 3);
    }
//Add Member

    public void addMember() {
        Character ans = new Character('Y');
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int num=Member.getNum()+1;

        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) {
                do {
                   /* System.out.printf("No :%d \n", i + 1);
                    clrBuf = input.nextLine();
                    System.out.print("Enter New Member ID (F###) (X to Exit):");
                    newIDNo = input.nextLine();
                    if (newIDNo.charAt(0) == 'X') {
                        break;
                    }*/
                    if(num<10)
                    {
                    	System.out.println("Current ID: "+"F00"+num);
		    			newIDNo= String.format("F00"+num);
                    }
                    else if(num>=10)
                    {
                    	System.out.println("Current ID: "+"F0"+num);
		    			newIDNo = String.format("F0"+num);
                    }
					clrBuf = input.nextLine();
                    System.out.print("Enter New Member Name :");
                    newName = input.nextLine();
                    System.out.print("Enter New Member Date Of Birth (dd/mm/yyyy):");
                    newDOB = input.nextLine();
                    System.out.print("Enter New Member Phone Number :");
                    newPhoneNo = input.nextLine();
                    System.out.println("Enter New Member Date Join (dd/mm/yyyy):");
                    System.out.println("Do you wanna use the current date? ");
                    System.out.println("Current Date :" + formatter.format(date));
                    System.out.print("Yes or No? Y/N >");
                    ans = input.next().charAt(0);

                    if (Character.toUpperCase(ans) == 'Y') {
                        newDateJoin = formatter.format(date);
                    } else {
                        clrBuf = input.nextLine();
                        System.out.print("Enter New Member Date Join (dd/mm/yyyy):");
                        newDateJoin = input.nextLine();
                    }
                    m[i] = new Member(newIDNo, newName, newDOB, newDateJoin, newPhoneNo, 0);
                    System.out.printf("%4s\t%-10s\t%10s\t%10s\t%-11s\t%-6s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
                    System.out.printf("%4s\t%-15s\t%10s\t%10s\t%-11s\t%-6d\n", m[i].getID(), m[i].getName(), m[i].getDOB(), m[i].getDateJoin(), m[i].getPhoneNo(), m[i].getPoints());
                    System.out.print("Anymore ? Y/N >");
                    ans = input.next().charAt(0);
                    i++;
                } while (Character.toUpperCase(ans) == 'Y');
                break;
            }
        }
    }
//Delete Member

    public void deleteMember() {
        Character confirm = new Character('n');
        int number = 1;
        System.out.printf("  %4s\t%-10s\t%10s\t%10s\t%-11s\t%-6s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.printf("%d. ", i + 1);
                System.out.printf("%4s\t%-10s\t%10s\t%10s\t%-11s\t%-6d\n", m[i].getID(), m[i].getName(), m[i].getDOB(), m[i].getDateJoin(), m[i].getPhoneNo(), m[i].getPoints());
                number++;
            }
        }
        System.out.print("Which Member you want to delete ? :");
        int ans = input.nextInt();
        System.out.print("Are You Sure (Y/N)? :");
        confirm = input.next().charAt(0);

        if (confirm == 'y'||confirm == 'Y') {

            m[ans - 1] = null;
            Member[] temp = new Member[10];
            int x = 0;

            for (int i = 0; i < number - 1; i++) {
                if (x >= m.length) {
                    temp[i] = null;
                    break;
                } else if (m[x] != null) {
                    temp[i] = m[x];
                } else {
                    temp[i] = m[x + 1];
                    x++;
                }
                x++;
            }
            m = temp;
            System.out.println("Changes has been made");
        } else {
            System.out.println("No Changes has been made");
        }
    }
//Modify Member

    public void ModifyMember() {
        int number = 1;
        System.out.printf("   %4s\t%-10s\t%10s\t%10s\t%-11s\t%-6s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.printf("%d. ", i + 1);
                System.out.printf("%4s\t%-10s\t%10s\t%10s\t%-11s\t%-6d\n", m[i].getID(), m[i].getName(), m[i].getDOB(), m[i].getDateJoin(), m[i].getPhoneNo(), m[i].getPoints());
                number++;
            }
        }
        System.out.print("Which Member you want to edit ? :");
        int ans = input.nextInt();
        System.out.print("\nNo." + ans + " has been selected\n\n");

        System.out.println("Modify Options");
        System.out.println("--------------");
        System.out.println("1.Edit Member IDNo");
        System.out.println("2.Edit Member Member");
        System.out.println("3.Edit Member Date Of Birth");
        System.out.println("4.Edit Member Phone Number");
        System.out.println("5.Edit Member Date Join");
        System.out.println("6.Edit Member Points");
        System.out.println("7.Exit");
        System.out.print("Enter Option : ");
        int option = input.nextInt();
        clrBuf = input.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter New Member ID (F###) :");
                newIDNo = input.nextLine();
                m[ans - 1].setIdNo(newIDNo);
                break;
            case 2:
                System.out.print("Enter New Member Name :");
                newName = input.nextLine();
                m[ans - 1].setName(newName);
                break;
            case 3:
                System.out.print("Enter New Member Date Of Birth (dd/mm/yyyy):");
                newDOB = input.nextLine();
                m[ans - 1].setDOB(newDOB);
                break;
            case 4:
                System.out.print("Enter New Member Phone Number :");
                newPhoneNo = input.nextLine();
                m[ans - 1].setPhoneNo(newPhoneNo);
                break;
            case 5:
                System.out.print("Enter New Member Date Join (dd/mm/yyyy):");
                newDateJoin = input.nextLine();
                m[ans - 1].setDateJoin(newDateJoin);
                break;
            case 6:
                System.out.print("Enter New Points :");
                int newPoints = input.nextInt();
                m[ans - 1].setaPoints(newPoints);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }

        System.out.printf("%-4s\t%-15s\t%-10s\t%-10s\t%-11s\t%s\n", "ID", "Name", "D.O.B", "Date Join", "Phone No.", "Available Points");
        for (Member m1 : m) {
            if (m1 != null) {
                m1.View();
            }
        }

    }

}
