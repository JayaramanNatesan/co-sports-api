package com.harman.events.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}
		
    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.xyz.someapp.web package or any sub-package
     * under that.
     */
    @Pointcut("within(com.harman..web..*)")
    public void inWebLayer() {}
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void inRestfulServiceClass() {}
    
    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.xyz.someapp.service package or any sub-package
     * under that.
     */
    @Pointcut("within(com.harman..service..*)")
    public void inServiceLayer() {}

	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void inServiceClass() {}

	/**
     * A join point is in the data access layer if the method is defined
     * in a type in the com.xyz.someapp.dao package or any sub-package
     * under that.
     */
    @Pointcut("within(com.harman..repository..*)")
    public void inRepositoryLayer() {}

	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void inRepositoryClass() {}
    
    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     *
     * If you group service interfaces by functional area (for example,
     * in packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service) then
     * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
     * could be used instead.
     *
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* com.harman..services.*.*(..))")
    public void serviceOperation() {}

    /**
     * A data access operation is the execution of any method defined on a
     * dao interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* com.harman..repository.*.*(..))")
    public void repositoryOperation() {}
    
    /*
     * In restful service methods
     */
    @Pointcut("execution(* com.harman..web.*.*(..))")
    public void restfulOperation() {}

    /*
     * In any layer entry points
     */
    @Pointcut("restfulOperation() || serviceOperation() || repositoryOperation()")
    public void atLayerEntryPoints() {}    
}
