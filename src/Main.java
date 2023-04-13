
public class Main {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4)))); // 1 -> 2 -> 2 -> 4
        System.out.println(size(node)); // 4
        asString(node); // [1 -> 2 -> 2 -> 4]
//
        System.out.println(getByIndex(node, 0)); // 1
        System.out.println(getByIndex(node, 3)); // 4
        System.out.println(getByIndex(node, 4)); // new IndexOutOfBoundsException
    }


    /**
     * Посчитать размер списка.
     */
    static int size(ListNode head) {
        int count = 0;
        if (head != null) {
            count++;
            while (head.next != null) {
                count++;
                head = head.next;
            }
        } else {
            return 0;
        }
        return count;
    }

    /**
     * Написать строковое представление списка в формате
     * [first_value -> second_value -> ... -> last_value]
     */
    static String asString(ListNode head) {
        ListNode iterat = head;
        StringBuilder builder = new StringBuilder();
        while (iterat != null) {
            builder.append(iterat.value);
            iterat = iterat.next;
            if (iterat == null) {
                break;
            } else
                builder.append("->");
        }
        String result = builder.toString();
        System.out.println("[" + result + "]");
        return null;
    }

    /**
     * Найти значение по индексу
     */
    static int getByIndex(ListNode head, int index) {
        if (head != null) {
            ListNode iter = head;
            int counter = 0;
            while (counter != index) {
                if (iter != null) {
                    iter = iter.next;
                    counter++;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            return iter.value;
        } else {
            throw new UnsupportedOperationException();
        }

    }
}
