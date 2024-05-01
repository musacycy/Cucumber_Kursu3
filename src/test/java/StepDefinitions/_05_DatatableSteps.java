package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DatatableSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    FormContent fc=new FormContent();
    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String> listElement= elements.asList(String.class);

        for(int i=0;i<listElement.size();i++){
          //  System.out.println("element ="+listElement.get(i));
            ln.findAndClick(listElement.get(i));
        }
    }

    @And("Click on the elemen in the Dialog")
    public void clickOnTheElemenInTheDialog(DataTable elements) {
        List<String> listElements=elements.asList(String.class);

        for (int i=0;i<listElements.size();i++){
            dc.findAndClick(listElements.get(i));
        }
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement=elements.asLists(String.class);
        for (int i=0;i< listElement.size();i++){
            dc.findAndSend(listElement.get(i).get(0),listElement.get(i).get(1));
        }

    }


    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<String> listElements=elements.asList(String.class);

        for(int i=0;i< listElements.size();i++){
            dc.searchAndDelete(listElements.get(i));

        }
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {
        List<String> listElements=elements.asList(String.class);

        for (int i=0;i<listElements.size();i++){
            fc.findAndClick(listElements.get(i));
        }
    }
}
