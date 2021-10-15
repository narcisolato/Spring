package winter.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import winter.spring.repository.JdbcMemberRepository;
import winter.spring.repository.MemberRepository;
import winter.spring.repository.MemoryMemberRepository;
import winter.spring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    private DataSource dataSource;

    @Autowired SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
