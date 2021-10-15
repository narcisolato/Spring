package winter.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import winter.spring.repository.MemberRepository;
import winter.spring.repository.MemoryMemberRepository;
import winter.spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
