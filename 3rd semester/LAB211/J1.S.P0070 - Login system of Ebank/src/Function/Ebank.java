package Function;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/*
 * DuyDuc94
 */
/**
 *
 * @author duy20
 */
public class Ebank {

    //Perform login system with Vietnamese interface
    public void performVIetnameseInterfaceLoginSystem() {
        Locale Vietnam = new Locale("vi", "VN");
        performLoginSystemIn(Vietnam);
    }

    //Perform login system with English interface
    public void performEnglishInterfaceLoginSystem() {
        Locale English = new Locale("en", "US");
        performLoginSystemIn(English);
    }

    //Perform login system with selected locale 
    public void performLoginSystemIn(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Resources.lang", locale);
        GetData getData = new GetData();
        String accountNumber, password, captchaGenerate, captchaUserInput;
        //Loop until get a valid account number
        do {
            accountNumber = getData.getUserInputString(resourceBundle.getString("inputAccountNumber"), resourceBundle.getString("inputIsEmpty"));
        } while (!checkValidAccountNumber(accountNumber, resourceBundle.getString("accountNumberNotValid")));
        //Loop until get a valid password
        do {
            password = getData.getUserInputString(resourceBundle.getString("inputPassword"), resourceBundle.getString("inputIsEmpty"));
        } while (!checkValidPassword(password, resourceBundle.getString("passwordNotValid")));
        //Printout generated captcha
        captchaGenerate = generateCaptcha();
        System.out.println(resourceBundle.getString("generateCaptcha") + captchaGenerate);
        //Loop until get a correct captcha
        do {
            captchaUserInput = getData.getUserInputString(resourceBundle.getString("inputCaptcha"), resourceBundle.getString("inputIsEmpty"));
        } while (!checkCaptcha(captchaUserInput, captchaGenerate, resourceBundle.getString("captchaIncorrect")));
        //Check if account is exist in database or not
        if(!checkAccountExist(accountNumber, password)){
            System.out.println(resourceBundle.getString("accountDontExist"));
        }
    }

    //Check account number
    public boolean checkValidAccountNumber(String accountNumberNeedCheck, String errorMessage) {
        //Regex: [0-9]{10}: must contain 10 digits
        if (accountNumberNeedCheck.matches("^[0-9]{10}$")) {
            return true;
        }
        System.out.println(errorMessage);
        return false;
    }

    //Check password
    public boolean checkValidPassword(String passwordNeedCheck, String errorMessage) {
        /*Regex: 
         *  ^, &: indicates the beginning and the end of the string. (Use to 
         *  determine lengh of string)
         *  ?=: Positive lookahead assertion
         *  (?=.*[A-Za-z]): String contain at least 1 alphabet
         *  (?=.*[0-9]): String contain at least 1 digit
         *  [A-Za-z0-9]: Contain only alphabet and digit
         *  {8,31}: String length must be between 8 and 31 character
         */
        if (passwordNeedCheck.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,31}$")) {
            return true;
        }
        System.out.println(errorMessage);
        return false;

    }

    //Generate captcha
    public String generateCaptcha() {
        Random random = new Random();
        String captcha = "", generateString = "";
        //Loop use to gather all character from A-Z and 0-9 to a string
        for (char c = 'A'; c <= 'Z'; c++) {
            generateString += c;
        }
        for (char c = '0'; c <= '9'; c++) {
            generateString += c;
        }
        //Loop use to gather 5 random charater from generateString into capcha
        for (int i = 0; i < 5; i++) {
            captcha += generateString.charAt(random.nextInt(generateString.length()));
        }
        return captcha;
    }

    //Check captcha
    public boolean checkCaptcha(String captchaInput, String captchaGenerate, String errorMessage) {
        if (captchaGenerate.contains(captchaInput)) {
            return true;
        }
        System.out.println(errorMessage);
        return false;
    }

    public boolean checkAccountExist(String accountNumber, String password) {
        FileReader dataFile;
        BufferedReader bufferReader;
        String readString, currentDirectory = System.getProperty("user.dir");
        String accountNumberData, passwordData;
        try {
            dataFile = new FileReader(currentDirectory + "\\src\\Resources\\AccountData.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        bufferReader = new BufferedReader(dataFile);
        try {
            //Loop use to read every single line of file till end of file
            while ((readString = bufferReader.readLine()) != null) {
                if(readString.compareTo(accountNumber + " " + password) == 0){
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
