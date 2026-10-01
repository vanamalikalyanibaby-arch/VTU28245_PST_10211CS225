class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        // Sort people based on height in descending order
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                
                if (heights[i] < heights[j]) {
                    // Swap heights
                    int tempHeight = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tempHeight;
                    
                    // Swap corresponding names
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }
        
        return names;
    }
}