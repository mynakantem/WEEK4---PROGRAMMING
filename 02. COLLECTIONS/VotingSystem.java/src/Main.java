import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>();        // Candidate -> Vote count
    private LinkedHashMap<Integer, String> voteOrder = new LinkedHashMap<>(); // Vote number -> Candidate
    private int voteNumber = 1;

    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(voteNumber++, candidate);
    }

    public void displaySortedResults() {
        TreeMap<String, Integer> sorted = new TreeMap<>(voteCountMap);
        System.out.println("\n📊 Results (Sorted by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    public void displayVoteOrder() {
        System.out.println("\n🗳️ Voting Order:");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayCurrentVoteCounts() {
        System.out.println("\n📦 Current Vote Counts:");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Carol");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayCurrentVoteCounts();
        system.displayVoteOrder();
        system.displaySortedResults();
    }
}
