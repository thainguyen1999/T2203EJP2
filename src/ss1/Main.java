package ss1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hs= new HashSet<>();
        hs.add("hi");
        hs.add("hi hi");
        hs.add("hi hi");
        hs.add("hi");
        for (String s:hs){
            System.out.println(s);
        }
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        System.out.println("number:"+numbers);

        int first = numbers.peek();
        System.out.println("first:"+first);
        System.out.println("total:"+numbers.size());
        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());
        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());
        System.out.println("Poll:"+numbers.poll()+" remain:"+numbers.size());

    PriorityQueue<Student> st= new PriorityQueue<>(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.getMark()- o1.getMark();
        }

    });
    st.add(new Student("ntn",1));
    st.add(new Student("ntt",2));
    st.add(new Student("nte",3));
    st.add(new Student("ntr",4));

    Student s;
    while (st.size()>0){
        s = st.poll();
        System.out.println("sv:"+ s.getName()+" didemr thi:"+s.getMark());
    }
        HashMap<String,Integer> hm= new HashMap<>();
    hm.put("good",10);
    hm.put("bad",1);
        System.out.println("tiêu chuẩn sv xs là điểm thi phải đạt:"+hm.get("good"));
        System.out.println(hm.keySet());
        System.out.println(hm.values());
}}
