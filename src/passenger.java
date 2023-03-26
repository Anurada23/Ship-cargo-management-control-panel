public class passenger {

    String passfirstname="";
    String passsecondname="";
    int expences=0;


    public String getPassfirstname() {
        return passfirstname==""?"empty":passfirstname;
    }

    public void setPassfirstname(String passfirstname) {
        this.passfirstname = passfirstname;


    }

    public String getPasssecondname() {
        return passsecondname==""? "empty" : passsecondname;

    }

    public void setPasssecondname(String passsecondname) {
        this.passsecondname = passsecondname;
    }

    public int getExpences() {
        return expences;
    }

    public void setExpences(int expences) {
        this.expences = expences;
    }



}


