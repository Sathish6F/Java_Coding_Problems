package File_IO.Serialization;

import java.io.Serializable;

public class Patient implements Serializable {
	
    String name;
    int patientId;
    int age;
    String gender;
    transient long mobileNo;

    Patient(String name,int patientId,int age,String gender,long mobileNo){
        this.name = name;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.mobileNo = mobileNo;
    }

}