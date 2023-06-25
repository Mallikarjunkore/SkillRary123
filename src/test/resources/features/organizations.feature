
Feature: Organizations

	Background:
		Given login to vtiger application
    When click on organizations tab
  
  Scenario: Create Organization
    When create organization with mandatory details  
    Then New organization info page is displayed 
    And new organization is added to the organizations list 
    
  Scenario: Create organization with industry and type
  	When create organization with industry and type details
  	Then New organization info page is displayed 
    And new organization is added to the organizations list
  	
  
  	

  