package com.fbagamehjdt.api.queryad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.fbagamehjdt.api.API;

public class GetAdData
{
  public Context a;
  private String b = "GetAdData";
  private AdDataListenr c;
  
  public GetAdData(Context paramContext, AdDataListenr paramAdDataListenr)
  {
    this.a = paramContext;
    this.c = paramAdDataListenr;
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      ADInfo localADInfo = new ADInfo();
      if (paramString.has("id")) {
        localADInfo.a(paramString.getInt("id"));
      }
      if (paramString.has("pop_img_url")) {
        localADInfo.b(paramString.getString("pop_img_url"));
      }
      if (this.c != null) {
        this.c.a(localADInfo);
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (this.c != null) {
        this.c.b();
      }
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject = API.a + "?id=xugame_ifashiongame";
        try
        {
          localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
          ((HttpURLConnection)localObject).setRequestMethod("GET");
          if (((HttpURLConnection)localObject).getResponseCode() == 200)
          {
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject).getInputStream()));
            String str;
            for (localObject = "";; localObject = (String)localObject + str + "\n")
            {
              str = localBufferedReader.readLine();
              if (str == null) {
                break;
              }
            }
            Log.i(GetAdData.a(GetAdData.this), "返回" + (String)localObject);
            GetAdData.a(GetAdData.this, (String)localObject);
            return;
          }
          if (GetAdData.b(GetAdData.this) != null)
          {
            GetAdData.b(GetAdData.this).b();
            return;
          }
        }
        catch (IOException localIOException)
        {
          if (GetAdData.b(GetAdData.this) != null) {
            GetAdData.b(GetAdData.this).b();
          }
          localIOException.printStackTrace();
        }
      }
    }).start();
  }
  
  public static abstract interface AdDataListenr
  {
    public abstract void a(ADInfo paramADInfo);
    
    public abstract void b();
  }
}
