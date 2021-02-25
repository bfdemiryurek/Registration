// Student Name: Bugra Fatih Demiryurek
// Student Number:200460059
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Lenova
 */
/**
 * Course Class variables are here
 */
public class Course {
    private Instructor instructor;
    private String courseNum,courseName,classRoom;
    private DayOfWeek day;
    private LocalTime time;
    private int hours;
    private int classSize = 3;
    private List<Student> classList = new ArrayList<>();
    private String prerequisiteCourse;
/**
 * Course Constructors are here
 */
    public Course(Instructor instructor, String courseNum, String courseName, String classRoom, DayOfWeek day, LocalTime time, int hours, String prerequisiteCourse) {
        this(instructor,courseNum,courseName,classRoom,day,time,hours);
        this.prerequisiteCourse = prerequisiteCourse;
    }
    
    public Course(Instructor instructor, String courseNum, String courseName, String classRoom, DayOfWeek day, LocalTime time, int hours) {
        if(!instructor.instructorCanTeach(courseNum)){
            throw new IllegalArgumentException("Professor " + instructor.getFirstName()+ " " + instructor.getLastName() + " is not qualified to teach " + courseNum);
        }
        this.instructor = instructor;
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.classRoom = classRoom;
        this.day = day;
        if(LocalTime.parse("08:00").isAfter(time) || LocalTime.parse("18:00").isBefore(time)){
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        this.time = time;
        this.hours = hours;
    }
 /**
 * A method to get instructor of the course
 */  
    public Instructor getInstructor() {
        return instructor;
    }
 /**
 * A method to set instructor of the course
 */ 
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
 /**
 * A method to get number of the course
 */ 
    public String getCourseNum() {
        return courseNum;
    }
 /**
 * A method to set number of the course
 */ 
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
 /**
 * A method to get name of the course
 */ 
    public String getCourseName() {
        return courseName;
    }
 /**
 * A method to set name of the course
 */ 
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
 /**
 * A method to get classroom of the course
 */ 
    public String getClassRoom() {
        return classRoom;
    }
 /**
 * A method to set classroom of the course
 */ 
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
 /**
 * A method to get day of the course
 */ 
    public DayOfWeek getDay() {
        return day;
    }
 /**
 * A method to set day of the course
 */ 
    public void setDay(DayOfWeek day) {
        this.day = day;
    }
 /**
 * A method to get time of the course
 */ 
    public LocalTime getTime() {
        return time;
    }
 /**
 * A method to set time of the course
 */ 
    public void setTime(LocalTime time) {
        this.time = time;
    }
 /**
 * A method to get hours of the course
 */ 
    public int getHours() {
        return hours;
    }
 /**
 * A method to set hours of the course
 */ 
    public void setHours(int hours) {
        this.hours = hours;
    }
 /**
 * A method to get prerequisite course of the course
 */ 
    public String getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
 /**
 * A method to set prerequisite course of the course
 */ 
    public void setPrerequisiteCourse(String prerequisiteCourse) {
        this.prerequisiteCourse = prerequisiteCourse;
    }
 /**
 * To string method is here
 */   
    public String toString(){
        return (getCourseNum()+"-"+getCourseName());
    }
 /**
 * A method to get instuctor to teach of the course
 */ 
    public Instructor getInstructorToTeach(){
        return getInstructor();
    }
/**
 * A method to get day and time of the course
 */ 
   public String getCourseDayAndTime(){
        String courseDayAndTime = day.name()+"'s, starting at "+time.getHour()+":"+time.getMinute()+time.getSecond();
        return courseDayAndTime;
    }
 /**
 * A method to add student to the course
 */   
    public String addStudent(Student std){
        if(prerequisiteCourse != null && !std.hasCompleted(prerequisiteCourse)){
            return "Student has not completed the prerequisite course: " + getPrerequisiteCourse();
        }
        if(!std.studentInGoodStanding()){
            return "The Student is not in good standing and cannot join the course.";
        }
        if(classList.size() < classSize){
            classList.add(std);
            return std.toString();   
        }
        else{
             return "Student was not added because the course is full";
        }
    }
/**
 * A method to display the classlist of the course
 */ 
    public String displayTheClassList(){
        String str = "";
        for(int i=0; i<classList.size(); i++){
            str += classList.get(i).toString();
        }
        return str;
    }
 /**
 * A method to get class size of the course
 */ 
    public int getClassSize() {
        return classSize;
    }
 /**
 * A method to set class size of the course
 */ 
    public String setClassSize(int classSize) {
        if(classSize > 40){
            this.classSize = 40;
            return "Max class size = 40, it has been set to 40";
        }
        this.classSize = classSize;
        return "";
    }
 /**
 * A method to check whether it is a mature class
 */ 
    public boolean matureClass(){
        int totalAge = 0;
        for(int j=0; j<classList.size(); j++){
            totalAge += classList.get(j).getStudentAge(); 
        }
        return totalAge/classList.size() > 25; 
    }
/**
 * A method to check prerequisite course of the course
 */ 
    public String checkPrerequisite(){
        return prerequisiteCourse; 
    }
}
    
