// Student Name: Bugra Fatih Demiryurek
// Student Number:200460059
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenova
 */
/**
 * Instructor Class variables are here
 */
public class Instructor {
    private String firstName,lastName;
    private int instructorNumber;
    private String streetAddress,city,postalCode;
    private LocalDate startedDate,dateOfBirth;
    private List<String> abilities = new ArrayList<>();
/**
 * Instructor Constructor is here
 */
    public Instructor(String firstName, String lastName, int instructorNumber, String streetAddress, String city, String postalCode, LocalDate startedDate, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorNumber = instructorNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.startedDate = startedDate;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if(age>100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        int yearsAtCollege = Period.between(startedDate, LocalDate.now()).getYears();
        if(yearsAtCollege>50){
            throw new IllegalArgumentException("1910-08-22 as a hire date would mean Anita started working over 80 years ago");
        }
        this.dateOfBirth = dateOfBirth;
    }
/**
 * Getters and Setters start here, a method to get first name of instructor
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * A method to set first name of the instructor
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * A method to get last name of the instructor
 */
    public String getLastName() {
        return lastName;
    }
/**
 * A method to set last name of the instructor
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * A method to get number of the instructor
 */
    public int getInstructorNumber() {
        return instructorNumber;
    }
/**
 * A method to set number of the instructor
 */
    public void setInstructorNumber(int instructorNumber) {
        this.instructorNumber = instructorNumber;
    }
/**
 * A method to get street address of the instructor
 */
    public String getStreetAddress() {
        return streetAddress;
    }
/**
 * A method to set street address of the instructor
 */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
/**
 * A method to get city of the instructor
 */
    public String getCity() {
        return city;
    }
/**
 * A method to set city of the instructor
 */
    public void setCity(String city) {
        this.city = city;
    }
/**
 * A method to get postal code of the instructor
 */
    public String getPostalCode() {
        return postalCode;
    }
/**
 * A method to set postal code of the instructor
 */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
/**
 * A method to get started date the instructor
 */
    public LocalDate getStartedDate() {
        return startedDate;
    }
/**
 * A method to set started date of the instructor
 */
    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }
/**
 * A method to get date of birth of the instructor
 */
    public int getDateOfBirth() {
        int age = LocalDate.now().getYear()-dateOfBirth.getYear();
        return age;
    }
  /**
 * To string method is here
 */  
    public String toString(){
        return (getFirstName()+" "+getLastName());
    }
 /**
 * A method to get age of the instructor
 */       
    public int getAgeInYears() {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age;
    }
 /**
 * A method to get years at college of the instructor
 */   
    public int noOfYearsAtCollege() {
        int yearsAtCollege = Period.between(startedDate, LocalDate.now()).getYears();
        return yearsAtCollege;
    }
/**
 * A method to set date of birth of the instructor
 */     
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 /**
 * A method to get address of the instructor
 */  
    public String getInstructorAddress(){
        return (streetAddress+", "+city+", "+postalCode);
    }
 /**
 * A method to change address of the instructor
 */  
    public void changeAddress(String streetAddress,String city,String postalCode){
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }
/**
 * A method to take list of subjects certified to teach of the instructor
 */ 
    public String listOfSubjectsCertifiedToTeach(){
        if(abilities.size() == 0){
        return "not qualified to teach courses yet.";
        }
        return abilities.toString();
    }
 /**
 * A method to add courses to abilities of the instructor
 */  
    public void addCourseToInstructorAbilities(String course){
        if(!instructorCanTeach(course)){
            abilities.add(course);
        } 
    }
 /**
 * A method to check the courses of the instructor
 */  
    public boolean instructorCanTeach(String ability){
        for(int i=0;i<abilities.size();i++){
            if(abilities.get(i).equals(ability)){
                return true;
            }
        }
        return false;
    }
}
