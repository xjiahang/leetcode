    https://leetcode.com/problems/k-closest-points-to-origin
    
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxPQ = new 
            PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));
        for (int[] point : points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k)
                maxPQ.poll();
        }
        
        while (!maxPQ.isEmpty()) {
            res[--k] = maxPQ.poll();
        }
        return res; 
    }



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length - 1,  k);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void quickselect(int[][] points, int left, int right, int k) {
        if (left >= right)
            return;
        
        int index = partition(points, left, right);
        int curK = index - left + 1;
        if (curK == k)
            return;
        else if  (curK > k)
            quickselect(points, left, index - 1, k);
        else
            quickselect(points, index + 1, right, k - curK);
    }
    
    private int partition(int[][] points, int left, int right) {
        int pivot = getDis(points[right]);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (getDis(points[j]) <= pivot) {
                i++;
                swap(points, i, j);
            }
        }
        
        swap(points, i+1, right);
        return i + 1;
    }
    
    private int getDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i , int j) {
        int[] cur = points[i];
        points[i] = points[j];
        points[j] = cur;
    }
}
