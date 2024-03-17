**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# Introduction


# Analysis of 10 Mutants of the Range class 

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process
As a group, we selected a total of eight GUI website functions to test. These included login, colour and size selection, cart, checkout, favourite, menu selection, quantity selection, and search. Different baseline inputs and event combinations were tested for each functionality. The test suite was designed as a group through preliminary exploration of the website under test. By working together, the standard and depth of each function's tests was kept consistent. Test cases varied for different functionalities. For example, testing the favourite button involved testing different numbers of items being favourited, or removing favourites, while testing the checkout page involved following different paths to get to the same checkout screen. Then the design, automation, and execution of the tests were completed through pair programming. Some test cases were altered, and added throughout the automation with Selenium. 
# Explain the use of assertions and checkpoints
Assertions and verifications were added through one of two methods. Either they were implemented during the recording automation of a test by right clicking a target, or they were added after the recording by manually inserting a command and setting the target and value to verify a component of the website. Each verification was designed purposefully to ensure that the test case being implemented was performing as expected. For instance in the favourite one item test, a "verify element present" check was added to make sure that the selected item was in fact in the favourites page. Typically, multiple verifications were inputted as checkpoints throughout a single test case to make it more organized and obvious where an error may have occurred if a test were to fail. A challenge that arose from assertions was the slight delay in website reaction, which caused assertions to fail if the selenium tests ran too quickly. Specifically, in the test case Test_Login:Valid_Username_Password the verification added to ensure that the "Sign in" button now displayed "Hi <username>" was failing because the SUT was delayed. To solve this issue, the verification was changed to first hover over the previous button, then check that the "log out" text appeared in the dropdown menu. There was one other case in a quantity function test where the test execution speed had to be set slightly below the fastest setting for the verification to correctly check an element when it was changed in the previous  command. 
# how did you test each functionaity with different test data
As described above, different functionalities required different variations in test data. Some tests varied data by changing the inputs such as the tests for login, quantities, and search. Unique numbers in quantities were tested, and valid, half complete, fully complete, and invalid searches were tested. The cart and menu bar functions tested different paths in their pages. For example, the menu bar was used to navigate the site by the primary categories, secondary drop dropdowns, and even more specific selections that appeared when hovering over a secondary drop down item. Some difficulties in developing detailed and repeatable tests arose when testing the colour and size selections of a specific item. If a colour selection test was developed for the first item in a page with a verification that the colour displayed matched the one chosen, the tests that pass one day may fail another day if the first item in the page changed. In order to write effective tests, the items selected had to be pre chosen for each test case, so that a test that selected all the seven different colour options in one item wouldn't run on another item with only three colour options. 
# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
