package com.flipkart.service;
import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.AdminDaoImplementation;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.CourseNotFoundException;

public class AdminOperation implements AdminInterface {
    private static volatile AdminOperation instance = null;

    // private constructor
    private AdminOperation() {
    }

    public static AdminOperation getInstance() {
        if (instance == null) {
            synchronized (AdminOperation.class) {
                instance = new AdminOperation();
            }
        }
        return instance;
    }

    @Override
    //adding professor in 
    public void addProfessor(Professor professor) {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addProfessor(professor);
        if(ok) {
            System.out.println("\t\tProfessor added");
            System.out.println("\t\t+++++++++++++++++++++++");
        }
        else {
            System.out.println("\t\tProfessor not added");
        }
    }

    @Override
    public void addCourse(Course course){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.addCourse(course);
        if(ok) {
            System.out.println("\t\tCourse added");
            System.out.println("\t\t+++++++++++++++++++++++");
        }
        else {
            System.out.println("\t\tCourse not added");
        }

    }

    @Override
    public void dropCourse(int courseId){
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.dropCourse(courseId);
        if(ok) {
            System.out.println("\t\tCourse Dropped");
            System.out.println("\t\t+++++++++++++++++++++++");
        }
        else {
            System.out.println("\t\tCan't drop course");
        }

    }

    @Override
    public boolean approveStudents() {
        AdminDaoInterface admin = AdminDaoImplementation.getInstance();
        boolean ok = admin.approveStudents();
        if(ok) {
            System.out.println("");
            System.out.println("\t\t+++++++++++++++++++++++");
            return true;
        }
        else {
            System.out.println("\t\tCant drop course");
            return false;
        }
    }

	@Override
	public void assignCourse(int courseId, String professorId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		AdminDaoInterface admin = AdminDaoImplementation.getInstance();
		admin.assignCourse(courseId, professorId);
		
		
	}

	@Override
	public void viewCourse() {
		// TODO Auto-generated method stub
		AdminDaoInterface admin = AdminDaoImplementation.getInstance();
		try {
		List<Course> courseList = admin.viewCourse();
		if(courseList != null) {
			for(Course course: courseList) {
				String out = "\t\tCourseId: " + Integer.toString(course.getCourseId()) + " " + "CourseName: " + course.getCourseName() + " " ;
				if(course.getProfessorId() != null) {
					out += "ProfessorId: " + course.getProfessorId();
				}
				else {
					out += "No Professor";
				}
				out += "\n";
				System.out.println(out);
				
			}
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

//    @Override
//    public void generateReportCard(String studentId) {
//
//    }
}
