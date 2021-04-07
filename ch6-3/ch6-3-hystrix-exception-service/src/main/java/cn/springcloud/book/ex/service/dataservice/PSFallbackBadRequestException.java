package cn.springcloud.book.ex.service.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class PSFallbackBadRequestException extends HystrixCommand<String>{
	private static Logger log = LoggerFactory.getLogger(PSFallbackBadRequestException.class);
	
    public PSFallbackBadRequestException() {
        super(HystrixCommandGroupKey.Factory.asKey("GroupBRE"));
    }
    
	@Override
	protected String run() throws Exception {
		 throw new HystrixBadRequestException("HystrixBadRequestException error");
	}
	
    @Override
    protected String getFallback() {
    	System.out.println(getFailedExecutionException().getMessage());
        return "invoke HystrixBadRequestException fallback method:  ";
    }
	
	
}
