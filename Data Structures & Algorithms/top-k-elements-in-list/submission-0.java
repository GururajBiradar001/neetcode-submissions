class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freqMap.get(a), freqMap.get(b))
        );

        for(int num : freqMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int idx = 0;
        while(!minHeap.isEmpty()){
            result[idx++] = minHeap.poll();
        }
        return result;

    }
}
