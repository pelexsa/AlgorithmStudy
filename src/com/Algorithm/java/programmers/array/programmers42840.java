package com.Algorithm.java.programmers.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class programmers42840 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};
		int[] result = solution(numbers);
		for (int i : result)
			System.out.print(i + " ");
	}

	static int[] solution(int[] numbers) {
		int[] answer = new int[3];
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == student1[i%student1.length]) answer[0]++;
			if (numbers[i] == student2[i%student2.length]) answer[1]++;
			if (numbers[i] == student3[i%student3.length]) answer[2]++;
		}

		int max = Math.max(Math.max(answer[0], answer[1]), answer[2]);
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 3; i++)
			if (max == answer[i]) list.add(i + 1);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
