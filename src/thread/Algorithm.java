package thread;

import java.util.Random;

/**
 * Created by fengshiwei on 2018/9/19.
 */
public class Algorithm {

	static int number = 0;

	public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 6, 8};
//        int[] arr2 = {5, 3, 1, 7, 4};
//        int[] arr3 = {5, 3, 1, 7, 4};
		int[] arr4 = {5, 3, 3, 3, 3, 3};
		int[] arr5 = {5, 3, 3, 7, 2, 4, 5};
		Random random = new Random();

		int[] total = new int[5000];
		for (int j = 0; j < 5000; j++) {
			total[j] = random.nextInt(5000);
		}
//        binarySearch(a, arr);
		//选择排序
//        long l = System.currentTimeMillis();
//        chooseSort(total);
//        long l1 = System.currentTimeMillis();
//        System.out.println("选择排序用时:" + (l1 - l));

		long l2 = System.currentTimeMillis();
		shellSort(total);
		long l3 = System.currentTimeMillis();
		System.out.println("希尔排序:" + (l3 - l2));

//        shellSort2(total);

		long l4 = System.currentTimeMillis();
		mergeSort(total);
		long l5 = System.currentTimeMillis();
		System.out.println("归并排序:" + (l5 - l4));

		long l6 = System.currentTimeMillis();
		quickSort(arr5);
		long l7 = System.currentTimeMillis();
		System.out.println("快速排序:" + (l7 - l6));
	}

	//插入排序,蠢比方法，慢的不行哇
	private static void insertSort(int[] arr3) {
		for (int i = 1; i < arr3.length; i++) {
			//抽出一个数依次和前面比较
			int temp = arr3[i];
			//当抽出的数字大于前面一个时跳出循环
			while (i > 0 && temp <= arr3[i - 1]) {
				//小于的话，将这个数字往后移动一个
				arr3[i] = arr3[i - 1];
				//将当前数字依次和前面的数字进行比较
				i--;
			}
			//跳出循环 将当前数字放到抽出来的位置
			arr3[i++] = temp;
		}
	}

	//选择排序,将相邻的两个数进行比较，交换位置
	private static void chooseSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				//相邻的两个进行比较
				if (arr[i] > arr[j]) {
					//换位置
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	//二分查找
	private static int binarySearch(int a, int[] arr) {
		int max = arr.length - 1;//4
		int min = 0;//0
		while (min <= max) {
			int mid = (max + min) / 2;
			if (a > arr[mid]) {
				min = mid + 1;
			} else if (a < arr[mid]) {
				max = mid - 1;
			} else {
				return a;
			}
		}
		return -1;
	}

	//这辈子不可能懂的
	private static void mergeSort(int[] arr) {
		//arr:要排序的数组， temp：临时数组，左索引 右索引
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
			//int[] arr5 = {5, 3}; 0 1
			int center = (left + right) / 2;
			//拆分成每个数组就一个数 就相当于自动排序了
			mergeSort(arr, temp, left, center); // 左边
			mergeSort(arr, temp, center + 1, right); // 右边
			//依次合并
			merge(arr, temp, left, center + 1, right); // 合并两个有序
		}
	}

	private static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1; // 左边结束下标
		int tempPos = leftPos; // 从左边开始算
		int numEle = rightEnd - leftPos + 1; // 元素个数
		//左边和右边依次比较放入临时数组中去
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (arr[leftPos] <= arr[rightPos])
				temp[tempPos++] = arr[leftPos++];
			else
				temp[tempPos++] = arr[rightPos++];
		}
		while (leftPos <= leftEnd) {  // 右边的全部都放完了，左边如果有剩余，则将左边的全部放入临时数组
			temp[tempPos++] = arr[leftPos++];
		}
		while (rightPos <= rightEnd) { // 右边如果有剩余
			temp[tempPos++] = arr[rightPos++];
		}
		// 将temp复制到arr
		for (int i = 0; i < numEle; i++) {
			arr[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}

	//贼恐怖，贼难，内循环参考插入排序
	private static void shellSort(int[] arr4) {
		int length = arr4.length;
		for (int step = length / 2; step > 0; step = step / 2) {
			//从增量那组开始的那条数据进行插入排序
			for (int i = step; i < arr4.length; i++) {
				int j = i;
				int temp = arr4[j];
				// j - step 就是代表与它同组隔壁的元素
				while (j - step >= 0 && arr4[j - step] > temp) {
					arr4[j] = arr4[j - step];
					//依次和同组前面的元素进行比较
					j = j - step;
				}
				arr4[j] = temp;
			}
		}
	}

	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	//快速排序法,这个效率好像还没有希尔排序的效率高
	public static void sort(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		//进行第一轮排序获取分割点
		int index = partition(array, lo, hi);
		//排序前半部分
		sort(array, lo, index - 1);
		//排序后半部分
		sort(array, index + 1, hi);
		System.out.println(1);

	}

	//进行切分并返回 int[] arr5 = {5, 3, 3, 7, 2, 4, 5};
	public static int partition(int[] array, int lo, int hi) {
		int key = array[lo];//选取了基准点
		while (lo < hi) {
			//从后半部分向前扫描
			while (array[hi] >= key && hi > lo) {
				hi--;
			}
			array[lo] = array[hi];
			//从前半部分向后扫描
			while (array[lo] <= key && hi > lo) {
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;//最后把基准存入
		return hi;
	}
}
