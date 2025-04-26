import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", ₹" + premiumAmount + "]";
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMapByExpiry = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        treeMapByExpiry.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        List<Policy> expiring = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate in30Days = now.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : treeMapByExpiry.subMap(now, true, in30Days, true).entrySet()) {
            expiring.addAll(entry.getValue());
        }

        return expiring;
    }

    public List<Policy> getPoliciesByHolder(String name) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        List<String> toRemove = new ArrayList<>();

        for (Map.Entry<String, Policy> entry : hashMap.entrySet()) {
            if (entry.getValue().getExpiryDate().isBefore(now)) {
                toRemove.add(entry.getKey());
            }
        }

        for (String policyNumber : toRemove) {
            Policy policy = hashMap.remove(policyNumber);
            linkedHashMap.remove(policyNumber);
            treeMapByExpiry.get(policy.getExpiryDate()).remove(policy);
            if (treeMapByExpiry.get(policy.getExpiryDate()).isEmpty()) {
                treeMapByExpiry.remove(policy.getExpiryDate());
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.parse("2025-05-01", formatter), "Health", 5000));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.parse("2025-04-25", formatter), "Auto", 3000));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.parse("2025-05-10", formatter), "Home", 7000));
        manager.addPolicy(new Policy("P004", "David", LocalDate.parse("2024-12-31", formatter), "Health", 5500));
        manager.addPolicy(new Policy("P005", "Carol", LocalDate.parse("2025-04-23", formatter), "Auto", 3200));

        System.out.println("Policy P002: " + manager.getPolicyByNumber("P002"));

        System.out.println("\nPolicies expiring in next 30 days:");
        for (Policy p : manager.getExpiringPolicies()) {
            System.out.println(p);
        }

        System.out.println("\nPolicies of Alice:");
        for (Policy p : manager.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }

        manager.removeExpiredPolicies();
        System.out.println("\nAfter removing expired policies:");
        for (Policy p : manager.hashMap.values()) {
            System.out.println(p);
        }
    }
}
