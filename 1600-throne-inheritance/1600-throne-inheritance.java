class ThroneInheritance {

    // Stores parent -> children
    Map<String, List<String>> family = new HashMap<>();

    // Stores whether a person is dead
    Set<String> dead = new HashSet<>();

    String kingName;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        family.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.put(childName, new ArrayList<>());

        family.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();

        dfs(kingName, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person if alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children in birth order
        for (String child : family.get(person)) {
            dfs(child, result);
        }
    }
}