package com.dan.steps.serenity;


import com.dan.pages.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import java.util.concurrent.ThreadLocalRandom;

public class LoginSearchSelectRandomSteps extends ScenarioSteps {
    private CustomerLoginPage customerLoginPage;
    private MyAccountPage myAccountPage;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private LoginSteps loginSteps;
    private Cart cart;
    private int numberOfPages;
    private int randomPageNumber;
    private int numberOfProductsDisplayed;
    private int randomProduct;
    private int lastPageNumberOfProducts;
    //private int curentPage = 1;
    private String selectedProductName;


    //Inchide notificarea de cookies pentru ca imi acopera elemente.
    @Step
    public void clickOnCookieAcceptButton(){
       do {
            searchResultPage.moveToCookieAcceptBtn();
            searchResultPage.cookieAcceptBtn();
        }while (searchResultPage.cookieAcceptBtnIsDisplayed());
    }

    //Calculeaza numarul de pagini returnate de search si indica numarul de produse de pe ultima pagina.
    @Step
    public void totalNumberOfPages() {
        int totalNumberOfProducts = searchResultPage.setTotalNumberOfProductsFound();
        numberOfProductsDisplayed = searchResultPage.setNumberOfProductsDisplayedOnPage();
        if (totalNumberOfProducts % numberOfProductsDisplayed == 0) {
            numberOfPages = totalNumberOfProducts / numberOfProductsDisplayed;
        } else {
            numberOfPages = totalNumberOfProducts / numberOfProductsDisplayed + 1;
            lastPageNumberOfProducts = totalNumberOfProducts % numberOfProductsDisplayed;
        }
        System.out.println("Numarul de pagini returnate de cautare: " + numberOfPages);
    }

    //Genereaza un numar random in intervalul inchis [1-numarul de pagini returnate de search].
    @Step
    public void randomPageNumber() {
        int min = 1;
        int max = numberOfPages;
        randomPageNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("Numarul paginii generat random: " + randomPageNumber);
    }

    //Navigheaza la random url  SAU da click pe nextPage sau previousPage pana ajungi la pagina indicata de numarul generat random.
    @Step
    public void navigateToRandomPage() {
        String urlRandom = "https://substitute.ro/catalogsearch/result/index/?p="+randomPageNumber+"&q=aroma";
        getDriver().navigate().to(urlRandom);

        /*if (randomPageNumber > curentPage) {
            do {
                searchResultPage.moveToElementNextButton();
                searchResultPage.clickNextPageButton();
                curentPage = curentPage + 1;
            } while (curentPage != randomPageNumber);
            }
          if (randomPageNumber < curentPage){
            do{
                searchResultPage.moveToElementPreviousButton();
                searchResultPage.clickPreviousPageButton();
                curentPage = curentPage-1;
            }while (curentPage != randomPageNumber);
            }
        */ }

    //Genereaza un numar random in intervalul [0, numarul de produse afisate/pagina), indexul elementului produs.
    @Step
    public void randomProduct(){
        int min = 0;
        int max;
            if(randomPageNumber == numberOfPages && lastPageNumberOfProducts != 0) {
                max = lastPageNumberOfProducts;
            }else {
                max = numberOfProductsDisplayed;
            }
        randomProduct = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println("Indexul produsului generat random: " + randomProduct);
    }

    //Verifica daca exista cel putin un produs pe pagina care poate fi bagat in cos. Daca nu genereaza alta pagina
    @Step
    public void checkThatIsAtLeastOneProductInStockOnPage() {
        boolean repeat = true;
        boolean inStockProductIsDisplayedOnRandomPage = false;
        WebElementFacade element;

        do{
            for (int i = 0; i < searchResultPage.productList.size(); i++) {
                element = searchResultPage.productList.get(i);
                if(element.containsElements(".products.list .item button")) {
                    inStockProductIsDisplayedOnRandomPage = true;
                    repeat = false;
                    break;
                }
            }
            if(inStockProductIsDisplayedOnRandomPage == false) {
                randomPageNumber();
                navigateToRandomPage();
            }
        }while (repeat) ;
    }


    //Verifica daca produsul corespunzator indexului generat este in stoc(are pe el buton ""Cumpara"). Daca da, du-te la el si da click pe el. Daca nu genereaza alt index si repeta operatia.
    @Step
    public void selectAndAddToCart() {
        boolean repeat = true;
        int x;
        int y;
        do {
            if(searchResultPage.productList.get(randomProduct).containsElements(".products.list .item button span")){
                searchResultPage.productList.get(randomProduct).then().findBy(".products.list .item button").then().getCoordinates().inViewPort().getX();
                searchResultPage.productList.get(randomProduct).then().findBy(".products.list .item button").then().getCoordinates().inViewPort().getY();
                searchResultPage.productList.get(randomProduct).then().findBy(".products.list .item button").then().click();
                selectedProductName = searchResultPage.productList.get(randomProduct).thenFindAll(".product-item-link").get(0).getText();
                repeat = false;
                break;
            }
            else {
                randomProduct();
            }
        } while (repeat);
    }


    //Du-te in cos dupa ce ai adaugat un produs
    @Step
    public void navigateToCartPage(){
        searchResultPage.moveToElementCart();
        searchResultPage.clickOnCart();
        searchResultPage.moveToElementViewCart();
        searchResultPage.clickOnViewCart();
    }

    //Verifica ca ai ajuns in cos
    @Step
    public void checkCartPage(){
        Assert.assertTrue(cart.cartIsDidplayed());
    }

    //Verifica daca numele produsului selectat coincide cu numele produsului din cos "pam-pam"
    @Step
    public void compareSelectedProductWithCartProduct(){
        System.out.println("Nume produs selectat: " + selectedProductName);
        System.out.println("Nume produs din cos: " + cart.productInCartName());
        Assert.assertTrue(selectedProductName.equals(cart.productInCartName()));
    }

    //Goleste cosul ininte sa pleci
    @Step
    public void emptyCartBeforeExit(){
        cart.clickEmtyCartButton();
    }
}


