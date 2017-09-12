package beautynote.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ContextInitializer implements ServletContextListener {
	private static final Logger                loMeLogger         = Logger.getLogger(ContextInitializer.class);
	
	public ContextInitializer(){};
	/**
     * 시스템 구동 시 시작되는 메소드
     */
    public void contextInitialized(ServletContextEvent contextEvent) {
    	loMeLogger.info("========================= BeautyNote System Start =========================");
    	loMeLogger.info("========================= 여기서 static 변수선언하면 됨 =========================");
    } 
    
    public void contextDestoryed(ServletContextEvent contextEvent) {}

    /**
     * 시스템 종료 시 시작되는 메소드
     */
    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
    	loMeLogger.info("========================= BeautyNote System End  =========================");
    }
}
