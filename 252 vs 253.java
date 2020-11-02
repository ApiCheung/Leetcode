//252 vs 253


	//给开始的时间和结束的时间进行排序
	//把start和end的时间放进两个数组分别排序
class Solution {
   public boolean canAttendMeetings(int[][] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 1;
        int j = 0;
        while(i < start.length){
            if(start[i] < end[j]){
                return false;
            }else{
                i++;
                j++;
            }
        }
        
        return true;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int res = 1;
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 1;
        int j = 0;
        while(i < intervals.length){
            if(start[i] < end[j]){
                res++;
                i++;
                
            }else if(start[i] >= end[j]){
                i++;
                j++;
            }
                
        }
        
      
        return res ;
    }
}