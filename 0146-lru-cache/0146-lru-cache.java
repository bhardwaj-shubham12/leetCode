class LRUCache {
    class ListNode{
        int key, val;
        ListNode left,right;
        ListNode(){
            key = -1;
            val = -1;
            this.left = null;
            this.right = null;
        }
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    int numNodes = 0;
    int capacity = 0;
    Map<Integer, ListNode> keyToNodeMap;
    ListNode head;
    ListNode tail;



    public LRUCache(int capacity) {
        this.numNodes = 0;
        this.capacity = capacity;
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        this.keyToNodeMap = new HashMap<>();

        this.head = new ListNode();
        this.tail = new ListNode();

        this.head.right = this.tail;
        this.tail.left = this.head;
    }
    
    void moveTempToFirst(ListNode temp, ListNode head){
        ListNode prev = temp.left;
        ListNode next = temp.right;

        prev.right = next;
        next.left  = prev;

        temp.right = head.right;
        head.right.left = temp;
        temp.left = head;
        head.right = temp;
    }

    public int get(int key) {
        ListNode temp = keyToNodeMap.getOrDefault(key, null);
        
        if(temp == null) return -1;
        
        moveTempToFirst(temp,head);
       
        return temp.val;       
    }
    
    public void put(int key, int value) {
        ListNode temp = keyToNodeMap.getOrDefault(key, null);

        if(temp != null){
            temp.val = value;
            moveTempToFirst(temp,head);
           
            return;
        }

        temp = new ListNode(key,value);
        temp.right = head.right;
        temp.left = head;
        head.right.left = temp;
        head.right = temp;
        keyToNodeMap.put(key, temp); 

        numNodes++;

        if(numNodes > capacity){
            ListNode last = tail.left;
            last.left.right = tail;
            tail.left = last.left;
            keyToNodeMap.remove(last.key);
            numNodes --;
        }
      
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */