package kr.or.ddit.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingAdvice {
	public Object loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object target = joinPoint.getTarget();
		String targetName = target.getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed(args);
		long end = System.currentTimeMillis();
		log.info("========{}.{} 메소드 실행 : 소요시간 : {}ms=====================>>>>", targetName, methodName, (end-start));
		return result;
	}
}

