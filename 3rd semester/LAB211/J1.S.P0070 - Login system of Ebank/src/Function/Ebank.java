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
        performLoginSystem(Vietnam);
    }

    //Perform login system with English interface
    public void performEnglishInterfaceLoginSystem() {
        Locale English = new Locale("en", "US");
        performLoginSystem(English);
    }

    //Perform login system with selected language interface 
    public void performLoginSystem(Locale locale) {
        ResourceBundle resoureBundle = ResourceBundle.getBundle("Resources.language", locale);
        GetData getData = new GetData();
        String accountNumber, password, captchaGenerate, captchaUserInput;
        //Loop until get a valid account number
        do {
            accountNumber = getData.getUserInputString(resoureBundle.getString("inputAccountNumber"), resoureBundle.getString("inputIsEmpty"));
        } while (checkAccountNumber(accountNumber, resoureBundle.getString("accountNumberNotValid")) == null);
        //Loop until get a valid password
        do {
            password = getData.getUserInputString(resoureBundle.getString("inputPassword"), resoureBundle.getString("inputIsEmpty"));
        } while (checkPassword(password, resoureBundle.getString("passwordNotValid")) == null);
        //Printout generated captcha
        captchaGenerate = generateCaptcha();
        System.out.println(resoureBundle.getString("generateCaptcha") + captchaGenerate);
        //Loop until get a correct captcha
        do {
            captchaUserInput = getData.getUserInputString(resoureBundle.getString("inputCaptcha"), resoureBundle.getString("inputIsEmpty"));
        } while (checkCaptcha(captchaUserInput, captchaGenerate, resoureBundle.getString("captchaIncorrect")) == null);
        if(!checkAccountExist(accountNumber, password)){
            System.out.println(resoureBundle.getString("accountDontExist"));
        }
    }

    //Check account number
    public String checkAccountNumber(String accountNumberNeedCheck, String errorMessage) {
        //Regex: [0-9]{10}: must contain 10 digits
        if (accountNumberNeedCheck.matches("^[0-9]{10}$")) {
            return accountNumberNeedCheck;
        }
        System.out.println(errorMessage);
        return null;
    }

    //Check password
    public String checkPassword(String passwordNeedCheck, String errorMessage) {
        if (passwordNeedCheck.length() >= 8 && passwordNeedCheck.length() <= 31) {
            //^[a-zA-Z0-9]*: check password start with character a-z 
            //lower, upper, and digit in range 0 to 9
            //([a-zA-Z]+[0-9]+): check password must contain character first
            // and follow by digit from 0-9
            // | : OR
            //[0-9]+[a-zA-Z]+: check password must contain first
            //follow by character
            //[a-zA-Z0-9]*$: check password end with character a-z 
            //lower, upper, and digit in range 0 to 9
            if (passwordNeedCheck.matches("^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$")) {
                return passwordNeedCheck;
            }
        }
        System.out.println(errorMessage);
        return null;

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
    public String checkCaptcha(String captchaInput, String captchaGenerate, String errorMessage) {
        if (captchaGenerate.contains(captchaInput)) {
            return "";
        }
        System.out.println(errorMessage);
        return null;
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
