package TravelApp;


/**
* TravelApp/TravelPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Travel.idl
* Tuesday, November 15, 2022 8:05:12 PM ICT
*/

public abstract class TravelPOA extends org.omg.PortableServer.Servant
 implements TravelApp.TravelOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("login", new java.lang.Integer (0));
    _methods.put ("register", new java.lang.Integer (1));
    _methods.put ("add", new java.lang.Integer (2));
    _methods.put ("update", new java.lang.Integer (3));
    _methods.put ("delete", new java.lang.Integer (4));
    _methods.put ("find", new java.lang.Integer (5));
    _methods.put ("shutdown", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // TravelApp/Travel/login
       {
         String userName = in.read_string ();
         String pwd = in.read_string ();
         String $result = null;
         $result = this.login (userName, pwd);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // TravelApp/Travel/register
       {
         String userName = in.read_string ();
         String pwd = in.read_string ();
         int $result = (int)0;
         $result = this.register (userName, pwd);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // TravelApp/Travel/add
       {
         String locationName = in.read_string ();
         String phonenumber = in.read_string ();
         String note = in.read_string ();
         int $result = (int)0;
         $result = this.add (locationName, phonenumber, note);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // TravelApp/Travel/update
       {
         int id = in.read_long ();
         String locationName = in.read_string ();
         String phonenumber = in.read_string ();
         String note = in.read_string ();
         int $result = (int)0;
         $result = this.update (id, locationName, phonenumber, note);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 4:  // TravelApp/Travel/delete
       {
         int id = in.read_long ();
         int $result = (int)0;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 5:  // TravelApp/Travel/find
       {
         String locationName = in.read_string ();
         String $result = null;
         $result = this.find (locationName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 6:  // TravelApp/Travel/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:TravelApp/Travel:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Travel _this() 
  {
    return TravelHelper.narrow(
    super._this_object());
  }

  public Travel _this(org.omg.CORBA.ORB orb) 
  {
    return TravelHelper.narrow(
    super._this_object(orb));
  }


} // class TravelPOA
