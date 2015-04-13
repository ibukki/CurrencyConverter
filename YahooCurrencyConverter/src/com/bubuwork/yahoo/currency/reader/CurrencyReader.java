package com.bubuwork.yahoo.currency.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class CurrencyReader {
  private static final String YAHOO_FINANCE_CURRENT_QUOTES = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=xml";

  public static String loadCurrenyQuote(boolean useProxy) throws IOException {
    HttpClient httpclient = new HttpClient();

    HttpMethod httpget = new GetMethod(YAHOO_FINANCE_CURRENT_QUOTES);

    int statusCode = 0;
    if (useProxy) {
      HostConfiguration config = new HostConfiguration();
      config.setProxy("proxy.sin.sap.corp", 8080);
      statusCode = httpclient.executeMethod(config, httpget);
    } else {
      statusCode = httpclient.executeMethod(httpget);
    }
    if (statusCode != HttpStatus.SC_OK) {
      System.out.println("failed to execute get");
    }
    String responseBody = httpget.getResponseBodyAsString();
    return responseBody;
  }

  public static String loadCurrenyQuoteFromLocal() {
    InputStream is = CurrencyReader.class.getClassLoader().getResourceAsStream("quotes.xml");
    
    StringBuilder sb = new StringBuilder();
    if (is != null) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      String line = null;
      try {
        while ((line = reader.readLine()) != null) {
          sb.append(line + System.getProperty("line.separator"));
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }else{
      System.out.println("file is not loaded");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    try {
      String body = CurrencyReader.loadCurrenyQuoteFromLocal();
      System.out.println(body);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
