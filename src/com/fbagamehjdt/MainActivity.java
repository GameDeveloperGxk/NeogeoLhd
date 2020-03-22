package com.fbagamehjdt;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.fbagamehjdt.api.ResUtil;
import com.fbagamehjdt.api.Util;
import com.fbagamehjdt.api.queryad.ADInfo;
import com.fbagamehjdt.api.queryad.GetAdData;
import com.squareup.picasso.Picasso;
//import com.umeng.analytics.MobclickAgent;
//import com.umeng.analytics.MobclickAgent.EScenarioType;
//import com.umeng.commonsdk.UMConfigure;

public class MainActivity
  extends Activity
  implements MediaPlayer.OnCompletionListener, GetAdData.AdDataListenr
{
  public static final Object d = new Object();
  String a = "";
  ImageView b;
  ImageView c;
  private String e = "MainActivity";
  private Context f;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private VideoView j;
  private ImageView k;
  private CountDownTimer l;
  private int m = 10;
  private int n = 4;
  
  public static void a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageName", paramContext.getPackageName());
    MobclickAgent.onEvent(paramContext, "StartGame", localHashMap);
  }
  
  private void a(String paramString)
  {
    this.j.setVisibility(8);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    Picasso.with(this.f).load(paramString).into(this.c);
  }
  
  private void c()
  {
    if (this.f == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences("adInfo", 0);
    try
    {
      this.h = localSharedPreferences.getInt("lastADID", 0);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
      this.h = 0;
    }
  }
  
  private void d()
  {
    if (this.f == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.f.getSharedPreferences("adInfo", 0).edit();
    localEditor.putInt("lastADID", this.h);
    localEditor.commit();
  }
  
  private void e()
  {
    this.j = new VideoView(this);
    Object localObject = new RelativeLayout(this);
    this.j.setOnCompletionListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject).addView(this.j, localLayoutParams);
    this.c = new ImageView(this.f);
    this.c.setVisibility(8);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject).addView(this.c, localLayoutParams);
    this.b = new ImageView(this.f);
    this.b.setVisibility(8);
    this.b.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new RelativeLayout.LayoutParams(150, 150);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    ((RelativeLayout)localObject).addView(this.b, localLayoutParams);
    setContentView((View)localObject);
    if (this.a != null)
    {
      localObject = Uri.parse(this.a);
      this.j.setVideoURI((Uri)localObject);
      this.j.start();
      return;
    }
    startActivity(new Intent(this.f, IdentificationActivity.class));
    finish();
  }
  
  private void f()
  {
    c();
    if (this.g > this.h)
    {
      this.h = this.g;
      d();
      if ((this.i != null) && (!this.i.trim().equals("")))
      {
        runOnUiThread(new Runnable()
        {
          public void run()
          {
            MainActivity.a(MainActivity.this, MainActivity.a(MainActivity.this));
            MainActivity.b(MainActivity.this);
          }
        });
        return;
      }
      b();
      return;
    }
    b();
  }
  
  private void g()
  {
    h();
    this.l = new CountDownTimer(10000L, 1000L)
    {
      public void onFinish()
      {
        MainActivity.e(MainActivity.this).cancel();
        MainActivity.f(MainActivity.this).startActivity(new Intent(MainActivity.f(MainActivity.this), IdentificationActivity.class));
        MainActivity.this.finish();
      }
      
      public void onTick(long paramAnonymousLong)
      {
        for (;;)
        {
          synchronized (MainActivity.d)
          {
            MainActivity.c(MainActivity.this);
            if (MainActivity.a(MainActivity.this) != null)
            {
              if (MainActivity.d(MainActivity.this) <= 0)
              {
                MainActivity.e(MainActivity.this).cancel();
                MainActivity.f(MainActivity.this).startActivity(new Intent(MainActivity.f(MainActivity.this), IdentificationActivity.class));
                MainActivity.this.finish();
              }
            }
            else
            {
              if (TextUtils.isEmpty(MainActivity.a(MainActivity.this)))
              {
                MainActivity.e(MainActivity.this).cancel();
                MainActivity.f(MainActivity.this).startActivity(new Intent(MainActivity.f(MainActivity.this), IdentificationActivity.class));
                MainActivity.this.finish();
              }
              return;
            }
            switch (MainActivity.d(MainActivity.this))
            {
            case 1: 
              MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p10"));
            }
          }
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p20"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p30"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p40"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p50"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p60"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p70"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p80"));
          continue;
          MainActivity.this.b.setImageResource(ResUtil.b(MainActivity.f(MainActivity.this), "p90"));
        }
      }
    };
    this.l.start();
  }
  
  private void h()
  {
    this.m = 10;
    this.n = 4;
  }
  
  public void a(ADInfo paramADInfo)
  {
    this.i = paramADInfo.c();
    this.g = paramADInfo.a();
    Log.i(this.e, paramADInfo.toString());
    f();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    Object localObject = (ConnectivityManager)getSystemService("connectivity");
    boolean bool1 = bool2;
    int i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      bool1 = bool2;
      if (localObject != null) {
        i1 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < localObject.length)
      {
        if (localObject[i1].getState() == NetworkInfo.State.CONNECTED) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void b()
  {
    startActivity(new Intent(this.f, IdentificationActivity.class));
    finish();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (a())
    {
      new GetAdData(this, this).a();
      return;
    }
    startActivity(new Intent(this.f, IdentificationActivity.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Window localWindow = getWindow();
    requestWindowFeature(1);
    localWindow.setFlags(1024, 1024);
    super.onCreate(paramBundle);
    Util.a(this);
    this.f = this;
    this.a = ("android.resource://" + getPackageName() + "/" + ResUtil.k(this.f, "headvideo"));
    UMConfigure.init(this, 2, "55e568c3e0f55a31b8004bc4");
    MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    UMConfigure.init(this, "55e568c3e0f55a31b8004bc4", "xugame_ifashiongame", 2, "");
    a(this);
    e();
  }
  
  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }
}
