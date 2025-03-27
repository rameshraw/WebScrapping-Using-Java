package com.example.db;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DBOperation {
    private static DBConnection dbConnection;

    public static void insertUserData(String sql, JSONArray userArray)
            throws ClassNotFoundException, SQLException, JSONException, ParseException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        for (int i = 0; i < userArray.length(); i++) {
            JSONObject obj = userArray.getJSONObject(i);
            dbConnection.setParameter(1, obj.getString("firstName"));
            dbConnection.setParameter(2, obj.getString("lastName"));
            dbConnection.setParameter(3, obj.getString("maidenName"));
            dbConnection.setParameter(4, obj.getInt("age"));
            dbConnection.setParameter(5, obj.getString("gender"));
            dbConnection.setParameter(6, obj.getString("email"));
            dbConnection.setParameter(7, obj.getString("phone"));
            dbConnection.setParameter(8, obj.getString("username"));
            dbConnection.setParameter(9, obj.getString("password")); // assuming password is already hashed
            dbConnection.setParameter(10, new SimpleDateFormat("yyyy-MM-dd").parse(obj.getString("birthDate"))); // assuming birthDate is in String format
                                                                       // "yyyy-mm-dd"
            dbConnection.setParameter(11, obj.getString("image"));
            dbConnection.setParameter(12, obj.getString("bloodGroup"));
            dbConnection.setParameter(13, obj.getDouble("height"));
            dbConnection.setParameter(14, obj.getDouble("weight"));
            dbConnection.setParameter(15, obj.getString("eyeColor"));
            dbConnection.setParameter(16, obj.getString("ip"));
            dbConnection.setParameter(17, obj.getString("macAddress"));
            dbConnection.setParameter(18, obj.getString("university"));
            dbConnection.setParameter(19, obj.getString("ein"));
            dbConnection.setParameter(20, obj.getString("ssn"));
            dbConnection.setParameter(21, obj.getString("userAgent"));
            dbConnection.setParameter(22, obj.getString("role"));
            dbConnection.setParameter(23,i+1);
            dbConnection.setParameter(24, 60+i+1);
            dbConnection.setParameter(25, i+1);
            dbConnection.setParameter(26, i+2);
            dbConnection.setParameter(27, 60+i+1);

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

    public static void insertCryptoData(String sql, List<JSONObject> cryptoArray)
            throws ClassNotFoundException, SQLException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        for (int i = 0; i < cryptoArray.size(); i++) {
            JSONObject obj = cryptoArray.get(i);
            dbConnection.setParameter(1, obj.getString("coin"));
            dbConnection.setParameter(2, obj.getString("wallet"));
            dbConnection.setParameter(3, obj.getString("network"));

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

    public static void insertAddressData(String sql, List<JSONObject> addressArray)
            throws ClassNotFoundException, SQLException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        // String insertAddressSQL = "INSERT INTO addresses (address, city, state,
        // state_code, postal_code, country, lat, lng) " +
        // "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        for (int i = 0; i < addressArray.size(); i++) {
            JSONObject obj = addressArray.get(i);
            dbConnection.setParameter(1, obj.getString("address"));
            dbConnection.setParameter(2, obj.getString("city"));
            dbConnection.setParameter(3, obj.getString("state"));
            dbConnection.setParameter(4, obj.getString("stateCode"));
            dbConnection.setParameter(5, obj.getString("postalCode"));
            dbConnection.setParameter(6, obj.getString("country"));
            dbConnection.setParameter(7, obj.getJSONObject("coordinates").getBigDecimal("lat"));
            dbConnection.setParameter(8, obj.getJSONObject("coordinates").getBigDecimal("lng"));

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

    public static void insertCompanyData(String sql, List<JSONObject> companyArray)
            throws ClassNotFoundException, SQLException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        // String insertBankSQL = "INSERT INTO banks (card_expire, card_number,
        // card_type, currency, iban) VALUES (?, ?, ?, ?, ?)";
        for (int i = 0; i < companyArray.size(); i++) {
            JSONObject obj = companyArray.get(i);
            dbConnection.setParameter(1, obj.getString("department"));
            dbConnection.setParameter(2, obj.getString("name"));
            dbConnection.setParameter(3, obj.getString("title"));
            dbConnection.setParameter(4, 60 + i + 1);

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

    public static void insertBankData(String sql, List<JSONObject> bankArray)
            throws ClassNotFoundException, SQLException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        // String insertBankSQL = "INSERT INTO banks (card_expire, card_number,
        // card_type, currency, iban) VALUES (?, ?, ?, ?, ?)";
        for (int i = 0; i < bankArray.size(); i++) {
            JSONObject obj = bankArray.get(i);
            dbConnection.setParameter(1, obj.getString("cardExpire"));
            dbConnection.setParameter(2, obj.getString("cardNumber"));
            dbConnection.setParameter(3, obj.getString("cardType"));
            dbConnection.setParameter(4, obj.getString("currency"));
            dbConnection.setParameter(5, obj.getString("iban"));

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

    public static void insertHairData(String sql, List<JSONObject> hairArray)
            throws ClassNotFoundException, SQLException {
        dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.prepare(sql);
        // String insertBankSQL = "INSERT INTO banks (card_expire, card_number,
        // card_type, currency, iban) VALUES (?, ?, ?, ?, ?)";
        for (int i = 0; i < hairArray.size(); i++) {
            JSONObject obj = hairArray.get(i);
            dbConnection.setParameter(1, obj.getString("color"));
            dbConnection.setParameter(2, obj.getString("type"));

            int status = dbConnection.execute();
            if (status > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("NOT successfull");
            }
        }

        dbConnection.close();
    }

}