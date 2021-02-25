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

/**
 *
 * @author Lenova
 */
/**
 * Student Class variables are here
 */
public class Student {
    private String firstName,lastName,streetAddress,city,postalCode,courseCode;
    private int studentNumber;
    private LocalDate registrationDate,dateOfBirth;
    private boolean goodStanding = true;
    private Course course;
    private int grade;

/**
 * Student Constructor is here
 */
    public Student(String firstName, String lastName, String streetAddress, String city, String postalCode, String courseCode, int studentNumber, LocalDate registrationDate, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.registrationDate = registrationDate;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if(age>100){
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        this.dateOfBirth = dateOfBirth;
    }
/**
 * Getters and Setters start here, a method to get first name of student
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * A method to set first name of the student
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * A method to get last name of the student
 */
    public String getLastName() {
        return lastName;
    }
/**
 * A method to set last name of the student
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * A method to get street address of the student
 */
    public String getStreetAddress() {
        return streetAddress;
    }
/**
 * A method to set street address of the student
 */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
/**
 * A method to get city of the student
 */
    public String getCity() {
        return city;
    }
/**
 * A method to set city of the student
 */
    public void setCity(String city) {
        this.city = city;
    }
/**
 * A method to get postal code of the student
 */
    public String getPostalCode() {
        return postalCode;
    }
/**
 * A method to set postal code of the student
 */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
/**
 * A method to get course code of the student
 */
    public String getCourseCode() {
        return courseCode;
    }
/**
 * A method to set course code of the student
 */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
/**
 * A method to get student number of the student
 */
    public int getStudentNumber() {
        return studentNumber;
    }
/**
 * A method to set student number of the student
 */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
/**
 * A method to get registeration date of the student
 */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
/**
 * A method to set registeration date of the student
 */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
/**
 * A method to get date of birth of the student
 */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
/**
 * A method to set date of birth of the student
 */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 /**
 * A method to get birthday of student
 */  
    public LocalDate getStudentBirthday(){
        return dateOfBirth;
    }
/**
 * To string method is here
 */
    public String toString(){
        return (getFirstName()+" "+getLastName()+", student number: "+getStudentNumber());
    }
/**
 * A method to calculate student's age
 */    
    public int getStudentAge() {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age;
    }
/**
 * A method to calculate how long student has been enrolled
 */
    public int getYearEnrolled(){
        int yearsEnrolled = registrationDate.getYear();
        return yearsEnrolled;
    }
/**
 * A method to change student's address
 */    
    public void changeAddress(String streetAddress,String city,String postalCode){
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }
/**
 * A method to get students address
 */    
    public String getStudentAddress(){
        return (streetAddress+" "+city+" "+postalCode);
    }
/**
 * A method to check student's good standing
 */    
    public boolean studentInGoodStanding(){
        return goodStanding;
    }
/**
 * A method to suspend student
 */    
   public void suspendStudent(){
        goodStanding = false;
    }
/**
 * A method to reinstate student
 */    
    public void reinstateStudent(){
        goodStanding = true;
    }
/**
 * A method to set student's birthday
 */    
    public void setBirthday(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
/**
 * A method to add completed courses to student
 */    
    public void addCompletedCourse(Course course, int grade){
        if(grade < 0 || grade > 100){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");}
        this.course = course;
        this.grade = grade;
    }
/**
 * A method to check student's completed courses
 */    
    public boolean hasCompleted(String courseNum){
        if(course == null){
            return false;
        }
        if(course.getCourseNum().equals(courseNum)){
            if(grade >= 50){
                return true;
            }
            else{
            return false;
                    }
        }else{
            return false;
        }
    }
            
/**
 * A method to get completed courses
 */            
    public String getCoursesCompleted(){
        return "[" +course.getCourseNum()+"-"+course.getCourseName() +
               " grade=" + grade + "]" ;
    }
}
