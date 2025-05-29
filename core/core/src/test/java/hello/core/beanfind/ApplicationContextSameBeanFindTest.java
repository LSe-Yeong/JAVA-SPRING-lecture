package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberReopsitory;
import hello.core.member.MemoryMemberRepository;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplication() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberReopsitory.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberReopsitory memberRepository = ac.getBean("memberRepository1", MemberReopsitory.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberReopsitory.class);
    }

    @Test
    @DisplayName("특정 타입 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberReopsitory> beansOfType = ac.getBeansOfType(MemberReopsitory.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("key = "+ s + " value = "+beansOfType.get(s));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberReopsitory memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberReopsitory memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}
