package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberReopsitory;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberReopsitory memberReopsitory = ac.getBean("memberReopsitory", MemberReopsitory.class);

        MemberReopsitory memberRepository1 = memberService.getMemberReopsitory();
        MemberReopsitory memberRepository2 = orderService.getMemberReopsitory();

        System.out.println("memberService -> memberRepo =" +memberRepository1);
        System.out.println("orderService -> memberRepo = "+memberRepository2);
        System.out.println("memberRepo = "+memberReopsitory);

        Assertions.assertThat(memberService.getMemberReopsitory()).isSameAs(memberReopsitory);
        Assertions.assertThat(orderService.getMemberReopsitory()).isSameAs(memberReopsitory);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+bean.getClass());
    }
}
