class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Double> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i + k - 1 >= nums.length){
                break;
            }
            int[] cloneArr = nums.clone();
            int[] windowRange = Arrays.copyOfRange(cloneArr,i, k + i);
            Arrays.sort(windowRange);
            if(k % 2 == 0){ // k is even
                int mid = windowRange.length / 2;
                double a = (double) windowRange[mid];
                double b = (double) windowRange[mid - 1];
                res.add((double) (a + b) / 2);
            } else {
                res.add((double) windowRange[windowRange.length / 2]);
            }
            
        }
        double[] medianOfK = new double[res.size()];
        for(int i = 0; i < res.size(); i++){
            medianOfK[i] = res.get(i);
        }
        return medianOfK;
    }
}