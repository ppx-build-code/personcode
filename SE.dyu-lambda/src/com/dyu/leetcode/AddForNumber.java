package com.dyu.leetcode;

/**
 * @author dyu
 * @date 2018/08/10
 */
public class AddForNumber {

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        String num1 = "";
        String num2 = "";
        while (tempNode1 != null || tempNode2 != null) {
            num1 = (String.valueOf(tempNode1 == null ? 0 : tempNode1.val)).concat(num1);
            if(tempNode1 != null) tempNode1 = tempNode1.next;
            num2 = (String.valueOf(tempNode2 == null ? 0 : tempNode2.val)).concat(num2);
            if(tempNode2 != null) tempNode2 = tempNode2.next;
        }

        Integer result = Integer.valueOf(num1) + Integer.valueOf(num2);
        ListNode rNode = new ListNode(0);
        ListNode currNode = rNode;
        char [] rs = result.toString().toCharArray();
        for (int k = rs.length - 1; k >= 0; k--) {
            currNode.next = new ListNode(Integer.valueOf(String.valueOf(rs[k])));
            currNode = currNode.next;
        }
        return rNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new AddForNumber().new ListNode(1);
        ListNode l2 = new AddForNumber().new ListNode(9);
        l1.next = new AddForNumber().new ListNode(9);
        //l2.next = new AddForNumber().new ListNode(6);
        l1.next.next = new AddForNumber().new ListNode(9);
        //l2.next.next = new AddForNumber().new ListNode(8);
        //l1.next.next.next = new AddForNumber().new ListNode(9);
        //l1.next.next.next.next.next = new AddForNumber().new ListNode(9);
        //l2.next.next = new AddForNumber().new ListNode(5);
        System.out.println(new AddForNumber().addTwoNumber(l1, l2));

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(val + " -> ");
            while (next != null) {
                result.append(next.val).append(" -> ");
                next = next.next;
            }
            return result.toString();
        }
    }

}
