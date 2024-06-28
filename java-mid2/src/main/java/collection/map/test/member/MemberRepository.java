package collection.map.test.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

  private Map<String, Member> data = new HashMap<>();

  public void save(Member member) {
    data.put(member.getId(), member);
  }

  public Member findById(String id) {
    return data.get(id);
  }

  public Member findByName(String name) {
    return data.entrySet().stream()
        .filter(m -> m.getValue().getName().equals(name))
        .map(m -> data.get(m.getKey()))
        .findFirst()
        .orElse(null);
  }

  public void remove(String id) {
    data.remove(id);
  }
}
