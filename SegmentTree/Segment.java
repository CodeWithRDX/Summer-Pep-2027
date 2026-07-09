public class Segment{
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

    void update(int nodeIdx,int numsLeft,int numsRight,int idx,int val){
        if(numsLeft==numsRight){
            seg[nodeIdx]=val;
            return;
        }

        int mid = numsLeft+(numsRight-numsLeft)/2;

        if(idx<=mid) update(2*nodeIdx+1,numsLeft,mid,idx,val);
        else update(2*nodeIdx+2,mid+1,numsRight,idx,val);

        seg[nodeIdx] = seg[2*nodeIdx+1]+seg[2*nodeIdx+2];
    }

}
