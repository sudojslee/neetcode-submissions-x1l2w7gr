class MedianFinder {

    PriorityQueue<Integer> leftHalf; // left half (always has median)
    PriorityQueue<Integer> rightHalf; // right half

    public MedianFinder() {
        this.leftHalf = new PriorityQueue<>(Comparator.reverseOrder());
        this.rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftHalf.isEmpty() && rightHalf.isEmpty()) {
            leftHalf.add(num);
        } else {

            if (leftHalf.peek() >= num) {
                leftHalf.add(num);
            } else {
                rightHalf.add(num);
            }
        }

        rebalance();
        
    }

    private void rebalance() {
        if (leftHalf.size() - rightHalf.size() == 1) {
            return;
        }

        if (leftHalf.size() - rightHalf.size() > 1) {
            rightHalf.add(leftHalf.poll());
        } else if (rightHalf.size() - leftHalf.size() > 0){
            leftHalf.add(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        if ((leftHalf.size() + rightHalf.size()) % 2 == 0) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else {
            return leftHalf.peek();
        }

    }
}
