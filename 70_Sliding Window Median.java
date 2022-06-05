class Solution {
   
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result=new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(maxHeap.isEmpty() || maxHeap.peek()>=nums[i]){
                maxHeap.offer(nums[i]);
            }
            else minHeap.offer(nums[i]);
            balancedHeaps();
            if(i-k+1>=0){
                if(maxHeap.size()==minHeap.size()){
                    result[i-k+1]=maxHeap.peek()/2.0+minHeap.peek()/2.0;
                }
                else result[i-k+1]=maxHeap.peek();
                
                int itemToBeRemoved=nums[i-k+1];
                if(itemToBeRemoved<=maxHeap.peek()){
                    maxHeap.remove(itemToBeRemoved);
                }
                else minHeap.remove(itemToBeRemoved);
                balancedHeaps();
            }
           
            
        }
        return result;
    }
    
    private void balancedHeaps(){
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
}