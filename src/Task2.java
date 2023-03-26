import java.util.InputMismatchException;
import java.io.*;
import java.util.Scanner;

public class Task2 {


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        cabin[] cabins = new cabin[12];



        for (int i = 0; i < cabins.length; i++) {
            cabins[i] = new cabin();

        }


        initialise(cabins);


        int roomNum = 0;
        int nameno = 0;

        while (true) {     //This show these strings on loop as the menu.


            System.out.println("*****************************************************************************************");
            System.out.println("A: Book A New Cabin.");
            //  System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("E: Display Empty Cabins.");
            // System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("V: View all Cabins.");
            //  System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("D: Delete customer from a Cabin.");
            //   System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("F: Find Cabin from customer name.");
            //   System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("S: Store program data in to file.");
            //   System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("L: Load program data from file.");
            //   System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("O: View Cabins Ordered alphabetically by name.");
            //   System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("T: View Passenger Expences");

            String Selection = input.next();
            Selection = Selection.toUpperCase();
            switch (Selection) { //This switch is connected to all my function and gets called once the relevent option is selected.
                case "A":
                    cabins=BookARoom(nameno, roomNum, cabins);
                    break;
                case "E":
                    CheckIfEmpty(cabins);
                    break;
                case "V":
                    ViewAllRooms(cabins);
                    break;
                case "D":
                    DeleteCustomerFromRoom(cabins, roomNum, nameno);
                    break;
                case "F":
                    FindRoomFromCustomerName(cabins);
                    break;
                case "S":
                    StoreProgramDataInToFile(cabins);
                    break;
                case "L":
                    LoadProgramDataFromFile(cabins);
                    break;
                case "O":
                    ViewRoomsOrderedAlphabeticallyByName(cabins);
                    break;
                case "T":
                    ViewExpences(cabins);
                    break;




                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }


    private static void initialise(cabin[] cabins) { //initialize all my cabin passengers as empty.

            passenger temp = new passenger();

            cabin[] cabinx = new cabin[12];
            for (int x = 0; x < cabinx.length; x++) {
                cabinx[x] = new cabin();
                cabinx[x].setPassenger1(temp);
                cabinx[x].setPassenger2(temp);
                cabinx[x].setPassenger3(temp);

            }


        }



    private static void CheckIfEmpty(cabin[] cabins) {//this will check the first names of all the passengers,if the value isnt empty it ll return that particular passenger.


        for (int x = 0; x < cabins.length; x++) {


            String data1 = cabins[x].getPassenger1().getPassfirstname();
            String data2 = cabins[x].getPassenger2().getPassfirstname();
            String data3 = cabins[x].getPassenger3().getPassfirstname();


            if (data1 != "empty") {
                System.out.println("present1");
            } else {
                System.out.println("In cabin" + (x + 1) + "passenger 1 is Empty");

            }
            if (data2 != "empty") {
                System.out.println("present2");

            } else {
                System.out.println("In cabin" + (x + 1) + "passenger 2 is Empty");

            }
            if (data3 != "empty") {
                System.out.println("present3");
            } else {
                System.out.println("In cabin" + (x + 1) + "passenger 3 is Empty");

            }


        }
    }


    private static cabin[] BookARoom(int nameno, int roomNum, cabin[] cabins) {//This will help to book any passenger in any cabin unless its already taken.

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number (1-12):");
            roomNum = input.nextInt() - 1;

            System.out.println("Which slot you want to book  (select from 1-3):");
            nameno = input.nextInt() - 1;

            if (nameno == 0) {
                System.out.println("first name");
                cabins[roomNum].getPassenger1().setPassfirstname(input.next());
                System.out.println("second name");
                cabins[roomNum].getPassenger1().setPasssecondname(input.next());
                System.out.println("enter expences");
                cabins[roomNum].getPassenger1().setExpences(input.nextInt());

            } else if (nameno == 1) {
                System.out.println("first name");
                cabins[roomNum].getPassenger2().setPassfirstname(input.next());
                System.out.println("second name");
                cabins[roomNum].getPassenger2().setPasssecondname(input.next());
                System.out.println("enter expences");
                cabins[roomNum].getPassenger2().setExpences(input.nextInt());

            } else if (nameno == 2) {
                System.out.println("first name");
                cabins[roomNum].getPassenger3().setPassfirstname(input.next());
                System.out.println("second name");
                cabins[roomNum].getPassenger3().setPasssecondname(input.next());
                System.out.println("enter expences");
                cabins[roomNum].getPassenger3().setExpences(input.nextInt());
            }

            return cabins;
        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }

        return cabins;
     }





    private static void ViewAllRooms(cabin[] cabins) {//This will give a view of all the cabins wheather its occupied or not.


        for (int x = 0; x < cabins.length; x++) {

            String data1 = cabins[x].getPassenger1().getPassfirstname();
            String data2 = cabins[x].getPassenger2().getPassfirstname();
            String data3 = cabins[x].getPassenger3().getPassfirstname();


            if (data1 != "empty") {
                String p1 = cabins[x].getPassenger1().getPassfirstname();

                System.out.println(p1 + " is the 1st passenger in cabin " + (x + 1));


            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 1 is Empty");


            }
            if (data2 != "empty") {
                String p2 = cabins[x].getPassenger2().getPassfirstname();

                System.out.println(p2 + " is the 2nd passenger in cabin " + (x + 1));


            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 2 is Empty");


            }
            if (data3 != "empty") {
                String p3 = cabins[x].getPassenger3().getPassfirstname();

                System.out.println(p3 + " is the 3rd passenger in cabin " + (x + 1));

            } else {
                System.out.println("In cabin " + (x + 1) + " passenger 3 is Empty");


            }


        }


    }


    private static void DeleteCustomerFromRoom(cabin[] cabins, int roomNum, int nameno) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number to delete(1-12):");
            roomNum = input.nextInt() - 1;
            System.out.println("which slot");
            nameno = input.nextInt() - 1;

            passenger temp = new passenger();


            if (nameno == 0) {
                cabins[roomNum].setPassenger1(temp);
            } else if (nameno == 1) {
                cabins[roomNum].setPassenger2(temp);

            } else if (nameno == 2) {
                cabins[roomNum].setPassenger3(temp);

            }


            System.out.println(" Deleted ");
        }catch(InputMismatchException e){
            System.out.println("Input Mismatch Exception has occurred. "+e);

        }


    }


    private static void FindRoomFromCustomerName(cabin[] cabins) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the First name to Search for:");
            String roomName = input.next();

            for (int x = 0; x < cabins.length; x++) {

                String data1 = cabins[x].getPassenger1().getPassfirstname();
                String data2 = cabins[x].getPassenger2().getPassfirstname();
                String data3 = cabins[x].getPassenger3().getPassfirstname();


                if (data1.equals(roomName)) {
                    System.out.println(roomName + " is the 1st passenger in cabin " + (x + 1));


                } else if (data2.equals(roomName)) {
                    System.out.println(roomName + " is the 2nd passenger in cabin " + (x + 1));

                } else if (data3.equals(roomName)) {
                    System.out.println(roomName + " is the 3rd passenger in cabin " + (x + 1));

                } else {
                    System.out.println("There is no passenger named " + roomName);
                    System.out.println("P.S (make sure you've used the correct CAP's)");
                }


            }

        }catch(InputMismatchException e){
                System.out.println("Input Mismatch Exception has occurred. "+e);

            }
    }


    private static void StoreProgramDataInToFile(cabin[] cabins) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("Array.txt"))) {
            String save1;
            String save2;
            String save3;
            String save4;
            String save5;
            String save6;

            int savea;
            int saveb;
            int savec;

            String  trigger1;
            String  trigger2;
            String  trigger3;

            String emp="empty";


            for (int x = 0; x < cabins.length; x++) {

                trigger1=cabins[x].getPassenger1().getPassfirstname();
                trigger2=cabins[x].getPassenger2().getPassfirstname();
                trigger3=cabins[x].getPassenger3().getPassfirstname();


                if (!trigger1.equals(emp)) {

                    save1 = cabins[x].getPassenger1().getPassfirstname();
                    save2 = cabins[x].getPassenger1().getPasssecondname();
                    savea = cabins[x].getPassenger1().getExpences();

                    out.println("cabin "+(x+1)+": 1st passenger is occupied by "+ save1 + " " + save2+": Rs "+ savea );     //+ ": Rs." + save3
                }else{
                    out.println("cabin "+(x+1)+": 1st passenger is empty " );

                }


                if (!trigger2.equals(emp)) {

                    save3 = cabins[x].getPassenger2().getPassfirstname();
                    save4 = cabins[x].getPassenger2().getPasssecondname();
                    saveb = cabins[x].getPassenger2().getExpences();

                    out.println("cabin "+(x+1)+": 2nd passenger is occupied by "+ save3 + " " + save4+": Rs "+ saveb );     //+ ": Rs." + save3
                }else{
                    out.println("cabin "+(x+1)+": 2nd passenger is empty " );

                }


                if (!trigger3.equals(emp)) {

                    save5 = cabins[x].getPassenger3().getPassfirstname();
                    save6 = cabins[x].getPassenger3().getPasssecondname();
                    savec = cabins[x].getPassenger3().getExpences();

                    out.println("cabin "+(x+1)+": 3rd passenger is occupied by "+ save5 + " " + save6+": Rs "+ savec );     //+ ": Rs." + save3
                }else{
                    out.println("cabin "+(x+1)+": 3rd passenger is empty " );

                }

            }

        }
        System.out.println("All Room Names have been Saved.");
    }


    private static void LoadProgramDataFromFile(cabin[] cabins) {
        try {
            File myobjct = new File("Array.txt");
            Scanner myscan = new Scanner(myobjct);


            while (myscan.hasNextLine()) {
                for (int k = 0; k < 36; k++) {
                    System.out.println(myscan.nextLine());


                }


            }
            myscan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();

        }



    }

    public static void ViewExpences( cabin[] cabins){// this will view expences of indiviual passenger and the toltal expene of all the passengers


        String save1;
        String save2;
        String save3;
        String save4;
        String save5;
        String save6;

        Integer savea;
        Integer saveb;
        Integer savec;


        String  trigger1;
        String  trigger2;
        String  trigger3;

        String emp="empty";
        int total2=0;
        Integer totalExp=0;

        for (int x = 0; x < cabins.length; x++) {

            trigger1=cabins[x].getPassenger1().getPassfirstname();
            trigger2=cabins[x].getPassenger2().getPassfirstname();
            trigger3=cabins[x].getPassenger3().getPassfirstname();

            if (!trigger1.equals(emp)) {

                save1 = cabins[x].getPassenger1().getPassfirstname();
                save2 = cabins[x].getPassenger1().getPasssecondname();
                savea = cabins[x].getPassenger1().getExpences();

                System.out.println("cabin "+(x+1)+"s 1st passenger: "+ save1 + " " + save2+": Rs "+ savea );
                totalExp=totalExp+savea;

            }


            if (!trigger2.equals(emp)) {

                save3 = cabins[x].getPassenger2().getPassfirstname();
                save4 = cabins[x].getPassenger2().getPasssecondname();
                saveb = cabins[x].getPassenger2().getExpences();

                System.out.println("cabin "+(x+1)+"s 2nd passenger: "+ save3 + " " + save4+": Rs "+ saveb );     //+ ": Rs." + save3
                totalExp=totalExp+saveb;
            }


            if (!trigger3.equals(emp)) {

                save5 = cabins[x].getPassenger3().getPassfirstname();
                save6 = cabins[x].getPassenger3().getPasssecondname();
                savec = cabins[x].getPassenger3().getExpences();

                System.out.println("cabin "+(x+1)+"s 1st passenger: "+ save5 + " " + save6+": Rs "+ savec );     //+ ": Rs." + save3
                totalExp=totalExp+savec;
            }



        }

        System.out.println("Total expences of all the cabins are: Rs "+totalExp);


    }

    public static void ViewRoomsOrderedAlphabeticallyByName(cabin[] cabins){
        String save1;
        String save3;
        String save5;

        String  trigger1;
        String  trigger2;
        String  trigger3;

        String emp="empty";
        int count=0;


        for (int x = 0; x < cabins.length; x++) {

            trigger1 = cabins[x].getPassenger1().getPassfirstname();
            trigger2 = cabins[x].getPassenger2().getPassfirstname();
            trigger3 = cabins[x].getPassenger3().getPassfirstname();


            if (!trigger1.equals(emp)) {

                save1 = cabins[x].getPassenger1().getPassfirstname();
                count++;

            }

            if (!trigger2.equals(emp)) {

                save3 = cabins[x].getPassenger2().getPassfirstname();
                count++;

            }

            if (!trigger3.equals(emp)) {

                save5 = cabins[x].getPassenger3().getPassfirstname();
                count++;

            }
        }

        String myArraylist[]=new String[count];
        int arrcount=0;

        String savea;
        String saveb;
        String savec;


        String  trigger4;
        String  trigger5;
        String  trigger6;

        for (int i=0;i< cabins.length;i++){
            trigger4 = cabins[i].getPassenger1().getPassfirstname();
            trigger5 = cabins[i].getPassenger2().getPassfirstname();
            trigger6 = cabins[i].getPassenger3().getPassfirstname();

            if (!trigger4.equals(emp)) {

                savea = cabins[i].getPassenger1().getPassfirstname();
                myArraylist[arrcount]=savea;
                arrcount++;


            }

            if (!trigger5.equals(emp)) {

                saveb = cabins[i].getPassenger2().getPassfirstname();
                myArraylist[arrcount]=saveb;
                arrcount++;

            }

            if (!trigger6.equals(emp)) {

                savec = cabins[i].getPassenger3().getPassfirstname();
                myArraylist[arrcount]=savec;
                arrcount++;

            }



        }
        System.out.println(arrcount);
                                                      //https://www.w3schools.com/java/ref_string_compareto.asp
        for(int u = 0; u< myArraylist.length; u++) {
            for (int j = u + 1; j < (myArraylist.length); j++) {
                if ((myArraylist[u].compareTo(myArraylist[j])) > 0) {
                    String temp_store = myArraylist[u];
                    myArraylist[u] = myArraylist[j];
                    myArraylist[j] = temp_store;
                }
            }

        }



        for (int s=0;s<myArraylist.length;s++){
            System.out.println(myArraylist[s]);

        }


    }

}


