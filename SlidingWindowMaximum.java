package slidingwindowmaximum;

import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        //声明数据结构
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] ans = new int[n-k+1];
        //对边界的判断
        if(n==0){
            return null;
        }
        if(n==1){
            return nums;
        }
        int index=0;
        //开始循环加入元素
        for(int i=0;i<n;i++){
            //如果队列不空的话需要倒着比较队列中的元素与当前i位置元素的值
            //如果当前i位置的值比队尾的元素大需要将队尾的元素比他小的弹出
            //注意要用for循环
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            //将值的下标添加到队列中
            queue.addLast(i);
            //滑动窗口像后面移动时删除队列队头元素的条件
            if(queue.peekFirst()<i-k+1){
                queue.pollFirst();
            }
            //滑动窗口中的最大值进入ans数组的条件
            if(i>=k-1){
                ans[index++]=nums[queue.peekFirst()];
            }
        }

        return ans;

    }
}