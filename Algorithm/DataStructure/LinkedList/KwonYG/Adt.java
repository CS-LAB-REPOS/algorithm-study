class LinkedList {
    Node head;
    Node tail;
    int size = 0; // add 할 때마다 넣는거 까먹지좀 마셈

    private class Node {
        Object data;
        Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
    }

    // index 번째 노드를 반환하는 메서드
    public Node node(int index) {

    }

    // 첫번째 위치에 원소를 저장하는 메서드
    public void addFirst(Object input) {

    }

    // 마지막 위치에 원소를 저장하는 메서드
    public void addLast(Object input) {

    }

    // i번째 위치에 원소를 저장하는 메서드
    public void add(int i, Object input) {

    }

    // 원소 내용을 출력하는 메서드
    public String toString() {

    }


    // 첫번째 위치의 원소를 제거하는 메서드
    public Object removeFirst() {

    }

    // i번째 위치의 원소를 제거하는 메서드
    public Object remove(int i) {

    }

    // 마지막 위치의 원소를 제거하는 메서드
    public Object removeLast() {

    }

    // 연결리스트 크기를 반환하는 메서드
    public int size() {

    }

    // i번째 위치의 노드 데이터를 반환하는 메서드
    public Object get(int i) {

    }

    // 노드 데이터의 위치를 반환하는 메서드
    public int indexOf(Object data) {

    }

}

public class Adt {
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
