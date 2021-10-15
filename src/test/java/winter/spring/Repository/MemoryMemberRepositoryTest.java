package winter.spring.Repository;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import winter.spring.domain.Member;
import winter.spring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.ClearStore();
    }

    @Test
    public void Save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result =  repository.findById(member.getId()).get();

        System.out.println("result save() = " + (result == member));
        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        var member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        var member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        var result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        var member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        var member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        var result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
