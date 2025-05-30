package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService{

    private final MemberReopsitory memberReopsitory;

    @Autowired
    public MemberServiceImpl(MemberReopsitory memberReopsitory) {
        this.memberReopsitory = memberReopsitory;
    }

    @Override
    public void join(Member member) {
        memberReopsitory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberReopsitory.findById(memberId);
    }

    //테스트 용도
    public MemberReopsitory getMemberReopsitory() {
        return memberReopsitory;
    }
}
