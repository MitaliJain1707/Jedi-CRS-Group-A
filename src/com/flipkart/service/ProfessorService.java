package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorOperations;
import com.flipkart.service.ProfessorServiceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ProfessorService implements ProfessorServiceInterface {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    ProfessorOperations profOp=new ProfessorOperations();
    public Professor validateCredentials(String userId,String password){

        return profOp.validateCredentialsWithDB(userId,password);
    }
    public ArrayList<Course> viewAllCourses() throws SQLException{
        return profOp.viewCoursesWithDB();
    }
    public Map<String, ArrayList<String>> viewEnrolledStudents(Professor professor) throws SQLException {
        Map<String,ArrayList<String>> students=profOp.viewEnrolledStudentsWithDB(professor);
        return students;
    }
    public void assignGrades(Professor professor) throws SQLException, IOException {
        Map<String,ArrayList<String>> courseWithStudents=profOp.viewEnrolledStudentsWithDB(professor);
        System.out.println("\t\tEnter the Course Index and Students index ");
        int courseindex=1;
        for(String CourseName:courseWithStudents.keySet()){
            System.out.println(courseindex+". "+"("+CourseName+")");
            int studentsIndex=1;
            for(String student:courseWithStudents.get(CourseName)){
                System.out.println("\t"+studentsIndex+". ("+student+")");
                studentsIndex++;
            }
            courseindex++;
        }
        System.out.println("\t\tPick course Id");
        int courseChoice=Integer.parseInt(br.readLine());
        System.out.println("\t\tPick student Id");
        String studentChoice=br.readLine();
        System.out.println("\t\tEnter the grade between (A-F)");
        String Grade=br.readLine();
        profOp.provideGrade(courseChoice,studentChoice,Grade);



    }
    public void registerCourses(Professor professor) throws SQLException, IOException {
        ArrayList<Course> courses=profOp.viewAvailableCoursesWithDB(professor);
        while(true) {
            System.out.println("\t\t---Enter the Index which you want to register(Enter 0 to exit)");
            System.out.println("\t\tIndex." +"CourseName-CourseId");
            int index=1;
            for (Course c : courses) {
                System.out.println(index+".\t ("+c.getCourseId() + "\t-\t" + c.getCourseName()+")");
                index++;
            }

            int choice=Integer.parseInt(br.readLine());
            if(choice==0){
                break;
            }
            else{
                if((choice-1)<courses.size())
                profOp.registerCoursesWithDB(professor,courses.get(choice-1));
                else
                    System.out.println("\t\tEnter Correct index number");
            }
        }
    }

}
