class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>() ;
        Map<String,List<String>> sortedMap = new HashMap<String, List<String>>();

       // sort each element in the string array and create a map with common sorted string
        for (String curr : strs){
            createMap(curr,sortedMap);
        }

       
       // the sortedMap now contains all the possible anagrams set
        for ( Map.Entry<String,List<String>> l : sortedMap.entrySet() ){
            result.add(l.getValue());
        }

        return result;
    }

    
    private Map<String, List<String>> createMap(String curr,Map<String, List<String>> sortedMap) {

        char toChar[] = curr.toCharArray();
        Arrays.sort(toChar);
        String output = new String(toChar);

        if ( sortedMap.containsKey(output) ){
            sortedMap.get(output).add(curr);
        }else{
            List<String> anagramList = new ArrayList<String>();
            anagramList.add(curr);
            sortedMap.put(output,anagramList);
        }

        return sortedMap;

    }
}