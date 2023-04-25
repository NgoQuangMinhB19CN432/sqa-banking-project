/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.example.sqaProject.utility;

import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.stereotype.Component;

/**
 *
 * @author Minh ngo
 */
@Component
public class utilityAppication {
    public static String formattedMoney(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        String formattedMoney = formatter.format(money);
        formattedMoney = formattedMoney.replace(",", ".");
        return formattedMoney;
    }
}
