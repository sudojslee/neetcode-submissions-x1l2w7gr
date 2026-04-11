class DynamicArray {

    int capacity;
    int size;
    List<Integer> list;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.list = new ArrayList<>();
    }

    public int get(int i) {
        return list.get(i);
    }

    public void set(int i, int n) {
        list.set(i, n);
    }

    public void pushback(int n) {
        if (this.size >= this.capacity) {
            this.resize();
        }
        list.add(n);
        this.size++;
    }

    public int popback() {
        int result = list.get(this.size - 1);
        list.remove(this.size - 1);
        this.size--;
        return result;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
