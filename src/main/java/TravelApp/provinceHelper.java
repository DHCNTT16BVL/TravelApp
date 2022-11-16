package TravelApp;


/**
* TravelApp/provinceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Travel.idl
* Thursday, November 17, 2022 1:12:54 AM ICT
*/

abstract public class provinceHelper
{
  private static String  _id = "IDL:TravelApp/province:1.0";

  public static void insert (org.omg.CORBA.Any a, TravelApp.province that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static TravelApp.province extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id_province",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "province",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (TravelApp.provinceHelper.id (), "province", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static TravelApp.province read (org.omg.CORBA.portable.InputStream istream)
  {
    TravelApp.province value = new TravelApp.province ();
    value.id_province = istream.read_long ();
    value.province = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, TravelApp.province value)
  {
    ostream.write_long (value.id_province);
    ostream.write_string (value.province);
  }

}
