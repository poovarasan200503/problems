public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>>list=new ArrayList<>();
        HashMap<String,List<String>>mp=new HashMap<>();
        for(String str:strs)
        {
            char[]arr=str.toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            if(mp.containsKey(temp))
            {
                mp.get(temp).add(str);
            }
            else
            {
                mp.put(temp,new ArrayList<>());
                mp.get(temp).add(str);
            }
        }
        for(Map.Entry<String,List<String>>em:mp.entrySet())
        {
            list.add(em.getValue());
        }
        return list;
