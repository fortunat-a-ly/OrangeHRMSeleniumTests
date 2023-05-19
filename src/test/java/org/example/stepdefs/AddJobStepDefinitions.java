package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AdminPage;
import org.example.pages.LoginPage;
import org.example.pages.Page;
import org.example.pages.WelcomePage;


public class AddJobStepDefinitions {

        Page page = new LoginPage();
        String jobTitle = "B Java developer";
        String jobDescription ="Write code 40 hours/week";
        String jobNote = "Applicants should be graduates";

        @Given("I login successfully")
        public void loginSuccessfully() {
                LoginPage loginPage = (LoginPage) page;
                loginPage.setUsername("Admin");
                loginPage.setPassword("admin123");
                loginPage.clickLoginButton();
                page = page.nextPage();
        }

        @And("I navigate to Admin Page")
        public void navigateToAdminPage() {
                WelcomePage welcomePage = (WelcomePage) page;
                welcomePage.clickAdminMenuItem();
                page = page.nextPage();
        }

        @And("I click on Job menu button to see submenu")
        public void clickJobMenuButton() {
                AdminPage adminPage = (AdminPage) page;
                adminPage.openJobSubmenu();
        }

        @And("I navigate to Job Titles page by clicking on Job Titles from the submenu")
        public void navigateToAddJobTitlesPage() {
                AdminPage adminPage = (AdminPage) page;
                adminPage.clickJobTitles();
        }

        @And("I click Add button in Job Titles page")
        public void clickAddJobTitlesButton() {
                AdminPage adminPage = (AdminPage) page;
                adminPage.clickAddJobButton();
        }

        @When("I fill in Job Title, Description and Note")
        public void fillInForm() {
                AdminPage adminPage = (AdminPage) page;
                adminPage.fillJobTitleField(jobTitle);
                adminPage.fillJobDescriptionField(jobDescription);
                adminPage.fillJobNoteField(jobNote);
        }

        @And("I click Save button")
        public void saveJob() {
                AdminPage adminPage = (AdminPage) page;
                adminPage.clickSaveJobButton();
        }

        @Then("There should be my job added in Job Title Page")
        public void jobAdded() {
                ((AdminPage) page).jobOfferExists(jobTitle, jobDescription, jobNote);
        }

        @When("I click on Bin icon next to the job")
        public void clickOnBinButton() {
                ((AdminPage) page).deleteButton(jobTitle);
        }

        @And("I click Yes in Popup dialog")
        public void clickYesInPopupDialog() {
                ((AdminPage) page).clickYesInPopupDialog();
        }

        @Then("The job should disappear from the list")
        public void isJobDeleted() {
                ((AdminPage) page).isJobDeleted(jobTitle);
        }


}
