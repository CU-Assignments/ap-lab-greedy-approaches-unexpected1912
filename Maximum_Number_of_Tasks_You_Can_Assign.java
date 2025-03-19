class Solution {
    static int firstPowerguy(int w[],int s,int reqstrength){
        for(int i=0;i<w.length;i++){
            if(w[i]==-1)
                continue;
            else if(w[i]+s>=reqstrength){
                return i;
            }
        }
        return -1;
    }
    static boolean canThisMuchTaskBeDone(int mid,int workers[],int tasks[],int pills,int strength){
        int end=workers.length-1;
        while(mid>0){
            if(workers[end]==-1){
                end--;
                continue;
            }
           if(tasks[mid-1]<=workers[end]){
                end--;
                mid--;
           }
            else{
               if(pills<=0)
                   return false;
                else{
                   
                    int ind=firstPowerguy(workers,strength,tasks[mid-1]);
                    if(ind!=-1){
                        pills--;
                        tasks[mid-1]=-1;
                        mid--;
                        workers[ind]=-1;
                        
                    }
                    else{
                        return false;
                    }
                }
            }        
       }
        return true;
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int low=0;
        int high=Math.min(tasks.length,workers.length);
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
             int wc[]=Arrays.copyOf(workers,workers.length);
             int tc[]=Arrays.copyOf(tasks,tasks.length);
           if(canThisMuchTaskBeDone(mid,wc,tc,pills,strength)){
                low=mid+1;      
                ans=mid;
           }    
         else{

                high=mid-1;
            }
        }
        return ans;
    }
}