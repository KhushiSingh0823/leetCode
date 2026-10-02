class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int n2: nums2){
            set.add(n2);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for( int n1: nums1){
            if(set.contains(n1)){
                list.add(n1);
                set.remove(n1);
            }
        }

        int res[] = new int[list.size()];
        int j = 0;
        for(int i : list){
            res[j++] = i;
        }

        return res;
    }
}