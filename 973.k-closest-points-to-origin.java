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