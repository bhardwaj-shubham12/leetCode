class LRUCache {
    class ListNode{
        int key, value;
        ListNode left,right;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Map<Integer, ListNode> keyMap;
    ListNode head,tail;
    int numNodes;
    int capacity;
    public LRUCache(int capacity) {
        keyMap = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.right = tail;
        tail.left = head;
        numNodes = 0;
        this.capacity = capacity;
    }

    void moveToFront(ListNode res){
        ListNode leftNode,rightNode;

        leftNode = res.left;
        rightNode = res.right;

        leftNode.right = rightNode;
        rightNode.left = leftNode;

        res.right = head.right;
        head.right.left = res;
        res.left = head;
        head.right = res;
    }
    /*
    void printList(){
        ListNode temp = head;
        temp = head.right;
        while(temp != tail){
            System.out.println(temp.key +": "+ temp.value);
            temp = temp.right;
        }
        System.out.println();
    }
    */
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        ListNode res = keyMap.get(key);
        moveToFront(res);
        //printList();
        return res.value;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            ListNode res = keyMap.get(key);
            moveToFront(res);
            res.value = value;
            return;
        }
        ListNode newNode = new ListNode(key,value);
        keyMap.put(key, newNode);
        //head -> <- newNode -> <- head.right
        newNode.right = head.right;
        head.right.left = newNode;
        newNode.left = head;
        head.right = newNode;
        numNodes++;

        if(numNodes > capacity){
            ListNode last = tail.left;
            last.left.right = tail;
            tail.left = last.left;
            numNodes--;
            keyMap.remove(last.key);
        }
        //printList();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */