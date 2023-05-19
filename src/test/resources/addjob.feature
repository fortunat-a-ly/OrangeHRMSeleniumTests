# Created by User at 19/05/2023
Feature: Add and remove job

    Scenario: Add job
      Given I login successfully
      And I navigate to Admin Page
      And I click on Job menu button to see submenu
      And I navigate to Job Titles page by clicking on Job Titles from the submenu
      And I click Add button in Job Titles page
      When I fill in Job Title, Description and Note
      And I click Save button
      Then There should be my job added in Job Title Page

    Scenario: Remove the job
      Given There is a job I have to delete
      When I click on Bin icon next to the job
      And I click Yes in Popup dialog
      Then The job should disappear from the list