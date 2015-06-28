# mongodb-jdbc
mongodb java jdbc 驱动

================
        public static void main( String args[] ) throws SQLException , ClassNotFoundException {
 		    jdbcdriver="org.opencloudb.jdbc.mongodb.MongoDriver";
		    jdbcurl="mongodb://192.168.0.99/test";
		    String username="jifeng";
	    	    String password="jifeng";
	    	    Class.forName(jdbcdriver);
	    	    Connection c = DriverManager.getConnection(jdbcurl,username,password); 
		    Statement st = c.createStatement();

		    print( "test jdbc " , st.executeQuery("select * from people ")); 

		}
		
			 static void print( String name , ResultSet res )
				        throws SQLException {
				        System.out.println( name);
				        ResultSetMetaData meta=res.getMetaData();				        
		                //System.out.println( "\t"+res.getRow()+"条记录");
		                String	str="";
		                for(int i=1;i<=meta.getColumnCount();i++){
		                	str+=meta.getColumnName(i)+"   ";
		                	//System.out.println( meta.getColumnName(i)+"   ");
		                }
		                System.out.println("\t"+str);
		                str="";
				        while ( res.next() ){
				        	for(int i=1;i<=meta.getColumnCount();i++){	
				        		str+= res.getString(i)+"   ";		
				        		} 
				        	System.out.println("\t"+str);
				        	str="";
				        }
				    }	
