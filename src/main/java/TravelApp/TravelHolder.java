package TravelApp;

/**
* TravelApp/TravelHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Travel.idl
* Thursday, November 17, 2022 1:12:54 AM ICT
*/

public final class TravelHolder implements org.omg.CORBA.portable.Streamable
{
  public TravelApp.Travel value = null;

  public TravelHolder ()
  {
  }

  public TravelHolder (TravelApp.Travel initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TravelApp.TravelHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TravelApp.TravelHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TravelApp.TravelHelper.type ();
  }

}
