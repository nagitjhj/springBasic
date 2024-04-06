package com.study.springbasic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //저장소니까 Map 넣어서 이렇게 구현해줌 테스트용으로
    //Concurrent 해시맵을 쓰는 것이 좋은데 - 동시성이 있으니까 - 실무에서는 이거 씀
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
