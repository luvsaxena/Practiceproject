package paymentprocessor.errorhandling;

@Aspect
@Component
public class PgRetryAspect {

    @Around("@annotation(retry")
    public Object executeWithRetry(ProceedingJoinPoint proceedingJoinPoint, PgRetry retry) throws Throwable {
        int attempts = 0;
        Throwable lastException = null;

        do {
            try{
                attempts++;
                return proceedingJoinPoint.proceed();
            }
            catch (Throwable e) {
                lastException = e;

                if(attempts >= retry.times()){
                    break;
                }

                //wait for retry interval
                Thread.sleep(retry.delay());
            }

        }while (attempts < retry.times());

        throw lastException;

    }


}
