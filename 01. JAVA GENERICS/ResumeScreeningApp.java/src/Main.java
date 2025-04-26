import java.util.*;
import java.util.List;

abstract class JobRole {
    String candidateName;
    String resumeSummary;

    public JobRole(String candidateName, String resumeSummary) {
        this.candidateName = candidateName;
        this.resumeSummary = resumeSummary;
    }

    public abstract String getRole();
    public abstract boolean isEligible();
}

class SoftwareEngineer extends JobRole {
    int yearsOfExperience;

    public SoftwareEngineer(String name, String summary, int experience) {
        super(name, summary);
        this.yearsOfExperience = experience;
    }

    @Override
    public String getRole() {
        return "Software Engineer";
    }

    @Override
    public boolean isEligible() {
        return yearsOfExperience >= 2;
    }
}

class DataScientist extends JobRole {
    boolean knowsML;

    public DataScientist(String name, String summary, boolean knowsML) {
        super(name, summary);
        this.knowsML = knowsML;
    }

    @Override
    public String getRole() {
        return "Data Scientist";
    }

    @Override
    public boolean isEligible() {
        return knowsML;
    }
}

class ProductManager extends JobRole {
    int projectsHandled;

    public ProductManager(String name, String summary, int projects) {
        super(name, summary);
        this.projectsHandled = projects;
    }

    @Override
    public String getRole() {
        return "Product Manager";
    }

    @Override
    public boolean isEligible() {
        return projectsHandled >= 3;
    }
}

class Resume<T extends JobRole> {
    private T jobApplicant;

    public Resume(T jobApplicant) {
        this.jobApplicant = jobApplicant;
    }

    public void processResume() {
        System.out.println("Candidate: " + jobApplicant.candidateName);
        System.out.println("Role Applied: " + jobApplicant.getRole());
        System.out.println("Summary: " + jobApplicant.resumeSummary);
        if (jobApplicant.isEligible()) {
            System.out.println("Status: ✅ Eligible\n");
        } else {
            System.out.println("Status: ❌ Not Eligible\n");
        }
    }

    public T getApplicant() {
        return jobApplicant;
    }
}

class ResumeScreeningSystem {
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        resume.processResume();
    }

    public static void batchScreening(List<? extends JobRole> applicants) {
        System.out.println("=== Batch Screening ===");
        for (JobRole applicant : applicants) {
            Resume<? extends JobRole> resume = new Resume<>(applicant);
            resume.processResume();
        }
    }
}


class ResumeScreeningApp {
    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("Alice", "Java Developer with Spring Boot", 3);
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        ResumeScreeningSystem.screenResume(seResume);

        DataScientist ds = new DataScientist("Bob", "Experienced in Python, ML, and Data Visualization", true);
        ProductManager pm = new ProductManager("Charlie", "Managed 5+ product launches", 4);

        List<JobRole> applicantList = new ArrayList<>();
        applicantList.add(se);
        applicantList.add(ds);
        applicantList.add(pm);

        ResumeScreeningSystem.batchScreening(applicantList);
    }
}
