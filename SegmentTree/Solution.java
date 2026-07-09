import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of Array:- ");
        int n = sc.nextInt();

        int[]nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        Segment seg = new Segment(n);
        seg.build(0,0,n-1,nums);
        System.out.println(seg.query(0,0,n-1,0,n-1));

    }
}