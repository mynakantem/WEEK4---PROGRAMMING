package RegexExample;

import java.util.regex.*;

public class CreditCardsValidator {
    public static void main(String[] args) {
     
        String visaCard = "4123456789012345";
        String masterCard = "5123456789012345";
        String invalidCard = "6123456789012345";

        System.out.println(validateCreditCard(visaCard));  
        System.out.println(validateCreditCard(masterCard));  
        System.out.println(validateCreditCard(invalidCard));  
    }

    public static String validateCreditCard(String cardNumber) {
        String visaPattern = "^4[0-9]{15}$";  
        String masterCardPattern = "^5[0-9]{15}$";  

        if (cardNumber.matches(visaPattern)) {
            return cardNumber + " is a valid Visa card.";
        } else if (cardNumber.matches(masterCardPattern)) {
            return cardNumber + " is a valid MasterCard.";
        } else {
            return cardNumber + " is an invalid card number.";
        }
    }
}
