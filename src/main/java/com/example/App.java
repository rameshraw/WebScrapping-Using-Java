package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.db.DBOperation;
import com.example.helpers.JsonParser;
import com.example.helpers.URLhelper;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, JSONException, ParseException {
        String insertUserSQL = "INSERT INTO users (first_name, last_name, maiden_name, age, gender, email, phone, username, password_hash, birth_date, image, blood_group, height, weight, eye_color, ip, mac_address, university, ein, ssn, user_agent, role, hair_id, address_id, bank_id, company_id, crypto_id) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertHairSQL = "INSERT INTO hair (color, type) VALUES (?, ?)";
        String insertCryptoSQL = "INSERT INTO crypto (coin, wallet, network) VALUES (?, ?, ?)";
        String insertAddressSQL = "INSERT INTO addresses (address, city, state, state_code, postal_code, country, lat, lng) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String insertCompanySQL = "INSERT INTO companies (department, name, title, address_id) VALUES (?, ?, ?, ?)";
        String insertBankSQL = "INSERT INTO banks (card_expire, card_number, card_type, currency, iban) VALUES (?, ?, ?, ?, ?)";
        List<JSONObject> addressArray = new ArrayList<>();
        List<JSONObject> bankArray = new ArrayList<>();
        List<JSONObject> companyarray = new ArrayList<>();
        ;
        List<JSONObject> hairArray = new ArrayList<>();
        ;
        List<JSONObject> cryptoArray = new ArrayList<>();
        ;

        try {

            String link = "https://dummyjson.com/users";
            String content = URLhelper.getcontent(link);
            JSONArray contentArray = JsonParser.parseJson(content);
            for (int i = 0; i < contentArray.length(); i++) {
                addressArray.add(contentArray.getJSONObject(i).getJSONObject("address"));
                bankArray.add(contentArray.getJSONObject(i).getJSONObject("bank"));
                companyarray.add(contentArray.getJSONObject(i).getJSONObject("company"));
                hairArray.add(contentArray.getJSONObject(i).getJSONObject("hair"));
                cryptoArray.add(contentArray.getJSONObject(i).getJSONObject("crypto"));

            }
            
        //    I scrap data from users json file into databases;
            DBOperation.insertUserData(insertUserSQL, contentArray);
            // DBOperation.insertAddressData(insertAddressSQL, addressArray);
            // DBOperation.insertCompanyData(insertCompanySQL,companyarray);
            // DBOperation.insertCryptoData(insertCryptoSQL, cryptoArray);
           // DBOperation.insertHairData(insertHairSQL, hairArray);
            // DBOperation.insertBankData(insertBankSQL, bankArray);
            

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}