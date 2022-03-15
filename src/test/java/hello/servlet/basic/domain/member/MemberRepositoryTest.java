package hello.servlet.basic.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MemberRepositoryTest 클래스")
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void tearDown() {
        memberRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.finedById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
