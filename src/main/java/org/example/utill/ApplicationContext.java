package org.example.utill;


import org.example.repository.*;
import org.example.repository.impl.*;
import org.example.service.*;
import org.example.service.impl.*;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private static final ExpertRepository EXPERT_REPOSITORY;

    private static final OrderRepository ORDER_REPOSITORY;
    private static final ServiceRepository SERVICE_REPOSITORY;
    private static final SubServiceRepository SUB_SERVICE_REPOSITORY;

    private static final AdminService ADMIN_SERVICE;
    private static final CustomerService CUSTOMER_SERVICE;
    private static final ExpertService EXPERT_SERVICE;

    private static final OrderService ORDER_SERVICE;
    private static final ServiceService SERVICE_SERVICE;
    private static final SubServiceService SUB_SERVICE_SERVICE;

    static {
        ADMIN_REPOSITORY = new AdminRepositoryImpl(entityManager);
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl(entityManager);
        EXPERT_REPOSITORY = new ExpertRepositoryImpl(entityManager);
        ORDER_REPOSITORY = new OrderRepositoryImpl(entityManager);
        SERVICE_REPOSITORY = new ServiceRepositoryImpl(entityManager);
        SUB_SERVICE_REPOSITORY = new SubServiceRepositoryImpl(entityManager);
        SUB_SERVICE_SERVICE = new SubServiceServiceImpl(SUB_SERVICE_REPOSITORY);
        SERVICE_SERVICE = new ServiceServiceImpl(SERVICE_REPOSITORY);
        EXPERT_SERVICE = new ExpertServiceImpl(EXPERT_REPOSITORY);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY,SUB_SERVICE_SERVICE,SERVICE_SERVICE,EXPERT_SERVICE);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY,SUB_SERVICE_SERVICE,SERVICE_SERVICE);
        ORDER_SERVICE = new OrderServiceImpl(ORDER_REPOSITORY);


    }

    public static AdminService getAdminService() {
        return ADMIN_SERVICE;
    }

    public static CustomerService getCustomerService() {
        return CUSTOMER_SERVICE;
    }

    public static ExpertService getExpertService() {
        return EXPERT_SERVICE;
    }

    public static OrderService getOrderService() {
        return ORDER_SERVICE;
    }

    public static ServiceService getServiceService() {
        return SERVICE_SERVICE;
    }

    public static SubServiceService getSubServiceService() {
        return SUB_SERVICE_SERVICE;
    }
}
