package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberReopsitory;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberReopsitory());
    }

    @Bean
    public MemberReopsitory memberReopsitory() {

        System.out.println("Call AppConfig.memberReopsitory");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberReopsitory(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
