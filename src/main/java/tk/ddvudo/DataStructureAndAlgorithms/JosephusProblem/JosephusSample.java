package tk.ddvudo.DataStructureAndAlgorithms.JosephusProblem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JosephusSample {
	private static Logger logger = LoggerFactory.getLogger(JosephusSample.class.getName());

	private static void outputNodeList(node head) {
		StringBuilder buffer = new StringBuilder();
		node tmphead = head;
		buffer.append(tmphead.code).append("->");
		while (head.next != tmphead) {
			buffer.append(head.next.code).append("->");
			head = head.next;
		}
		logger.info(buffer.toString());
	}

	public static void main(String... args) {
		int num = 42, killnum = 3, length = num;
		//初始化单循环链表
		node head = new node(1, null);
		head.next = head;
		while (num > 1) {
			head.next = new node(num, head.next);
			num--;
		}
		outputNodeList(head);
		playJosephus(head, killnum, length);
	}

	private static void playJosephus(node head, int killnum, int length) {
		int initCount = 1;
		while (length > 1) {
			if (initCount == killnum - 1) {
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

	public static class node {
		int code;
		node next;

		public node(int code, node nest) {
			this.code = code;
			this.next = nest;
		}
	}
}
