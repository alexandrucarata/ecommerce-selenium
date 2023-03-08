# Selenium WebDriver Training
*This is the final project I completed as part of my Selenium training to become a Java QA Automation Engineer within the company.
Used knowledge gained throughout the course of an internal company training to develop a testing framework for a demo e-commerce application as part of the final task.*

## Technology Stack:
1. Programming language - `Java`
2. Build and project management tool - `Maven`
3. Testing framework - `JUnit 5`
4. Automation framework - `Selenium WebDriver`
5. Reporting framework - `Allure`

## Tasks:
1. Automate 5 scenarios (described below)
2. Tests from 1 test class should be executed in 1 browser (if 3 test classes - browser should be opened 3 times, before each test class, not before each test method)
3. Required Design Patterns: `Page Object + Page Factory`, `Singleton` (can add more)
4. If your project contains DDT - store datasets in txt/xml/json files
5. Project should be shared on `Github` or `Bitbucket`
6. Tests should work in `Chrome` and `Firefox` browsers
7. Add switch in code to run tests `locally`/ using `Selenium Grid`/ `SauceLabs`/ `Docker` (user can give params - url, port, etc)
8. If test fails, attach screenshot, date and time, browser, platform version to your report
9. Add cleanup

## Test Plan:
### AP-1 Verify the ability to create an account
1.	Go to login page `https://magento.softwaretestingboard.com/customer/account/create/`
2.	Fill required fields 
3.	Click Create an account button 

Expected result: Account was created 

### AP-2 Verify the ability to login in
1.	Go to main page: `https://magento.softwaretestingboard.com/` 
2.	Fill Email address and Password inputs 
3.	Click Sign in button 

Expected result: You were able to login 

### AP-3 Verify the ability to add an address 
1.	Login 
2.	Go to address book: `https://magento.softwaretestingboard.com/customer/address/index/` 
3.	Add new address

Expected result: New address was added to the address list

### AP-4 Verify the ability to add products to Wishlist 
1.	Login 
2.	Go to a page with clothes
3.	Go to any product detail page and click Add to Wishlist button

Expected result: Product was added to Wishlist 

### AP-5 Verify the ability to add products to cart 
1.	Login 
2.	Go to a page with clothes 
3.	Add 3 different products to cart 
4.	Go to shopping cart

Expected result: All 3 products are in the cart and subtotal is correct 
