package winter.spring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import winter.spring.domain.Member;
import winter.spring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.ClearStore();
    }

    @Test
    void 회원가입() {
        // given
        var member = new Member();
        member.setName("spring");

        // when
        var saveId = memberService.join(member);

        // then
        var findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        var member1 = new Member();
        member1.setName("spring");

        var member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        var e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        System.out.println(e);
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}