#1 sınav girişi yapınız
  # sonrasında silmesii yapınız

  Feature: Entrance exam functionality

    Background:
      Given Navigate to basqar
      When Enter username and password and click login button
      Then User should login successfuly


      Scenario Outline: Create exam

        And Click on the element in the left Nav
          |entranceExam|
          |setupTwo    |
          |entranceExam2|
        And Click on the elemen in the Dialog
          |createCountry|

        And User sending the keys in Dialog content
          |nameInput|<ExamName>|
        And Click on the element in the Form Content
          |academicPeriod|
          |<AcademicPeriodOption>|
          |gradeLevel|
          |<GradeLevelOption>|
          |SaveButton|
        #TODO:SAVEBUTTON STALE ELEMENT HATASI




        Then Success Message should be displayed

        And User delete item from Dialog
          |<ExamName>|
        #TODO: searchInput locator kontrol edilecek ortak mı
        Then Success Message should be displayed
      Examples:
        |ExamName|AcademicPeriodOption|GradeLevelOption|
        |tyt2023 |academicPeriod1     |gradeLevel2     |
