class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
    }

    // index 번째 노드를 반환하는 메서드
    public Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // 첫번째 위치에 원소를 저장하는 메서드
    public void addFirst(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);

        // 새로운 노드의 다음 노드로 해드를 지정합니다.
        newNode.next = head;

        // 헤드로 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        if (head.next == null) { // 처음으로 넣는 원소라면 tail 역시 head가 가르키는 노드
            tail = head;
        }
    }
    
    // 마지막 위치에 원소를 저장하는 메서드
    public void addLast(Object input) {
        
        
        // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if (size == 0) {
            addFirst(input);
        } else {
            // 노드를 생성합니다.
            Node newNode = new Node(input);
            // 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1 증가 시킵니다.
            size++;
        }
    }
    
    
    // i번째 위치에 원소를 저장하는 메서드
    public void add(int i, Object input) {
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
        if (i == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(i - 1);
            // i 번째 노드를 temp2로 지정합니다.
            Node temp2 = temp1.next;

            // 새로운 노드를 생성합니다.
            Node newNode = new Node(input);

            // temp1의 다음 노드로 새로운 노드를 지정합니다.
            temp1.next = newNode;

            // 새로운 노드의 다음 노드로 temp2를 지정합니다.
            newNode.next = temp2;
            size++;

            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다. 주의
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    // 원소 내용을 출력하는 메서드
    public String toString() {
       t
    }
    
    
    // 첫번째 위치의 원소를 제거하는 메서드
    public Object removeFirst() {
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;

        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        size--;

        return returnData;
    }

    // i번째 위치의 원소를 제거하는 메서드
    public Object remove(int i) {
        if (i == 0)
            return removeFirst();

        // k-1번째 노드를 temp의 값으로 지정합니다.
        Node temp = node(i - 1);

        // 삭제 노드를 todoDeleted에 기록해 둡니다.
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.
        Node todoDeleted = temp.next;

        // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
        temp.next = temp.next.next;

        // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
        Object returnData = todoDeleted.data;
        if (todoDeleted == tail) { // 주의
            tail = temp;
        }

        // cur.next를 삭제 합니다.
        todoDeleted = null;
        size--;
        return returnData;

    }

    // 마지막 위치의 원소를 제거하는 메서드
    public Object removeLast() {
        return remove(size - 1);
    }

    // 연결리스트 크기를 반환하는 메서드
    public int size() {
        return size;
    }

    // i번째 위치의 노드 데이터를 반환하는 메서드
    public Object get(int i) {
        Node temp = node(i);
        return temp.data;
    }

    // 노드 데이터의 위치를 반환하는 메서드
    public int indexOf(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = head;

        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;

        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while (temp.data != data) {
            temp = temp.next;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if (temp == null)
                return -1;
        }

        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
        return index;
    }

}

public class Main {
    public static void main(String[] args) {
        LinkedList items = new LinkedList();

        items.addFirst(1);
        items.addFirst(2);
        items.addFirst(3);
        System.out.println(items.toString());  // 3, 2, 1

        items.removeLast();
        items.removeFirst();
        System.out.println(items.toString()); // 2

        items.add(0, 1);
        items.add(1, 3);
        items.add(3, 4);
        System.out.println(items.toString()); // 1, 3, 2, 4

        items.remove(1);
        System.out.println(items.toString()); // 1, 2, 4

        items.addLast(3);
        System.out.println(items.toString()); // 1, 2, 4, 3

        System.out.println(items.get(1)); // 2

        System.out.println(items.indexOf(2)); // 1

    }
}
