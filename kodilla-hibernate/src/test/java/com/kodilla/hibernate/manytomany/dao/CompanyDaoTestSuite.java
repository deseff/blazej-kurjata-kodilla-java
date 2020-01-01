package com.kodilla.hibernate.manytomany.dao;

import java.util.List;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarcson = new Employee("Stephanie", "Clarcson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarcson);
        employeeDao.save(lindaKovalsky);

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Measters");
        Company greyMatter = new Company("Grey Matter");
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarcson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarcson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
    }

    @Test
    public void testNamedQueries() {
        //Given
        Employee louisArmstrong = new Employee("Louis", "Armstrong");
        Employee frankSinatra = new Employee("Frank", "Sinatra");
        Employee ellaFitzgerald = new Employee("Ella", "Fitzgerald");
        employeeDao.save(louisArmstrong);
        employeeDao.save(frankSinatra);
        employeeDao.save(ellaFitzgerald);

        Company hotFive = new Company("Hot Five");
        Company hotSeven = new Company("Hot Seven");
        Company allStars = new Company("All Stars");
        companyDao.save(hotFive);
        companyDao.save(hotSeven);
        companyDao.save(allStars);

        hotFive.getEmployees().add(louisArmstrong);
        hotFive.getEmployees().add(frankSinatra);
        hotSeven.getEmployees().add(louisArmstrong);
        hotSeven.getEmployees().add(ellaFitzgerald);
        allStars.getEmployees().add(louisArmstrong);
        allStars.getEmployees().add(frankSinatra);
        allStars.getEmployees().add(ellaFitzgerald);

        louisArmstrong.getCompanies().add(hotFive);
        louisArmstrong.getCompanies().add(hotSeven);
        louisArmstrong.getCompanies().add(allStars);
        frankSinatra.getCompanies().add(hotFive);
        frankSinatra.getCompanies().add(allStars);
        ellaFitzgerald.getCompanies().add(hotSeven);
        ellaFitzgerald.getCompanies().add(allStars);

        companyDao.save(hotFive);
        int hotFiveId = hotFive.getId();
        companyDao.save(hotSeven);
        int hotSevenId = hotSeven.getId();
        companyDao.save(allStars);
        int allStarsId = allStars.getId();

        employeeDao.save(louisArmstrong);
        int louisArmstrongId = louisArmstrong.getId();
        employeeDao.save(frankSinatra);
        int frankSinatraId = frankSinatra.getId();
        employeeDao.save(ellaFitzgerald);
        int ellaFitzgeraldId = ellaFitzgerald.getId();

        //When
        List<Employee> employeeWithGivenLastName = employeeDao.retrieveEmployeesWithGivenLastname("Armstrong");
        List<Company> companiesNamesBeginningWithThreeLetters = companyDao.retrieveCompaniesNamesBeginningWithThreeLetters("Hot");

        //Then
        Assert.assertEquals(1, employeeWithGivenLastName.size());
        Assert.assertEquals(2, companiesNamesBeginningWithThreeLetters.size());

        //Cleanup
        companyDao.deleteById(allStarsId);
        companyDao.deleteById(hotSevenId);
        companyDao.deleteById(hotFiveId);
    }
}