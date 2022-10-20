package exss1.Member;

import java.util.ArrayList;

public interface IMemberInterface {
    ArrayList<Member> list();
    void create(Member member);
    void update(Member member);
    void delete(Member member);
}
