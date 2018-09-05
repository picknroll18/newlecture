package com.newlecture.aop.spring.anno;

import org.springframework.aop.ThrowsAdvice;

public class ErrorHandler implements ThrowsAdvice {

	// ������ ó���ϴ� �ڵ带 �ۼ��մϴ�.
	// �츮�� � ���ܰ� �߻��� �� �ִµ���. target���� �޼ҵ带 ȣ���ϴٰ�
	// ���⼭�� �� ���ܸ� �޴� ���Դϴ�.
	// �� ���ܸ� �޾Ƽ� ó���ϴ� ���Դϴ�.
	// ��, ���� ó���ϴ� ������ ����ȭ, ���

	// ó���� ���ܰ�ü �Ķ���ͷ� ���
	public void afterThrowing(ArithmeticException e) throws Throwable {
		System.out.println("ArithmeticException ���� �Դϴ�.");
	}
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("IllegalArgumentException �����Դϴ�.");
	}

}