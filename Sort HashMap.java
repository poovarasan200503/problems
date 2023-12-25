class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)+1);
            }
            else
            {
                hm.put(ch,1);
            }
        }
        List<Map.Entry<Character,Integer>>li=new ArrayList<>();
        for(Map.Entry<Character,Integer>me:hm.entrySet())
        {
            li.add(me);
        }

        Comparator<Map.Entry<Character,Integer>>com=new Comparator<>()
        {
            x @Override
            public int compare(Map.Entry<Character,Integer>o1,Map.Entry<Character,Integer>o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        Collections.sort(li,com);

        HashMap<Character,Integer>hm2=new LinkedHashMap<>();
        for(Map.Entry<Character,Integer>me2:li)
        {
            hm2.put(me2.getKey(),me2.getValue());
        }
        String str="";
        for(Map.Entry<Character,Integer>me3:hm2.entrySet())
        {
            for(int i=0;i<me3.getValue();i++)
            {
                str+=me3.getKey();
            }
        }
        return str;
    }
}
