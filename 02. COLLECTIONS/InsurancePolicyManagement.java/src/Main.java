import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}

class InsurancePolicyManagement {

    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies in HashSet:");
        hashSetPolicies.forEach(System.out::println);

        System.out.println("All Policies in LinkedHashSet:");
        linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("All Policies in TreeSet:");
        treeSetPolicies.forEach(System.out::println);
    }

    public void displayExpiringPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("Policies Expiring Soon (next 30 days):");
        for (Policy policy : hashSetPolicies) {
            if (policy.getExpiryDate().isBefore(today.plusDays(30))) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("Policies with coverage type: " + coverageType);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void comparePerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            addPolicy(new Policy("POL" + i, "Policyholder" + i, LocalDate.now().plusDays(i), "Health", 1000));
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken to add 1000 policies (NanoSeconds): " + (endTime - startTime));

        startTime = System.nanoTime();
        hashSetPolicies.contains(new Policy("POL500", "Policyholder500", LocalDate.now().plusDays(500), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("Time taken to search a policy in HashSet (NanoSeconds): " + (endTime - startTime));

        startTime = System.nanoTime();
        hashSetPolicies.remove(new Policy("POL500", "Policyholder500", LocalDate.now().plusDays(500), "Health", 1000));
        endTime = System.nanoTime();
        System.out.println("Time taken to remove a policy from HashSet (NanoSeconds): " + (endTime - startTime));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement ipm = new InsurancePolicyManagement();

        ipm.addPolicy(new Policy("POL123", "Alice", LocalDate.of(2025, 5, 30), "Health", 2000));
        ipm.addPolicy(new Policy("POL124", "Bob", LocalDate.of(2023, 6, 15), "Auto", 1500));
        ipm.addPolicy(new Policy("POL125", "Charlie", LocalDate.of(2023, 12, 25), "Home", 1000));
        ipm.addPolicy(new Policy("POL126", "David", LocalDate.of(2024, 7, 1), "Health", 2500));

        ipm.displayAllPolicies();

        ipm.displayExpiringPolicies();

        ipm.displayPoliciesByCoverage("Health");

        ipm.comparePerformance();
    }
}
