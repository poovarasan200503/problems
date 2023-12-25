class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l=0;
        int r=matrix[0].length-1;
        int t=0;
        int b=matrix.length-1;
        ArrayList<Integer>li=new ArrayList <>();
        while(t<=b&&l<=r)
        {
            for(int i=l;i<=r;i++)
            {
                li.add(matrix[t][i]);
            }
            t++;
            for(int i=t;i<=b;i++)
            {
                li.add(matrix[i][r]);
            }
            r--;
            if(t<=b)
            {
                for(int i=r;i>=l;i--)
                {
                    li.add(matrix[b][i]);
                }
                b--;
            }
            if(r>=l)
            {
                for(int i=b;i>=t;i--)
                {
                    li.add(matrix[i][l]);
                }
                l++;
            }
        }
        return li;
    }
}
