package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> findAll = memberRepository.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("list", findAll);

        return modelView;
    }
}
