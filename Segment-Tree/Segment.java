class Segment{
    int[] seg;
    Segment(int n){
        seg = new int[4*n];
    }

    void build(int nodeIdx, int left,int right,int []nums){
        if(left==right){
            seg[nodeIdx]=nums[left];
            return;
        }

        int  mid = left+(right-left)/2;
        build(2*nodeIdx+1,left,mid,nums);
        build(2*nodeIdx+2,mid+1,right,nums);
        seg[nodeIdx] = seg[2*nodeIdx+1]+seg[2*nodeIdx+2];
    }

    int query(int nodeIdx,int ql,int qr,int numsLeft,int numsRight){
        if(numsLeft>=ql && numsRight<=qr) return seg[nodeIdx];

        if(numsRight<ql || numsLeft>qr) return 0;

        int mid = numsLeft+(numsRight-numsLeft)/2;

        return query(2*nodeIdx+1,ql,qr,numsLeft,mid) + query(2*nodeIdx+2,ql,qr,mid+1,numsRight);
    }
    
}

import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Size of Array:- ");
        int n = sc.nextInt();
    }
}