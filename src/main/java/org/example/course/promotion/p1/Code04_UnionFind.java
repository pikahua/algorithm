package org.example.course.promotion.p1;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// 并查集，实现两个方法isSameSet与union，时间复杂度O(1)
public class Code04_UnionFind {

	public static class Element<V> {
		public V value;

		public Element(V value) {
			this.value = value;
		}

	}

	// 将集合概念转换成类似元素父链表的指针，当两个元素最高代表元素相同即在同一个集合，实现方式用两个集合fatherMap与rankMap
	public static class UnionFindSet<V> {
		// key:某个元素值，value:元素所在集合
		public HashMap<V, Element<V>> elementMap;
		// key:某个元素集合，value:元素所在父集合
		public HashMap<Element<V>, Element<V>> fatherMap;
		// key:某个集合的代表元素，value:该集合大小
		public HashMap<Element<V>, Integer> rankMap;

		public UnionFindSet(List<V> list) {
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			rankMap = new HashMap<>();
			for (V value : list) {
				Element<V> element = new Element<V>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				rankMap.put(element, 1);
			}
		}

		// 给定一个元素，一直往上找，返回代表元素，同时更新沿途节点的父元素，直接指向代表元素，降低高度
		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}

		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if (aF != bF) {
					Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
					Element<V> small = big == aF ? bF : aF;
					fatherMap.put(small, big);
					rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
					rankMap.remove(small);
				}
			}
		}

	}

}
