import java.util.Stack;

public class NextLargestElement {

    public static void main(String[] args) {
        NextLargestElement test = new NextLargestElement();
        int[] arr = {6,5,4,3,2,1,7};
        int[] ans = test.nle(arr);
        for (int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
    }

    public int[] nle(int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] nle = new int[nums2.length];
        for (int i=nums2.length-1; i>=0; i--) {
            if (stack.isEmpty()) {
                nle[i] = -1;
            } else {
                if (stack.peek() > nums2[i]) {
                    nle[i] = stack.peek();
                } else {
                    while(!stack.isEmpty() && stack.peek() <= nums2[i])  {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        nle[i] = -1;
                    } else {
                        nle[i] = stack.peek();
                    }
                }
            }
            stack.push(nums2[i]);
        }
        return nle;
    }
}
