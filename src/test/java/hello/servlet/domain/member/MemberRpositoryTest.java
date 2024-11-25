package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRpositoryTest {

    MemberRepository memberRpository = MemberRepository.getInstance();

    @AfterEach
    public void clear(){
        memberRpository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRpository.save(member);

        //then
        Member findmember = memberRpository.findById(saveMember.getId());

        assertThat(saveMember.getId()).isEqualTo(findmember.getId());
        assertThat(saveMember).isEqualTo(findmember);
    }

    @Test
    void findAll() throws Exception{
        //given
        Member member1 = new Member("hello", 21);
        Member member2 = new Member("kim", 22);
        Member member3 = new Member("string", 23);

        //when
        memberRpository.save(member1);
        memberRpository.save(member2);
        memberRpository.save(member3);

        //then
        List<Member> findAll = memberRpository.findAll();

        assertThat(findAll.size()).isEqualTo(3);
        assertThat(findAll).contains(member1, member2, member3);
    }
}