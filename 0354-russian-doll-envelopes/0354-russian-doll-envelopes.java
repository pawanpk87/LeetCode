class Envelope {
    public int w;
    public int h;
    
    public Envelope(int w, int h) {
        this.w = w;
        this.h = h;
    }
}

class Solution {
    private int lowerBound(List<Integer> arr, int targetNum) {
        int left = 0, right = arr.size() - 1;
        while(left != right) {
            int mid = (left + right)/2;
            if(arr.get(mid) < targetNum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        List<Envelope> enp = new ArrayList<>();
        
        for(int[] envelope : envelopes) {
            enp.add(new Envelope(envelope[0], envelope[1]));
        }
        
        Collections.sort(enp, new Comparator<Envelope>() {
            @Override
            public int compare(Envelope e1, Envelope e2) {
                if(e1.w < e2.w) {
                    return -1;
                } else if(e1.w > e2.w) {
                    return 1;
                } else {
                    return e2.h - e1.h;
                }
            }
        });
        
        List<Integer> increasingSizeEnvelopes = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(increasingSizeEnvelopes.size() == 0 ||
               increasingSizeEnvelopes.get(increasingSizeEnvelopes.size() -1) < enp.get(i).h) {
                increasingSizeEnvelopes.add(enp.get(i).h);
            } else {
                int index = lowerBound(increasingSizeEnvelopes, enp.get(i).h);
                increasingSizeEnvelopes.set(index, enp.get(i).h);
            }
        }
        
        for(int height : increasingSizeEnvelopes) {
            System.out.println(height);
        }
        
        return increasingSizeEnvelopes.size();
    }
}


/*


    [[5,4],[6,4],[6,7],[2,3]]
    
    
    [2, 3] [5, 4] [6, 4] [6, 7]
    
    
    
    [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
    
    
    
    
    [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
    
    [[2,100],[3,200],[4,300],[5,250],[5,400],[5,500],[6,360],[6,370],[7,380]]
    
    
    {100, 200, 250, 360, 370, }
    
    
    100
200
250
360
370
380
    
    
    
    
    
    
    
    
    
    
    
    
    
    



*/