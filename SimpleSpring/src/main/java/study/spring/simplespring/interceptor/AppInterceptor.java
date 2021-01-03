package study.spring.simplespring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppInterceptor extends HandlerInterceptorAdapter
{

	long startTime, endTime;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		// TODO Auto-generated method stub
		//log.debug("preHandle 실행됨");
		startTime = System.currentTimeMillis();
		
		// 1) 클라이언트의 요청 정보 확인하기
		// 현재 URL ghlrdms
		String url = request.getRequestURL().toString();
		
		// GET방식인지, POST방식인지 조회.
		String methdName = request.getMethod();
		
		// URL에서 "?" 이후에 전달되는 GET파라미터 문자열을 모두 가져온다
		String queryString = request.getQueryString();
		
		// 가져온 값이 있따면 URL 과 결합하여 완전한 URL을 구성한다.
		
		if(queryString != null)
		{
			url = url + "?" + queryString;
		}
		
		// 획득한 정보를 로그로 표시한다.
		log.debug(String.format("[%s] %s", methdName,url));
		
		
		// 2) 클라이언트가 전달한 모든 파라미터 확인하기
		// 3) 클라이언트가 머물렀던 이전 페이지와 이전 페이지에 머문 시간 확인 하기
		
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		// TODO Auto-generated method stub
		//log.debug("postHandle 실행됨");
		endTime = System.currentTimeMillis();
		log.debug(String.format("running time : %d(ms)\n", endTime-startTime));
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		// TODO Auto-generated method stub
		log.debug("afterCompletion 실행됨");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception
	{
		// TODO Auto-generated method stub
		log.debug("afterConcurrentHandlingStarted 실행됨");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
