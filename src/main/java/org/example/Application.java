package org.example;

import org.example.entity.*;
import org.example.entity.enumaration.ExpertStatus;
import org.example.service.*;
import org.example.service.dto.CustomerRegisterDto;
import org.example.service.dto.ExpertRegisterDto;
import org.example.service.dto.OrderDto;
import org.example.utill.ApplicationContext;
import org.example.utill.Validation;

import javax.persistence.EntityManager;
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
//        System.out.println("enter your fist name");
//        String firstName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(firstName)){
//            System.out.println("invalid field!!!");
//            firstName = sc.nextLine();
//        }
//        System.out.println("enter your last name");
//        String lastName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(lastName)){
//            System.out.println("invalid field!!!");
//            lastName = sc.nextLine();
//        }
//        System.out.println("enter your email");
//        String email = sc.nextLine();
//        while (!Validation.isValidEmail(email)){
//            System.out.println("invalid field!!!");
//            email = sc.nextLine();
//        }
//
//        System.out.println("enter your password");
//        String password = sc.nextLine();
//        while (!Validation.isValidPassword(password)){
//            System.out.println("invalid field!!!");
//            password = sc.nextLine();
//        }
//        System.out.println("enter the image name:");
//        String imageName = sc.nextLine();
//        while (!Validation.isValidImage(Validation.readsImage(imageName)) || Validation.readsImage(imageName) == null ){
//            imageName = sc.nextLine();
//        }
//        byte[] profileImage = Validation.readsImage(imageName);
//
//        ExpertRegisterDto expertRegisterDto = new ExpertRegisterDto(firstName, lastName, email, password,profileImage);
//        expertService.registerExpert(expertRegisterDto);




//  ************************* SAVE IMAGE ******************************************************
        expertService.loadAll().forEach(System.out::println);
        System.out.println("enter expert id");
        int expertId = Validation.input();
        Expert expert = expertService.load(expertId);
        if (expert != null) {
            byte[] imageData = expert.getProfileImage();
            Validation.saveImageToFile(imageData, "src/main/resources/image.jpg");
            System.out.println("Image saved successfully.");
        } else {
            System.out.println("Expert not found in the database.");
        }

//  ************************* CHANGE PASSWORD ******************************************************
//        System.out.println("enter your id");
//        int expertId = Validation.input();
//        if (expertService.load(expertId)!=null) {
//            Expert expert = expertService.load(expertId);
//            String email = expert.getEmail();
//            System.out.println("enter new password");
//            String newPassword = sc.nextLine();
//            while (!Validation.isValidPassword(newPassword)){
//                System.out.println("invalid field");
//                newPassword = sc.nextLine();
//            }
//            expertService.changePassword(email,newPassword);
//        }else {
//            System.out.println("id not found");
//        }


//  ************************* SERVICE REGISTER ******************************************************
//        System.out.println("enter number of default service name or enter another service name");
//        String serviceNames = """
//                1.building decoration,
//                2.building Facilities,
//                3.vehicles
//                4.moving and carrying,
//                5.home appliances,
//                6.cleaning and hygiene
//                enter another character and save another service name
//                """;
//        System.out.println(serviceNames);
//        int select = Validation.input();
//        String serviceName = null;
//        switch (select) {
//            case 1 -> serviceName = "building decoration";
//            case 2 -> serviceName = "building Facilities";
//            case 3 -> serviceName = "vehicles";
//            case 4 -> serviceName = "moving and carrying";
//            case 5 -> serviceName = "home appliances";
//            case 6 -> serviceName = "cleaning and hygiene";
//            default -> {
//                System.out.println("enter another service name");
//                serviceName = sc.nextLine();
//
//            }
//        }
//        while (!Validation.containsOnlyAlphabetsAndSpaces(serviceName)){
//            System.out.println("invalid field");
//            serviceName = sc.nextLine();
//        }
//        if (!adminService.existByServiceName(serviceName))adminService.saveService(serviceName);
//        else System.out.println("this service saved in data base");


//  ************************* SubSERVICE REGISTER ******************************************************
//        System.out.println("enter number of default service name or enter another service name");
//        String serviceNames = """
//                1.building decoration,
//                2.building Facilities,
//                3.vehicles
//                4.moving and carrying,
//                5.home appliances,
//                6.cleaning and hygiene
//                enter another character and save another service name
//                """;
//        System.out.println(serviceNames);
//        int select = Validation.input();
//        String serviceName = null;
//        switch (select) {
//            case 1 -> serviceName = "building decoration";
//            case 2 -> serviceName = "building Facilities";
//            case 3 -> serviceName = "vehicles";
//            case 4 -> serviceName = "moving and carrying";
//            case 5 -> serviceName = "home appliances";
//            case 6 -> serviceName = "cleaning and hygiene";
//            default -> {
//                System.out.println("enter another service name");
//                serviceName = sc.nextLine();
//            }
//        }
//        while (!Validation.containsOnlyAlphabetsAndSpaces(serviceName)){
//            System.out.println("invalid field");
//            serviceName = sc.nextLine();
//        }
//        System.out.println("enter subService name");
//        String subServiceName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(subServiceName)){
//            System.out.println("invalid field");
//            subServiceName = sc.nextLine();
//        }
//        System.out.println("enter base price for subService");
//        double basePrice = Validation.inputDouble();
//        System.out.println("enter description");
//        String description = sc.nextLine();
//        while (!Validation.validateString(description)){
//            System.out.println("address is blank");
//            description = sc.nextLine();
//        }
//        SubService subService = new SubService();
//        subService.setSubServiceName(subServiceName);
//        subService.setBasePrice(basePrice);
//        subService.setDescription(description);
//        adminService.saveSubService(serviceName,subService);


//  ************************* EDIT SubService ******************************************************
//        subServiceService.loadAll().forEach(System.out::println);
//        System.out.println("enter subService name");
//        String subServiceName = sc.nextLine();
//        while (!Validation.containsOnlyAlphabetsAndSpaces(subServiceName)){
//            System.out.println("invalid field");
//            subServiceName = sc.nextLine();
//        }
//        System.out.println("enter base price for subService");
//        double price = Validation.inputDouble();
//        System.out.println("enter description");
//        String description = sc.nextLine();
//        while (!Validation.validateString(description)){
//            System.out.println("address is blank");
//            description = sc.nextLine();
//        }
//
//        subServiceService.editSubService(subServiceName,price,description);


//  ************************* SHOW ALL SERVICE AND SubSERVICE ******************************************************
//        adminService.showAllService().forEach(System.out::println);


//  ************************* CHANGE EXPERT STATUS ******************************************************
//        adminService.showAllExpert().forEach(System.out::println);
//        System.out.println("enter expert id");
//        int expertId = Validation.input();
//        Expert expert = expertService.load(expertId);
//        if (expert != null){
//            adminService.changeExpertStatus(expert);
//        }else System.out.println("Expert not found in the database.");


//  ************************* ADD EXPERT TO SubSERVICE *****************************************************************************
//        adminService.ShowAllSubService().forEach(System.out::println);
//        System.out.println("enter subService Id");
//        int subServiceId = Validation.input();
//        adminService.showAllExpert().forEach(System.out::println);
//        System.out.println("enter expert id");
//        int expertId = Validation.input();
//        Expert expert = expertService.load(expertId);
//        SubService subService = subServiceService.load(subServiceId);
//        if (subService!=null && expert!=null)adminService.saveExpertForSubService(subService,expert);


//  ************************* DELETE EXPERT TO SubSERVICE *******************************************************************
//        adminService.ShowAllSubService().forEach(System.out::println);
//        System.out.println("enter subService Id");
//        int subServiceId = Validation.input();
//        adminService.showAllExpert().forEach(System.out::println);
//        System.out.println("enter expert id");
//        int expertId = Validation.input();
//        Expert expert = expertService.load(expertId);
//        SubService subService = subServiceService.load(subServiceId);
//        if (subService!=null && expert!=null)adminService.deleteExpertFromSubService(subService,expert);
//        else System.out.println("subService or expert not found");


//  ************************* REGISTER ORDER **********************************************************************************
//        System.out.println("enter customer id");
//        int customerId = Validation.input();
//        Customer customer = customerService.load(customerId);
//        if (customer != null) {
//            customerService.showAllService().forEach(System.out::println);
//            System.out.println("enter service id");
//            int serviceId = Validation.input();
//            Service service = serviceService.load(serviceId);
//            if (service != null) {
//                customerService.showAllSubServiceByService(service).forEach(System.out::println);
//                System.out.println("enter subService Id");
//                int subServiceId = Validation.input();
//                SubService subService = subServiceService.load(subServiceId);
//                if (subService != null) {
//                    System.out.println("enter address");
//                    String address = sc.nextLine();
//                    while (!Validation.validateString(address)) {
//                        System.out.println("address is blank");
//                        address = sc.nextLine();
//                    }
//                    System.out.println("enter recommended price");
//                    double recommendedPrice = Validation.inputDouble();
//                    System.out.println("enter description");
//                    String description = sc.nextLine();
//                    while (!Validation.validateString(description)) {
//                        System.out.println("address is blank");
//                        description = sc.nextLine();
//                    }
//                    System.out.print("Enter a date (yyyy-MM-dd): ");
//                    String inputDate = sc.nextLine();
//                    try {
//                        LocalDate dateDoOrder = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
//                        if (recommendedPrice > subService.getBasePrice() && dateDoOrder.isAfter(LocalDate.now())) {
//                            OrderDto dto = new OrderDto(address, recommendedPrice, description, dateDoOrder);
//                            orderService.registerOrder(dto, customer, subService);
//                        } else System.out.println("time or price in not valid");
//                    } catch (DateTimeParseException e) {
//                        System.out.println("Invalid date format. Please enter a date in yyyy-MM-dd format.");
//                    }
//                }else System.out.println("subService is not valid");
//            } else System.out.println("service is not valid");
//        } else System.out.println("customer in not found");


//        String password = "1234Abcd"; // Replace this with the password you want to validate
//
//        if (validatePassword(password)) {
//            System.out.println("Password is valid.");
//        } else {
//            System.out.println("Password is invalid.");
//        }
//    }

//    private static boolean validatePassword(String password) {
//        // Define the regex pattern
//        String regex = "^[A-Za-z0-9]{8}$";
//
//        // Create a Pattern object
//        Pattern pattern = Pattern.compile(regex);
//
//        // Create a Matcher object
//        Matcher matcher = pattern.matcher(password);
//
//        // Check if the password matches the pattern
//        return matcher.matches();
//    }

    }
}