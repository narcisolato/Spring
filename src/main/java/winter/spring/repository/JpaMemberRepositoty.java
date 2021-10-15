package winter.spring.repository;

import winter.spring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepositoty implements MemberRepository{

    private final EntityManager entityManager;

    public JpaMemberRepositoty(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        var member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return entityManager
                .createQuery("select m from Member as m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        var result = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        return result;

    }
}
