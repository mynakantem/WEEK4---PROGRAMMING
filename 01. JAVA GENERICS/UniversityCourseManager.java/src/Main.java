import java.util.*;

abstract class CourseType {
    protected String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public abstract String getEvaluationMethod();

    public String getCourseName() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(T courseType, String department) {
        this.courseType = courseType;
        this.department = department;
    }

    public void displayCourseDetails() {
        System.out.println("Department: " + department +
                " | Course: " + courseType.getCourseName() +
                " | Evaluation: " + courseType.getEvaluationMethod());
    }

    public T getCourseType() {
        return courseType;
    }
}

class CourseUtils {
    public static void printAllCourses(List<? extends CourseType> courses) {
        System.out.println("\n--- List of All Courses ---");
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | " + course.getEvaluationMethod());
        }
    }
}

class UniversityCourseManager {
    public static void main(String[] args) {
        Course<ExamCourse> math101 = new Course<>(new ExamCourse("Math 101"), "Mathematics");
        Course<AssignmentCourse> design202 = new Course<>(new AssignmentCourse("Design 202"), "Design");
        Course<ResearchCourse> thesis301 = new Course<>(new ResearchCourse("Thesis 301"), "Research");

        math101.displayCourseDetails();
        design202.displayCourseDetails();
        thesis301.displayCourseDetails();

        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(new ExamCourse("Physics 102"));
        allCourseTypes.add(new AssignmentCourse("UX Fundamentals"));
        allCourseTypes.add(new ResearchCourse("AI Research Lab"));

        CourseUtils.printAllCourses(allCourseTypes);
    }
}
