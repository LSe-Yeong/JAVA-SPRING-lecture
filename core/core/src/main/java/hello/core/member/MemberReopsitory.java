package hello.core.member;

public interface MemberReopsitory {
    void save(Member member);

    Member findById(Long memberId);
}
