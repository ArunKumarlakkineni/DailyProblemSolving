class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[2], a[2]));
        for(int i=0;i<classes.length;i++){
            // double[] temp = new double[3];
            double pass = classes[i][0];
            double total =classes[i][1];
            double inc =(pass+1.0)/(total+1.0)-(pass/total);
            maxHeap.offer(new double[]{pass,total,inc});
        }
        for(int i=0;i<extraStudents;i++){
            double[] top = maxHeap.poll();
            double pass = top[0]+1;
            double total = top[1]+1;
            double inc = (pass+1.0)/(total+1.0) -(pass/total);
            maxHeap.offer(new double[]{pass,total,inc});
        }
        double sum = 0;
        Object[] arr = maxHeap.toArray();
        for(int i=0;i<arr.length;i++){
            double[] c = (double[]) arr[i];
            sum+= c[0]/c[1];
        }
        return sum / classes.length;
    }
}