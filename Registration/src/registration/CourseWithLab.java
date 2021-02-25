// Student Name: Bugra Fatih Demiryurek
// Student Number:200460059
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Lenova
 */
/**
 * CourseWithLab Class variables are here
 */
public class CourseWithLab {
    private Instructor instructor;
    private String courseNum;
    private String courseName;
    private String classRoom;
    private DayOfWeek classDay;
    private LocalTime classTime;
    private int bfd;
    private String prerequisiteCourse;
    private Instructor technician;
    private String labRoom;
    private DayOfWeek labDay;
    private LocalTime labTime;
 /**
 * CourseWithLab constructors are here
 */ 
    public CourseWithLab(Instructor instructor, String courseNum, 
            String courseName, String classRoom, DayOfWeek classDay, 
            LocalTime classTime, int bfd, String prerequisiteCourse, Instructor technician, String labRoom,
            DayOfWeek labDay, LocalTime labTime) {
        
        this(instructor,courseNum,courseName,classRoom,classDay,classTime,bfd,
                technician,labRoom,labDay,labTime);
        this.prerequisiteCourse = prerequisiteCourse;
    }
    public CourseWithLab(Instructor instructor, String courseNum, String courseName, String classRoom, DayOfWeek classDay, LocalTime classTime, int bfd, Instructor technician, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        if(!instructor.instructorCanTeach(courseNum)){
            throw new IllegalArgumentException("Professor " + instructor.getFirstName()+ " " + instructor.getLastName() + " is not qualified to teach " + courseNum);
        }
        this.instructor = instructor;
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.classRoom = classRoom;
        this.classDay = classDay;
        this.classTime = classTime;
        this.bfd = bfd;
        if(!technician.instructorCanTeach(courseNum+"-LAB")){
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
        this.technician = technician;
        this.labRoom = labRoom;
        this.labDay = labDay;
        if(LocalTime.parse("08:00").isAfter(labTime) || LocalTime.parse("18:00").isBefore(labTime)){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        this.labTime = labTime;
    }
/**
 * Getters and Setters start here, a method to get first name of instructor
 */
    public Instructor getInstructor() {
        return instructor;
    }
/**
 * A method to set first name of the instructor
 */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
/**
 * A method to get course number
 */
    public String getCourseNum() {
        return courseNum;
    }
/**
 * A method to set course number
 */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
/**
 * A method to get course name
 */
    public String getCourseName() {
        return courseName;
    }
/**
 * A method to set course name
 */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
/**
 * A method to get classroom
 */
    public String getClassRoom() {
        return classRoom;
    }
/**
 * A method to set classroom
 */
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
/**
 * A method to get class day
 */
    public DayOfWeek getClassDay() {
        return classDay;
    }
/**
 * A method to set class day
 */
    public void setClassDay(DayOfWeek classDay) {
        this.classDay = classDay;
    }
/**
 * A method to get class time
 */
    public LocalTime getClassTime() {
        return classTime;
    }
/**
 * A method to set class time
 */
    public void setClassTime(LocalTime classTime) {
        this.classTime = classTime;
    }
/**
 * A method to get an int (probably a variable to define total lab hours)
 */
    public int getBfd() {
        return bfd;
    }
/**
 * A method to set an int (probably a variable to define total lab hours)
 */
    public void setBfd(int bfd) {
        this.bfd = bfd;
    }
/**
 * A method to get lab technician
 */
    public Instructor getTechnician() {
        return technician;
    }
/**
 * A method to set lab technician
 */
    public void setTechnician(Instructor technician) {
        this.technician = technician;
    }
/**
 * A method to get lab room
 */
    public String getLabRoom() {
        return labRoom;
    }
/**
 * A method to set lab room
 */
    public void setLabRoom(String labRoom) {
        this.labRoom = labRoom;
    }
/**
 * A method to get lab day
 */
    public DayOfWeek getLabDay() {
        return labDay;
    }
/**
 * A method to set lab day
 */
    public void setLabDay(DayOfWeek labDay) {
        this.labDay = labDay;
    }
/**
 * A method to get lab time
 */
    public LocalTime getLabTime() {
        return labTime;
    }
/**
 * A method to set lab time
 */
    public void setLabTime(LocalTime labTime) {
        this.labTime = labTime;
    }
/**
 * To string method is here
 */
    public String toString(){
        return(getCourseNum()+"-"+getCourseName()+" with lab");
    }
/**
 * A method to get lab and class time
 */
    public String getLabClassAndTime(){
        String hour = "" ;
        String minute = "" ;
        if(getLabTime().getHour()%10 == 0){
            hour = "0"+getLabTime().getHour();
        }
        else{
            hour = String.valueOf(getLabTime().getHour());
        }
        if(getLabTime().getMinute()%10 == 0){
            minute = "0"+getLabTime().getMinute();
        }
        else{
            minute = String.valueOf(getLabTime().getMinute());
        }
        return "room: " +getLabRoom() + ", " + getLabDay()+  " " + "starting at " + hour + ":" + minute;
    }
 /**
 * A method to get instructor to teach
 */  
    public Instructor getInstructorToTeach(){
        return instructor;
    }
/**
 * A method to get technician to teach
 */  
    public Instructor getLabTech(){
        return technician;
    }
/**
 * A method to check prerequisite courses
 */   
    public String checkPrerequisite(){
        return prerequisiteCourse; 
    }
}

