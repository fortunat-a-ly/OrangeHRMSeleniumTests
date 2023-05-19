package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;


public class AddJobStepDefinitions {

        LoginPage loginPage = new LoginPage();
        WelcomePage welcomePage;
        AdminPage adminPage;
        JobTitlesSubpage jobTitlesSubpage;
        AddJobSubpage addJobSubpage;
        String jobTitle = "B Java developer" + Math.random() % 1000;
        String jobDescription ="Write code 40 hours/week";
        String jobNote = "Applicants should be graduates";

        @Given("I login successfully")
        public void loginSuccessfully() {
                loginPage.setUsername("Admin");
                loginPage.setPassword("admin123");
                loginPage.clickLoginButton();
        }

        @And("I navigate to Admin Page")
        public void navigateToAdminPage() {
                welcomePage = loginPage.nextPage();
                welcomePage.clickAdminMenuItem();
        }

        @And("I click on Job menu button to see submenu")
        public void clickJobMenuButton() {
                adminPage = welcomePage.nextPage();
                adminPage.openJobSubmenu();
        }

        @And("I navigate to Job Titles page by clicking on Job Titles from the submenu")
        public void navigateToJobTitlesPage() {
                adminPage.clickJobTitles();
        }

        @And("I click Add button in Job Titles page")
        public void clickAddJobTitlesButton() {
                jobTitlesSubpage = adminPage.nextPage();
                jobTitlesSubpage.clickAddJobButton();
        }

        @When("I fill in Job Title, Description and Note")
        public void fillInForm() {
                addJobSubpage = jobTitlesSubpage.nextPage();
                addJobSubpage.fillJobTitleField(jobTitle);
                addJobSubpage.fillJobDescriptionField(jobDescription);
                addJobSubpage.fillJobNoteField(jobNote);
        }

        @And("I click Save button")
        public void saveJob() {
                addJobSubpage.clickSaveJobButton();
        }

        @Then("There should be my job added in Job Title Page")
        public void jobAdded() {
                jobTitlesSubpage.jobOfferExists(jobTitle, jobDescription, jobNote);
        }

        @When("I click on Bin icon next to the job")
        public void clickOnBinButton() {
                jobTitlesSubpage.deleteButton(jobTitle);
        }

        @And("I click Yes in Popup dialog")
        public void clickYesInPopupDialog() {
                jobTitlesSubpage.clickYesInPopupDialog();
        }

        @Then("The job should disappear from the list")
        public void isJobDeleted() {
                jobTitlesSubpage.isJobDeleted(jobTitle);
        }

}
