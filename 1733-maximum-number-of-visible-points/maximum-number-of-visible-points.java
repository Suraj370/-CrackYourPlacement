class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
   List<Double> angles = new ArrayList<>();
        int observerX = location.get(0), observerY = location.get(1);
        int overlapCount = 0; 

        for (List<Integer> point : points) {
            int pointX = point.get(0), pointY = point.get(1);
          
            if (pointX == observerX && pointY == observerY) {
                overlapCount++; 
                continue; 
            }
          
            angles.add(Math.atan2(pointY - observerY, pointX - observerX));
        }

        Collections.sort(angles);

        int anglesCount = angles.size();
        for (int i = 0; i < anglesCount; ++i) {
            angles.add(angles.get(i) + 2 * Math.PI);
        }

        double threshold = angle * Math.PI / 180;

        int maxVisible = 0;

        for (int left = 0, right = 0; right < 2 * anglesCount; ++right) {
            while (left < right && angles.get(right) - angles.get(left) > threshold) {
                left++; 
            }
          
            maxVisible = Math.max(maxVisible, right - left + 1);
        }

        return maxVisible + overlapCount;
    }
}