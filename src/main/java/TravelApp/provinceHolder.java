package TravelApp;

/**
* TravelApp/provinceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Travel.idl
* Thursday, November 17, 2022 2:58:05 AM ICT
*/

public final class provinceHolder implements org.omg.CORBA.portable.Streamable
{
  public TravelApp.province value = null;

  public provinceHolder ()
  {
  }

  public provinceHolder (TravelApp.province initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TravelApp.provinceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TravelApp.provinceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TravelApp.provinceHelper.type ();
  }

}
