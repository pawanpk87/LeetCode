class NumberContainers {
	Map<Integer, Integer> indexNumMap;
	Map<Integer, SortedSet<Integer>> numIndexMap;

    public NumberContainers() {
        indexNumMap = new HashMap<>();
        numIndexMap = new HashMap<>();
    }
   
    public void change(int index, int number) {
		if(indexNumMap.containsKey(index)) {
			int prevNum = indexNumMap.get(index);
           
            numIndexMap.get(prevNum).remove(index);
            if(numIndexMap.get(prevNum).isEmpty()) {
                numIndexMap.remove(prevNum);
            }
		}

        indexNumMap.put(index, number);

		numIndexMap.putIfAbsent(number, new TreeSet<Integer>());
		numIndexMap.get(number).add(index);
    }
   
    public int find(int number) {
		if(!numIndexMap.containsKey(number)) {
			return -1;
		}
		return numIndexMap.get(number).first();
    }
}