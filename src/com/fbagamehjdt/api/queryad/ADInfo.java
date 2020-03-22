package com.fbagamehjdt.api.queryad;

public class ADInfo
{
  private int a = 0;
  private String b = "0";
  private String c;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "id=" + this.a + "adUrl=" + this.c + "time" + this.b;
  }
}
