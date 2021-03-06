package es.agustruiz.solarforecast.scheduler;

import es.agustruiz.solarforecast.bean.OpenWeatherMapBean;
import es.agustruiz.solarforecast.model.manager.LogLineManager;
import es.agustruiz.solarforecast.service.apiClients.OpenWeatherMapClient;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
@Component
@Configuration
@EnableScheduling
public class OpenWeatherMapScheduler implements SchedulingConfigurer {

    protected static final String LOG_TAG = OpenWeatherMapScheduler.class.getName();

    @Autowired
    LogLineManager logManager;

    @Autowired
    OpenWeatherMapBean bean;
    
    @Autowired
    OpenWeatherMapClient client;

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(100);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar str) {

        Runnable runnable = () -> {
            client.QueryAllForecasts();
        };

        Trigger trigger = (TriggerContext triggerContext) -> {
            Calendar nextExecutionTime = new GregorianCalendar();
            Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
            nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
            nextExecutionTime.add(Calendar.MILLISECOND, bean.getQueryFrequency());
            return nextExecutionTime.getTime();
        };

        str.setScheduler(taskExecutor());
        str.addTriggerTask(runnable, trigger);

    }

}
