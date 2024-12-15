class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b)->{
            return Double.compare(b[0], a[0]);
        });
        
        for(int i = 0; i < n; i++) {
            int students = classes[i][0];
            int totalStudents = classes[i][1];
            
            double gain = calculateGain(students, totalStudents);
            
            maxHeap.add(new double[]{gain, students, totalStudents});
        }
        
        while(extraStudents-- > 0) {
            double[] currSchool = maxHeap.poll();
            
            int students = (int) currSchool[1];
            int totalStudents = (int) currSchool[2];
            
            double gain = calculateGain(students + 1, totalStudents + 1);
            
            maxHeap.add(new double[]{gain, students + 1, totalStudents + 1});
        }
        
        double totalSum = 0;
        
        while(!maxHeap.isEmpty()) {
            double[] currSchool = maxHeap.poll();
            
            int students = (int) currSchool[1];
            int totalStudents = (int) currSchool[2];
            
            totalSum += (double)students/totalStudents;
        }
        
        return totalSum/n;
    }
    
    private double calculateGain(int students, int totalStudents) {
        return (
            (double)(students + 1)/(totalStudents + 1) - 
            (double) students/totalStudents
        );
    }
}