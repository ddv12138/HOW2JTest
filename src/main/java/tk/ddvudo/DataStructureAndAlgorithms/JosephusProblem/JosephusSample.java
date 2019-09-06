package tk.ddvudo.DataStructureAndAlgorithms.JosephusProblem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JosephusSample {
    private static Logger logger = LoggerFactory.getLogger(JosephusSample.class.getName());

    public static class node {
        int code;
        node next;

        public node(int code, node nest) {
            this.code = code;
            this.next = nest;
        }
    }

    public static void outputNodeList(node head) {
        StringBuffer buffer = new StringBuffer();
        node tmphead = head;
        buffer.append(tmphead.code + "->");
        while (head.next != tmphead) {
            buffer.append(head.next.code + "->");
            head = head.next;
        }
        logger.info(buffer.toString());
    }

    public static void main(String... args) {
        int num = 41, killnum = 3, length = num;
        //初始化单循环链表
        node head = new node(1, null);
        head.next = head;
        while (num > 1) {
            node tmp = new node(num, head.next);
            head.next = tmp;
            num--;
        }
        outputNodeList(head);
        playJosephus(head, killnum, length);
    }

    private static void playJosephus(node head, int killnum, int length) {
        int initCount = 1;
        while (length > 1) {
            if (initCount == 2) {
                logger.info("node " + head.next.code + " is out");
                head.next = head.next.next;
//                outputNodeList(head);
                initCount = 0;
                length--;
            }
            head = head.next;
            initCount++;
        }
        logger.info("last one is " + head.code);
    }
}
