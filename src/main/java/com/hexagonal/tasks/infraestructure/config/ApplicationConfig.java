package com.hexagonal.tasks.infraestructure.config;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.*;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskUseInfoCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infraestructure.adapters.ExternalServiceAdapter;
import com.hexagonal.tasks.infraestructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskUseInfoCase getAdditionalTaskUseInfoCase) {
        return new TaskService(
                new CreateTaskUseCaseImp(taskRepositoryPort),
                new RetrieveTaskUseCaseImp(taskRepositoryPort),
                new UpdateTaskUseCaseImp(taskRepositoryPort),
                new DeleteTaskUseCaseImp(taskRepositoryPort),
                getAdditionalTaskUseInfoCase
        );

    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskUseInfoCase getAdditionalTaskUseInfoCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpCase(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }


}
