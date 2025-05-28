package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberReopsitory memberReopsitory;

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
}
