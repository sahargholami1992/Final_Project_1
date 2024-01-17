package org.example;

import org.example.entity.*;
import org.example.entity.enumaration.ExpertStatus;
import org.example.service.*;
import org.example.service.dto.CustomerRegisterDto;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.dto.OrderDto;
import org.example.utill.ApplicationContext;
import org.example.utill.SecurityContext;
import org.example.utill.Validation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminService adminService = ApplicationContext.getAdminService();
        CustomerService customerService = ApplicationContext.getCustomerService();
        ExpertService expertService = ApplicationContext.getExpertService();
        SubServiceService subServiceService = ApplicationContext.getSubServiceService();
        ServiceService serviceService = ApplicationContext.getServiceService();
        OrderService orderService = ApplicationContext.getOrderService();

// ************************ REGISTER CUSTOMER ******************************************************
//        System.out.println("enter your fist name");
//        String firstName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(firstName)) {
//            System.out.println("invalid field!!!");
//            firstName = sc.nextLine();
//        }
//        System.out.println("enter your last name");
//        String lastName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(lastName)) {
//            System.out.println("invalid field!!!");
//            lastName = sc.nextLine();
//        }
//        System.out.println("enter your email");
//        String email = sc.nextLine();
//        while (!Validation.isValidEmail(email)) {
//            System.out.println("invalid field!!!");
//            email = sc.nextLine();
//        }
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//        while (!Validation.isValidPassword(password)) {
//            System.out.println("invalid field!!!");
//            password = sc.nextLine();
//        }
//        CustomerRegisterDto customerRegisterDto = new CustomerRegisterDto(firstName, lastName, email, password);
//        customerService.registerCustomer(customerRegisterDto);

        // ************************ REGISTER EXPERT ******************************************************
        System.out.println("enter your fist name");
        String firstName = sc.nextLine();
        while (!Validation.containsOnlyAlphabetsAndSpaces(firstName)){
            System.out.println("invalid field!!!");
            firstName = sc.nextLine();
        }
        System.out.println("enter your last name");
        String lastName = sc.nextLine();
        while (!Validation.containsOnlyAlphabetsAndSpaces(lastName)){
            System.out.println("invalid field!!!");
            lastName = sc.nextLine();
        }
        System.out.println("enter your email");
        String email = sc.nextLine();
        while (!Validation.isValidEmail(email)){
            System.out.println("invalid field!!!");
            email = sc.nextLine();
        }

        System.out.println("enter your password");
        String password = sc.nextLine();
        while (!Validation.isValidPassword(password)){
            System.out.println("invalid field!!!");
            password = sc.nextLine();
        }
        System.out.println("enter the image name:");
        String imageName = sc.nextLine();
        while (!Validation.isValidImage(Validation.readsImage(imageName)) || Validation.readsImage(imageName) == null ){
            imageName = sc.nextLine();
        }
        byte[] profileImage = Validation.readsImage(imageName);

        ExpertRegisterDto expertRegisterDto = new ExpertRegisterDto(firstName, lastName, email, password,profileImage);
        expertService.registerExpert(expertRegisterDto);


//  ************************* SAVE IMAGE ******************************************************
//        System.out.println("enter your email");
//        String email = sc.nextLine();
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//        try {
//            Expert expert = expertService.logIn(email, password);
//                byte[] imageData = expert.getProfileImage();
//                Validation.saveImageToFile(imageData, "src/main/resources/image.jpg");
//                System.out.println("Image saved successfully.");
//
//        }catch (NoResultException e){
//            System.out.println("no result for this user and password or you are new yet");
//        }catch (RuntimeException e){
//            System.out.println("userName or password is wrong or you are new yet");
//        }


//  ************************* CHANGE PASSWORD ******************************************************
//          System.out.println("enter your email");
//        String email = sc.nextLine();
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//        try {
//            Expert expert =  expertService.logIn(email, password);
//            System.out.println("enter new password");
//            String newPassword = sc.nextLine();
//            while (!Validation.isValidPassword(newPassword)) {
//                System.out.println("invalid field");
//                newPassword = sc.nextLine();
//            }
//            expertService.changePassword(email, newPassword);
//
//        }catch (NoResultException e){
//            System.out.println("no result for this user and password or you are new yet");
//        }catch (RuntimeException e){
//            System.out.println("userName or password is wrong or you are new yet");
//        }


//  ************************* SERVICE REGISTER ******************************************************
//          System.out.println("enter your email");
//        String email = sc.nextLine();
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//         try {
//             Admin admin = adminService.logIn(email, password);
//             SecurityContext.fillContext(admin);
//             System.out.println("enter number of default service name or enter another service name");
//             String serviceNames = """
//                1.building decoration,
//                2.building Facilities,
//                3.vehicles
//                4.moving and carrying,
//                5.home appliances,
//                6.cleaning and hygiene
//                enter another character and save another service name
//                """;
//             System.out.println(serviceNames);
//             int select = Validation.input();
//             String serviceName = null;
//             switch (select) {
//                 case 1 -> serviceName = "building decoration";
//                 case 2 -> serviceName = "building Facilities";
//                 case 3 -> serviceName = "vehicles";
//                 case 4 -> serviceName = "moving and carrying";
//                 case 5 -> serviceName = "home appliances";
//                 case 6 -> serviceName = "cleaning and hygiene";
//                 default -> {
//                     System.out.println("enter another service name");
//                     serviceName = sc.nextLine();
//
//                 }
//             }
//             while (!Validation.containsOnlyAlphabetsAndSpaces(serviceName)){
//                 System.out.println("invalid field");
//                 serviceName = sc.nextLine();
//             }
//             adminService.saveService(serviceName);
//         }catch (NoResultException e) {
//             System.out.println("no result for this user and password ");
//         }catch (IllegalArgumentException e){
//                 System.out.println("this service existed");
//         } catch (RuntimeException e){
//            System.out.println("userName or password is wrong ");
//        }



//  ************************* SubSERVICE REGISTER ******************************************************
//        System.out.println("************subService Register******************* ");
//        Admin admin = SecurityContext.getCurrentAdmin();
//         if (admin != null){
//             try {
//                 System.out.println("enter number of default service name or enter another service name");
//                 String serviceNames = """
//                1.building decoration,
//                2.building Facilities,
//                3.vehicles
//                4.moving and carrying,
//                5.home appliances,
//                6.cleaning and hygiene
//                enter another character and save another service name
//                """;
//                 System.out.println(serviceNames);
//                 int select = Validation.input();
//                 String serviceName = null;
//                 switch (select) {
//                     case 1 -> serviceName = "building decoration";
//                     case 2 -> serviceName = "building Facilities";
//                     case 3 -> serviceName = "vehicles";
//                     case 4 -> serviceName = "moving and carrying";
//                     case 5 -> serviceName = "home appliances";
//                     case 6 -> serviceName = "cleaning and hygiene";
//                     default -> {
//                         System.out.println("enter another service name");
//                         serviceName = sc.nextLine();
//                     }
//                 }
//                 while (!Validation.containsOnlyAlphabetsAndSpaces(serviceName)){
//                     System.out.println("invalid field");
//                     serviceName = sc.nextLine();
//                 }
//                 System.out.println("enter subService name");
//                 String subServiceName = sc.nextLine();
//                 while (!Validation.containsOnlyAlphabetsAndSpaces(subServiceName)){
//                     System.out.println("invalid field");
//                     subServiceName = sc.nextLine();
//                 }
//                 System.out.println("enter base price for subService");
//                 double basePrice = Validation.inputDouble();
//                 System.out.println("enter description");
//                 String description = sc.nextLine();
//                 while (!Validation.validateString(description)){
//                     System.out.println("address is blank");
//                     description = sc.nextLine();
//                 }
//                 SubService subService = new SubService();
//                 subService.setSubServiceName(subServiceName);
//                 subService.setBasePrice(basePrice);
//                 subService.setDescription(description);
//
//                 adminService.saveSubService(serviceName,subService);
//
//             }catch (IllegalArgumentException e){
//                 System.out.println("this service not exist or duplicate subService name ");
//             }
//         }else System.out.println("this admin not log In");



//  ************************* EDIT SubService ******************************************************
//        System.out.println("****************EDIT SubService************");
//        if (admin!=null){
//            adminService.ShowAllSubService().forEach(System.out::println);
//            System.out.println("enter subService name");
//            String subServiceName = sc.nextLine();
//            while (!Validation.containsOnlyAlphabetsAndSpaces(subServiceName)){
//                System.out.println("invalid field");
//                subServiceName = sc.nextLine();
//            }
//            System.out.println("enter base price for subService");
//            double price = Validation.inputDouble();
//            System.out.println("enter description");
//            String description = sc.nextLine();
//            while (!Validation.validateString(description)){
//                System.out.println("address is blank");
//                description = sc.nextLine();
//            }
//            adminService.editSubService(subServiceName,price,description);
//
//        }else System.out.println("this admin not log In");



//  ************************* SHOW ALL SERVICE AND SubSERVICE ******************************************************
//        adminService.showAllService().forEach(System.out::println);


//  ************************* CHANGE EXPERT STATUS ******************************************************
//        adminService.showAllExpert().forEach(System.out::println);
//        System.out.println("enter expert id");
//        int expertId = Validation.input();
//        try {
//            Expert expert = expertService.load(expertId);
//            adminService.changeExpertStatus(expert);
//        }catch (NullPointerException e){
//            System.out.println("Expert not found in the database.");
//        }


//  ************************* ADD EXPERT TO SubSERVICE *****************************************************************************

//        adminService.ShowAllSubService().forEach(System.out::println);
//        System.out.println("enter subService Id");
//        int subServiceId = Validation.input();
//        adminService.showAllExpert().forEach(System.out::println);
//        System.out.println("enter expert id");
//        int expertId = Validation.input();
//        try {
//            Expert expert = expertService.load(expertId);
//            SubService subService = subServiceService.load(subServiceId);
//            adminService.saveExpertForSubService(subService,expert);
//
//        }catch (NullPointerException e){
//            System.out.println("Expert or SubService not found in the database or ExpertStatus is not equals ACCEPTED ");
//        }


//  ************************* DELETE EXPERT TO SubSERVICE *******************************************************************

        adminService.ShowAllSubService().forEach(System.out::println);
        System.out.println("enter subService Id");
        int subServiceId = Validation.input();
//        adminService.showAllExpert().forEach(System.out::println);
        try {

            SubService subService = subServiceService.load(subServiceId);
            subService.getExperts().forEach(System.out::println);
            System.out.println("enter expert id");
            int expertId = Validation.input();
            Expert expert = expertService.load(expertId);
            adminService.deleteExpertFromSubService(subService,expert);
        }catch (NullPointerException e){
            System.out.println("Expert or SubService not found in the database or Expert does not have the desired subService ");
        }


//  ************************* CHANGE CUSTOMER PASSWORD ******************************************************
//        System.out.println("enter your email");
//        String email = sc.nextLine();
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//        try {
//            Customer customer = customerService.logIn(email, password);
//            SecurityContext.fillContext(customer);
//            System.out.println("enter new password");
//            String newPassword = sc.nextLine();
//            while (!Validation.isValidPassword(newPassword)) {
//                System.out.println("invalid field");
//                newPassword = sc.nextLine();
//            }
//            expertService.changePassword(email, newPassword);
//
//        } catch (NoResultException e) {
//            System.out.println("no result for this user and password or you are new yet");
//        } catch (RuntimeException e) {
//            System.out.println("userName or password is wrong or you are not accept yet");
//        }


//  ************************* REGISTER ORDER **********************************************************************************
//        Customer customer = SecurityContext.getCurrentCustomer();
//        try {
//            customerService.showAllService().forEach(System.out::println);
//            System.out.println("enter service id");
//            int serviceId = Validation.input();
//            Service service = serviceService.load(serviceId);
//            customerService.showAllSubServiceByService(service).forEach(System.out::println);
//            System.out.println("enter subService Id");
//            int subServiceId = Validation.input();
//            SubService subService = subServiceService.load(subServiceId);
//            System.out.println("enter address");
//            String address = sc.nextLine();
//            while (!Validation.validateString(address)) {
//                System.out.println("address is blank");
//                address = sc.nextLine();
//            }
//            System.out.println("enter recommended price");
//            double recommendedPrice = Validation.inputDouble();
//            System.out.println("enter description");
//            String description = sc.nextLine();
//            while (!Validation.validateString(description)) {
//                System.out.println("address is blank");
//                description = sc.nextLine();
//            }
//            System.out.print("Enter a date (yyyy-MM-dd): ");
//            String inputDate = sc.nextLine();
//            LocalDate dateDoOrder = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
//            OrderDto dto = new OrderDto(address, recommendedPrice, description, dateDoOrder);
//            orderService.registerOrder(dto, customer, subService);
//        } catch (DateTimeParseException e) {
//            System.out.println("Invalid date format. Please enter a date in yyyy-MM-dd format.");
//        } catch (NullPointerException e) {
//            System.out.println("service or SubService not found in the database ");
//        } catch (NoResultException e) {
//            System.out.println("time or price in not valid");
//        }




    }
}