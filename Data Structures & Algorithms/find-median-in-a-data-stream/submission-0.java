class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftMaxHeap.offer(num);
        rightMinHeap.offer(leftMaxHeap.poll());

        if(leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() > rightMinHeap.size()){
            return leftMaxHeap.peek();
        }

        return  (leftMaxHeap.peek() + rightMinHeap.peek())/2.0;
    }
}
